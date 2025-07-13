/*
 *	Copyright 2022-2023 cufy.org
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

import com.mongodb.MongoCommandException
import org.cufy.bson.AnyID
import org.cufy.bson.BsonDocument
import org.cufy.bson.BsonDocumentBlock
import org.cufy.bson.by
import org.cufy.mongodb.expr.filter

/* ============= ------------------ ============= */

// ===============[ count: exists ]

/**
 * Check existence of any document in the collection
 * according to the given options.
 *
 * @param session the client session with which to associate this operation.
 * @param filter  the query filter.
 * @param options the options describing the count.
 * @return true, if any document was found.
 * @see MongoCollection.count
 */
suspend fun MongoCollection.exists(
    filter: BsonDocument = BsonDocument.Empty,
    options: CountOptions = CountOptions(),
    session: ClientSession? = null,
): Boolean {
    return count(
        filter = filter,
        options = options.copy(limit = 1),
        session = session,
    ) > 0L
}

/**
 * Check existence of any documents in the collection
 * according to the given options.
 *
 * @param session the client session with which to associate this operation.
 * @param filter  the query filter.
 * @param options the options describing the count.
 * @return true, if any document was found.
 * @see MongoCollection.count
 */
suspend fun MongoCollection.exists(
    filter: BsonDocumentBlock,
    session: ClientSession? = null,
    options: CountOptions.() -> Unit = {},
): Boolean {
    return count(
        filter = BsonDocument(filter),
        options = CountOptions(options)
            .apply { limit = 1 },
        session = session
    ) > 0L
}

// ===============[ count: existsById ]

/**
 * Check existence of any document in the collection
 * according to the given options.
 *
 * @param session the client session with which to associate this operation.
 * @param filter  the query filter.
 * @param options the options describing the count.
 * @return true, if any document was found.
 * @see MongoCollection.count
 */
suspend fun MongoCollection.existsById(
    id: AnyID,
    options: CountOptions = CountOptions(),
    session: ClientSession? = null,
): Boolean {
    return count(
        filter = BsonDocument { "_id" by id },
        options = options.copy(limit = 1),
        session = session,
    ) > 0L
}

/**
 * Check existence of any documents in the collection
 * according to the given options.
 *
 * @param session the client session with which to associate this operation.
 * @param filter  the query filter.
 * @param options the options describing the count.
 * @return true, if any document was found.
 * @see MongoCollection.count
 */
suspend fun MongoCollection.existsById(
    id: AnyID,
    session: ClientSession? = null,
    options: CountOptions.() -> Unit,
): Boolean {
    return count(
        filter = BsonDocument { "_id" by id },
        options = CountOptions(options)
            .apply { limit = 1 },
        session = session,
    ) > 0L
}

// ===============[ findOneAndReplace: replaceOneGet ]

/**
 * Atomically find a document and replace it and return the replacement document.
 *
 * @param session the client session with which to associate this operation.
 * @param filter the query filter to apply the replace operation.
 * @param replacement the replacement document.
 * @param options the options to apply to the operation.
 * @return the document that was replaced.
 * @see com.mongodb.client.MongoCollection.findOneAndReplace
 */
suspend fun MongoCollection.replaceOneGet(
    filter: BsonDocument,
    replacement: BsonDocument,
    options: FindOneAndReplaceOptions = FindOneAndReplaceOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndReplace(
        filter = filter,
        replacement = replacement,
        options = options.copy(returnDocument = ReturnDocument.After),
        session = session,
    )
}

/**
 * Atomically find a document and replace it and return the replacement document.
 *
 * @param session the client session with which to associate this operation.
 * @param filter the query filter to apply the replace operation.
 * @param replacement the replacement document.
 * @param options the options to apply to the operation.
 * @return the document that was replaced.
 * @see com.mongodb.client.MongoCollection.findOneAndReplace
 */
suspend fun MongoCollection.replaceOneGet(
    filter: BsonDocumentBlock,
    replacement: BsonDocumentBlock,
    session: ClientSession? = null,
    options: FindOneAndReplaceOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndReplace(
        filter = BsonDocument(filter),
        replacement = BsonDocument(replacement),
        options = FindOneAndReplaceOptions(options)
            .apply { returnDocument = ReturnDocument.After },
        session = session,
    )
}

// ===============[ findOneAndReplace: replaceOneByIdGet ]

