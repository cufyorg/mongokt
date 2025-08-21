@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.*
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#array-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/arrayElemAt/ */
@BsonMarker4
fun <T : _Element> `$arrayElemAt`(array: Expr<_Array<T>>, idx: Expr<_Number>): Expr<T> =
    Expr { `$arrayElemAt` by array(array.element, idx.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/arrayToObject/ */
@BsonMarker4
fun `$arrayToObject`(expression: Expr<_Array<*>>): Expr<_Document> =
    Expr { `$arrayToObject` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/concatArrays/ */
@BsonMarker4
fun <T : _Element> `$concatArrays`(vararg arrays: Expr<_Array<T>>): Expr<_Array<T>> =
    `$concatArrays`(arrays.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/concatArrays/ */
@BsonMarker4
fun <T : _Element> `$concatArrays`(arrays: List<Expr<_Array<T>>>): Expr<_Array<T>> =
    Expr { `$concatArrays` by array { arrays.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/filter/ */
@BsonMarker4
fun <T : _Element> `$filter`(
    input: Expr<_Array<T>>,
    cond: Expr<_Boolean>,
    limit: Expr<_Number>? = null,
): Expr<_Array<T>> = Expr {
    `$filter` by {
        "input" by input.element
        "cond" by cond.element
        if (limit != null) "limit" by limit.element
    }
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/filter/ */
@Suppress("LocalVariableName")
@BsonMarker4
fun <T : _Element> `$filter`(
    input: Expr<_Array<T>>,
    _as: String? = null,
    cond: Expr<_Boolean>,
    limit: Expr<_Number>? = null,
): Expr<_Array<T>> = Expr {
    `$filter` by {
        "input" by input.element
        if (_as != null) "as" by _as
        "cond" by cond.element
        if (limit != null) "limit" by limit.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/firstN/ */
@BsonMarker4
fun <T : _Element> `$firstN`(input: Expr<_Array<T>>, n: Expr<_Number>): Expr<_Array<T>> =
    Expr { `$firstN` by { "input" by input.element; "n" by n.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/in/ */
@BsonMarker4
fun <T : _Element> `$in`(expression: Expr<T>, arrayExpression: Expr<_Array<T>>): Expr<_Boolean> =
    Expr { `$in` by array(expression.element, arrayExpression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/indexOfArray/ */
@BsonMarker4
fun <T : _Element> `$indexOfArray`(
    arrayExpression: Expr<_Array<T>>,
    searchExpression: Expr<T>,
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
@BsonMarker4
fun <T : _Element> `$indexOfArray`(
    arrayExpression: Expr<_Array<T>>,
    searchExpression: Expr<T>,
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
@BsonMarker4
fun `$isArray`(expression: Expr<_Element>): Expr<_Boolean> =
    Expr { `$isArray` by array(expression.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/lastN/ */
@BsonMarker4
fun <T : _Element> `$lastN`(input: Expr<_Array<T>>, n: Expr<_Number>): Expr<_Array<T>> =
    Expr { `$lastN` by { "input" by input.element; "n" by n.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/map/ */
@Suppress("LocalVariableName")
@BsonMarker4
fun <U : _Element> `$map`(
    input: Expr<_Array<*>>,
    _in: Expr<U>,
): Expr<_Array<U>> = Expr {
    `$map` by {
        "input" by input.element
        "in" by _in.element
    }
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/map/ */
@Suppress("LocalVariableName")
@BsonMarker4
fun <U : _Element> `$map`(
    input: Expr<_Array<*>>,
    _as: String? = null,
    _in: Expr<U>,
): Expr<_Array<U>> = Expr {
    `$map` by {
        "input" by input.element
        if (_as != null) "as" by _as
        "in" by _in.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/maxN/ */
@BsonMarker4
fun <T : _Element> `$maxN`(input: Expr<_Array<T>>, n: Expr<_Number>): Expr<_Array<T>> =
    Expr { `$maxN` by { "input" by input.element; "n" by n.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/minN/ */
@BsonMarker4
fun <T : _Element> `$minN`(input: Expr<_Array<T>>, n: Expr<_Number>): Expr<_Array<T>> =
    Expr { `$minN` by { "input" by input.element; "n" by n.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/objectToArray/ */
@Suppress("LocalVariableName")
@BsonMarker4
fun `$objectToArray`(_object: Expr<_Document>): Expr<_Array<_Element>> =
    Expr { `$objectToArray` by _object.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/range/ */
@BsonMarker4
fun `$range`(
    start: Expr<_Number>,
    end: Expr<_Number>,
    step: Expr<_Number>? = null,
): Expr<_Array<_Number>> = Expr {
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
@BsonMarker4
fun <U : _Element> `$reduce`(
    input: Expr<_Array<*>>,
    initialValue: Expr<U>,
    _in: Expr<U>,
): Expr<U> = Expr {
    `$reduce` by {
        "input" by input.element
        "initialValue" by initialValue.element
        "in" by _in.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/reverseArray/ */
@BsonMarker4
fun <T : _Element> `$reverseArray`(arrayExpression: Expr<_Array<T>>): Expr<_Array<T>> =
    Expr { `$reverseArray` by arrayExpression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/size/ */
@BsonMarker4
fun `$size`(expression: Expr<_Array<*>>): Expr<_Number> =
    Expr { `$size` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/slice/ */
@BsonMarker4
fun <T : _Element> `$slice`(array: Expr<_Array<T>>, n: Expr<_Number>): Expr<_Array<T>> =
    Expr { `$slice` by array(array.element, n.element) }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/slice/ */
@BsonMarker4
fun <T : _Element> `$slice`(array: Expr<_Array<T>>, position: Expr<_Number>, n: Expr<_Number>): Expr<_Array<T>> =
    Expr { `$slice` by array(array.element, position.element, n.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sortArray/ */
@BsonMarker4
fun <T : _Element> `$sortArray`(input: Expr<_Array<T>>, sortBy: Expr<_Number>): Expr<_Array<T>> =
    Expr { `$sortArray` by { "input" by input.element; "sortBy" by sortBy.element } }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sortArray/ */
@BsonMarker4
fun <T : _Element> `$sortArray`(input: Expr<_Array<T>>, sortBy: BsonDocument): Expr<_Array<T>> =
    Expr { `$sortArray` by { "input" by input.element; "sortBy" by sortBy } }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sortArray/ */
@BsonMarker4
fun <T : _Element> `$sortArray`(input: Expr<_Array<T>>, sortBy: BsonDocumentBlock): Expr<_Array<T>> =
    Expr { `$sortArray` by { "input" by input.element; "sortBy" by sortBy } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/zip/ */
@BsonMarker4
fun <T : _Element> `$zip`(
    vararg inputs: Expr<_Array<T>>,
    useLongestLength: Expr<_Boolean>? = null,
    defaults: Expr<_Array<T>>? = null,
): Expr<_Array<_Array<T>>> = `$zip`(
    inputs.asList(),
    useLongestLength,
    defaults,
)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/zip/ */
@BsonMarker4
fun <T : _Element> `$zip`(
    inputs: List<Expr<_Array<T>>>,
    useLongestLength: Expr<_Boolean>? = null,
    defaults: Expr<_Array<T>>? = null,
): Expr<_Array<_Array<T>>> = Expr {
    `$zip` by {
        "inputs" by array { inputs.forEach { by(it.element) } }
        if (useLongestLength != null) "useLongestLength" by useLongestLength.element
        if (defaults != null) "defaults" by defaults.element
    }
}

/* ============= ------------------ ============= */
