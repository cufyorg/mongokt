package org.cufy.mongodb.filters

import org.cufy.bson.*
import org.cufy.mongodb.*

// https://www.mongodb.com/docs/manual/reference/operator/query/#comparison

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/eq */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun eq(value: BsonElement) =
    `$eq` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/eq */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.eq(value: BsonElement) =
    this by { `$eq` by value }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/gt */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun gt(value: BsonElement) =
    `$gt` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/gt */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.gt(value: BsonElement) =
    this by { `$gt` by value }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/gte */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun gte(value: BsonElement) =
    `$gte` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/gte */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.gte(value: BsonElement) =
    this by { `$gte` by value }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/in */
@Suppress("FunctionName")
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun _in(vararg values: BsonElement) =
    `$in` by array(*values)

/** https://www.mongodb.com/docs/manual/reference/operator/query/in */
@Suppress("FunctionName")
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun _in(values: List<BsonElement>) =
    `$in` by values

/** https://www.mongodb.com/docs/manual/reference/operator/query/in */
@Suppress("FunctionName")
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String._in(values: List<BsonElement>) =
    this by { `$in` by values }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/lt */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun lt(value: BsonElement) =
    `$lt` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/lt */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.lt(value: BsonElement) =
    this by { `$lt` by value }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/lte */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun lte(value: BsonElement) =
    `$lte` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/lte */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.lte(value: BsonElement) =
    this by { `$lte` by value }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/ne */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun ne(value: BsonElement) =
    `$ne` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/ne */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.ne(value: BsonElement) =
    this by { `$ne` by value }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/nin */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun nin(vararg values: BsonElement) =
    `$nin` by array(*values)

/** https://www.mongodb.com/docs/manual/reference/operator/query/nin */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun nin(values: List<BsonElement>) =
    `$nin` by values

/** https://www.mongodb.com/docs/manual/reference/operator/query/nin */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.nin(values: List<BsonElement>) =
    this by { `$nin` by values }

/* ============= ------------------ ============= */
