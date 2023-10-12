package model.lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

private const val INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 1에서 45 사이여야 합니다."

class LottoNumberTest : FreeSpec(
    {
        "LottoNumber 생성" - {
            "번호가 1 미만일 때는 예외가 발생해야한다." {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoNumber(0)
                }.message shouldBe INVALID_LOTTO_NUMBER_MESSAGE
            }
            "번호가 46 이상일 때는 예외가 발생해야한다." {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoNumber(46)
                }.message shouldBe INVALID_LOTTO_NUMBER_MESSAGE
            }
            "번호가 1 이상 45 이하일 때는 인스턴스가 생성되어야한다." {
                LottoNumber(1) shouldBe LottoNumber(1)
                LottoNumber(45) shouldBe LottoNumber(45)
            }
        }
    },
)
