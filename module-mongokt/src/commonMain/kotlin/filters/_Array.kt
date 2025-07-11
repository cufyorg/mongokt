package org.cufy.mongodb.filters

import org.cufy.bson.*
import org.cufy.mongodb.`$all`
import org.cufy.mongodb.`$elemMatch`
import org.cufy.mongodb.`$size`

// https://www.mongodb.com/docs/manual/reference/operator/query/#array

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/all */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun all(vararg values: BsonElement) =
    `$all` by array(*values)

/** https://www.mongodb.com/docs/manual/reference/operator/query/all */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun all(values: List<BsonElement>) =
    `$all` by values

/** https://www.mongodb.com/docs/manual/reference/operator/query/all */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.all(values: List<BsonElement>) =
    this by { `$all` by values }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/elemMatch */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun elemMatch(query: /* Query & Operator */BsonDocumentBlock) =
    `$elemMatch` by query

/** https://www.mongodb.com/docs/manual/reference/operator/query/elemMatch */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun elemMatch(query: /* Query & Operator */BsonDocument) =
    `$elemMatch` by query

/** https://www.mongodb.com/docs/manual/reference/operator/query/elemMatch */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.elemMatch(query: /* Query & Operator */BsonDocumentBlock) =
    this by { `$elemMatch` by query }

/** https://www.mongodb.com/docs/manual/reference/operator/query/elemMatch */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.elemMatch(query: /* Query & Operator */BsonDocument) =
    this by { `$elemMatch` by query }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/size */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun size(value: Int) =
    `$size` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/size */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun size(value: Long) =
    `$size` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/size */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.size(value: Int) =
    this by { `$size` by value }

/** https://www.mongodb.com/docs/manual/reference/operator/query/size */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.size(value: Long) =
    this by { `$size` by value }

/* ============= ------------------ ============= */
