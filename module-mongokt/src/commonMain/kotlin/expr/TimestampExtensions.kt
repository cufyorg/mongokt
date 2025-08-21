@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

/* ============= ------------------ ============= */

// _Timestamp.kt

@BsonMarker4
fun Expr<_Timestamp>.increment(): Expr<_Number> =
    `$tsIncrement`(this)

@BsonMarker4
fun Expr<_Timestamp>.second(): Expr<_Number> =
    `$tsSecond`(this)

// _Date.kt

@JvmName("Timestamp_dayOfMonth")
fun Expr<_Timestamp>.dayOfMonth(timezone: Expr<_String>? = null): Expr<_Number> =
    `$dayOfMonth`(this, timezone)

@JvmName("Timestamp_dayOfWeek")
fun Expr<_Timestamp>.dayOfWeek(timezone: Expr<_String>? = null): Expr<_Number> =
    `$dayOfWeek`(this, timezone)

@JvmName("Timestamp_dayOfYear")
fun Expr<_Timestamp>.dayOfYear(timezone: Expr<_String>? = null): Expr<_Number> =
    `$dayOfYear`(this, timezone)

@JvmName("Timestamp_hour")
fun Expr<_Timestamp>.hour(timezone: Expr<_String>? = null): Expr<_Number> =
    `$hour`(this, timezone)

@JvmName("Timestamp_isoDayOfWeek")
fun Expr<_Timestamp>.isoDayOfWeek(timezone: Expr<_String>? = null): Expr<_Number> =
    `$isoDayOfWeek`(this, timezone)

@JvmName("Timestamp_isoWeek")
fun Expr<_Timestamp>.isoWeek(timezone: Expr<_String>? = null): Expr<_Number> =
    `$isoWeek`(this, timezone)

@JvmName("Timestamp_isoWeekYear")
fun Expr<_Timestamp>.isoWeekYear(timezone: Expr<_String>? = null): Expr<_Number> =
    `$isoWeekYear`(this, timezone)

@JvmName("Timestamp_millisecond")
fun Expr<_Timestamp>.millisecond(timezone: Expr<_String>? = null): Expr<_Number> =
    `$millisecond`(this, timezone)

@JvmName("Timestamp_minute")
fun Expr<_Timestamp>.minute(timezone: Expr<_String>? = null): Expr<_Number> =
    `$minute`(this, timezone)

@JvmName("Timestamp_month")
fun Expr<_Timestamp>.month(timezone: Expr<_String>? = null): Expr<_Number> =
    `$month`(this, timezone)

@JvmName("Timestamp_second")
fun Expr<_Timestamp>.second(timezone: Expr<_String>? = null): Expr<_Number> =
    `$second`(this, timezone)

@JvmName("Timestamp_week")
fun Expr<_Timestamp>.week(timezone: Expr<_String>? = null): Expr<_Number> =
    `$week`(this, timezone)

@JvmName("Timestamp_year")
fun Expr<_Timestamp>.year(timezone: Expr<_String>? = null): Expr<_Number> =
    `$year`(this, timezone)

/* ============= ------------------ ============= */
