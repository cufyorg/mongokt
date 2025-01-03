package org.cufy.mongodb.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.runBlocking
import org.cufy.mongodb.*
import org.cufy.mongodb.gridfs.MongoBucket
import org.cufy.mongodb.gridfs.createMongoBucket
import org.cufy.mongodb.gridfs.download
import org.cufy.mongodb.gridfs.upload
import java.io.File
import java.io.InputStream
import java.nio.ByteBuffer
import java.util.*
import kotlin.io.path.createTempFile
import kotlin.random.Random
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class GridFSTest {
    private lateinit var client: MongoClient
    private lateinit var database: MongoDatabase
    private lateinit var bucket: MongoBucket

    @BeforeTest
    fun before() {
        val connectionString = "mongodb://localhost"
        val name = "mongodb-gridfs-test-${UUID.randomUUID()}"
        client = createMongoClient(connectionString)
        database = client[name]
        bucket = createMongoBucket(database)
    }

    @AfterTest
    fun after() {
        runBlocking {
            database.drop()
        }
    }

    @Test
    @ExperimentalMongodbApi
    fun `upload simple files`() {
        runBlocking {
            val input = createTempFile().toFile()
            val output = createTempFile().toFile()

            input.fillWithGarbage()
            output.fillWithGarbage()

            val objectId = bucket.upload(filename = "a.jpeg") {
                input.inputStream().use { inStream ->
                    while (true) {
                        val buffer = ByteBuffer.allocate(1024)
                        val n = inStream.read(buffer.array())
                        if (n == -1) break
                        buffer.limit(n)
                        // no need to flip
                        send(buffer)
                    }
                }
            }

            val file = bucket.download(objectId) {
                output.outputStream().use { outStream ->
                    consumeEach { buffer ->
                        outStream.write(
                            buffer.array(),
                            buffer.position(),
                            buffer.limit(),
                        )
                    }
                }
            }

            assertTrue(diff(input, output), "Input does not equal output")
        }
    }

    //    @Test // not applicable
    @ExperimentalMongodbApi
    fun `upload using a single buffer`() {
        runBlocking(Dispatchers.IO) {
            val input = createTempFile().toFile()
            val output = createTempFile().toFile()

            input.fillWithGarbage()
            output.fillWithGarbage()

            val objectId = bucket.upload(filename = "b.jpeg") {
                input.inputStream().use { inStream ->
                    val buffer = ByteBuffer.allocate(1024)
                    while (true) {
                        val n = inStream.read(buffer.array())
                        if (n == -1) break
                        buffer.limit(n)
                        // no need to flip
                        send(buffer)
                        buffer.clear()
                    }
                }
            }

            val file = bucket.download(objectId) {
                output.outputStream().use { outStream ->
                    consumeEach { buffer ->
                        outStream.write(
                            buffer.array(),
                            buffer.position(),
                            buffer.limit(),
                        )
                    }
                }
            }

            assertTrue(diff(input, output), "Input does not equal output")
        }
    }
}

fun File.fillWithGarbage() {
    outputStream().use { outStream ->
        // 8B * 125,000 = 1MB
        repeat(431_353) {
            outStream.write(Random.nextBytes(8))
        }
    }
}

fun diff(a: File, b: File): Boolean {
    val aStream = a.inputStream()
    val bStream = b.inputStream()
    val aBuffer = ByteArray(1_000_000)
    val bBuffer = ByteArray(1_000_000)

    while (true) {
        val ar = aBuffer.fillFrom(aStream)
        val br = bBuffer.fillFrom(bStream)

        if (ar != br || !aBuffer.contentEquals(bBuffer))
            return false

        if (ar < 0)
            return true
    }
}

fun ByteArray.fillFrom(stream: InputStream): Int {
    var written = 0
    while (written < size) {
        val r = stream.read(this, written, size - written)
        if (r < 0) return if (written == 0) return -1 else written
        written += r
    }
    return written
}
