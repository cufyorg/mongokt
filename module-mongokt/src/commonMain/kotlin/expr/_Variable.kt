@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker2
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.`$let`
import org.cufy.mongodb.ExperimentalMongodbApi
import org.cufy.mongodb.expr.Expr._Element

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#variable-expression-operators

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/let/ */
@Suppress("LocalVariableName")
@BsonMarker2
context(_: ExprScope)
fun <T : _Element> let(
    vararg vars: Pair<String, Expr<_Element>>,
    _in: Expr<T>,
): Expr<T> = let(
    vars.asList(),
    _in,
)

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/let/ */
@Suppress("LocalVariableName")
@BsonMarker2
context(_: ExprScope)
fun <T : _Element> let(
    vars: List<Pair<String, Expr<_Element>>>,
    _in: Expr<T>,
): Expr<T> = Expr {
    `$let` by {
        "vars" by array {
            vars.forEach { (name, expression) ->
                by { name by expression.element }
            }
        }
        "in" by _in.element
    }
}

/* ============= ------------------ ============= */