/**
 * Atomically find a document and replace it and return the replacement document.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param replacement the replacement document.
 * @param options the options to apply to the operation.
 * @return the document that was replaced.
 * @see com.mongodb.client.MongoCollection.findOneAndReplace
 */
suspend fun MongoCollection.replaceOneByIdGet(
    id: AnyID,
    replacement: BsonDocument,
    options: FindOneAndReplaceOptions = FindOneAndReplaceOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndReplace(
        filter = BsonDocument { "_id" by id },
        replacement = replacement,
        options = options.copy(returnDocument = ReturnDocument.After),
        session = session
    )
}

/**
 * Atomically find a document and replace it and return the replacement document.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param replacement the replacement document.
 * @param options the options to apply to the operation.
 * @return the document that was replaced.
 * @see com.mongodb.client.MongoCollection.findOneAndReplace
 */
suspend fun MongoCollection.replaceOneByIdGet(
    id: AnyID,
    replacement: BsonDocumentBlock,
    session: ClientSession? = null,
    options: FindOneAndReplaceOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndReplace(
        filter = BsonDocument { "_id" by id },
        replacement = BsonDocument(replacement),
        options = FindOneAndReplaceOptions(options)
            .apply { returnDocument = ReturnDocument.After },
        session = session
    )
}

// ===============[ findOneAndUpdate: updateOneGet ]

/**
 * Atomically find a document and update it and return the resultant document.
 *
 * @param session the client session with which to associate this operation.
 * @param filter a document describing the query filter, which may not be null.
 * @param update  a document describing the update, which may not be null.
 *                The update to apply must include only update operators.
 * @param options the options to apply to the operation.
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.updateOneGet(
    filter: BsonDocument,
    update: BsonDocument,
    options: FindOneAndUpdateOptions = FindOneAndUpdateOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndUpdate(
        filter = filter,
        update = update,
        options = options.copy(returnDocument = ReturnDocument.After),
        session = session
    )
}

/**
 * Atomically find a document and update it and return the resultant document.
 *
 * Note: Supports retryable writes on MongoDB
 * server versions 3.6 or higher when the
 * retryWrites setting is enabled.
 *
 * @param session the client session with which to associate this operation.
 * @param filter a document describing the query filter, which may not be null.
 * @param update a pipeline describing the update, which may not be null.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 *         Depending on the value of the `returnOriginal` property, this will either be
 *         the document as it was before the update or as it is after the update.
 *         If no documents matched the query filter, then null will be returned.
 * @since 2.0.0
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.updateOneGet(
    filter: BsonDocument,
    update: List<BsonDocument>,
    options: FindOneAndUpdateOptions = FindOneAndUpdateOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndUpdate(
        filter = filter,
        update = update,
        options = options.copy(returnDocument = ReturnDocument.After),
        session = session
    )
}

/**
 * Atomically find a document and update it and return the resultant document.
 *
 * @param session the client session with which to associate this operation.
 * @param filter a document describing the query filter, which may not be null.
 * @param update  a document describing the update, which may not be null.
 *                The update to apply must include only update operators.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.updateOneGet(
    filter: BsonDocumentBlock,
    update: BsonDocumentBlock,
    session: ClientSession? = null,
    options: FindOneAndUpdateOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument(filter),
        update = BsonDocument(update),
        options = FindOneAndUpdateOptions(options)
            .apply { returnDocument = ReturnDocument.After },
        session = session
    )
}

/**
 * Atomically find a document and update it and return the resultant document.
 *
 * Note: Supports retryable writes on MongoDB
 * server versions 3.6 or higher when the
 * retryWrites setting is enabled.
 *
 * @param session the client session with which to associate this operation.
 * @param filter a document describing the query filter, which may not be null.
 * @param update a pipeline describing the update, which may not be null.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.updateOneGet(
    filter: BsonDocumentBlock,
    update: List<BsonDocumentBlock>,
    session: ClientSession? = null,
    options: FindOneAndUpdateOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument(filter),
        update = update.map { BsonDocument(it) },
        options = FindOneAndUpdateOptions(options)
            .apply { returnDocument = ReturnDocument.After },
        session = session
    )
}

// ===============[ findOneAndUpdate: updateOneByIdGet ]

/**
 * Atomically find a document and update it and return the resultant document.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update  a document describing the update, which may not be null.
 *                The update to apply must include only update operators.
 * @param options the options to apply to the operation.
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.updateOneByIdGet(
    id: AnyID,
    update: BsonDocument,
    options: FindOneAndUpdateOptions = FindOneAndUpdateOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = update,
        options = options.copy(returnDocument = ReturnDocument.After),
        session = session
    )
}

/**
 * Atomically find a document and update it and return the resultant document.
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
suspend fun MongoCollection.updateOneByIdGet(
    id: AnyID,
    update: List<BsonDocument>,
    options: FindOneAndUpdateOptions = FindOneAndUpdateOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = update,
        options = options.copy(returnDocument = ReturnDocument.After),
        session = session
    )
}

/**
 * Atomically find a document and update it and return the resultant document.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param update  a document describing the update, which may not be null.
 *                The update to apply must include only update operators.
 * @param options the options to apply to the operation.
 * @return the document that was updated.
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.updateOneByIdGet(
    id: AnyID,
    update: BsonDocumentBlock,
    session: ClientSession? = null,
    options: FindOneAndUpdateOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = BsonDocument(update),
        options = FindOneAndUpdateOptions(options)
            .apply { returnDocument = ReturnDocument.After },
        session = session
    )
}

/**
 * Atomically find a document and update it and return the resultant document.
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
 * @see com.mongodb.client.MongoCollection.findOneAndUpdate
 */
