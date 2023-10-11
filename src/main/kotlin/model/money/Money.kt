package model.money

import java.math.BigDecimal

class Money(amount: BigDecimal) {
    init {
        require(amount >= BigDecimal.ZERO) { NON_NEGATIVE_NUMBER_ERROR }
    }

    companion object {
        private const val NON_NEGATIVE_NUMBER_ERROR = "금액은 0원 이상이어야 합니다."
    }
}
