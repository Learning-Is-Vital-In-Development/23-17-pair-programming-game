package model.lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoGameTest : FreeSpec(
    {
        "LottoGame 생성" - {
            "주어진 LottoNumbers 와 TicketType 을 가진 LottoGame 을 반환" {
                val numbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
                val ticketType = TicketType.Manual
                val ticket = LottoGame.of(numbers, ticketType)

                ticket.numbers shouldBe numbers
                ticket.type shouldBe ticketType
            }
        }

        "LottoGame 출력" - {
            "LottoGame 의 numbers 필드를 문자열화 하여 반환" {
                val numbers = LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6))
                val ticket = LottoGame.of(numbers, TicketType.Manual)

                ticket.toString() shouldBe numbers.toString()
            }
        }
    },
)
