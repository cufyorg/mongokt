@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.*
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*
import kotlin.time.Instant

/* ============= ------------------ ============= */

@Suppress("ClassName")
@BsonMarker2
@ExperimentalMongodbApi
data class Expr<out T : _Element>(val element: BsonElement) {
    interface _Element
    interface _Number : _Element
    interface _Boolean : _Element
    interface _DateTime : _Element
    interface _String : _Element
    interface _RegExp : _Element
    interface _Array : _Element
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

@BsonMarker2
fun <T : _Element> `$`(path: String) = Expr<T>("$${path}".bson)

@Suppress("UNCHECKED_CAST")
@BsonMarker2
fun <T : _Element> Expr<*>.unsafeCast() = this as Expr<T>

/* ============= ------------------ ============= */

@BsonMarker2
fun arrayExpr() = Expr<_Array>(BsonArray())
@BsonMarker2
fun arrayExpr(block: BsonArrayBlock) = Expr<_Array>(BsonArray(block))
@BsonMarker2
fun arrayExpr(vararg items: BsonElement) = Expr<_Array>(BsonArray(*items))

@BsonMarker2
fun documentExpr() = Expr<_Document>(BsonDocument())
@BsonMarker2
fun documentExpr(block: BsonDocumentBlock) = Expr<_Document>(BsonDocument(block))
@BsonMarker2
fun documentExpr(vararg pairs: Pair<String, BsonElement>) = Expr<_Document>(BsonDocument(*pairs))

@BsonMarker2
val BsonArray?.exprUnsafe get() = Expr<_Array>(this ?: null.bson)
@BsonMarker2
val BsonDocument?.exprUnsafe get() = Expr<_Document>(this ?: null.bson)

//

@BsonMarker2
val Nothing?.expr get() = Expr<_Element>(null.bson)
@BsonMarker2
val BsonElement?.expr get() = Expr<_Element>(this ?: null.bson)
@BsonMarker2
val BsonDouble?.expr get() = Expr<_Number>(this ?: null.bson)
@BsonMarker2
val BsonInt32?.expr get() = Expr<_Number>(this ?: null.bson)
@BsonMarker2
val BsonInt64?.expr get() = Expr<_Number>(this ?: null.bson)
@BsonMarker2
val BsonDecimal128?.expr get() = Expr<_Number>(this ?: null.bson)
@BsonMarker2
val BsonBoolean?.expr get() = Expr<_Boolean>(this ?: null.bson)
@BsonMarker2
val BsonDateTime?.expr get() = Expr<_DateTime>(this ?: null.bson)
@BsonMarker2
val BsonObjectId?.expr get() = Expr<_ObjectId>(this ?: null.bson)
@BsonMarker2
val BsonString?.expr get() = Expr<_String>(this ?: null.bson)
@BsonMarker2
val BsonRegExp?.expr get() = Expr<_RegExp>(this ?: null.bson)
@BsonMarker2
val BsonBinary?.expr get() = Expr<_Binary>(this ?: null.bson)
@BsonMarker2
val BsonTimestamp?.expr get() = Expr<_Timestamp>(this ?: null.bson)

//

@BsonMarker2
val Double?.expr get() = Expr<_Number>(bson)
@BsonMarker2
val Int?.expr get() = Expr<_Number>(bson)
@BsonMarker2
val Long?.expr get() = Expr<_Number>(bson)
@BsonMarker2
val Decimal128?.expr get() = Expr<_Number>(bson)
@BsonMarker2
val Boolean?.expr get() = Expr<_Boolean>(bson)
@BsonMarker2
val Instant?.expr get() = Expr<_DateTime>(bson)
@BsonMarker2
val ObjectId?.expr get() = Expr<_ObjectId>(bson)
@BsonMarker2
val AnyID?.expr get() = Expr<_Element>(bson)
@BsonMarker2
val String?.expr get() = Expr<_String>(bson)

/* ============= ------------------ ============= */
