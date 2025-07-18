@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.bson.by
import org.cufy.mongodb.`$tsIncrement`
import org.cufy.mongodb.`$tsSecond`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr._Number
import org.cufy.mongodb.expr.Expr._Timestamp

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#timestamp-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/tsIncrement/ */
@BsonMarker4
fun `$tsIncrement`(expression: Expr<_Timestamp>): Expr<_Number> =
    Expr { `$tsIncrement` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/tsSecond/ */
@BsonMarker4
fun `$tsSecond`(expression: Expr<_Timestamp>): Expr<_Number> =
    Expr { `$tsSecond` by expression.element }

/* ============= ------------------ ============= */