suspend fun MongoCollection.updateOneByIdGet(
    id: AnyID,
    update: List<BsonDocumentBlock>,
    session: ClientSession? = null,
    options: FindOneAndUpdateOptions.() -> Unit = {},
): BsonDocument? {
    return findOneAndUpdate(
        filter = BsonDocument { "_id" by id },
        update = update.map { BsonDocument(it) },
        options = FindOneAndUpdateOptions(options)
            .apply { returnDocument = ReturnDocument.After },
        session = session
    )
}

// ===============[ find: findOne ]

/**
 * Finds the first document in the collection.
 *
 * @param session the client session with which to associate this operation.
 * @param filter the query filter.
 * @param options the operation options.
 * @return the first document.
 * @since 2.0.0
 * @see MongoCollection.find
 */
suspend fun MongoCollection.findOne(
    filter: BsonDocument = BsonDocument.Empty,
    options: FindOptions = FindOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return find(
        filter = filter,
        options = options.copy(limit = 1),
        session = session
    ).firstOrNull()
}

/**
 * Finds the first document in the collection.
 *
 * @param session the client session with which to associate this operation.
 * @param filter the query filter.
 * @param options the operation options.
 * @return the first document.
 * @since 2.0.0
 * @see MongoCollection.find
 */
suspend fun MongoCollection.findOne(
    filter: BsonDocumentBlock,
    session: ClientSession? = null,
    options: FindOptions.() -> Unit = {},
): BsonDocument? {
    return find(
        filter = BsonDocument(filter),
        options = FindOptions(options)
            .apply { limit = 1 },
        session = session
    ).firstOrNull()
}

// ===============[ find: findOneById ]

/**
 * Finds the first document in the collection.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param options the operation options.
 * @return the first document.
 * @since 2.0.0
 * @see MongoCollection.find
 */
suspend fun MongoCollection.findOneById(
    id: AnyID,
    options: FindOptions = FindOptions(),
    session: ClientSession? = null,
): BsonDocument? {
    return find(
        filter = BsonDocument { "_id" by id },
        options = options.copy(limit = 1),
        session = session
    ).firstOrNull()
}

/**
 * Finds the first document in the collection.
 *
 * @param session the client session with which to associate this operation.
 * @param id the id of the document.
 * @param options the operation options.
 * @return the first document.
 * @since 2.0.0
 * @see MongoCollection.find
 */
suspend fun MongoCollection.findOneById(
    id: AnyID,
    session: ClientSession? = null,
    options: FindOptions.() -> Unit,
): BsonDocument? {
    return find(
        filter = BsonDocument { "_id" by id },
        options = FindOptions(options)
            .apply { limit = 1 },
        session = session
    ).firstOrNull()
}

// ===============[ createIndex: tryCreateIndex ]

/**
 * Attempt creating an index. Return `null` on failure.
 *
 * @param keys an object describing the index key(s), which may not be null.
 * @param options the options for the index.
 * @param session the client session with which to associate this operation.
 * @see MongoCollection.createIndex
 */
