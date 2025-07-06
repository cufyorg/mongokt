package org.cufy.bson

/* ============= ------------------ ============= */

/**
 * Return the java version of this bson element.
 */
val BsonBinary.java: JavaBsonBinary
    get() = JavaBsonBinary(this.subtype, this.data)

/**
 * Return the kotlin version of this bson element.
 */
val JavaBsonBinary.kt: BsonBinary
    get() = BsonBinary(this.type, this.data)

/* ============= ------------------ ============= */
