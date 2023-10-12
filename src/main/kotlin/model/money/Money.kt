package model.money

import java.math.BigDecimal

private const val NON_NEGATIVE_NUMBER_ERROR_MESSAGE = "금액은 0원 이상이어야 합니다."

class Money(amount: BigDecimal) {
    init {
        require(amount >= BigDecimal.ZERO) { NON_NEGATIVE_NUMBER_ERROR_MESSAGE }
    }

}
