@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr._Array
import org.cufy.mongodb.expr.Expr._Boolean

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#set-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/allElementsTrue/ */
@BsonMarker2
fun `$allElementsTrue`(expression: Expr<_Array>): Expr<_Boolean> =
    Expr { `$allElementsTrue` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/anyElementTrue/ */
@BsonMarker2
fun `$anyElementTrue`(expression: Expr<_Array>): Expr<_Boolean> =
    Expr { `$anyElementTrue` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setDifference/ */
@BsonMarker2
fun `$setDifference`(expression1: Expr<_Array>, expression2: Expr<_Array>): Expr<_Array> =
    Expr { `$setDifference` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setEquals/ */
@BsonMarker2
fun `$setEquals`(vararg expressions: Expr<_Array>): Expr<_Boolean> =
    `$setEquals`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setEquals/ */
@BsonMarker2
fun `$setEquals`(expressions: List<Expr<_Array>>): Expr<_Boolean> =
    Expr { `$setEquals` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setIntersection/ */
@BsonMarker2
fun `$setIntersection`(vararg arrays: Expr<_Array>): Expr<_Array> =
    `$setIntersection`(arrays.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setIntersection/ */
@BsonMarker2
fun `$setIntersection`(arrays: List<Expr<_Array>>): Expr<_Array> =
    Expr { `$setIntersection` by array { arrays.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setIsSubset/ */
@BsonMarker2
fun `$setIsSubset`(expression1: Expr<_Array>, expression2: Expr<_Array>): Expr<_Boolean> =
    Expr { `$setIsSubset` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setUnion/ */
@BsonMarker2
fun `$setUnion`(vararg expressions: Expr<_Array>): Expr<_Array> =
    `$setUnion`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setUnion/ */
@BsonMarker2
fun `$setUnion`(expressions: List<Expr<_Array>>): Expr<_Array> =
    Expr { `$setUnion` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */
