package money

import java.math.BigDecimal

class Money(private val amount: BigDecimal) {
    init {
        require(amount >= BigDecimal.ZERO) { "금액은 0원 이상이어야 합니다." }
    }
}
