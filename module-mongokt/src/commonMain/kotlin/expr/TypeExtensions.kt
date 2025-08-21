@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

/* ============= ------------------ ============= */

// _Array.kt

@BsonMarker4
fun Expr<*>.isArray(): Expr<_Boolean> =
    `$isArray`(this)

// _DataSize.kt

@BsonMarker4
@JvmName("String_binarySize")
fun Expr<_String>.binarySize(): Expr<_Number> =
    `$binarySize`(this)

@BsonMarker4
@JvmName("Binary_binarySize")
fun Expr<_Binary>.binarySize(): Expr<_Number> =
    `$binarySize`(this)

@BsonMarker4
fun Expr<_Document>.bsonSize(): Expr<_Number> =
    `$bsonSize`(this)

// _Type.kt

@BsonMarker4
fun Expr<*>.isNumber(): Expr<_Boolean> =
    `$isNumber`(this)

@BsonMarker4
fun Expr<*>.type(): Expr<_String> =
    `$type`(this)

/* ============= ------------------ ============= */

// _Array.kt

@BsonMarker4
fun Expr<_Array<*>>.exprToObject(): Expr<_Document> =
    `$arrayToObject`(this)

@BsonMarker4
fun Expr<_Document>.exprToArray(): Expr<_Array<_Element>> =
    `$objectToArray`(this)

// _Date.kt

fun Expr<*>.exprToDate(): Expr<_DateTime> =
    `$toDate`(this)

// _String.kt

@BsonMarker4
fun Expr<*>.exprToString(): Expr<_String> =
    `$toString`(this)

// _Type.kt

@BsonMarker4
fun Expr<*>.exprToBool(): Expr<_Boolean> =
    `$toBool`(this)

@BsonMarker4
fun Expr<*>.exprToDecimal(): Expr<_Number> =
    `$toDecimal`(this)

@BsonMarker4
fun Expr<*>.exprToDouble(): Expr<_Number> =
    `$toDouble`(this)

@BsonMarker4
fun Expr<*>.exprToInt(): Expr<_Number> =
    `$toInt`(this)

@BsonMarker4
fun Expr<*>.exprToLong(): Expr<_Number> =
    `$toLong`(this)

@BsonMarker4
fun Expr<*>.exprToObjectId(): Expr<_ObjectId> =
    `$toObjectId`(this)

@BsonMarker4
fun Expr<_String>.exprToUUID(): Expr<_Binary> =
    `$toUUID`(this)

/* ============= ------------------ ============= */
