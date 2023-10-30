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

        describe("일치하는 LottoNumber 의 개수를 반환한다") {
            it("모든 숫자 일치") {
                val numbers = listOf(1, 2, 3, 4, 5, 6)
                val lottoNumbers = LottoNumbers.from(numbers)
                val winningNumbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
                lottoNumbers.matchCount(winningNumbers) shouldBe 6
            }

            it("순서는 상관없다") {
                val numbers = listOf(1, 2, 3, 4, 5, 6)
                val lottoNumbers = LottoNumbers.from(numbers)
                val winningNumbers = LottoNumbers.from(listOf(6, 5, 4, 3, 2, 1))
                lottoNumbers.matchCount(winningNumbers) shouldBe 6
            }

            it("일치하는 숫자가 없다") {
                val numbers = listOf(1, 2, 3, 4, 5, 6)
                val lottoNumbers = LottoNumbers.from(numbers)
                val winningNumbers = LottoNumbers.from(listOf(7, 8, 9, 10, 11, 12))
                lottoNumbers.matchCount(winningNumbers) shouldBe 0
            }
        }
    },
)
