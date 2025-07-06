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

/* ============= ------------------ ============= */

/**
 * A representation of the BSON Timestamp type.
 *
 * @since 2.0.0
 * @see org.bson.BsonTimestamp
 */
data class BsonTimestamp(val value: Long) : BsonElement {
    override val type: BsonType get() = BsonType.Timestamp

    /**
     * Gets the time in seconds since epoch.
     *
     * @return an int representing time in seconds since epoch
     * @see org.bson.BsonTimestamp.getTime
     */
    val time: Int get() = (value shr 32).toInt()

    /**
     * Gets the increment value.
     *
     * @return an incrementing ordinal for operations within a given second
     * @see org.bson.BsonTimestamp.getInc
     */
    val inc: Int get() = value.toInt()

    override fun equals(other: Any?) =
        other is BsonTimestamp && other.value == value

    override fun hashCode() =
        value.hashCode()

    // todo BsonTimestamp string representation
}

/* ============= ------------------ ============= */
