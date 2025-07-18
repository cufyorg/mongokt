@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.bson.by
import org.cufy.mongodb.`$getField`
import org.cufy.mongodb.`$rand`
import org.cufy.mongodb.`$toHashedIndexKey`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#miscellaneous-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/getField/ */
@BsonMarker4
fun `$getField`(
    field: Expr<_String>,
    input: Expr<_Document>? = null,
): Expr<_Element> = Expr {
    `$getField` by {
        "field" by field.element
        if (input != null) "input" by input.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/rand/ */
@BsonMarker4
fun `$rand`(): Expr<_Number> =
    Expr { `$rand` by {} }

/* ============= ------------------ ============= */

// $sampleRate is not an expression function

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toHashedIndexKey/ */
@BsonMarker4
fun `$toHashedIndexKey`(stringToHash: Expr<_String>): Expr<_Number> =
    Expr { `$toHashedIndexKey` by stringToHash.element }

/* ============= ------------------ ============= */
