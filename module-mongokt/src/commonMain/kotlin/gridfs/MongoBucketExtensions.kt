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
import kotlinx.coroutines.Dispatchers
import org.cufy.bson.BsonDocument
import org.cufy.bson.BsonDocumentBlock
import org.cufy.bson.BsonElement
import org.cufy.mongodb.ClientSession
import org.cufy.mongodb.ExperimentalMongodbApi

/*
These implementations are back-pressure wrappers
over the same functions in `MongoBucket.kt`
*/

/* ============= ------------------ ============= */

/**
 * Initiates a file upload process to a GridFS bucket and
 * returns a [MongoUpload] instance to complete the upload
 * process.
 *
 * @param filename the filename.
 * @param metadata user provided data for the `metadata` field of the files collection document.
 * @param session the client session with which to associate this operation.
 * @param coroutineScope the scope to execute the upload in the background in.
 * @param options  the upload options.
 * @return an upload instance to complete the upload process.
 * @see com.mongodb.reactivestreams.client.gridfs.GridFSBucket.uploadFromPublisher
 * @since 2.0.0
 */
@ExperimentalMongodbApi
expect suspend fun MongoBucket.asyncUpload(
    filename: String,
    metadata: BsonDocument = BsonDocument.Empty,
    options: UploadOptions = UploadOptions(),
    session: ClientSession? = null,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
): MongoUpload

/**
 * Initiates a file upload process to a GridFS bucket and
 * returns a [MongoUpload] instance to complete the upload
 * process.
 *
 * @param id       the custom id value of the file.
 * @param filename the filename.
 * @param metadata user provided data for the `metadata` field of the files collection document.
 * @param session the client session with which to associate this operation.
 * @param coroutineScope the scope to execute the upload in the background in.
 * @param options  the upload options.
 * @return an upload instance to complete the upload process.
 * @see com.mongodb.reactivestreams.client.gridfs.GridFSBucket.uploadFromPublisher
 * @since 2.0.0
 */
@ExperimentalMongodbApi
expect suspend fun MongoBucket.asyncUpload(
    filename: String,
    id: BsonElement,
    metadata: BsonDocument = BsonDocument.Empty,
    options: UploadOptions = UploadOptions(),
    session: ClientSession? = null,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
): MongoUpload

/**
 * Initiates a file upload process to a GridFS bucket and
 * returns a [MongoUpload] instance to complete the upload
 * process.
 *
 * @param filename the filename.
 * @param metadata user provided data for the `metadata` field of the files collection document.
 * @param session the client session with which to associate this operation.
 * @param coroutineScope the scope to execute the upload in the background in.
 * @param options  the upload options.
 * @return an upload instance to complete the upload process.
 * @see com.mongodb.reactivestreams.client.gridfs.GridFSBucket.uploadFromPublisher
 * @since 2.0.0
 */
@ExperimentalMongodbApi
suspend fun MongoBucket.asyncUpload(
    filename: String,
    metadata: BsonDocumentBlock,
    session: ClientSession? = null,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
    options: UploadOptions.() -> Unit = {},
): MongoUpload {
    return asyncUpload(
        filename = filename,
        metadata = BsonDocument(metadata),
        options = UploadOptions(options),
        session = session,
        coroutineScope = coroutineScope,
    )
}

/**
 * Initiates a file upload process to a GridFS bucket and
 * returns a [MongoUpload] instance to complete the upload
 * process.
 *
 * @param id       the custom id value of the file.
 * @param filename the filename.
 * @param metadata user provided data for the `metadata` field of the files collection document.
 * @param session the client session with which to associate this operation.
 * @param coroutineScope the scope to execute the upload in the background in.
 * @param options  the upload options.
 * @return an upload instance to complete the upload process.
 * @see com.mongodb.reactivestreams.client.gridfs.GridFSBucket.uploadFromPublisher
 * @since 2.0.0
 */
