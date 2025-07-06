package org.cufy.bson

/* ============= ------------------ ============= */

/**
 * Return the java version of this bson element.
 */
val BsonTimestamp.java: JavaBsonTimestamp
    get() = JavaBsonTimestamp(value)

/**
 * Return the kotlin version of this bson element.
 */
val JavaBsonTimestamp.kt: BsonTimestamp
    get() = BsonTimestamp(value)

/* ============= ------------------ ============= */
