@file:OptIn(ExperimentalMongodbApi::class)
@file:Suppress("FunctionName")

package org.cufy.mongodb.expr

import org.cufy.bson.BsonMarker4
import org.cufy.bson.array
import org.cufy.bson.by
import org.cufy.mongodb.*
import org.cufy.mongodb.expr.Expr.*

// https://www.mongodb.com/docs/manual/reference/operator/aggregation/#accumulators--in-other-stages-

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/avg */
@BsonMarker4
fun `$avg`(array: Expr<_Array<_Number>>): Expr<_Number> =
    Expr { `$avg` by array.element }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/avg */
@BsonMarker4
fun `$avg`(vararg expressions: Expr<_Number>): Expr<_Number> =
    Expr { `$avg` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/max */
@BsonMarker4
fun <T : _Element> `$max`(array: Expr<_Array<T>>): Expr<T> =
    Expr { `$max` by array.element }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/max */
@BsonMarker4
fun <T : _Element> `$max`(vararg expressions: Expr<T>): Expr<T> =
    Expr { `$max` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/min */
@BsonMarker4
fun <T : _Element> `$min`(array: Expr<_Array<T>>): Expr<T> =
    Expr { `$min` by array.element }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/min */
@BsonMarker4
fun <T : _Element> `$min`(vararg expressions: Expr<T>): Expr<T> =
    Expr { `$min` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/stdDevPop */
@BsonMarker4
fun `$stdDevPop`(array: Expr<_Array<_Number>>): Expr<_Number> =
    Expr { `$stdDevPop` by array.element }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/stdDevPop */
@BsonMarker4
fun `$stdDevPop`(vararg expressions: Expr<_Number>): Expr<_Number> =
    Expr { `$stdDevPop` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/stdDevSamp */
@BsonMarker4
fun `$stdDevSamp`(array: Expr<_Array<_Number>>): Expr<_Number> =
    Expr { `$stdDevSamp` by array.element }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/stdDevSamp */
@BsonMarker4
fun `$stdDevSamp`(vararg expressions: Expr<_Number>): Expr<_Number> =
    Expr { `$stdDevSamp` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sum */
@BsonMarker4
fun `$sum`(array: Expr<_Array<_Number>>): Expr<_Number> =
    Expr { `$sum` by array.element }

/** https://www.mongodb.com/docs/manual/reference/operator/aggregation/sum */
@BsonMarker4
fun `$sum`(vararg expressions: Expr<_Number>): Expr<_Number> =
    Expr { `$sum` by array { expressions.forEach { by(it.element) } } }

/* ============= ------------------ ============= */
