package model.money

import java.math.BigDecimal

internal const val NON_NEGATIVE_NUMBER_ERROR_MESSAGE = "금액은 0원 이상이어야 합니다."
val LOTTO_PRICE = Money(BigDecimal.valueOf(1000))

class Money(private val amount: BigDecimal) {
    init {
        require(amount >= BigDecimal.ZERO) { NON_NEGATIVE_NUMBER_ERROR_MESSAGE }
    }

    companion object {
        val ZERO = Money(BigDecimal.ZERO)
    }

    operator fun div(other: Money): Int {
        return amount.divide(other.amount).toInt()
    }

    operator fun times(count: Int): Money {
        return Money(amount.multiply(BigDecimal.valueOf(count.toLong())))
    }

    operator fun minus(other: Money): Money {
        return Money(amount.subtract(other.amount))
    }

    operator fun plus(other: Money): Money {
        return Money(amount.add(other.amount))
    }
}
