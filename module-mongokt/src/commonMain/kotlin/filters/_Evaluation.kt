@file:Suppress("FunctionName")

package org.cufy.mongodb.filters

import org.cufy.bson.*
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr
import org.cufy.mongodb.expr.Expr._Boolean
import org.cufy.mongodb.expr.by

// https://www.mongodb.com/docs/manual/reference/operator/query/#evaluation

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/expr */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$expr`(expression: BsonDocument) =
    `$expr` by expression

/** https://www.mongodb.com/docs/manual/reference/operator/query/expr */
@ExperimentalMongodbApi
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$expr`(expression: Expr<_Boolean>) =
    `$expr` by expression

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/jsonSchema */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$jsonSchema`(expression: BsonDocumentBlock) =
    `$jsonSchema` by expression

/** https://www.mongodb.com/docs/manual/reference/operator/query/jsonSchema */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$jsonSchema`(expression: BsonDocument) =
    `$jsonSchema` by expression

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/mod */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun `$mod`(divisor: Int, remainder: Int) =
    `$mod` by array(divisor.bson, remainder.bson)

/** https://www.mongodb.com/docs/manual/reference/operator/query/mod */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun `$mod`(divisor: Long, remainder: Long) =
    `$mod` by array(divisor.bson, remainder.bson)

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/regex */
@BsonMarker2
@JvmName("regex_String_String")
context(_: /* Operator */BsonDocumentBuilder)
fun `$regex`(regex: String, options: String? = null) {
    `$regex` by regex
    if (options != null) `$options` by options
}

/** https://www.mongodb.com/docs/manual/reference/operator/query/regex */
@BsonMarker2
context(_: /* Operator */BsonDocumentBuilder)
fun `$regex`(regex: BsonRegExp, options: String? = null) {
    `$regex` by regex
    if (options != null) `$options` by options
}

/** https://www.mongodb.com/docs/manual/reference/operator/query/regex */
@BsonMarker2
@JvmName("String_regex_String")
context(_: /* Query */BsonDocumentBuilder)
infix fun String.`$regex`(regex: String) =
    this by { `$regex` by regex }

/** https://www.mongodb.com/docs/manual/reference/operator/query/regex */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
infix fun String.`$regex`(regex: BsonRegExp) =
    this by { `$regex` by regex }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/query/text */
@BsonMarker2
context(_: /* Query */BsonDocumentBuilder)
fun `$text`(
    search: String,
    language: String? = null,
    caseSensitive: Boolean? = null,
    diacriticSensitive: Boolean? = null,
) {
    `$text` by {
        `$search` by search
        if (language != null) `$language` by language
        if (caseSensitive != null) `$caseSensitive` by caseSensitive
        if (diacriticSensitive != null) `$diacriticSensitive` by diacriticSensitive
    }
}

/* ============= ------------------ ============= */

// $where is already deprecated. Additionally, Both BSON Javascript Type 13 and 15 are not supported.

/* ============= ------------------ ============= */
