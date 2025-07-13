/*
 *	Copyright 2022-2025 cufy.org
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
@file:JvmMultifileClass
@file:JvmName("MongoCollectionExtensionsKt")

package org.cufy.mongodb

import org.cufy.bson.AnyID
import org.cufy.bson.BsonDocument
import org.cufy.bson.BsonDocumentBlock
import org.cufy.bson.by

/* ============= ------------------ ============= */

// ===============[ deleteOne: deleteOneById ]

/**
 * Removes at most one document from the
 * collection that has the given id.
 *
 * If no documents match, the collection is not
 * modified.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document to be deleted.
 * @param options the options to apply to the delete operation.
 * @return the DeleteResult.
 * @throws com.mongodb.MongoException
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.deleteOne
 */
suspend fun MongoCollection.deleteOneById(
    id: AnyID,
    options: DeleteOptions,
    session: ClientSession? = null,
): DeleteResult {
    return deleteOne(
        filter = BsonDocument { "_id" by id },
        options = options,
        session = session,
    )
}

/**
 * Removes at most one document from the
 * collection that has the given id.
 *
 * If no documents match, the collection is not
 * modified.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document to be deleted.
 * @param options the options to apply to the delete operation.
 * @return the DeleteResult.
 * @throws com.mongodb.MongoException
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.deleteOne
 */
suspend fun MongoCollection.deleteOneById(
    id: AnyID,
    session: ClientSession? = null,
    options: DeleteOptions.() -> Unit = {},
): DeleteResult {
    return deleteOne(
        filter = BsonDocument { "_id" by id },
        options = DeleteOptions(options),
        session = session,
    )
}

// ===============[ updateOne: updateOneById ]

/**
 * Update a single document in the collection
 * according to the specified arguments.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update a document describing the update, which may not be null.
 *               The update to apply must include only update operators.
 * @param options the options to apply to the update operation.
 * @return the UpdateResult
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.updateOne
 */
suspend fun MongoCollection.updateOneById(
    id: AnyID,
    update: BsonDocument,
    options: UpdateOptions = UpdateOptions(),
    session: ClientSession? = null,
): UpdateResult {
    return updateOne(
        filter = BsonDocument { "_id" by id },
        update = update,
        options = options,
        session = session,
    )
}

/**
 * Update a single document in the collection
 * according to the specified arguments.
 *
 * Note: Supports retryable writes on MongoDB
 * server versions 3.6 or higher when the
 * retryWrites setting is enabled.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update a pipeline describing the update, which may not be null.
 * @param options the options to apply to the update operation
 * @return the UpdateResult
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.updateOne
 */
suspend fun MongoCollection.updateOneById(
    id: AnyID,
    update: List<BsonDocument>,
    options: UpdateOptions = UpdateOptions(),
    session: ClientSession? = null,
): UpdateResult {
    return updateOne(
        filter = BsonDocument { "_id" by id },
        update = update,
        options = options,
        session = session,
    )
}

/**
 * Update a single document in the collection
 * according to the specified arguments.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update a document describing the update, which may not be null.
 *               The update to apply must include only update operators.
 * @param options the options to apply to the update operation.
 * @return the UpdateResult
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.updateOne
 */
suspend fun MongoCollection.updateOneById(
    id: AnyID,
    update: BsonDocumentBlock,
    session: ClientSession? = null,
    options: UpdateOptions.() -> Unit = {},
): UpdateResult {
    return updateOne(
        filter = BsonDocument { "_id" by id },
        update = BsonDocument(update),
        options = UpdateOptions(options),
        session = session,
    )
}

/**
 * Update a single document in the collection
 * according to the specified arguments.
 *
 * Note: Supports retryable writes on MongoDB
 * server versions 3.6 or higher when the
 * retryWrites setting is enabled.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update a pipeline describing the update, which may not be null.
 * @param options the options to apply to the update operation
 * @return the UpdateResult
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.updateOne
 */
