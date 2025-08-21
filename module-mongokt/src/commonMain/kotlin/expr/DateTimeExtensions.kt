@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

/* ============= ------------------ ============= */

// _Arithmetic.kt

@BsonMarker4
@JvmName("DateTime_plus_Number")
operator fun Expr<_DateTime>.plus(other: Expr<_Number>): Expr<_DateTime> =
    `$add`(this, other)

@BsonMarker4
@JvmName("DateTime_minus_Number")
operator fun Expr<_DateTime>.minus(other: Expr<_Number>): Expr<_DateTime> =
    `$subtract`(this, other)

@BsonMarker4
@JvmName("DateTime_minus_DateTime")
operator fun Expr<_DateTime>.minus(other: Expr<_DateTime>): Expr<_Number> =
    `$subtract`(this, other)

/* ============= ------------------ ============= */

@JvmName("DateTime_dayOfMonth")
fun Expr<_DateTime>.dayOfMonth(timezone: Expr<_String>? = null): Expr<_Number> =
    `$dayOfMonth`(this, timezone)

@JvmName("DateTime_dayOfWeek")
fun Expr<_DateTime>.dayOfWeek(timezone: Expr<_String>? = null): Expr<_Number> =
    `$dayOfWeek`(this, timezone)

@JvmName("DateTime_dayOfYear")
fun Expr<_DateTime>.dayOfYear(timezone: Expr<_String>? = null): Expr<_Number> =
    `$dayOfYear`(this, timezone)

@JvmName("DateTime_hour")
fun Expr<_DateTime>.hour(timezone: Expr<_String>? = null): Expr<_Number> =
    `$hour`(this, timezone)

@JvmName("DateTime_isoDayOfWeek")
fun Expr<_DateTime>.isoDayOfWeek(timezone: Expr<_String>? = null): Expr<_Number> =
    `$isoDayOfWeek`(this, timezone)

@JvmName("DateTime_isoWeek")
fun Expr<_DateTime>.isoWeek(timezone: Expr<_String>? = null): Expr<_Number> =
    `$isoWeek`(this, timezone)

@JvmName("DateTime_isoWeekYear")
fun Expr<_DateTime>.isoWeekYear(timezone: Expr<_String>? = null): Expr<_Number> =
    `$isoWeekYear`(this, timezone)

@JvmName("DateTime_millisecond")
fun Expr<_DateTime>.millisecond(timezone: Expr<_String>? = null): Expr<_Number> =
    `$millisecond`(this, timezone)

@JvmName("DateTime_minute")
fun Expr<_DateTime>.minute(timezone: Expr<_String>? = null): Expr<_Number> =
    `$minute`(this, timezone)

@JvmName("DateTime_month")
fun Expr<_DateTime>.month(timezone: Expr<_String>? = null): Expr<_Number> =
    `$month`(this, timezone)

@JvmName("DateTime_second")
fun Expr<_DateTime>.second(timezone: Expr<_String>? = null): Expr<_Number> =
    `$second`(this, timezone)

@JvmName("DateTime_week")
fun Expr<_DateTime>.week(timezone: Expr<_String>? = null): Expr<_Number> =
    `$week`(this, timezone)

@JvmName("DateTime_year")
fun Expr<_DateTime>.year(timezone: Expr<_String>? = null): Expr<_Number> =
    `$year`(this, timezone)

/* ============= ------------------ ============= */
