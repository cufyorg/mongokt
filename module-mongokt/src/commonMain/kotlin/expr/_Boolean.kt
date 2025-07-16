@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.`$and`
import org.cufy.mongodb.`$not`
import org.cufy.mongodb.`$or`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr._Element
import org.cufy.mongodb.expr.Expr._Boolean

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#boolean-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/and/ */
@BsonMarker2
fun `$and`(vararg expressions: Expr<_Element>): Expr<_Boolean> =
    `$and`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/and/ */
@BsonMarker2
fun `$and`(expressions: List<Expr<_Element>>): Expr<_Boolean> =
    Expr { `$and` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/not/ */
@BsonMarker2
fun `$not`(expression: Expr<_Element>): Expr<_Boolean> =
    Expr { `$not` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/or/ */
@BsonMarker2
fun `$or`(vararg expressions: Expr<_Element>): Expr<_Boolean> =
    `$or`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/or/ */
@BsonMarker2
fun `$or`(expressions: List<Expr<_Element>>): Expr<_Boolean> =
    Expr { `$or` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */
