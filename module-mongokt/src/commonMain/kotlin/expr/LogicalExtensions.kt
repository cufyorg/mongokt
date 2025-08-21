@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

/* ============= ------------------ ============= */

// _Boolean.kt

@BsonMarker4
operator fun Expr<_Element>.not(): Expr<_Boolean> =
    `$not`(this)

/* ============= ------------------ ============= */

// _Boolean.kt

@BsonMarker4
infix fun Expr<_Element>.and(other: Expr<_Element>): Expr<_Boolean> =
    `$and`(this, other)

@BsonMarker4
infix fun Expr<_Element>.or(other: Expr<_Element>): Expr<_Boolean> =
    `$or`(this, other)

// _Comparison.kt

@BsonMarker4
infix fun Expr<_Element>.cmp(other: Expr<_Element>): Expr<_Number> =
    `$cmp`(this, other)

@BsonMarker4
infix fun Expr<_Element>.eq(other: Expr<_Element>): Expr<_Boolean> =
    `$eq`(this, other)

@BsonMarker4
infix fun Expr<_Element>.gt(other: Expr<_Element>): Expr<_Boolean> =
    `$gt`(this, other)

@BsonMarker4
infix fun Expr<_Element>.gte(other: Expr<_Element>): Expr<_Boolean> =
    `$gte`(this, other)

@BsonMarker4
infix fun Expr<_Element>.lt(other: Expr<_Element>): Expr<_Boolean> =
    `$lt`(this, other)

@BsonMarker4
infix fun Expr<_Element>.lte(other: Expr<_Element>): Expr<_Boolean> =
    `$lte`(this, other)

@BsonMarker4
infix fun Expr<_Element>.ne(other: Expr<_Element>): Expr<_Boolean> =
    `$ne`(this, other)

// _Conditional.kt

@BsonMarker4
infix fun <T : _Element> Expr<T>.ifNull(other: Expr<T>): Expr<T> =
    `$ifNull`(this, other)

/* ============= ------------------ ============= */
