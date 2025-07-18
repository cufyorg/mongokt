/*
 *	Copyright 2022-2023 cufy.org and meemer.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package org.cufy.bson

import kotlin.time.Instant

/* ============= ------------------ ============= */

/**
 * A map containing only items of type [BsonElement].
 *
 * @since 2.0.0
 */
typealias BsonDocumentLike = Map<String, BsonElement>

/**
 * A mutable map containing only items of type [BsonElement].
 *
 * @since 2.0.0
 */
typealias MutableBsonDocumentLike = MutableMap<String, BsonElement>

@BsonMarker2
typealias BsonDocumentBuilder = MutableBsonDocumentLike

/**
 * A block of code building a bson document.
 *
 * @since 2.0.0
 */
typealias BsonDocumentBlock = context(BsonDocumentBuilder) () -> Unit

/* ============= ------------------ ============= */

/**
 * Construct a new mutable bson map from this map.
 *
 * This function will be obsolete once kotlin
 * context receivers is stable.
 *
 * @see toMutableMap
 * @since 2.0.0
 */
@Deprecated("Deprecated because of context parameters", ReplaceWith("this.toMutableMap()"))
fun Map<String, BsonElement>.toMutableBsonDocument(): MutableBsonDocumentLike = toMutableMap()

/**
 * Obtain a mutable bson map backed by this map.
 *
 * This function will be obsolete once kotlin
 * context receivers is stable.
 *
 * @since 2.0.0
 */
@Deprecated("Deprecated because of context parameters", ReplaceWith("this"))
fun MutableMap<String, BsonElement>.asMutableBsonDocument(): MutableBsonDocumentLike = this

/* ============= ------------------ ============= */

/**
 * Return an empty new [MutableBsonDocumentLike].
 *
 * This function will be obsolete once kotlin
 * context receivers is stable.
 *
 * @see mutableMapOf
 * @since 2.0.0
 */
@Deprecated(
    "Deprecated because of context parameters",
    ReplaceWith("mutableMapOf<String, BsonElement>()", imports = ["org.cufy.bson.BsonElement"])
)
fun mutableBsonDocumentOf(): MutableBsonDocumentLike = mutableMapOf()

/**
 * Returns a new [MutableBsonDocumentLike] with the given pairs.
 *
 * This function will be obsolete once kotlin
 * context receivers is stable.
 *
 * @see mutableMapOf
 * @since 2.0.0
 */
@Deprecated(
    "Deprecated because of context parameters",
    ReplaceWith("mutableMapOf<String, BsonElement>(*pairs)", imports = ["org.cufy.bson.BsonElement"])
)
fun mutableBsonDocumentOf(vararg pairs: Pair<String, BsonElement>): MutableBsonDocumentLike = mutableMapOf(*pairs)

/* ============= ------------------ ============= */

/**
 * Static (pure) utility function to prettify
 * creating arrays within the dsl.
 *
 * Usage:
 * ```
 * BsonDocument {
 *     "name" by array {
 *         by(100L)
 *         by("item")
 *         /* ... */
 *     }
 * }
 * ```
 *
 * @return an array built with the given [block].
 * @since 2.0.0
 */
@BsonMarker2
context(_: BsonDocumentBuilder)
fun array(block: BsonArrayBlock) = BsonArray(block)

/**
 * Static (pure) utility function to prettify
 * creating arrays within the dsl.
 *
 * Usage:
 * ```
 * BsonDocument {
 *     "name" by array(
 *         100L.bson,
 *         "item".bson,
 *         /* ... */
 *     )
 * }
 * ```
 *
 * @return an array with the given [elements].
 * @since 2.0.0
 */
@BsonMarker2
context(_: BsonDocumentBuilder)
fun array(vararg elements: BsonElement) = BsonArray(*elements)

/**
 * Static (pure) utility function to prettify
 * creating documents within the dsl.
 *
 * Usage:
 * ```
 * BsonDocument {
 *     "a" by document {
 *         "a" by 100L
 *         "b" by "item"
 *         /* ... */
 *     }
 * }
 * ```
 *
 * @return a document built with the given [block].
 * @since 2.0.0
 */
@BsonMarker2
context(_: BsonDocumentBuilder)
fun document(block: BsonDocumentBlock) = BsonDocument(block)

/* ============= ------------------ ============= */

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: BsonElement?) {
    value ?: return run { builder[this] = null.bson }
    builder[this] = value
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: BsonDocument?) {
    value ?: return run { builder[this] = null.bson }
    builder[this] = value
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: BsonArray?) {
    value ?: return run { builder[this] = null.bson }
    builder[this] = value
}

//

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDocument].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: BsonDocumentLike?) {
    value ?: return run { builder[this] = null.bson }
    builder[this] = value.toBsonDocument()
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonArray].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: BsonArrayLike?) {
    value ?: return run { builder[this] = null.bson }
    builder[this] = value.toBsonArray()
}

/**
 * Put all the mappings in the given [map].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
fun byAll(map: BsonDocumentLike) {
    builder += map
}

/**
 * Set the field with the name [this] to the value from invoking the given [block]
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(block: BsonDocumentBlock) {
    builder[this] = BsonDocument(block)
}

@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.flatBy(value: BsonDocumentLike?) {
    value ?: return run { builder[this] = null.bson }
    value.forEach { (name, value) ->
        builder["${this}.${name}"] = value
    }
}

@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.flatBy(block: BsonDocumentBlock) {
    BsonDocument(block).forEach { (name, value) ->
        builder["${this}.${name}"] = value
    }
}

/* ============= ------------------ ============= */

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonString].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: String?) {
    builder[this] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonBoolean].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: Boolean?) {
    builder[this] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonInt32].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: Int?) {
    builder[this] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonInt64].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: Long?) {
    builder[this] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDouble].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: Double?) {
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
infix fun String.by(value: Decimal128?) {
    builder[this] = value.bson
}

/* ============= ------------------ ============= */

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonObjectId].
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: ObjectId?) {
    builder[this] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped using [ID.bson].
 *
 */
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: AnyID?) {
    builder[this] = value.bson
}

/**
 * Set the field with the name [this] to the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped using [BsonArray] and [ID.bson].
 */
@JvmName("byIDList")
@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(value: List<AnyID>?) {
    value ?: return run { builder[this] = null.bson }
    builder[this] = value.map { it.bson }.toBsonArray()
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
infix fun String.by(value: Instant?) {
    builder[this] = value.bson
}

/* ============= ------------------ ============= */