suspend fun MongoCollection.tryCreateIndex(
    keys: BsonDocument,
    options: CreateIndexOptions = CreateIndexOptions(),
    session: ClientSession? = null,
): String? {
    return try {
        createIndex(
            keys = keys,
            options = options,
            session = session
        )
    } catch (_: MongoCommandException) {
        null
    }
}

/**
 * Attempt creating an index. Return `null` on failure.
 *
 * @param keys an object describing the index key(s), which may not be null.
 * @param options the options for the index.
 * @param session the client session with which to associate this operation.
 * @see MongoCollection.createIndex
 */
suspend fun MongoCollection.tryCreateIndex(
    keys: BsonDocumentBlock,
    session: ClientSession? = null,
    options: CreateIndexOptions.() -> Unit = {},
): String? {
    return try {
        createIndex(
            keys = BsonDocument(keys),
            options = CreateIndexOptions(options),
            session = session
        )
    } catch (_: MongoCommandException) {
        null
    }
}

// ===============[ createIndexes: tryCreateIndexes ]

/**
 * Create multiple indexes.. Return `null` on failure.
 *
 * @param indexes the list of indexes.
 * @param options options to use when creating indexes.
 * @param session the client session with which to associate this operation.
 * @see MongoCollection.createIndexes
 */
suspend fun MongoCollection.tryCreateIndexes(
    indexes: List<CreateIndexModel>,
    options: CreateIndexesOptions = CreateIndexesOptions(),
    session: ClientSession? = null,
): List<String>? {
    return try {
        createIndexes(
            indexes = indexes,
            options = options,
            session = session
        )
    } catch (_: MongoCommandException) {
        null
    }
}

/**
 * Create multiple indexes.. Return `null` on failure.
 *
 * @param indexes the list of indexes.
 * @param options options to use when creating indexes.
 * @param session the client session with which to associate this operation.
 * @see MongoCollection.createIndexes
 */
suspend fun MongoCollection.tryCreateIndexes(
    vararg indexes: CreateIndexModel,
    session: ClientSession? = null,
    options: CreateIndexesOptions.() -> Unit = {},
): List<String>? {
    return try {
        createIndexes(
            indexes = indexes.asList(),
            options = CreateIndexesOptions(options),
            session = session
        )
    } catch (_: MongoCommandException) {
        null
    }
}

/* ============= ------------------ ============= */

/**
 * Creates an index.
 * If the index already exists, remove the existing
 * index and recreate it.
 *
 * @param keys an object describing the index key(s), which may not be null.
 * @param options the options for the index.
 * @param session the client session with which to associate this operation.
 * @since 2.0.0
 * @see MongoCollection.dropIndex
 * @see MongoCollection.createIndex
 */
@Deprecated("Use tryCreateIndex instead. This is dangerous to performance.")
suspend fun MongoCollection.ensureIndex(
    keys: BsonDocument,
    options: CreateIndexOptions = CreateIndexOptions(),
    session: ClientSession? = null,
): String {
    return try {
        createIndex(
            keys = keys,
            options = options,
            session = session
        )
    } catch (_: MongoCommandException) {
        dropIndex(keys)
        createIndex(
            keys = keys,
            options = options,
            session = session
        )
    }
}

/**
 * Creates an index.
 * If the index already exists, remove the existing
 * index and recreate it.
 *
 * @param keys an object describing the index key(s), which may not be null.
 * @param options the options for the index.
 * @param session the client session with which to associate this operation.
 * @since 2.0.0
 * @see MongoCollection.dropIndex
 * @see MongoCollection.createIndex
 */
@Deprecated("Use tryCreateIndex instead. This is dangerous to performance.")
suspend fun MongoCollection.ensureIndex(
    keys: BsonDocumentBlock,
    session: ClientSession? = null,
    options: CreateIndexOptions.() -> Unit = {},
): String {
    val keysDocument = BsonDocument(keys)
    val optionsDocument = CreateIndexOptions(options)
    return try {
        createIndex(
            keys = keysDocument,
            options = optionsDocument,
            session = session
        )
    } catch (_: MongoCommandException) {
        dropIndex(keys = keysDocument)
        createIndex(
            keys = keysDocument,
            options = optionsDocument,
            session = session
        )
    }
}

/* ============= ------------------ ============= */
