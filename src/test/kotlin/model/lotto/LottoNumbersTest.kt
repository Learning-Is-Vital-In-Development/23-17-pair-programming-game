package model.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : DescribeSpec(
    {
        describe("로또 번호는 6개의 유일한 숫자로 구성되어야 한다") {
            it("6개가 아니면 예외가 발생한다") {
                val numbers = listOf(1, 2, 3, 4, 5)
                val exception = shouldThrow<IllegalStateException> {
                    LottoNumbers.from(numbers)
                }
                exception.message shouldBe INVALID_LOTTO_NUMBER_COUNT_MESSAGE
            }

            it("6개면 예외가 발생하지 않는다") {
                val numbers = listOf(1, 2, 3, 4, 5, 6)
                LottoNumbers.from(numbers)
            }

            it("중복된 숫자가 있으면 예외가 발생한다") {
                val numbers = listOf(1, 2, 3, 4, 5, 5)
                val exception =
                    shouldThrow<IllegalStateException> {
                    LottoNumbers.from(numbers)
                }
                exception.message shouldBe INVALID_LOTTO_NUMBER_DUPLICATE_MESSAGE
            }
        }
    },
)
