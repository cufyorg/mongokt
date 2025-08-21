@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#set-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/allElementsTrue/ */
@BsonMarker4
fun `$allElementsTrue`(expression: Expr<_Array<*>>): Expr<_Boolean> =
    Expr { `$allElementsTrue` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/anyElementTrue/ */
@BsonMarker4
fun `$anyElementTrue`(expression: Expr<_Array<*>>): Expr<_Boolean> =
    Expr { `$anyElementTrue` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setDifference/ */
@BsonMarker4
fun <T : _Element> `$setDifference`(expression1: Expr<_Array<T>>, expression2: Expr<_Array<T>>): Expr<_Array<T>> =
    Expr { `$setDifference` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setEquals/ */
@BsonMarker4
fun `$setEquals`(vararg expressions: Expr<_Array<*>>): Expr<_Boolean> =
    `$setEquals`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setEquals/ */
@BsonMarker4
fun `$setEquals`(expressions: List<Expr<_Array<*>>>): Expr<_Boolean> =
    Expr { `$setEquals` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setIntersection/ */
@BsonMarker4
fun <T : _Element> `$setIntersection`(vararg arrays: Expr<_Array<T>>): Expr<_Array<T>> =
    `$setIntersection`(arrays.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setIntersection/ */
@BsonMarker4
fun <T : _Element> `$setIntersection`(arrays: List<Expr<_Array<T>>>): Expr<_Array<T>> =
    Expr { `$setIntersection` by array { arrays.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setIsSubset/ */
@BsonMarker4
fun `$setIsSubset`(expression1: Expr<_Array<*>>, expression2: Expr<_Array<*>>): Expr<_Boolean> =
    Expr { `$setIsSubset` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setUnion/ */
@BsonMarker4
fun <T : _Element> `$setUnion`(vararg expressions: Expr<_Array<T>>): Expr<_Array<T>> =
    `$setUnion`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setUnion/ */
@BsonMarker4
fun <T : _Element> `$setUnion`(expressions: List<Expr<_Array<T>>>): Expr<_Array<T>> =
    Expr { `$setUnion` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */
