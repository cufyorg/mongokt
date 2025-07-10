@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#comparison-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/cmp/ */
@BsonMarker2
context(_: ExprScope)
fun cmp(expression1: Expr<_Element>, expression2: Expr<_Element>): Expr<_Number> =
    Expr { `$cmp` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/eq/ */
@BsonMarker2
context(_: ExprScope)
fun eq(expression1: Expr<_Element>, expression2: Expr<_Element>): Expr<_Boolean> =
    Expr { `$eq` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/gt/ */
@BsonMarker2
context(_: ExprScope)
fun gt(expression1: Expr<_Element>, expression2: Expr<_Element>): Expr<_Boolean> =
    Expr { `$gt` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/gte/ */
@BsonMarker2
context(_: ExprScope)
fun gte(expression1: Expr<_Element>, expression2: Expr<_Element>): Expr<_Boolean> =
    Expr { `$gte` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/lt/ */
@BsonMarker2
context(_: ExprScope)
fun lt(expression1: Expr<_Element>, expression2: Expr<_Element>): Expr<_Boolean> =
    Expr { `$lt` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/lte/ */
@BsonMarker2
context(_: ExprScope)
fun lte(expression1: Expr<_Element>, expression2: Expr<_Element>): Expr<_Boolean> =
    Expr { `$lte` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/ne/ */
@BsonMarker2
context(_: ExprScope)
fun ne(expression1: Expr<_Element>, expression2: Expr<_Element>): Expr<_Boolean> =
    Expr { `$ne` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */
