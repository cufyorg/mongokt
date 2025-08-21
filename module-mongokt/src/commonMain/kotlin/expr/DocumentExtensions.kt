@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.*
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

/* ============= ------------------ ============= */

// _Literal.kt

@BsonMarker4
val BsonDocument.exprLiteral get() = `$literal`(this)

@BsonMarker4
fun documentLiteral(): Expr<_Document> =
    `$literal`(BsonDocument())

@BsonMarker4
fun documentLiteral(vararg pairs: Pair<String, BsonElement>): Expr<_Document> =
    `$literal`(BsonDocument(*pairs))

@BsonMarker4
fun documentLiteral(block: BsonDocumentBlock): Expr<_Document> =
    `$literal`(BsonDocument(block))

@BsonMarker4
fun documentExpr(): Expr<_Document> {
    // todo is this safe?
    return Expr { BsonDocument() }
}

@BsonMarker4
fun documentExpr(vararg pairs: Pair<String, Expr<*>>): Expr<_Document> {
    // todo is this safe?
    return Expr { BsonDocument { pairs.forEach { it.first by it.second.element } } }
}

@BsonMarker4
fun documentExpr(block: BsonDocumentBlock): Expr<_Document> {
    // todo is this safe?
    return Expr { BsonDocument(block) }
}

/* ============= ------------------ ============= */

// _Object.kt

@BsonMarker4
@JvmName("Document_plus_Document")
operator fun Expr<_Document>.plus(other: Expr<_Document>): Expr<_Document> =
    `$mergeObjects`(this, other)

@BsonMarker4
@JvmName("Document_plus_Document")
operator fun Expr<_Document>.plus(other: Pair<Expr<_String>, Expr<_Element>>): Expr<_Document> =
    `$setField`(other.first, this, other.second)

// _Miscellaneous.kt

@BsonMarker4
@JvmName("Document_get_String")
operator fun Expr<_Document>.get(field: Expr<_String>): Expr<_Element> =
    `$getField`(field, this)

/* ============= ------------------ ============= */
