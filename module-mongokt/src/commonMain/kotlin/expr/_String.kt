@file:Suppress("FunctionName")
@file:OptIn(ExperimentalMongodbApi::class)

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#string-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/concat/ */
@BsonMarker4
fun `$concat`(vararg expressions: Expr<_String>): Expr<_String> =
    `$concat`(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/concat/ */
@BsonMarker4
fun `$concat`(expressions: List<Expr<_String>>): Expr<_String> =
    Expr { `$concat` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

// $dateFromString @ _Date.kt

/* ============= ------------------ ============= */

// $dateToString @ _Date.kt

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/indexOfBytes/ */
@BsonMarker4
fun `$indexOfBytes`(
    stringExpression: Expr<_String>,
    substringExpression: Expr<_String>,
    start: Expr<_Number>? = null,
): Expr<_Number> = Expr {
    if (start != null) {
        `$indexOfBytes` by array(
            stringExpression.element,
            substringExpression.element,
            start.element,
        )
    } else {
        `$indexOfBytes` by array(
            stringExpression.element,
            substringExpression.element,
        )
    }
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/indexOfBytes/ */
@BsonMarker4
fun `$indexOfBytes`(
    stringExpression: Expr<_String>,
    substringExpression: Expr<_String>,
    start: Expr<_Number>,
    end: Expr<_Number>? = null,
): Expr<_Number> = Expr {
    if (end != null) {
        `$indexOfBytes` by array(
            stringExpression.element,
            substringExpression.element,
            start.element,
            end.element,
        )
    } else {
        `$indexOfBytes` by array(
            stringExpression.element,
            substringExpression.element,
            start.element,
        )
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/indexOfCP/ */
@BsonMarker4
fun `$indexOfCP`(
    stringExpression: Expr<_String>,
    substringExpression: Expr<_String>,
    start: Expr<_Number>? = null,
): Expr<_Number> = Expr {
    if (start != null) {
        `$indexOfCP` by array(
            stringExpression.element,
            substringExpression.element,
            start.element,
        )
    } else {
        `$indexOfCP` by array(
            stringExpression.element,
            substringExpression.element,
        )
    }
}

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/indexOfCP/ */
@BsonMarker4
fun `$indexOfCP`(
    stringExpression: Expr<_String>,
    substringExpression: Expr<_String>,
    start: Expr<_Number>,
    end: Expr<_Number>? = null,
): Expr<_Number> = Expr {
    if (end != null) {
        `$indexOfCP` by array(
            stringExpression.element,
            substringExpression.element,
            start.element,
            end.element,
        )
    } else {
        `$indexOfCP` by array(
            stringExpression.element,
            substringExpression.element,
            start.element,
        )
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/ltrim/ */
@BsonMarker4
fun `$ltrim`(input: Expr<_String>, chars: Expr<_String>? = null): Expr<_String> =
    Expr { `$ltrim` by { "input" by input.element; if (chars != null) "chars" by chars.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/regexFind/ */
@BsonMarker4
fun `$regexFind`(
    input: Expr<_String>,
    regex: Expr<_Element /* String | RegExp */>,
    options: String? = null,
): Expr<_Document> = Expr {
    `$regexFind` by {
        "input" by input.element
        "regex" by regex.element
        if (options != null) "options" by options
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/regexFindAll/ */
@BsonMarker4
fun `$regexFindAll`(
    input: Expr<_String>,
    regex: Expr<_Element /* String | RegExp */>,
    options: String? = null,
): Expr<_Array> = Expr {
    `$regexFindAll` by {
        "input" by input.element
        "regex" by regex.element
        if (options != null) "options" by options
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/regexMatch/ */
@BsonMarker4
fun `$regexMatch`(
    input: Expr<_String>,
    regex: Expr<_Element /* String | RegExp */>,
    options: String? = null,
): Expr<_Boolean> = Expr {
    `$regexMatch` by {
        "input" by input.element
        "regex" by regex.element
        if (options != null) "options" by options
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/replaceOne/ */
@BsonMarker4
fun `$replaceOne`(
    input: Expr<_String>,
    find: Expr<_String>,
    replacement: Expr<_String>,
): Expr<_String> = Expr {
    `$replaceOne` by {
        "input" by input.element
        "find" by find.element
        "replacement" by replacement.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/replaceAll/ */
@BsonMarker4
fun `$replaceAll`(
    input: Expr<_String>,
    find: Expr<_String>,
    replacement: Expr<_String>,
): Expr<_String> = Expr {
    `$replaceAll` by {
        "input" by input.element
        "find" by find.element
        "replacement" by replacement.element
    }
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/rtrim/ */
@BsonMarker4
fun `$rtrim`(input: Expr<_String>, chars: Expr<_String>? = null): Expr<_String> =
    Expr { `$rtrim` by { "input" by input.element; if (chars != null) "chars" by chars.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/split/ */
@BsonMarker4
fun `$split`(stringExpression: Expr<_String>, delimiter: Expr<_String>): Expr<_Array> =
    Expr { `$split` by array(stringExpression.element, delimiter.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/strLenBytes/ */
@BsonMarker4
fun `$strLenBytes`(stringExpression: Expr<_String>): Expr<_Number> =
    Expr { `$strLenBytes` by stringExpression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/strLenCP/ */
@BsonMarker4
fun `$strLenCP`(stringExpression: Expr<_String>): Expr<_Number> =
    Expr { `$strLenCP` by stringExpression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/strcasecmp/ */
@BsonMarker4
fun `$strcasecmp`(expression1: Expr<_String>, expression2: Expr<_String>): Expr<_Number> =
    Expr { `$strcasecmp` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/substr/ */
@BsonMarker4
fun `$substr`(
    string: Expr<_String>,
    start: Expr<_Number>,
    length: Expr<_Number>,
): Expr<_String> = Expr {
    `$substr` by array(
        string.element,
        start.element,
        length.element,
    )
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/substrBytes/ */
@BsonMarker4
fun `$substrBytes`(
    stringExpression: Expr<_String>,
    byteIndex: Expr<_Number>,
    byteCount: Expr<_Number>,
): Expr<_String> = Expr {
    `$substrBytes` by array(
        stringExpression.element,
        byteIndex.element,
        byteCount.element,
    )
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/substrCP/ */
@BsonMarker4
fun `$substrCP`(
    stringExpression: Expr<_String>,
    codePointIndex: Expr<_Number>,
    codePointCount: Expr<_Number>,
): Expr<_String> = Expr {
    `$substrCP` by array(
        stringExpression.element,
        codePointIndex.element,
        codePointCount.element,
    )
}

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toLower/ */
@BsonMarker4
fun `$toLower`(expression: Expr<_String>): Expr<_String> =
    Expr { `$toLower` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toString/ */
@BsonMarker4
fun `$toString`(expression: Expr<_Element>): Expr<_String> =
    Expr { `$toString` by expression.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/trim/ */
@BsonMarker4
fun `$trim`(input: Expr<_String>, chars: Expr<_String>? = null): Expr<_String> =
    Expr { `$trim` by { "input" by input.element; if (chars != null) "chars" by chars.element } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/toUpper/ */
@BsonMarker4
fun `$toUpper`(expression: Expr<_String>): Expr<_String> =
    Expr { `$toUpper` by expression.element }

/* ============= ------------------ ============= */
