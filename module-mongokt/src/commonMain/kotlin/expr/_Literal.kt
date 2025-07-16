@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.*
import org.cufy.mongodb.`$literal`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#literal-expression-operator

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/literal/ */
@BsonMarker2
fun `$literal`(value: BsonElement): Expr<_Element> =
    Expr { `$literal` by value }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/literal/ */
@BsonMarker2
fun `$literal`(value: BsonDocument): Expr<_Document> =
    Expr { `$literal` by value }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/literal/ */
@BsonMarker2
fun `$literal`(value: BsonArray): Expr<_Array> =
    Expr { `$literal` by value }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/literal/ */
@BsonMarker2
fun `$literal`(value: BsonDocumentBlock): Expr<_Document> =
    Expr { `$literal` by document(value) }

@BsonMarker2
val BsonArray.exprLiteral get() = `$literal`(this)
@BsonMarker2
val BsonDocument.exprLiteral get() = `$literal`(this)

/* ============= ------------------ ============= */
