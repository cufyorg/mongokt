@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonDocumentBlock
import org.cufy.bson.BsonElement
import org.cufy.bson.BsonMarker2
import org.cufy.bson.by
import org.cufy.mongodb.`$literal`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr._Document
import org.cufy.mongodb.expr.Expr._Element

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#literal-expression-operator

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/literal/ */
@BsonMarker2
context(_: ExprScope)
fun literal(value: BsonElement): Expr<_Element> =
    Expr { `$literal` by value }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/literal/ */
@BsonMarker2
context(_: ExprScope)
fun literal(value: BsonDocumentBlock): Expr<_Document> =
    Expr { `$literal` by document(value) }

/* ============= ------------------ ============= */
