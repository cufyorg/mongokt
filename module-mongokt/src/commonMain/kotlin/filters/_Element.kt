@file:Suppress("FunctionName")

package org.cufy.mongodb.filters

import org.cufy.bson.*
import org.cufy.mongodb.`$exists`
import org.cufy.mongodb.`$type`

// https://www.mongodb.com/docs/manual/reference/operator/query/#element

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/exists */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun `$exists`(value: Boolean) =
    `$exists` by value

/** https://www.mongodb.com/docs/manual/reference/operator/query/exists */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.`$exists`(value: Boolean) =
    this by { `$exists` by value }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/type */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun `$type`(type: Int) =
    `$type` by type

/** https://www.mongodb.com/docs/manual/reference/operator/query/type */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun `$type`(type: String) =
    `$type` by type

/** https://www.mongodb.com/docs/manual/reference/operator/query/type */
@BsonMarker2
@JvmName("type_List<Int>")
context(_: /* Operator */BsonDocumentBuilder)
fun `$type`(types: List<Int>) =
    `$type` by array { types.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/type */
@BsonMarker2
@JvmName("type_List<String>")
context(_: /* Operator */BsonDocumentBuilder)
fun `$type`(types: List<String>) =
    `$type` by array { types.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/type */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.`$type`(type: Int) =
    this by { `$type` by type }

/** https://www.mongodb.com/docs/manual/reference/operator/query/type */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.`$type`(type: String) =
    this by { `$type` by type }

/** https://www.mongodb.com/docs/manual/reference/operator/query/type */
@BsonMarker2
@JvmName("String_type_List<Int>")
context(_: /* Query */BsonDocumentBuilder)
infix fun String.`$type`(types: List<Int>) =
    this by { `$type` by array { types.forEach { contextOf().add(it.bson) } } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/type */
@BsonMarker2
@JvmName("String_type_List<String>")
context(_: /* Query */BsonDocumentBuilder)
infix fun String.`$type`(types: List<String>) =
    this by { `$type` by array { types.forEach { contextOf().add(it.bson) } } }

/* ============= ------------------ ============= */
