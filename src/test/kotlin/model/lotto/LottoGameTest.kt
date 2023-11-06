package model.lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoGameTest : FreeSpec(
    {
        "ManualLotto 생성" {
            val numbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
            val ticket = LottoGame.Manual(numbers)

            ticket.numbers shouldBe numbers
        }

        "AutoLotto 출력" {
            val numbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
            val ticket = LottoGame.Auto(numbers)

            ticket.toString() shouldBe numbers.toString()
        }
    },
)
