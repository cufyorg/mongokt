package org.cufy.bson

import java.math.BigDecimal
import java.util.*

/* ============= ------------------ ============= */

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDecimal128].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: BigDecimal?) {
    builder += value.bson
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDateTime].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: Date?) {
    builder += value.bson
}

/* ============= ------------------ ============= */
