@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#array-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/arrayElemAt/ */
@BsonMarker2
fun `$arrayElemAt`(array: Expr<_Array>, idx: Expr<_Number>): Expr<_Element> =
    Expr { `$arrayElemAt` by array(array.element, idx.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/arrayToObject/ */
@BsonMarker2
fun `$arrayToObject`(expression: Expr<_Array>): Expr<_Document> =
    Expr { `$arrayToObject` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/concatArrays/ */
@BsonMarker2
fun `$concatArrays`(vararg arrays: Expr<_Array>): Expr<_Array> =
    `$concatArrays`(arrays.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/concatArrays/ */
@BsonMarker2
fun `$concatArrays`(arrays: List<Expr<_Array>>): Expr<_Array> =
    Expr { `$concatArrays` by array { arrays.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/filter/ */
@Suppress("LocalVariableName")
@BsonMarker2
fun `$filter`(
    input: Expr<_Array>,
    _as: String? = null,
    cond: Expr<_Boolean>,
    limit: Expr<_Number>? = null,
): Expr<_Array> = Expr {
    `$filter` by {
        "input" by input.element
        if (_as != null) "as" by _as
        "cond" by cond.element
        if (limit != null) "limit" by limit.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/firstN/ */
@BsonMarker2
fun `$firstN`(input: Expr<_Array>, n: Expr<_Number>): Expr<_Array> =
    Expr { `$firstN` by { "input" by input.element; "n" by n.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/in/ */
@BsonMarker2
fun `$in`(expression: Expr<_Element>, arrayExpression: Expr<_Array>): Expr<_Boolean> =
    Expr { `$in` by array(expression.element, arrayExpression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/indexOfArray/ */
@BsonMarker2
fun `$indexOfArray`(
    arrayExpression: Expr<_Array>,
    searchExpression: Expr<_Element>,
    start: Expr<_Number>? = null,
): Expr<_Number> = Expr {
    if (start != null) {
        `$indexOfArray` by array(
            arrayExpression.element,
            searchExpression.element,
            start.element,
        )
    } else {
        `$indexOfArray` by array(
            arrayExpression.element,
            searchExpression.element,
        )
    }
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/indexOfArray/ */
@BsonMarker2
fun `$indexOfArray`(
    arrayExpression: Expr<_Array>,
    searchExpression: Expr<_Element>,
    start: Expr<_Number>,
    end: Expr<_Number>? = null,
): Expr<_Number> = Expr {
    if (end != null) {
        `$indexOfArray` by array(
            arrayExpression.element,
            searchExpression.element,
            start.element,
            end.element,
        )
    } else {
        `$indexOfArray` by array(
            arrayExpression.element,
            searchExpression.element,
            start.element,
        )
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/isArray/ */
@BsonMarker2
fun `$isArray`(expression: Expr<_Element>): Expr<_Boolean> =
    Expr { `$isArray` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/lastN/ */
@BsonMarker2
fun `$lastN`(input: Expr<_Array>, n: Expr<_Number>): Expr<_Array> =
    Expr { `$lastN` by { "input" by input.element; "n" by n.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/map/ */
@Suppress("LocalVariableName")
@BsonMarker2
fun `$map`(
    input: Expr<_Array>,
    _as: String? = null,
    _in: Expr<_Element>,
): Expr<_Array> = Expr {
    `$map` by {
        "input" by input.element
        if (_as != null) "as" by _as
        "in" by _in.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/maxN/ */
@BsonMarker2
fun `$maxN`(input: Expr<_Array>, n: Expr<_Number>): Expr<_Array> =
    Expr { `$maxN` by { "input" by input.element; "n" by n.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/minN/ */
@BsonMarker2
fun `$minN`(input: Expr<_Array>, n: Expr<_Number>): Expr<_Array> =
    Expr { `$minN` by { "input" by input.element; "n" by n.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/objectToArray/ */
@Suppress("LocalVariableName")
@BsonMarker2
fun `$objectToArray`(_object: Expr<_Document>): Expr<_Array> =
    Expr { `$objectToArray` by _object.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/range/ */
@BsonMarker2
fun `$range`(
    start: Expr<_Number>,
    end: Expr<_Number>,
    step: Expr<_Number>? = null,
): Expr<_Array> = Expr {
    if (step != null) {
        `$range` by array(
            start.element,
            end.element,
            step.element,
        )
    } else {
        `$range` by array(
            start.element,
            end.element,
        )
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/reduce/ */
@Suppress("LocalVariableName")
@BsonMarker2
fun <T : _Element> `$reduce`(
    input: Expr<_Array>,
    initialValue: Expr<_Element>,
    _in: Expr<T>,
): Expr<T> = Expr {
    `$reduce` by {
        "input" by input.element
        "initialValue" by initialValue.element
        "in" by _in.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/reverseArray/ */
@BsonMarker2
fun `$reverseArray`(arrayExpression: Expr<_Array>): Expr<_Array> =
    Expr { `$reverseArray` by arrayExpression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/size/ */
@BsonMarker2
fun `$size`(expression: Expr<_Array>): Expr<_Number> =
    Expr { `$size` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/slice/ */
@BsonMarker2
fun `$slice`(array: Expr<_Array>, n: Expr<_Number>): Expr<_Array> =
    Expr { `$slice` by array(array.element, n.element) }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/slice/ */
@BsonMarker2
fun `$slice`(array: Expr<_Array>, position: Expr<_Number>, n: Expr<_Number>): Expr<_Array> =
    Expr { `$slice` by array(array.element, position.element, n.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sortArray/ */
@BsonMarker2
@JvmName("sortArray_Array_Number")
fun `$sortArray`(input: Expr<_Array>, sortBy: Expr<_Number>): Expr<_Array> =
    Expr { `$sortArray` by { "input" by input.element; "sortBy" by sortBy.element } }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sortArray/ */
@BsonMarker2
@JvmName("sortArray_Array_Document")
fun `$sortArray`(input: Expr<_Array>, sortBy: Expr<_Document>): Expr<_Array> =
    Expr { `$sortArray` by { "input" by input.element; "sortBy" by sortBy.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/zip/ */
@BsonMarker2
fun `$zip`(
    vararg inputs: Expr<_Array>,
    useLongestLength: Expr<_Boolean>? = null,
    defaults: Expr<_Array>? = null,
): Expr<_Array> = `$zip`(
    inputs.asList(),
    useLongestLength,
    defaults,
)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/zip/ */
@BsonMarker2
fun `$zip`(
    inputs: List<Expr<_Array>>,
    useLongestLength: Expr<_Boolean>? = null,
    defaults: Expr<_Array>? = null,
): Expr<_Array> = Expr {
    `$zip` by {
        "inputs" by array { inputs.forEach { by(it.element) } }
        if (useLongestLength != null) "useLongestLength" by useLongestLength.element
        if (defaults != null) "defaults" by defaults.element
    }
}

/* ============= ------------------ ============= */
