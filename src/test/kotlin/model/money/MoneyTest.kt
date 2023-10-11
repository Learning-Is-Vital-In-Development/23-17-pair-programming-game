package model.money

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

private const val NON_NEGATIVE_NUMBER_ERROR = "금액은 0원 이상이어야 합니다."

class MoneyTest : FreeSpec({

    "Money 생성" - {
        "금액이 0원 이상이면 생성 가능하다." {
            Money(BigDecimal.ZERO)
            Money(BigDecimal.ONE)
        }

        "금액이 0원 미만이면 예외가 발생한다." {
            shouldThrowExactly<IllegalArgumentException> {
                Money(BigDecimal.valueOf(-1))
            }.message shouldBe NON_NEGATIVE_NUMBER_ERROR
        }
    }
})
