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
package org.cufy.mongodb.gridfs

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedSendChannelException
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.reactive.asPublisher
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.collect
import org.cufy.bson.BsonDocument
import org.cufy.bson.BsonElement
import org.cufy.bson.kt
import org.cufy.mongodb.ClientSession
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.gridfs.internal.downloadToPublisher0
import org.cufy.mongodb.gridfs.internal.uploadFromPublisher0
import java.nio.ByteBuffer

/* ============= ------------------ ============= */

@ExperimentalMongodbApi
actual suspend fun MongoBucket.asyncUpload(
    filename: String,
    metadata: BsonDocument,
    options: UploadOptions,
    session: ClientSession?,
    coroutineScope: CoroutineScope,
): MongoUpload {
    val chunkSize = options.chunkSizeBytes ?: chunkSizeBytes
    val channel = Channel<ByteBuffer>()
    val publisher = java.uploadFromPublisher0(
        source = channel.receiveAsFlow().asPublisher(),
        filename = filename,
        metadata = metadata,
        options = options,
        session = session,
    )
    val job = coroutineScope.async<Unit> {
        publisher.awaitFirstOrNull()
    }
    job.invokeOnCompletion {
        channel.close()
    }
    return MongoUpload(
        chunkSizeBytes = chunkSize,
        id = publisher.id.kt,
        channel = channel,
        job = job,
    )
}

@ExperimentalMongodbApi
actual suspend fun MongoBucket.asyncUpload(
    filename: String,
    id: BsonElement,
    metadata: BsonDocument,
    options: UploadOptions,
    session: ClientSession?,
    coroutineScope: CoroutineScope,
): MongoUpload {
    val chunkSize = options.chunkSizeBytes ?: chunkSizeBytes
    val channel = Channel<ByteBuffer>()
    val publisher = java.uploadFromPublisher0(
        source = channel.receiveAsFlow().asPublisher(),
        filename = filename,
        id = id,
        metadata = metadata,
        options = options,
        session = session,
    )
    val job = coroutineScope.async<Unit> {
        publisher.awaitFirstOrNull()
    }
    job.invokeOnCompletion {
        channel.close()
    }
    return MongoUpload(
        chunkSizeBytes = chunkSize,
        id = publisher.id.kt,
        channel = channel,
        job = job,
    )
}

@ExperimentalMongodbApi
actual suspend fun MongoBucket.asyncDownload(
    id: BsonElement,
    options: DownloadOptions,
    session: ClientSession?,
    coroutineScope: CoroutineScope,
): MongoDownload {
    val chunkSize = options.bufferSizeBytes ?: chunkSizeBytes
    val channel = Channel<ByteBuffer>()
    val publisher = java.downloadToPublisher0(
        id = id,
        options = options,
        session = session,
    )
    val job = coroutineScope.async {
        try {
            publisher.collect { channel.send(it) }
        } catch (_: ClosedSendChannelException) {
            // it is completely ok to close mid-download
        }
    }
    job.invokeOnCompletion {
        channel.close()
    }
    return MongoDownload(
        bufferSizeBytes = chunkSize,
        file = coroutineScope.async(start = CoroutineStart.LAZY) {
            publisher.gridFSFile.awaitFirstOrNull()?.kt
        },
        channel = channel,
        job = job,
    )
}

@ExperimentalMongodbApi
actual suspend fun MongoBucket.asyncDownload(
    filename: String,
    options: DownloadOptions,
    revision: FileRevision,
    session: ClientSession?,
    coroutineScope: CoroutineScope,
): MongoDownload {
    val chunkSize = options.bufferSizeBytes ?: chunkSizeBytes
    val channel = Channel<ByteBuffer>()
    val publisher = java.downloadToPublisher0(
        filename = filename,
        options = options,
        revision = revision,
        session = session,
    )
    val job = coroutineScope.async {
        try {
            publisher.collect { channel.send(it) }
        } catch (_: ClosedSendChannelException) {
            // it is completely ok to close mid-download
        }
    }
    job.invokeOnCompletion {
        channel.close()
    }
    return MongoDownload(
        bufferSizeBytes = chunkSize,
        file = coroutineScope.async(start = CoroutineStart.LAZY) {
            publisher.gridFSFile.awaitFirstOrNull()?.kt
        },
        channel = channel,
        job = job,
    )
}

/* ============= ------------------ ============= */
