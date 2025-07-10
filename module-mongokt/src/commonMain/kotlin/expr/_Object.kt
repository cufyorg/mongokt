@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.`$mergeObjects`
import org.cufy.mongodb.`$setField`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#object-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/mergeObjects/ */
@BsonMarker2
context(_: ExprScope)
fun mergeObjects(vararg documents: Expr<_Document>): Expr<_Document> =
    mergeObjects(documents.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/mergeObjects/ */
@BsonMarker2
context(_: ExprScope)
fun mergeObjects(documents: List<Expr<_Document>>): Expr<_Document> =
    Expr { `$mergeObjects` by array { documents.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

// $objectToArray @ _Array.kt

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setField/ */
@BsonMarker2
context(_: ExprScope)
fun setField(
    field: Expr<_String>,
    input: Expr<_Document>,
    value: Expr<_Element>,
): Expr<_Document> = Expr {
    `$setField` by {
        "field" by field.element
        "input" by input.element
        "value" by value.element
    }
}

/* ============= ------------------ ============= */
