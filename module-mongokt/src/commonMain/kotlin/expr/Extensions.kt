@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

/* ============= ------------------ ============= */

// Arithmetic

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/add/ */
@BsonMarker2
@JvmName("Number_plus_Number")
operator fun Expr<_Number>.plus(other: Expr<_Number>): Expr<_Number> =
    `$add`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/add/ */
@BsonMarker2
@JvmName("DateTime_plus_Number")
operator fun Expr<_DateTime>.plus(other: Expr<_Number>): Expr<_DateTime> =
    `$add`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/divide/ */
@BsonMarker2
@JvmName("Number_div_Number")
operator fun Expr<_Number>.div(other: Expr<_Number>): Expr<_Number> =
    `$divide`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/mod/ */
@BsonMarker2
@JvmName($$"Number_$mod_Number")
infix fun Expr<_Number>.`$mod`(other: Expr<_Number>): Expr<_Number> =
    `$mod`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/multiply/ */
@BsonMarker2
@JvmName("Number_times_Number")
operator fun Expr<_Number>.times(other: Expr<_Number>): Expr<_Number> =
    `$multiply`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/pow/ */
@BsonMarker2
@JvmName($$"Number_$pow_Number")
infix fun Expr<_Number>.`$pow`(other: Expr<_Number>): Expr<_Number> =
    `$pow`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/subtract/ */
@BsonMarker2
@JvmName("Number_minus_Number")
operator fun Expr<_Number>.minus(other: Expr<_Number>): Expr<_Number> =
    `$subtract`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/subtract/ */
@BsonMarker2
@JvmName("DateTime_minus_Number")
operator fun Expr<_DateTime>.minus(other: Expr<_Number>): Expr<_DateTime> =
    `$subtract`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/subtract/ */
@BsonMarker2
@JvmName("DateTime_minus_DateTime")
operator fun Expr<_DateTime>.minus(other: Expr<_DateTime>): Expr<_Number> =
    `$subtract`(this, other)

/* ============= ------------------ ============= */

// Array

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/arrayElemAt/ */
@BsonMarker2
@JvmName("Array_get_Number")
operator fun Expr<_Array>.get(idx: Expr<_Number>): Expr<_Element> =
    `$arrayElemAt`(this, idx)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/concatArrays/ */
@BsonMarker2
@JvmName("Array_plus_Array")
operator fun Expr<_Array>.plus(other: Expr<_Array>): Expr<_Array> =
    `$concatArrays`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/in/ */
@BsonMarker2
@JvmName($$"Element_$in_Array")
infix fun Expr<_Element>.`$in`(other: Expr<_Array>): Expr<_Boolean> =
    `$in`(this, other)

/* ============= ------------------ ============= */

// Bitwise

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitAnd/ */
@BsonMarker2
@JvmName($$"Number_$bitAnd_Number")
infix fun Expr<_Number>.`$bitAnd`(other: Expr<_Number>): Expr<_Number> =
    `$bitAnd`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitOr/ */
@BsonMarker2
@JvmName($$"Number_$bitOr_Number")
infix fun Expr<_Number>.`$bitOr`(other: Expr<_Number>): Expr<_Number> =
    `$bitOr`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bitXor/ */
@BsonMarker2
@JvmName($$"Number_$bitXor_Number")
infix fun Expr<_Number>.`$bitXor`(other: Expr<_Number>): Expr<_Number> =
    `$bitXor`(this, other)

/* ============= ------------------ ============= */

// Boolean

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/and/ */
@BsonMarker2
@JvmName($$"Element_$and_Element")
infix fun Expr<_Element>.`$and`(other: Expr<_Element>): Expr<_Boolean> =
    `$and`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/or/ */
@BsonMarker2
@JvmName($$"Element_$or_Element")
infix fun Expr<_Element>.`$or`(other: Expr<_Element>): Expr<_Boolean> =
    `$or`(this, other)

/* ============= ------------------ ============= */

// Comparison

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/cmp/ */
@BsonMarker2
@JvmName($$"Element_$cmp_Element")
infix fun Expr<_Element>.`$cmp`(other: Expr<_Element>): Expr<_Number> =
    `$cmp`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/eq/ */
