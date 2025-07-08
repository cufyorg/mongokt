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
 * A list containing only items of type [BsonElement].
 *
 * @since 2.0.0
 */
typealias BsonArrayLike = List<BsonElement>

/**
 * A mutable list containing only items of type [BsonElement].
 *
 * @since 2.0.0
 */
typealias MutableBsonArrayLike = MutableList<BsonElement>

@BsonMarker2
typealias BsonArrayBuilder = MutableBsonArrayLike

/**
 * A block of code building a bson array.
 *
 * @since 2.0.0
 */
typealias BsonArrayBlock = context(BsonArrayBuilder) () -> Unit

/* ============= ------------------ ============= */

/**
 * Construct a new mutable bson list from this list.
 *
 * This function will be obsolete once kotlin
 * context receivers is stable.
 *
 * @see toMutableList
 * @since 2.0.0
 */
@Deprecated("Deprecated because of context parameters", ReplaceWith("this.toMutableList()"))
fun Iterable<BsonElement>.toMutableBsonArray(): MutableBsonArrayLike = toMutableList()

/**
 * Obtain a mutable bson list backed by this list.
 *
 * This function will be obsolete once kotlin
 * context receivers is stable.
 *
 * @since 2.0.0
 */
@Deprecated("Deprecated because of context parameters", ReplaceWith("this"))
fun MutableList<BsonElement>.asMutableBsonArray(): MutableBsonArrayLike = this

/* ============= ------------------ ============= */

/**
 * Return an empty new [MutableBsonArrayLike].
 *
 * This function will be obsolete once kotlin
 * context receivers is stable.
 *
 * @see mutableListOf
 * @since 2.0.0
 */
@Deprecated(
    "Deprecated because of context parameters",
    ReplaceWith("mutableListOf<BsonElement>()", imports = ["org.cufy.bson.BsonElement"])
)
fun mutableBsonArrayOf(): MutableBsonArrayLike = mutableListOf()

/**
 * Returns a new [MutableBsonArrayLike] with the given elements.
 *
 * This function will be obsolete once kotlin
 * context receivers is stable.
 *
 * @see mutableListOf
 * @since 2.0.0
 */
@Deprecated(
    "Deprecated because of context parameters",
    ReplaceWith("mutableListOf<BsonElement>(*elements)", imports = ["org.cufy.bson.BsonElement"])
)
fun mutableBsonArrayOf(vararg elements: BsonElement): MutableBsonArrayLike = mutableListOf(*elements)

/* ============= ------------------ ============= */

/**
 * Static (pure) utility function to prettify
 * creating arrays within the dsl.
 *
 * Usage:
 * ```
 * BsonArray {
 *     by(array {
 *         by(100L)
 *         by("item")
 *         /* ... */
 *     })
 * }
 * ```
 *
 * @return an array built with the given [block].
 * @since 2.0.0
 */
@BsonMarker2
context(_: BsonArrayBuilder)
fun array(block: BsonArrayBlock) = BsonArray(block)

/**
 * Static (pure) utility function to prettify
 * creating arrays within the dsl.
 *
 * Usage:
 * ```
 * BsonArray {
 *     by(array(
 *         100L.bson,
 *         "item".bson,
 *         /* ... */
 *     ))
 * }
 * ```
 *
 * @return an array with the given [elements].
 * @since 2.0.0
 */
@BsonMarker2
context(_: BsonArrayBuilder)
fun array(vararg elements: BsonElement) = BsonArray(*elements)

/**
 * Static (pure) utility function to prettify
 * creating documents within the dsl.
 *
 * Usage:
 * ```
 * BsonArray {
 *     by(document {
 *         "a" by 100L
 *         "b" by "item"
 *         /* ... */
 *     })
 * }
 * ```
 *
 * @return a document built with the given [block].
 * @since 2.0.0
 */
@BsonMarker2
context(_: BsonArrayBuilder)
fun document(block: BsonDocumentBlock) = BsonDocument(block)

/* ============= ------------------ ============= */

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: BsonElement?) {
    value ?: return run { builder += null.bson }
    builder += value
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: BsonDocument?) {
    value ?: return run { builder += null.bson }
    builder += value
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: BsonArray?) {
    value ?: return run { builder += null.bson }
    builder.add(value)
}

//

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDocument].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: BsonDocumentLike?) {
    value ?: return run { builder += null.bson }
    builder += value.toBsonDocument()
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonArray].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: BsonArrayLike?) {
    value ?: return run { builder += null.bson }
    builder.add(value.toBsonArray())
}

/**
 * Put all the items in the given [list].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun byAll(list: BsonArrayLike) {
    builder += list
}

/**
 * Add the value from invoking the given [block].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(block: BsonDocumentBlock) {
    builder += BsonDocument(block)
}

/* ============= ------------------ ============= */

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonString].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: String?) {
    builder += value.bson
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonBoolean].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: Boolean?) {
    builder += value.bson
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonInt32].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: Int?) {
    builder += value.bson
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonInt64].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: Long?) {
    builder += value.bson
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDouble].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: Double?) {
    builder += value.bson
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonDecimal128].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: Decimal128?) {
    builder += value.bson
}

/* ============= ------------------ ============= */

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped with [BsonObjectId].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: ObjectId?) {
    builder += value.bson
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped using [ID.bson].
 */
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: AnyID?) {
    builder += value.bson
}

/**
 * Add the given [value].
 *
 * If [value] is null then [BsonNull] will be set instead.
 *
 * The given [value] will be wrapped using [BsonArray] and [ID.bson].
 */
@JvmName("byIDList")
@BsonMarker2
context(builder: BsonArrayBuilder)
fun by(value: List<AnyID>?) {
    value ?: return run { builder += null.bson }
    builder.add(value.map { it.bson }.toBsonArray())
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
fun by(value: Instant?) {
    builder += value.bson
}

/* ============= ------------------ ============= */
