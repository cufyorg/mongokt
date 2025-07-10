@file:Suppress("FunctionName")
@file:OptIn(ExperimentalMongodbApi::class)

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.`$cond`
import org.cufy.mongodb.`$ifNull`
import org.cufy.mongodb.`$switch`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr._Element
import org.cufy.mongodb.expr.Expr._Boolean

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#conditional-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/cond/ */
@Suppress("LocalVariableName")
@BsonMarker2
context(_: ExprScope)
fun <T : _Element> cond(_if: Expr<_Boolean>, then: Expr<T>, _else: Expr<T>): Expr<T> =
    Expr { `$cond` by array(_if.element, then.element, _else.element) }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/ifNull/ */
@BsonMarker2
context(_: ExprScope)
fun <T : _Element> ifNull(vararg expressions: Expr<T>): Expr<T> =
    ifNull(expressions.asList())

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/ifNull/ */
@BsonMarker2
context(_: ExprScope)
fun <T : _Element> ifNull(expressions: List<Expr<T>>): Expr<T> =
    Expr { `$ifNull` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/switch/ */
@BsonMarker2
context(_: ExprScope)
fun <T : _Element> switch(
    vararg branches: Pair<Expr<_Boolean>, Expr<T>>,
    default: Expr<T>? = null,
): Expr<T> = switch(
    branches.asList(),
    default,
)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/switch/ */
@BsonMarker2
context(_: ExprScope)
fun <T : _Element> switch(
    branches: List<Pair<Expr<_Boolean>, Expr<T>>>,
    default: Expr<T>? = null,
): Expr<T> = Expr {
    `$switch` by {
        "branches" by array {
            branches.forEach { (case, then) ->
                by { "case" by case.element; "then" by then.element }
            }
        }

        if (default != null)
            "default" by default.element
    }
}

/* ============= ------------------ ============= */