@Deprecated("Use updateOneById with listOf()")
suspend fun MongoCollection.updateOneById(
    id: AnyID,
    vararg update: BsonDocumentBlock,
    session: ClientSession? = null,
    options: UpdateOptions.() -> Unit = {},
): UpdateResult {
    return updateOne(
        filter = BsonDocument { "_id" by id },
        update = update.map { BsonDocument(it) },
        options = UpdateOptions(options),
        session = session,
    )
}

/**
 * Update a single document in the collection
 * according to the specified arguments.
 *
 * Note: Supports retryable writes on MongoDB
 * server versions 3.6 or higher when the
 * retryWrites setting is enabled.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update a pipeline describing the update, which may not be null.
 * @param options the options to apply to the update operation
 * @return the UpdateResult
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.updateOne
 */
suspend fun MongoCollection.updateOneById(
    id: AnyID,
    update: List<BsonDocumentBlock>,
    session: ClientSession? = null,
    options: UpdateOptions.() -> Unit = {},
): UpdateResult {
    return updateOne(
        filter = BsonDocument { "_id" by id },
        update = update.map { BsonDocument(it) },
        options = UpdateOptions(options),
        session = session,
    )
}

// ===============[ replaceOne: replaceOneById ]

/**
 * Replace a document in the collection according
 * to the specified arguments.
 *
 * @param session the client session with which to associate this operation
 * @param id the id of the document
 * @param replacement the replacement document
 * @param options the options to apply to the replace operation
 * @return the UpdateResult
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.replaceOne
 */
suspend fun MongoCollection.replaceOneById(
    id: AnyID,
    replacement: BsonDocument,
    options: ReplaceOptions = ReplaceOptions(),
    session: ClientSession? = null,
): UpdateResult {
    return replaceOne(
        filter = BsonDocument { "_id" by id },
        replacement = replacement,
        options = options,
        session = session,
    )
}

/**
 * Replace a document in the collection according
 * to the specified arguments.
 *
 * @param session the client session with which to associate this operation
 * @param id the id of the document
 * @param replacement the replacement document
 * @param options the options to apply to the replace operation
 * @return the UpdateResult
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.replaceOne
 */
suspend fun MongoCollection.replaceOneById(
    id: AnyID,
    replacement: BsonDocumentBlock,
    session: ClientSession? = null,
    options: ReplaceOptions.() -> Unit = {},
): UpdateResult {
    return replaceOne(
        filter = BsonDocument { "_id" by id },
        replacement = BsonDocument(replacement),
        options = ReplaceOptions(options),
        session = session,
    )
}

// ===============[ findOneAndDelete: findOneByIdAndDelete ]

/**
 * Atomically find a document and remove it.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param options the options to apply to the operation.
 * @return the document that was removed.
 *         If no documents matched the query filter, then null will be returned.
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndDelete
 */
suspend fun MongoCollection.findOneByIdAndDelete(
    id: AnyID,
    options: FindOneAndDeleteOptions = FindOneAndDeleteOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndDelete(
        filter = BsonDocument { "_id" by id },
        options = options,
        session = session,
    )
}

/**
 * Atomically find a document and remove it.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param options the options to apply to the operation.
 * @return the document that was removed.
 *         If no documents matched the query filter, then null will be returned.
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndDelete
 */
suspend fun MongoCollection.findOneByIdAndDelete(
    id: AnyID,
    session: ClientSession? = null,
    options: FindOneAndDeleteOptions.() -> Unit,
): BsonDocument? {
    return findOneAndDelete(
        filter = BsonDocument { "_id" by id },
        options = FindOneAndDeleteOptions(options),
        session = session,
    )
}

// ===============[ findOneAndReplace: findOneByIdAndReplace ]

/**
 * Atomically find a document and replace it.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param replacement the replacement document.
 * @param options the options to apply to the operation.
 * @return the document that was replaced.
 *         Depending on the value of the `returnOriginal` property, this will either
 *         be the document as it was before the update or as it is after the update.
 *         If no documents matched the query filter, then null will be returned
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndReplace
 */
suspend fun MongoCollection.findOneByIdAndReplace(
    id: AnyID,
    replacement: BsonDocument,
    options: FindOneAndReplaceOptions = FindOneAndReplaceOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndReplace(
        filter = BsonDocument { "_id" by id },
        replacement = replacement,
        options = options,
        session = session,
    )
}

/**
 * Atomically find a document and replace it.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param replacement the replacement document.
 * @param options the options to apply to the operation.
 * @return the document that was replaced.
 *         Depending on the value of the `returnOriginal` property, this will either
 *         be the document as it was before the update or as it is after the update.
 *         If no documents matched the query filter, then null will be returned
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndReplace
 */
suspend fun MongoCollection.findOneByIdAndReplace(
    id: AnyID,
    replacement: BsonDocumentBlock,
    session: ClientSession? = null,
    options: FindOneAndReplaceOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndReplace(
        filter = BsonDocument { "_id" by id },
        replacement = BsonDocument(replacement),
        options = FindOneAndReplaceOptions(options),
        session = session,
    )
}

// ===============[ findOneAndUpdate: findOneByIdAndUpdate ]

/**
 * Atomically find a document and update it.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update  a document describing the update, which may not be null.
 *                The update to apply must include only update operators.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 *         Depending on the value of the `returnOriginal` property, this will either be
 *         the document as it was before the update or as it is after the update.
 *         If no documents matched the query filter, then null will be returned.
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.findOneByIdAndUpdate(
    id: AnyID,
    update: BsonDocument,
    options: FindOneAndUpdateOptions = FindOneAndUpdateOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = update,
        options = options,
        session = session
    )
}

/**
 * Atomically find a document and update it.
 *
 * Note: Supports retryable writes on MongoDB
 * server versions 3.6 or higher when the
 * retryWrites setting is enabled.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update a pipeline describing the update, which may not be null.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 *         Depending on the value of the `returnOriginal` property, this will either be
 *         the document as it was before the update or as it is after the update.
 *         If no documents matched the query filter, then null will be returned.
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.findOneByIdAndUpdate(
    id: AnyID,
    update: List<BsonDocument>,
    options: FindOneAndUpdateOptions = FindOneAndUpdateOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = update,
        options = options,
        session = session
    )
}

/**
 * Atomically find a document and update it.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update  a document describing the update, which may not be null.
 *                The update to apply must include only update operators.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 *         Depending on the value of the `returnOriginal` property, this will either be
 *         the document as it was before the update or as it is after the update.
 *         If no documents matched the query filter, then null will be returned.
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.findOneByIdAndUpdate(
    id: AnyID,
    update: BsonDocumentBlock,
    session: ClientSession? = null,
    options: FindOneAndUpdateOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = BsonDocument(update),
        options = FindOneAndUpdateOptions(options),
        session = session
    )
}

/**
 * Atomically find a document and update it.
 *
 * Note: Supports retryable writes on MongoDB
 * server versions 3.6 or higher when the
 * retryWrites setting is enabled.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update a pipeline describing the update, which may not be null.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 *         Depending on the value of the `returnOriginal` property, this will either be
 *         the document as it was before the update or as it is after the update.
 *         If no documents matched the query filter, then null will be returned.
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
@Deprecated("Use findOneByIdAndUpdate with listOf()")
suspend fun MongoCollection.findOneByIdAndUpdate(
    id: AnyID,
    vararg update: BsonDocumentBlock,
    session: ClientSession? = null,
    options: FindOneAndUpdateOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = update.map { BsonDocument(it) },
        options = FindOneAndUpdateOptions(options),
        session = session
    )
}

/**
 * Atomically find a document and update it.
 *
 * Note: Supports retryable writes on MongoDB
 * server versions 3.6 or higher when the
 * retryWrites setting is enabled.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update a pipeline describing the update, which may not be null.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 *         Depending on the value of the `returnOriginal` property, this will either be
 *         the document as it was before the update or as it is after the update.
 *         If no documents matched the query filter, then null will be returned.
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.findOneByIdAndUpdate(
    id: AnyID,
    update: List<BsonDocumentBlock>,
    session: ClientSession? = null,
    options: FindOneAndUpdateOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = update.map { BsonDocument(it) },
        options = FindOneAndUpdateOptions(options),
        session = session
    )
}

/* ============= ------------------ ============= */
