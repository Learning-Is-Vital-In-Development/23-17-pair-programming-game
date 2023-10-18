package view

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.math.BigDecimal

class InputViewTest : BehaviorSpec(
    {

        given("사용자의 입력을 받는 상황에서") {
            val inputView = InputView()
            `when`("숫자를 금액으로 입력하면") {
                val amount = "2400"
                System.setIn(ByteArrayInputStream(amount.toByteArray()))
                then("금액에 맞는 BigDecimal 자료형이 반환된다.") {
                    inputView.requestAmount() shouldBe BigDecimal(amount)
                }
            }

            `when`("문자열을 금액으로 입력하면") {
                val invalidAmount = "invalid amount"
                System.setIn(ByteArrayInputStream(invalidAmount.toByteArray()))
                then("IllegalArgumentException 예외가 발생한다") {
                    shouldThrowExactly<IllegalArgumentException> {
                        inputView.requestAmount()
                    }
                }
            }

            `when`("숫자가 포함된 문자열을 금액으로 입력하면") {
                val invalidAmount = "3k34j4"
                System.setIn(ByteArrayInputStream(invalidAmount.toByteArray()))
                then("IllegalArgumentException 예외가 발생한다") {
                    shouldThrowExactly<IllegalArgumentException> {
                        inputView.requestAmount()
                    }
                }
            }
        }
    },
)


