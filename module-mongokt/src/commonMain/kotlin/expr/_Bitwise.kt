@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr._Number

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#bitwise-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitAnd/ */
@BsonMarker4
fun `$bitAnd`(vararg expressions: Expr<_Number>): Expr<_Number> =
    `$bitAnd`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitAnd/ */
@BsonMarker4
fun `$bitAnd`(expressions: List<Expr<_Number>>): Expr<_Number> =
    Expr { `$bitAnd` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitNot/ */
@BsonMarker4
fun `$bitNot`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$bitNot` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitOr/ */
@BsonMarker4
fun `$bitOr`(vararg expressions: Expr<_Number>): Expr<_Number> =
    `$bitOr`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitOr/ */
@BsonMarker4
fun `$bitOr`(expressions: List<Expr<_Number>>): Expr<_Number> =
    Expr { `$bitOr` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitXor/ */
@BsonMarker4
fun `$bitXor`(vararg expressions: Expr<_Number>): Expr<_Number> =
    `$bitXor`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitXor/ */
@BsonMarker4
fun `$bitXor`(expressions: List<Expr<_Number>>): Expr<_Number> =
    Expr { `$bitXor` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */
