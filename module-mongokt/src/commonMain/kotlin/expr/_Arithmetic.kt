@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr._DateTime
import org.cufy.mongodb.expr.Expr._Number

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#arithmetic-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/abs/ */
@BsonMarker2
context(_: ExprScope)
fun abs(number: Expr<_Number>): Expr<_Number> =
    Expr { `$abs` by number.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/add/ */
@BsonMarker2
context(_: ExprScope)
fun add(vararg expressions: Expr<_Number>): Expr<_Number> =
    add(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/add/ */
@BsonMarker2
context(_: ExprScope)
fun add(expressions: List<Expr<_Number>>): Expr<_Number> =
    Expr { `$add` by array { expressions.forEach { by(it.element) } } }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/add/ */
@BsonMarker2
context(_: ExprScope)
fun add(expression1: Expr<_DateTime>, vararg expressions: Expr<_Number>): Expr<_DateTime> =
    add(expression1, expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/add/ */
@BsonMarker2
context(_: ExprScope)
fun add(expression1: Expr<_DateTime>, expressions: List<Expr<_Number>>): Expr<_DateTime> =
    Expr { `$add` by array { by(expression1.element); expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/ceil/ */
@BsonMarker2
context(_: ExprScope)
fun ceil(number: Expr<_Number>): Expr<_Number> =
    Expr { `$ceil` by number.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/divide/ */
@BsonMarker2
context(_: ExprScope)
fun divide(expression1: Expr<_Number>, expression2: Expr<_Number>): Expr<_Number> =
    Expr { `$divide` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/exp/ */
@BsonMarker2
context(_: ExprScope)
fun exp(exponent: Expr<_Number>): Expr<_Number> =
    Expr { `$exp` by exponent.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/floor/ */
@BsonMarker2
context(_: ExprScope)
fun floor(number: Expr<_Number>): Expr<_Number> =
    Expr { `$floor` by number.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/ln/ */
@BsonMarker2
context(_: ExprScope)
fun ln(number: Expr<_Number>): Expr<_Number> =
    Expr { `$ln` by number.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/log/ */
@BsonMarker2
context(_: ExprScope)
fun log(number: Expr<_Number>, base: Expr<_Number>): Expr<_Number> =
    Expr { `$log` by array(number.element, base.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/log10/ */
@BsonMarker2
context(_: ExprScope)
fun log10(number: Expr<_Number>): Expr<_Number> =
    Expr { `$log10` by number.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/mod/ */
@BsonMarker2
context(_: ExprScope)
fun mod(expression1: Expr<_Number>, expression2: Expr<_Number>): Expr<_Number> =
    Expr { `$mod` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/multiply/ */
@BsonMarker2
context(_: ExprScope)
fun multiply(vararg expressions: Expr<_Number>): Expr<_Number> =
    multiply(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/multiply/ */
@BsonMarker2
context(_: ExprScope)
fun multiply(expressions: List<Expr<_Number>>): Expr<_Number> =
    Expr { `$multiply` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/pow/ */
@BsonMarker2
context(_: ExprScope)
fun pow(number: Expr<_Number>, exponent: Expr<_Number>): Expr<_Number> =
    Expr { `$pow` by array(number.element, exponent.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/round/ */
@BsonMarker2
context(_: ExprScope)
fun round(number: Expr<_Number>, place: Expr<_Number>): Expr<_Number> =
    Expr { `$round` by array(number.element, place.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sqrt/ */
@BsonMarker2
context(_: ExprScope)
fun sqrt(number: Expr<_Number>): Expr<_Number> =
    Expr { `$sqrt` by number.element }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/subtract/ */
@BsonMarker2
@JvmName("subtract_Number_Number")
context(_: ExprScope)
fun subtract(expression1: Expr<_Number>, expression2: Expr<_Number>): Expr<_Number> =
    Expr { `$subtract` by array(expression1.element, expression2.element) }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/subtract/ */
@BsonMarker2
@JvmName("subtract_DateTime_Number")
context(_: ExprScope)
fun subtract(expression1: Expr<_DateTime>, expression2: Expr<_Number>): Expr<_DateTime> =
    Expr { `$subtract` by array(expression1.element, expression2.element) }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/subtract/ */
@BsonMarker2
@JvmName("subtract_DateTime_DateTime")
context(_: ExprScope)
fun subtract(expression1: Expr<_DateTime>, expression2: Expr<_DateTime>): Expr<_Number> =
    Expr { `$subtract` by array(expression1.element, expression2.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/trunc/ */
@BsonMarker2
context(_: ExprScope)
fun trunc(number: Expr<_Number>, place: Expr<_Number>): Expr<_Number> =
    Expr { `$trunc` by array(number.element, place.element) }

/* ============= ------------------ ============= */
