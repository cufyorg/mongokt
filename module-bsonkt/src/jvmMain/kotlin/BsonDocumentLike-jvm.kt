package org.cufy.bson

import java.math.BigDecimal
import java.util.*
import kotlin.reflect.KCallable

/* ============= ------------------ ============= */

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDecimal128].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: BigDecimal?) {
    builder[this] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDecimal128].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun KCallable<*>.by(value: BigDecimal?) {
    builder[name] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDateTime].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: Date?) {
    builder[this] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDateTime].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun KCallable<*>.by(value: Date?) {
    builder[name] = value.bson
}

/* ============= ------------------ ============= */
