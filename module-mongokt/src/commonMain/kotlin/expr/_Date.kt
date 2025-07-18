@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#date-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateAdd/ */
@BsonMarker4
fun `$dateAdd`(
    startDate: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    unit: Expr<_String>,
    amount: Expr<_Number>,
    timezone: Expr<_String>? = null,
): Expr<_DateTime> = Expr {
    `$dateAdd` by {
        "startDate" by startDate.element
        "unit" by unit.element
        "amount" by amount.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateDiff/ */
@BsonMarker4
fun `$dateDiff`(
    startDate: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    endDate: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    unit: Expr<_String>,
    timezone: Expr<_String>? = null,
    startOfWeek: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$dateDiff` by {
        "startDate" by startDate.element
        "endDate" by endDate.element
        "unit" by unit.element
        if (timezone != null) "timezone" by timezone.element
        if (startOfWeek != null) "startOfWeek" by startOfWeek.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateFromParts/ */
@BsonMarker4
fun `$dateFromParts`(
    year: Expr<_Number>,
    month: Expr<_Number>? = null,
    day: Expr<_Number>? = null,
    hour: Expr<_Number>? = null,
    minute: Expr<_Number>? = null,
    second: Expr<_Number>? = null,
    millisecond: Expr<_Number>? = null,
    timezone: Expr<_String>? = null,
): Expr<_DateTime> = Expr {
    `$dateFromParts` by {
        "year" by year.element
        if (month != null) "month" by month.element
        if (day != null) "day" by day.element
        if (hour != null) "hour" by hour.element
        if (minute != null) "minute" by minute.element
        if (second != null) "second" by second.element
        if (millisecond != null) "millisecond" by millisecond.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateFromParts/ */
@BsonMarker4
fun `$dateFromParts`(
    isoWeekYear: Expr<_Number>,
    isoWeek: Expr<_Number>? = null,
    isoDayOfWeek: Expr<_Number>? = null,
    hour: Expr<_Number>? = null,
    minute: Expr<_Number>? = null,
    second: Expr<_Number>? = null,
    millisecond: Expr<_Number>? = null,
    timezone: Expr<_String>? = null,
    dummy: Nothing? = null,
): Expr<_DateTime> = Expr {
    `$dateFromParts` by {
        "isoWeekYear" by isoWeekYear.element
        if (isoWeek != null) "isoWeek" by isoWeek.element
        if (isoDayOfWeek != null) "isoDayOfWeek" by isoDayOfWeek.element
        if (hour != null) "hour" by hour.element
        if (minute != null) "minute" by minute.element
        if (second != null) "second" by second.element
        if (millisecond != null) "millisecond" by millisecond.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateFromString/ */
@BsonMarker4
fun `$dateFromString`(
    dateString: Expr<_String>,
    format: Expr<_String>? = null,
    timezone: Expr<_String>? = null,
    onError: Expr<_Element>? = null,
    onNull: Expr<_Element>? = null,
): Expr<_DateTime> = Expr {
    `$dateFromString` by {
        "dateString" by dateString.element
        if (format != null) "format" by format.element
        if (timezone != null) "timezone" by timezone.element
        if (onError != null) "onError" by onError.element
        if (onNull != null) "onNull" by onNull.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateSubtract/ */
@BsonMarker4
fun `$dateSubtract`(
    startDate: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    unit: Expr<_String>,
    amount: Expr<_Number>,
    timezone: Expr<_String>? = null,
): Expr<_DateTime> = Expr {
    `$dateSubtract` by {
        "startDate" by startDate.element
        "unit" by unit.element
        "amount" by amount.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateToParts/ */
@BsonMarker4
fun `$dateToParts`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
    iso8601: Boolean? = null,
): Expr<_Document> = Expr {
    `$dateToParts` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
        if (iso8601 != null) "iso8601" by iso8601
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateToString/ */
@BsonMarker4
fun `$dateToString`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    format: Expr<_String>? = null,
    timezone: Expr<_String>? = null,
    onNull: Expr<_Element>? = null,
): Expr<_String> = Expr {
    `$dateToString` by {
        "date" by date.element
        if (format != null) "format" by format.element
        if (timezone != null) "timezone" by timezone.element
        if (onNull != null) "onNull" by onNull.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dateTrunc/ */
@BsonMarker4
fun `$dateTrunc`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    unit: Expr<_String>,
    binSize: Expr<_Number>? = null,
    timezone: Expr<_String>? = null,
    startOfWeek: Expr<_String>? = null,
): Expr<_DateTime> = Expr {
    `$dateTrunc` by {
        "date" by date.element
        "unit" by unit.element
        if (binSize != null) "binSize" by binSize.element
        if (timezone != null) "timezone" by timezone.element
        if (startOfWeek != null) "startOfWeek" by startOfWeek.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dayOfMonth/ */
@BsonMarker4
fun `$dayOfMonth`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$dayOfMonth` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dayOfMonth/ */
@BsonMarker4
fun `$dayOfMonth`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$dayOfMonth` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dayOfWeek/ */
@BsonMarker4
fun `$dayOfWeek`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$dayOfWeek` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dayOfWeek/ */
@BsonMarker4
fun `$dayOfWeek`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$dayOfWeek` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dayOfYear/ */
@BsonMarker4
fun `$dayOfYear`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$dayOfYear` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/dayOfYear/ */
@BsonMarker4
fun `$dayOfYear`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$dayOfYear` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/hour/ */
@BsonMarker4
fun `$hour`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$hour` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/hour/ */
@BsonMarker4
fun `$hour`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$hour` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/isoDayOfWeek/ */
@BsonMarker4
fun `$isoDayOfWeek`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$isoDayOfWeek` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/isoDayOfWeek/ */
@BsonMarker4
fun `$isoDayOfWeek`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$isoDayOfWeek` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/isoWeek/ */
@BsonMarker4
fun `$isoWeek`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$isoWeek` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/isoWeek/ */
@BsonMarker4
fun `$isoWeek`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$isoWeek` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/isoWeekYear/ */
@BsonMarker4
fun `$isoWeekYear`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$isoWeekYear` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/isoWeekYear/ */
@BsonMarker4
fun `$isoWeekYear`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$isoWeekYear` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/millisecond/ */
@BsonMarker4
fun `$millisecond`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$millisecond` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/millisecond/ */
@BsonMarker4
fun `$millisecond`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$millisecond` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/minute/ */
@BsonMarker4
fun `$minute`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$minute` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/minute/ */
@BsonMarker4
fun `$minute`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$minute` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/month/ */
@BsonMarker4
fun `$month`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$month` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/month/ */
@BsonMarker4
fun `$month`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$month` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/second/ */
@BsonMarker4
fun `$second`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$second` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/second/ */
@BsonMarker4
fun `$second`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$second` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toDate/ */
@BsonMarker4
fun `$toDate`(expression: Expr<_Element>): Expr<_DateTime> =
    Expr { `$toDate` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/week/ */
@BsonMarker4
fun `$week`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$week` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/week/ */
@BsonMarker4
fun `$week`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$week` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/year/ */
@BsonMarker4
fun `$year`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
): Expr<_Number> = Expr {
    `$year` by date.element
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/year/ */
@BsonMarker4
fun `$year`(
    date: Expr<_Element /* DateTime | Timestamp | ObjectId */>,
    timezone: Expr<_String>? = null,
): Expr<_Number> = Expr {
    `$year` by {
        "date" by date.element
        if (timezone != null) "timezone" by timezone.element
    }
}

/* ============= ------------------ ============= */
