package view

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import view.Amount
import java.math.BigDecimal

class AmountTest : BehaviorSpec(
    {

        given("금액을 입력받을 때") {
            `when`("숫자를 금액으로 입력하면") {
                val amount = "2400"
                then("금액에 맞는 BigDecimal 자료형이 반환된다.") {
                    Amount(amount).getBigDecimal() shouldBe BigDecimal(amount)
                }
            }

            `when`("문자열을 금액으로 입력하면") {
                val invalidAmount = "invalid amount"
                then("IllegalArgumentException 예외가 발생한다") {
                    shouldThrowExactly<IllegalArgumentException> {
                        Amount(invalidAmount)
                    }
                }
            }

            `when`("숫자가 포함된 문자열을 금액으로 입력하면") {
                val invalidAmount = "3k34j4"
                then("IllegalArgumentException 예외가 발생한다") {
                    shouldThrowExactly<IllegalArgumentException> {
                        Amount(invalidAmount)
                    }
                }
            }

            `when`("비어있는 문자열을 금액으로 입력하면") {
                val invalidAmount = ""
                then("IllegalArgumentException 예외가 발생한다") {
                    shouldThrowExactly<IllegalArgumentException> {
                        Amount(invalidAmount)
                    }
                }
            }
        }
    },
)
