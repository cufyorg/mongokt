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

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.cufy.bson.BsonDocument
import org.cufy.bson.BsonElement
import org.cufy.bson.BsonObjectId
import org.cufy.mongodb.ClientSession
import java.nio.ByteBuffer

suspend fun MongoBucket.upload(
    filename: String,
    metadata: BsonDocument = BsonDocument.Empty,
    options: UploadOptions = UploadOptions(),
    session: ClientSession? = null,
    block: suspend SendChannel<ByteBuffer>.() -> Unit,
): BsonObjectId {
    return coroutineScope {
        val channel = Channel<ByteBuffer>()

        launch {
            try {
                block(channel)
            } finally {
                channel.close()
            }
        }

        try {
            upload(
                channel = channel,
                filename = filename,
                metadata = metadata,
                options = options,
                session = session,
            )
        } finally {
            channel.close()
        }
    }
}

suspend fun MongoBucket.upload(
    filename: String,
    id: BsonElement,
    metadata: BsonDocument = BsonDocument.Empty,
    options: UploadOptions = UploadOptions(),
    session: ClientSession? = null,
    block: suspend SendChannel<ByteBuffer>.() -> Unit,
) {
    coroutineScope {
        val channel = Channel<ByteBuffer>()

        launch {
            try {
                block(channel)
            } finally {
                channel.close()
            }
        }

        try {
            upload(
                channel = channel,
                filename = filename,
                id = id,
                metadata = metadata,
                options = options,
                session = session,
            )
        } finally {
            channel.close()
        }
    }
}

suspend fun MongoBucket.download(
    id: BsonElement,
    options: DownloadOptions = DownloadOptions(),
    session: ClientSession? = null,
    block: suspend ReceiveChannel<ByteBuffer>.() -> Unit,
): MongoFile {
    return coroutineScope {
        val channel = Channel<ByteBuffer>()

        launch {
            try {
                block(channel)
            } finally {
                channel.close()
            }
        }

        try {
            download(
                channel = channel,
                id = id,
                options = options,
                session = session,
            )
        } finally {
            channel.close()
        }
    }
}

suspend fun MongoBucket.download(
    filename: String,
    options: DownloadOptions = DownloadOptions(),
    revision: FileRevision = FileRevision.Latest,
    session: ClientSession? = null,
    block: suspend ReceiveChannel<ByteBuffer>.() -> Unit,
): MongoFile {
    return coroutineScope {
        val channel = Channel<ByteBuffer>()

        launch {
            try {
                block(channel)
            } finally {
                channel.close()
            }
        }

        try {
            download(
                channel = channel,
                filename = filename,
                options = options,
                revision = revision,
                session = session,
            )
        } finally {
            channel.close()
        }
    }
}
