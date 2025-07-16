@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#type-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/convert/ */
@BsonMarker2
fun `$convert`(
    input: Expr<_Element>,
    to: Expr<_Element>,
    format: String? = null,
    onError: Expr<_Element>? = null,
    onNull: Expr<_Element>? = null
): Expr<_Element> = Expr {
    `$convert` by {
        "input" by input.element
        "to" by to.element
        if (format != null) "format" by format
        if (onError != null) "onError" by onError.element
        if (onNull != null) "onNull" by onNull.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/isNumber/ */
@BsonMarker2
fun `$isNumber`(expression: Expr<_Number>): Expr<_Boolean> =
    Expr { `$isNumber` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toBool/ */
@BsonMarker2
fun `$toBool`(expression: Expr<_Element>): Expr<_Boolean> =
    Expr { `$toBool` by expression.element }

/* ============= ------------------ ============= */

// $toDate @ _Date.kt

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toDecimal/ */
@BsonMarker2
fun `$toDecimal`(expression: Expr<_Element>): Expr<_Number> =
    Expr { `$toDecimal` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toDouble/ */
@BsonMarker2
fun `$toDouble`(expression: Expr<_Element>): Expr<_Number> =
    Expr { `$toDouble` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toInt/ */
@BsonMarker2
fun `$toInt`(expression: Expr<_Element>): Expr<_Number> =
    Expr { `$toInt` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toLong/ */
@BsonMarker2
fun `$toLong`(expression: Expr<_Element>): Expr<_Number> =
    Expr { `$toLong` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toObjectId/ */
@BsonMarker2
fun `$toObjectId`(expression: Expr<_Element>): Expr<_ObjectId> =
    Expr { `$toObjectId` by expression.element }

/* ============= ------------------ ============= */

// $toString @ _String.kt

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/type/ */
@BsonMarker2
fun `$type`(expression: Expr<_Element>): Expr<_String> =
    Expr { `$type` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toUUID/ */
@BsonMarker2
fun `$toUUID`(expression: Expr<_String>): Expr<_Binary> =
    Expr { `$toUUID` by expression.element }

/* ============= ------------------ ============= */
