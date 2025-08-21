@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

/* ============= ------------------ ============= */

// _String.kt

@BsonMarker4
@JvmName("String_plus_String")
operator fun Expr<_String>.plus(other: Expr<_String>): Expr<_String> =
    `$concat`(this, other)

/* ============= ------------------ ============= */

// _String.kt

@BsonMarker4
fun Expr<_String>.indexOfBytes(substring: Expr<_String>): Expr<_Number> =
    `$indexOfBytes`(this, substring)

@BsonMarker4
fun Expr<_String>.indexOfBytes(substring: Expr<_String>, start: Expr<_Number>): Expr<_Number> =
    `$indexOfBytes`(this, substring, start)

@BsonMarker4
fun Expr<_String>.indexOfBytes(substring: Expr<_String>, start: Expr<_Number>, end: Expr<_Number>): Expr<_Number> =
    `$indexOfBytes`(this, substring, start, end)

@BsonMarker4
fun Expr<_String>.indexOfCP(substring: Expr<_String>): Expr<_Number> =
    `$indexOfCP`(this, substring)

@BsonMarker4
fun Expr<_String>.indexOfCP(substring: Expr<_String>, start: Expr<_Number>): Expr<_Number> =
    `$indexOfCP`(this, substring, start)

@BsonMarker4
fun Expr<_String>.indexOfCP(substring: Expr<_String>, start: Expr<_Number>, end: Expr<_Number>): Expr<_Number> =
    `$indexOfCP`(this, substring, start, end)

@BsonMarker4
fun Expr<_String>.ltrim(chars: Expr<_String>? = null): Expr<_String> =
    `$ltrim`(this, chars)

@BsonMarker4
fun Expr<_String>.find(regex: Expr<_Element>, options: String? = null): Expr<_Document> =
    `$regexFind`(this, regex, options)

@BsonMarker4
fun Expr<_String>.findAll(regex: Expr<_Element>, options: String? = null): Expr<_Array<_Document>> =
    `$regexFindAll`(this, regex, options)

@BsonMarker4
infix fun Expr<_String>.match(regex: Expr<_Element>): Expr<_Boolean> =
    `$regexMatch`(this, regex)

@BsonMarker4
fun Expr<_String>.match(regex: Expr<_Element>, options: String? = null): Expr<_Boolean> =
    `$regexMatch`(this, regex, options)

@BsonMarker4
fun Expr<_String>.replaceOne(find: Expr<_String>, replacement: Expr<_String>): Expr<_String> =
    `$replaceOne`(this, find, replacement)

@BsonMarker4
fun Expr<_String>.replaceAll(find: Expr<_String>, replacement: Expr<_String>): Expr<_String> =
    `$replaceAll`(this, find, replacement)

@BsonMarker4
fun Expr<_String>.rtrim(chars: Expr<_String>? = null): Expr<_String> =
    `$rtrim`(this, chars)

@BsonMarker4
fun Expr<_String>.split(delimiter: Expr<_String>): Expr<_Array<_String>> =
    `$split`(this, delimiter)

@BsonMarker4
fun Expr<_String>.lenBytes(): Expr<_Number> =
    `$strLenBytes`(this)

@BsonMarker4
fun Expr<_String>.lenCP(): Expr<_Number> =
    `$strLenCP`(this)

@BsonMarker4
infix fun Expr<_String>.casecmp(other: Expr<_String>): Expr<_Number> =
    `$strcasecmp`(this, other)

@BsonMarker4
fun Expr<_String>.substr(start: Expr<_Number>, length: Expr<_Number>): Expr<_String> =
    `$substr`(this, start, length)

@BsonMarker4
fun Expr<_String>.substrBytes(byteIndex: Expr<_Number>, byteCount: Expr<_Number>): Expr<_String> =
    `$substrBytes`(this, byteIndex, byteCount)

@BsonMarker4
fun Expr<_String>.substrCP(codePointIndex: Expr<_Number>, codePointCount: Expr<_Number>): Expr<_String> =
    `$substrCP`(this, codePointIndex, codePointCount)

@BsonMarker4
fun Expr<_String>.toLower(): Expr<_String> =
    `$toLower`(this)

@BsonMarker4
fun Expr<_String>.trim(chars: Expr<_String>? = null): Expr<_String> =
    `$trim`(this, chars)

@BsonMarker4
fun Expr<_String>.toUpper(): Expr<_String> =
    `$toUpper`(this)

/* ============= ------------------ ============= */
