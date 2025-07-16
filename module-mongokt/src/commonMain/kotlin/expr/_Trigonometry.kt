@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr._Number

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#trigonometry-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sin/ */
@BsonMarker2
fun `$sin`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$sin` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/cos/ */
@BsonMarker2
fun `$cos`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$cos` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/tan/ */
@BsonMarker2
fun `$tan`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$tan` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/asin/ */
@BsonMarker2
fun `$asin`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$asin` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/acos/ */
@BsonMarker2
fun `$acos`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$acos` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/atan/ */
@BsonMarker2
fun `$atan`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$atan` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/atan2/ */
@BsonMarker2
fun `$atan2`(expression1: Expr<_Number>, expression2: Expr<_Number>): Expr<_Number> =
    Expr { `$atan2` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/asinh/ */
@BsonMarker2
fun `$asinh`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$asinh` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/acosh/ */
@BsonMarker2
fun `$acosh`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$acosh` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/atanh/ */
@BsonMarker2
fun `$atanh`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$atanh` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sinh/ */
@BsonMarker2
fun `$sinh`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$sinh` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/cosh/ */
@BsonMarker2
fun `$cosh`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$cosh` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/tanh/ */
@BsonMarker2
fun `$tanh`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$tanh` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/degreesToRadians/ */
@BsonMarker2
fun `$degreesToRadians`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$degreesToRadians` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/radiansToDegrees/ */
@BsonMarker2
fun `$radiansToDegrees`(expression: Expr<_Number>): Expr<_Number> =
    Expr { `$radiansToDegrees` by expression.element }

/* ============= ------------------ ============= */
