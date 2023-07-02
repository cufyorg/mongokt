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
package org.cufy.mongodb.gridfs.java

import org.bson.Document
import org.cufy.bson.java.java
import org.cufy.mongodb.gridfs.BucketFindOptions
import org.cufy.mongodb.gridfs.DownloadOptions
import org.cufy.mongodb.gridfs.UploadOptions
import org.cufy.mongodb.java.java
import java.util.concurrent.TimeUnit

/* ============= ------------------ ============= */

internal typealias JavaUploadOptions =
        com.mongodb.client.gridfs.model.GridFSUploadOptions

/**
 * Return a java version of this.
 */
val UploadOptions.java: JavaUploadOptions
    get() {
        return JavaUploadOptions()
            .chunkSizeBytes(chunkSizeBytes)
            .metadata(metadata?.java?.let { Document(it) })
    }

/* ============= ------------------ ============= */

internal typealias JavaDownloadPublisher =
        com.mongodb.reactivestreams.client.gridfs.GridFSDownloadPublisher

/**
 * Apply the given [options] to this publisher.
 */
fun JavaDownloadPublisher.apply(options: DownloadOptions): JavaDownloadPublisher {
    options.bufferSizeBytes?.let { bufferSizeBytes(it) }
    return this
}

/* ============= ------------------ ============= */

internal typealias JavaBucketFindPublisher =
        com.mongodb.reactivestreams.client.gridfs.GridFSFindPublisher

/**
 * Apply the given [options] to this publisher.
 */
fun JavaBucketFindPublisher.apply(options: BucketFindOptions): JavaBucketFindPublisher {
    limit(options.limit)
    skip(options.skip)
    sort(options.sort?.java)
    noCursorTimeout(options.noCursorTimeout)
    maxTime(options.maxTime.inWholeMilliseconds, TimeUnit.MILLISECONDS)
    collation(options.collation?.java)
    options.batchSize?.let { batchSize(it) }
    return this
}

/* ============= ------------------ ============= */
