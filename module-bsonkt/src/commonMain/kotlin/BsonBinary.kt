package org.cufy.bson

/* ============= ------------------ ============= */

/**
 * A representation of the BSON Timestamp type.
 *
 * @since 2.0.0
 * @see org.bson.BsonBinary
 */
data class BsonBinary(val subtype: Byte, val data: ByteArray) : BsonElement {
    override val type: BsonType get() = BsonType.Binary

    override fun equals(other: Any?): Boolean {
        return other is BsonBinary &&
                subtype == other.subtype &&
                data.contentEquals(other.data)
    }

    override fun hashCode(): Int {
        var result = subtype.toInt()
        result = 31 * result + data.contentHashCode()
        return result
    }

    // todo BsonBinary string representation
}

/* ============= ------------------ ============= */
