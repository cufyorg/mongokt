@file:Suppress("FunctionName")

package org.cufy.mongodb.filters

import org.cufy.bson.*
import org.cufy.mongodb.`$and`
import org.cufy.mongodb.`$nor`
import org.cufy.mongodb.`$not`
import org.cufy.mongodb.`$or`

// https://www.mongodb.com/docs/manual/reference/operator/query/#logical

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/and */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$and`(vararg expressions: /* Query */BsonDocumentBlock) =
    `$and` by array { expressions.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/and */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$and`(expressions: List</* Query */BsonDocument>) =
    `$and` by array { expressions.forEach { by(it) } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/not */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun `$not`(operatorExpression: /* Operator */BsonDocumentBlock) =
    `$not` by operatorExpression

/** https://www.mongodb.com/docs/manual/reference/operator/query/not */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.`$not`(operatorExpression: /* Operator */BsonDocumentBlock) =
    this by { `$not` by operatorExpression }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/nor */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$nor`(vararg expressions: /* Query */BsonDocumentBlock) =
    `$nor` by array { expressions.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/nor */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$nor`(expressions: List</* Query */BsonDocument>) =
    `$nor` by array { expressions.forEach { by(it) } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/or */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$or`(vararg expressions: /* Query */BsonDocumentBlock) =
    `$or` by array { expressions.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/or */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$or`(expressions: List</* Query */BsonDocument>) =
    `$or` by array { expressions.forEach { by(it) } }

/* ============= ------------------ ============= */
