@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr._Number

/* ============= ------------------ ============= */

// _Arithmetic.kt

@BsonMarker4
@JvmName("Number_plus_Number")
operator fun Expr<_Number>.plus(other: Expr<_Number>): Expr<_Number> =
    `$add`(this, other)

@BsonMarker4
operator fun Expr<_Number>.div(other: Expr<_Number>): Expr<_Number> =
    `$divide`(this, other)

@BsonMarker4
operator fun Expr<_Number>.times(other: Expr<_Number>): Expr<_Number> =
    `$multiply`(this, other)

@BsonMarker4
operator fun Expr<_Number>.unaryMinus(): Expr<_Number> =
    this * (-1).expr

@BsonMarker4
@JvmName("Number_minus_Number")
operator fun Expr<_Number>.minus(other: Expr<_Number>): Expr<_Number> =
    `$subtract`(this, other)

/* ============= ------------------ ============= */

// _Arithmetic.kt

@BsonMarker4
fun Expr<_Number>.abs(): Expr<_Number> =
    `$abs`(this)

@BsonMarker4
fun Expr<_Number>.ceil(): Expr<_Number> =
    `$ceil`(this)

@BsonMarker4
fun Expr<_Number>.exp(): Expr<_Number> =
    `$exp`(this)

@BsonMarker4
fun Expr<_Number>.floor(): Expr<_Number> =
    `$floor`(this)

@BsonMarker4
fun Expr<_Number>.ln(): Expr<_Number> =
    `$ln`(this)

@BsonMarker4
fun Expr<_Number>.log(base: Expr<_Number>): Expr<_Number> =
    `$log`(this, base)

@BsonMarker4
fun Expr<_Number>.log10(): Expr<_Number> =
    `$log10`(this)

@BsonMarker4
infix fun Expr<_Number>.mod(other: Expr<_Number>): Expr<_Number> =
    `$mod`(this, other)

@BsonMarker4
infix fun Expr<_Number>.pow(other: Expr<_Number>): Expr<_Number> =
    `$pow`(this, other)

@BsonMarker4
fun Expr<_Number>.round(place: Expr<_Number>): Expr<_Number> =
    `$round`(this, place)

@BsonMarker4
fun Expr<_Number>.sqrt(): Expr<_Number> =
    `$sqrt`(this)

@BsonMarker4
fun Expr<_Number>.trunc(place: Expr<_Number>): Expr<_Number> =
    `$trunc`(this, place)

// _Bitwise.kt

@BsonMarker4
infix fun Expr<_Number>.bitAnd(other: Expr<_Number>): Expr<_Number> =
    `$bitAnd`(this, other)

@BsonMarker4
fun Expr<_Number>.bitNot(): Expr<_Number> =
    `$bitNot`(this)

@BsonMarker4
infix fun Expr<_Number>.bitOr(other: Expr<_Number>): Expr<_Number> =
    `$bitOr`(this, other)

@BsonMarker4
infix fun Expr<_Number>.bitXor(other: Expr<_Number>): Expr<_Number> =
    `$bitXor`(this, other)

// _Trigonometry.kt

@BsonMarker4
fun Expr<_Number>.degreesToRadians(): Expr<_Number> =
    `$degreesToRadians`(this)

@BsonMarker4
fun Expr<_Number>.radiansToDegrees(): Expr<_Number> =
    `$radiansToDegrees`(this)

/* ============= ------------------ ============= */
