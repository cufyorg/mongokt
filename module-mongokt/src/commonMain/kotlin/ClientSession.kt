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
@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package org.cufy.mongodb

/* ============= ------------------ ============= */

/**
 * A client session that supports transactions.
 *
 * @see com.mongodb.reactivestreams.client.ClientSession
 * @author LSafer
 * @since 2.0.0
 */
expect class ClientSession

/* ============= ------------------ ============= */

/**
 * Returns true if there is an active transaction on
 * this session, and false otherwise
 *
 * @see com.mongodb.reactivestreams.client.ClientSession.hasActiveTransaction
 */
expect val ClientSession.hasActiveTransaction: Boolean

/**
 * Gets the transaction options.
 *
 * Only call this method of the session has an active
 * transaction.
 *
 * @see com.mongodb.reactivestreams.client.ClientSession.getTransactionOptions
 */
expect val ClientSession.transactionOptions: TransactionOptions

/* ============= ------------------ ============= */

/**
 * Start a transaction in the context of this session
 * with the given transaction options.
 *
 * A transaction can not be started if there is already
 * an active transaction on this session.
 *
 * @param options the options to apply to the transaction.
 * @see com.mongodb.reactivestreams.client.ClientSession.startTransaction
 */
expect fun ClientSession.startTransaction(
    options: TransactionOptions = TransactionOptions(),
)

/**
 * Commit a transaction in the context of this session.
 *
 * A transaction can only be commmited if one has first been started.
 *
 * @see com.mongodb.reactivestreams.client.ClientSession.commitTransaction
 */
expect suspend fun ClientSession.commitTransaction()

/**
 * Abort a transaction in the context of this session.
 *
 * A transaction can only be aborted if one has first been started.
 *
 * @see com.mongodb.reactivestreams.client.ClientSession.abortTransaction
 */
expect suspend fun ClientSession.abortTransaction()

/* ============= ------------------ ============= */