@ExperimentalMongodbApi
suspend fun MongoBucket.asyncUpload(
    filename: String,
    id: BsonElement,
    metadata: BsonDocumentBlock,
    session: ClientSession? = null,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
    options: UploadOptions.() -> Unit = {},
): MongoUpload {
    return asyncUpload(
        filename = filename,
        id = id,
        metadata = BsonDocument(metadata),
        options = UploadOptions(options),
        session = session,
        coroutineScope = coroutineScope,
    )
}

/* ============= ------------------ ============= */

/**
 * Downloads the contents of the stored file specified by [id]
 * and return an instance of [MongoDownload] to complete the
 * download process.
 *
 * @param id the id of the file to be downloaded.
 * @param session the client session with which to associate this operation.
 * @param coroutineScope the scope to execute the download in the background in.
 * @param options the download options.
 * @return a download instance to complete the download process.
 * @see com.mongodb.reactivestreams.client.gridfs.GridFSBucket.downloadToPublisher
 * @since 2.0.0
 */
@ExperimentalMongodbApi
expect suspend fun MongoBucket.asyncDownload(
    id: BsonElement,
    options: DownloadOptions = DownloadOptions(),
    session: ClientSession? = null,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
): MongoDownload

/**
 * Downloads the contents of the stored file specified by [filename] and [revision]
 * and return an instance of [MongoDownload] to complete the
 * download process.
 *
 * @param filename the name of the file to be downloaded.
 * @param revision the revision of the file to be downloaded.
 * @param session the client session with which to associate this operation.
 * @param coroutineScope the scope to execute the download in the background in.
 * @param options the download options.
 * @return a download instance to complete the download process.
 * @see com.mongodb.reactivestreams.client.gridfs.GridFSBucket.downloadToPublisher
 * @since 2.0.0
 */
@ExperimentalMongodbApi
expect suspend fun MongoBucket.asyncDownload(
    filename: String,
    options: DownloadOptions = DownloadOptions(),
    revision: FileRevision = FileRevision.Latest,
    session: ClientSession? = null,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
): MongoDownload

/**
 * Downloads the contents of the stored file specified by [id]
 * and return an instance of [MongoDownload] to complete the
 * download process.
 *
 * @param id the id of the file to be downloaded.
 * @param session the client session with which to associate this operation.
 * @param coroutineScope the scope to execute the download in the background in.
 * @param options the download options.
 * @return a download instance to complete the download process.
 * @see com.mongodb.reactivestreams.client.gridfs.GridFSBucket.downloadToPublisher
 * @since 2.0.0
 */
@ExperimentalMongodbApi
suspend fun MongoBucket.asyncDownload(
    id: BsonElement,
    session: ClientSession? = null,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
    options: DownloadOptions.() -> Unit,
): MongoDownload {
    return asyncDownload(
        id = id,
        options = DownloadOptions(options),
        session = session,
        coroutineScope = coroutineScope,
    )
}

/**
 * Downloads the contents of the stored file specified by [filename] and [revision]
 * and return an instance of [MongoDownload] to complete the
 * download process.
 *
 * @param filename the name of the file to be downloaded.
 * @param revision the revision of the file to be downloaded.
 * @param session the client session with which to associate this operation.
 * @param coroutineScope the scope to execute the download in the background in.
 * @param options the download options.
 * @return a download instance to complete the download process.
 * @see com.mongodb.reactivestreams.client.gridfs.GridFSBucket.downloadToPublisher
 * @since 2.0.0
 */
@ExperimentalMongodbApi
suspend fun MongoBucket.asyncDownload(
    filename: String,
    revision: FileRevision = FileRevision.Latest,
    session: ClientSession? = null,
    coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
    options: DownloadOptions.() -> Unit,
): MongoDownload {
    return asyncDownload(
        filename = filename,
        options = DownloadOptions(options),
        revision = revision,
        session = session,
        coroutineScope = coroutineScope,
    )
}

/* ============= ------------------ ============= */
