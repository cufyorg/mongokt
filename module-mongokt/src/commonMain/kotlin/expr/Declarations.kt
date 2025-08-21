@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.*
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*
import kotlin.time.Instant

/* ============= ------------------ ============= */

@Suppress("ClassName")
@ExperimentalMongodbApi
data class Expr<out T : _Element>(val element: BsonElement) {
    interface _Element
    interface _Number : _Element
    interface _Boolean : _Element
    interface _DateTime : _Element
    interface _String : _Element
    interface _RegExp : _Element
    interface _Array<out T : _Element> : _Element
    interface _Document : _Element
    interface _ObjectId : _Element
    interface _Binary : _Element
    interface _Timestamp : _Element
}

fun <T : _Element> Expr(block: BsonDocumentBlock) =
    Expr<T>(BsonDocument(block))

@BsonMarker2
context(builder: BsonDocumentBuilder)
infix fun String.by(expr: Expr<*>) =
    this by expr.element

/* ============= ------------------ ============= */

@BsonMarker4
fun `$`(path: String) = Expr<_Element>("$${path}".bson)

@BsonMarker4
fun `$$`(path: String) = Expr<_Element>("$$${path}".bson)

@Suppress("UNCHECKED_CAST")
@BsonMarker4
fun <T : _Element> Expr<*>.unsafeCast() = this as Expr<T>

/* ============= ------------------ ============= */

@BsonMarker4
val BsonArray?.exprUnsafe get() = Expr<_Array<_Element>>(this ?: null.bson)
@BsonMarker4
val BsonDocument?.exprUnsafe get() = Expr<_Document>(this ?: null.bson)

//

@BsonMarker4
val Nothing?.expr get() = Expr<_Element>(null.bson)
@BsonMarker4
val BsonElement?.expr get() = Expr<_Element>(this ?: null.bson)
@BsonMarker4
val BsonDouble?.expr get() = Expr<_Number>(this ?: null.bson)
@BsonMarker4
val BsonInt32?.expr get() = Expr<_Number>(this ?: null.bson)
@BsonMarker4
val BsonInt64?.expr get() = Expr<_Number>(this ?: null.bson)
@BsonMarker4
val BsonDecimal128?.expr get() = Expr<_Number>(this ?: null.bson)
@BsonMarker4
val BsonBoolean?.expr get() = Expr<_Boolean>(this ?: null.bson)
@BsonMarker4
val BsonDateTime?.expr get() = Expr<_DateTime>(this ?: null.bson)
@BsonMarker4
val BsonObjectId?.expr get() = Expr<_ObjectId>(this ?: null.bson)
@BsonMarker4
val BsonString?.expr get() = Expr<_String>(this ?: null.bson)
@BsonMarker4
val BsonRegExp?.expr get() = Expr<_RegExp>(this ?: null.bson)
@BsonMarker4
val BsonBinary?.expr get() = Expr<_Binary>(this ?: null.bson)
@BsonMarker4
val BsonTimestamp?.expr get() = Expr<_Timestamp>(this ?: null.bson)

//

@BsonMarker4
val Double?.expr get() = Expr<_Number>(bson)
@BsonMarker4
val Int?.expr get() = Expr<_Number>(bson)
@BsonMarker4
val Long?.expr get() = Expr<_Number>(bson)
@BsonMarker4
val Decimal128?.expr get() = Expr<_Number>(bson)
@BsonMarker4
val Boolean?.expr get() = Expr<_Boolean>(bson)
@BsonMarker4
val Instant?.expr get() = Expr<_DateTime>(bson)
@BsonMarker4
val ObjectId?.expr get() = Expr<_ObjectId>(bson)
@BsonMarker4
val AnyID?.expr get() = Expr<_Element>(bson)
@BsonMarker4
val String?.expr get() = Expr<_String>(bson)

/* ============= ------------------ ============= */
