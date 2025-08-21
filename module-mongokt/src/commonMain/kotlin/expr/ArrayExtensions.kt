@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.*
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

/* ============= ------------------ ============= */

// _Literal.kt

@BsonMarker4
val BsonArray.exprLiteral get() = `$literal`(this)

@BsonMarker4
fun arrayLiteral(): Expr<_Array<_Element>> =
    `$literal`(BsonArray())

@BsonMarker4
fun arrayLiteral(vararg items: BsonElement): Expr<_Array<_Element>> =
    `$literal`(BsonArray(*items))

@BsonMarker4
fun arrayLiteral(block: BsonArrayBlock): Expr<_Array<_Element>> =
    `$literal`(BsonArray(block))

@BsonMarker4
fun <T : _Element> arrayExpr(): Expr<_Array<T>> {
    // todo is this safe?
    return Expr { BsonArray() }
}

@BsonMarker4
fun <T : _Element> arrayExpr(vararg items: Expr<T>): Expr<_Array<T>> {
    // todo is this safe?
    return Expr { BsonArray { items.forEach { by(it.element) } } }
}

@BsonMarker4
fun <T : _Element> arrayExpr(block: BsonArrayBlock): Expr<_Array<T>> {
    // todo is this safe?
    return Expr { BsonArray(block) }
}

/* ============= ------------------ ============= */

// _Array.kt

@BsonMarker4
@JvmName("Array_get_Number")
operator fun <T : _Element> Expr<_Array<T>>.get(idx: Expr<_Number>): Expr<T> =
    `$arrayElemAt`(this, idx)

@BsonMarker4
@JvmName("Array_plus_Array")
operator fun <T : _Element> Expr<_Array<T>>.plus(other: Expr<_Array<T>>): Expr<_Array<T>> =
    `$concatArrays`(this, other)

/* ============= ------------------ ============= */

// _Array.kt

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.firstN(n: Expr<_Number>): Expr<_Array<T>> =
    `$firstN`(this, n)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.contains(other: Expr<T>): Expr<_Boolean> =
    `$in`(other, this)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.indexOf(element: Expr<T>): Expr<_Number> =
    `$indexOfArray`(this, element)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.indexOf(element: Expr<T>, start: Expr<_Number>): Expr<_Number> =
    `$indexOfArray`(this, element, start)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.indexOf(element: Expr<T>, start: Expr<_Number>, end: Expr<_Number>): Expr<_Number> =
    `$indexOfArray`(this, element, start, end)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.lastN(n: Expr<_Number>): Expr<_Array<T>> =
    `$lastN`(this, n)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.maxN(n: Expr<_Number>): Expr<_Array<T>> =
    `$maxN`(this, n)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.minN(n: Expr<_Number>): Expr<_Array<T>> =
    `$minN`(this, n)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.reverse(): Expr<_Array<T>> =
    `$reverseArray`(this)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.size(): Expr<_Number> =
    `$size`(this)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.slice(n: Expr<_Number>): Expr<_Array<T>> =
    `$slice`(this, n)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.slice(position: Expr<_Number>, n: Expr<_Number>): Expr<_Array<T>> =
    `$slice`(this, position, n)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.sort(sortBy: Expr<_Number>): Expr<_Array<T>> =
    `$sortArray`(this, sortBy)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.sort(sortBy: BsonDocument): Expr<_Array<T>> =
    `$sortArray`(this, sortBy)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.sort(sortBy: BsonDocumentBlock): Expr<_Array<T>> =
    `$sortArray`(this, sortBy)

// _Set.kt

@BsonMarker4
fun Expr<_Array<*>>.allElementsTrue(): Expr<_Boolean> =
    `$allElementsTrue`(this)

@BsonMarker4
fun Expr<_Array<*>>.anyElementTrue(): Expr<_Boolean> =
    `$anyElementTrue`(this)

@BsonMarker4
infix fun <T : _Element> Expr<_Array<T>>.setDifference(other: Expr<_Array<T>>): Expr<_Array<T>> =
    `$setDifference`(this, other)

@BsonMarker4
infix fun Expr<_Array<*>>.setEquals(other: Expr<_Array<*>>): Expr<_Boolean> =
    `$setEquals`(this, other)

@BsonMarker4
infix fun <T : _Element> Expr<_Array<T>>.setIntersection(other: Expr<_Array<T>>): Expr<_Array<T>> =
    `$setIntersection`(this, other)

@BsonMarker4
infix fun Expr<_Array<*>>.setIsSubset(other: Expr<_Array<*>>): Expr<_Boolean> =
    `$setIsSubset`(this, other)

@BsonMarker4
infix fun <T : _Element> Expr<_Array<T>>.setUnion(other: Expr<_Array<T>>): Expr<_Array<T>> =
    `$setUnion`(this, other)

// _Accumulators.kt

@BsonMarker4
fun Expr<_Array<_Number>>.avg(): Expr<_Number> =
    `$avg`(this)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.max(): Expr<T> =
    `$max`(this)

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.min(): Expr<T> =
    `$min`(this)

@BsonMarker4
fun Expr<_Array<_Number>>.stdDevPop(): Expr<_Number> =
    `$stdDevPop`(this)

@BsonMarker4
fun Expr<_Array<_Number>>.stdDevSamp(): Expr<_Number> =
    `$stdDevSamp`(this)

@BsonMarker4
fun Expr<_Array<_Number>>.sum(): Expr<_Number> =
    `$sum`(this)

/* ============= ------------------ ============= */

// _Array.kt

@BsonMarker4
fun <T : _Element> Expr<_Array<T>>.filter(
    cond: (Expr<T>) -> Expr<_Boolean>,
): Expr<_Array<T>> {
    return `$filter`(
        input = this,
        cond = cond(Expr($$$"$$this".bson))
    )
}

@Suppress("LocalVariableName")
@BsonMarker4
fun <T : _Element, U : _Element> Expr<_Array<T>>.map(
    _in: (Expr<T>) -> Expr<U>
): Expr<_Array<U>> {
    return `$map`(
        input = this,
        _in = _in(Expr($$$"$$this".bson)),
    )
}

@Suppress("LocalVariableName")
@BsonMarker4
fun <T : _Element, U : _Element> Expr<_Array<T>>.reduce(
    initialValue: Expr<U>,
    _in: (Expr<U>, Expr<U>) -> Expr<U>,
): Expr<U> {
    return `$reduce`(
        input = this,
        initialValue = initialValue,
        _in = _in(Expr($$$"$$value".bson), Expr($$$"$$this".bson))
    )
}

@BsonMarker4
fun <T : _Element> List<Expr<_Array<T>>>.zip(
    useLongestLength: Expr<_Boolean>? = null,
    defaults: Expr<_Array<T>>? = null,
): Expr<_Array<_Array<T>>> {
    return `$zip`(
        inputs = this,
        useLongestLength = useLongestLength,
        defaults = defaults,
    )
}

/* ============= ------------------ ============= */
