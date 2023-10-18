package view

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class NumberTest : BehaviorSpec(
    {
        given("로또 번호를 입력 할 때") {
            `when`("숫자를 로또 번호로 입력하면") {
                val stringNumber = "23"
                val number = Number(stringNumber)
                then("올바른 숫자를 반환한다.") {
                    number.getInt() shouldBe stringNumber.toInt()
                }
            }

            `when`("비어있는 문자열을 입력하면") {
                val invalidNumber = ""
                then("예외가 발생한다.") {
                    shouldThrowExactly<IllegalArgumentException> {
                        Number(invalidNumber)
                    }
                }
            }

            `when`("숫자가 포함되지 않은 문자열을 입력하면") {
                val invalidNumber = "invalid Number"
                then("예외가 발생한다.") {
                    shouldThrowExactly<IllegalArgumentException> {
                        Number(invalidNumber)
                    }
                }
            }

            `when`("숫자와 문자가 포함된 문자열을 입력하면") {
                val invalidNumber = "d3"
                then("예외가 발생한다.") {
                    shouldThrowExactly<IllegalArgumentException> {
                        Number(invalidNumber)
                    }
                }
            }
        }
    },
)
