/*
 *	Copyright 2022-2023 cufy.org and meemer.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package org.cufy.mongodb.gridfs

import kotlinx.coroutines.Deferred
import org.cufy.mongodb.ExperimentalMongodbApi

/* ============= ------------------ ============= */

/**
 * A GridFS download instance.
 *
 * Can be used to asynchronously complete a download
 * operation.
 *
 * This interface is a combination of a coroutine-based
 * [java.io.InputStream] for reading the downloaded file chunks
 * and [Deferred] instance for the download result.
 *
 * The [read] functions does not fail. Instead, it
 * returns special values representing that no more
 * data can be obtained.
 *
 * This interface implements [kotlinx.coroutines.Job]
 * which represents the background download job.
 *
 * @author LSafer
 * @since 2.0.0
 */
@ExperimentalMongodbApi
expect class MongoDownload : AutoCloseable {
    /**
     * The preferred download buffer size as set in the
     * [DownloadOptions].
     */
    val bufferSizeBytes: Int

    /**
     * The file data. Can be awaited without the
     * need to await the whole job.
     *
     * If the download operation has failed,
     * this yields `null`.
     *
     * @since 2.0.0
     */
    val file: Deferred<MongoFile?>

    /**
     * Await the completion of the download operation.
     *
     * If the download operation has failed, this function
     * will throw the fail cause.
     */
    suspend fun await()

    /**
     * Close the download channel.
     *
     * After calling this function, the download
     * channel will be closed causing the download
     * job to finish and the download operation to
     * be canceled.
     *
     * Calling this function would not cause [await]
     * to throw an exception.
     *
     * @since 2.0.0
     */
    override fun close()

    /**
     * Read the next bytes into the given [dest] array.
     *
     * @return how many bytes have been read. Or `-1` if no more data can be read.
     * @since 2.0.0
     */
    suspend fun read(dest: ByteArray): Int

    /**
     * Read the next bytes into the given [dest] array.
     *
     * @param offset where to start writing at [dest].
     * @param limit the limit to how many bytes to be written.
     * @return how many bytes have been read. Or `-1` if no more data can be read.
     * @throws IndexOutOfBoundsException if `offset + limit > dest.size`
     * @since 2.0.0
     */
    suspend fun read(dest: ByteArray, offset: Int, limit: Int): Int
}

/* ============= ------------------ ============= */

/**
 * Write all the remaining chunks to the given [upload]
 * instance and **suspend** until all the chunks has
 * been written.
 *
 * @param upload the instance to transfer the buffers to.
 * @return the number of bytes written.
 * @since 2.0.0
 */
@ExperimentalMongodbApi
expect suspend fun MongoDownload.writeTo(upload: MongoUpload): Long

/* ============= ------------------ ============= */