@BsonMarker2
@JvmName($$"Element_$eq_Element")
infix fun Expr<_Element>.`$eq`(other: Expr<_Element>): Expr<_Boolean> =
    `$eq`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/gt/ */
@BsonMarker2
@JvmName($$"Element_$gt_Element")
infix fun Expr<_Element>.`$gt`(other: Expr<_Element>): Expr<_Boolean> =
    `$gt`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/gte/ */
@BsonMarker2
@JvmName($$"Element_$gte_Element")
infix fun Expr<_Element>.`$gte`(other: Expr<_Element>): Expr<_Boolean> =
    `$gte`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/lt/ */
@BsonMarker2
@JvmName($$"Element_$lt_Element")
infix fun Expr<_Element>.`$lt`(other: Expr<_Element>): Expr<_Boolean> =
    `$lt`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/lte/ */
@BsonMarker2
@JvmName($$"Element_$lte_Element")
infix fun Expr<_Element>.`$lte`(other: Expr<_Element>): Expr<_Boolean> =
    `$lte`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/ne/ */
@BsonMarker2
@JvmName($$"Element_$ne_Element")
infix fun Expr<_Element>.`$ne`(other: Expr<_Element>): Expr<_Boolean> =
    `$ne`(this, other)

/* ============= ------------------ ============= */

// Conditional

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/ifNull/ */
@BsonMarker2
@JvmName($$"T_$ifNull_T")
infix fun <T : _Element> Expr<T>.`$ifNull`(other: Expr<T>): Expr<T> =
    `$ifNull`(this, other)

/* ============= ------------------ ============= */

// Miscellaneous

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/getField/ */
@BsonMarker2
@JvmName("Document_get_String")
operator fun Expr<_Document>.get(field: Expr<_String>): Expr<_Element> =
    `$getField`(field, this)

/* ============= ------------------ ============= */

// Object

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/mergeObjects/ */
@BsonMarker2
@JvmName("Document_plus_Document")
operator fun Expr<_Document>.plus(other: Expr<_Document>): Expr<_Document> =
    `$mergeObjects`(this, other)

/* ============= ------------------ ============= */

// Set

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setDifference/ */
@BsonMarker2
@JvmName($$"Array_$setDifference_Array")
infix fun Expr<_Array>.`$setDifference`(other: Expr<_Array>): Expr<_Array> =
    `$setDifference`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setEquals/ */
@BsonMarker2
@JvmName($$"Array_$setEquals_Array")
infix fun Expr<_Array>.`$setEquals`(other: Expr<_Array>): Expr<_Boolean> =
    `$setEquals`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setIntersection/ */
@BsonMarker2
@JvmName($$"Array_$setIntersection_Array")
infix fun Expr<_Array>.`$setIntersection`(other: Expr<_Array>): Expr<_Array> =
    `$setIntersection`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setIsSubset/ */
@BsonMarker2
@JvmName($$"Array_$setIsSubset_Array")
infix fun Expr<_Array>.`$setIsSubset`(other: Expr<_Array>): Expr<_Boolean> =
    `$setIsSubset`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/setUnion/ */
@BsonMarker2
@JvmName($$"Array_$setUnion_Array")
infix fun Expr<_Array>.`$setUnion`(other: Expr<_Array>): Expr<_Array> =
    `$setUnion`(this, other)

/* ============= ------------------ ============= */

// String

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/concat/ */
@BsonMarker2
@JvmName("String_plus_String")
operator fun Expr<_String>.plus(other: Expr<_String>): Expr<_String> =
    `$concat`(this, other)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/regexMatch/ */
@BsonMarker2
@JvmName($$"String_$regexMatch_Element")
infix fun Expr<_String>.`$regexMatch`(regex: Expr<_Element /* String | RegExp */>): Expr<_Boolean> =
    `$regexMatch`(this, regex)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/strcasecmp/ */
@BsonMarker2
@JvmName($$"String_$strcasecmp_String")
infix fun Expr<_String>.`$strcasecmp`(regex: Expr<_String>): Expr<_Number> =
    `$strcasecmp`(this, regex)

/* ============= ------------------ ============= */
