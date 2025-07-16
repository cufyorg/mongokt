@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.by
import org.cufy.mongodb.`$binarySize`
import org.cufy.mongodb.`$bsonSize`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#data-size-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/binarySize/ */
@BsonMarker2
@JvmName("binarySize_String")
fun `$binarySize`(string: Expr<_String>): Expr<_Number> =
    Expr { `$binarySize` by string.element }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/binarySize/ */
@BsonMarker2
@JvmName("binarySize_Binary")
fun `$binarySize`(binary: Expr<_Binary>): Expr<_Number> =
    Expr { `$binarySize` by binary.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/bsonSize/ */
@Suppress("LocalVariableName")
@BsonMarker2
fun `$bsonSize`(_object: Expr<_Document>): Expr<_Number> =
    Expr { `$bsonSize` by _object.element }

/* ============= ------------------ ============= */
