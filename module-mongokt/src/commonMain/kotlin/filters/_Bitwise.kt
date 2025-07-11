package org.cufy.mongodb.filters

import org.cufy.bson.*
import org.cufy.mongodb.`$bitsAllClear`
import org.cufy.mongodb.`$bitsAllSet`
import org.cufy.mongodb.`$bitsAnyClear`
import org.cufy.mongodb.`$bitsAnySet`

// https://www.mongodb.com/docs/manual/reference/operator/query/#bitwise

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllClear */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAllClear(bitMask: Long) =
    `$bitsAllClear` by bitMask

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllClear */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAllClear(bitMask: BsonBinary) =
    `$bitsAllClear` by bitMask

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllClear */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAllClear(positions: List<Int>) =
    `$bitsAllClear` by array { positions.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllClear */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAllClear(bitMask: Long) =
    this by { `$bitsAllClear` by bitMask }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllClear */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAllClear(bitMask: BsonBinary) =
    this by { `$bitsAllClear` by bitMask }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllClear */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAllClear(positions: List<Int>) =
    this by { `$bitsAllClear` by array { positions.forEach { contextOf().add(it.bson) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllSet */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAllSet(bitMask: Long) =
    `$bitsAllSet` by bitMask

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllSet */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAllSet(bitMask: BsonBinary) =
    `$bitsAllSet` by bitMask

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllSet */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAllSet(positions: List<Int>) =
    `$bitsAllSet` by array { positions.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllSet */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAllSet(bitMask: Long) =
    this by { `$bitsAllSet` by bitMask }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllSet */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAllSet(bitMask: BsonBinary) =
    this by { `$bitsAllSet` by bitMask }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAllSet */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAllSet(positions: List<Int>) =
    this by { `$bitsAllSet` by array { positions.forEach { contextOf().add(it.bson) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnyClear */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAnyClear(bitMask: Long) =
    `$bitsAnyClear` by bitMask

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnyClear */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAnyClear(bitMask: BsonBinary) =
    `$bitsAnyClear` by bitMask

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnyClear */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAnyClear(positions: List<Int>) =
    `$bitsAnyClear` by array { positions.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnyClear */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAnyClear(bitMask: Long) =
    this by { `$bitsAnyClear` by bitMask }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnyClear */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAnyClear(bitMask: BsonBinary) =
    this by { `$bitsAnyClear` by bitMask }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnyClear */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAnyClear(positions: List<Int>) =
    this by { `$bitsAnyClear` by array { positions.forEach { contextOf().add(it.bson) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnySet */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAnySet(bitMask: Long) =
    `$bitsAnySet` by bitMask

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnySet */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAnySet(bitMask: BsonBinary) =
    `$bitsAnySet` by bitMask

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnySet */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun bitsAnySet(positions: List<Int>) =
    `$bitsAnySet` by array { positions.forEach { by(it) } }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnySet */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAnySet(bitMask: Long) =
    this by { `$bitsAnySet` by bitMask }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnySet */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAnySet(bitMask: BsonBinary) =
    this by { `$bitsAnySet` by bitMask }

/** https://www.mongodb.com/docs/manual/reference/operator/query/bitsAnySet */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.bitsAnySet(positions: List<Int>) =
    this by { `$bitsAnySet` by array { positions.forEach { contextOf().add(it.bson) } } }

/* ============= ------------------ ============= */
