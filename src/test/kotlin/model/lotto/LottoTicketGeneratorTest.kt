package model.lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTicketGeneratorTest : FreeSpec(
    {
        "LottoTicketGenerator 생성" - {
            "일정 수의 티켓 생성" {
                val count = 5
                val tickets = LottoGameGenerator.generate(count)

                tickets.size shouldBe count
            }

            "수동 티켓 생성" {
                val manualNumbers =
                    listOf(
                        LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6)),
                        LottoNumbers.from(listOf(7, 8, 9, 10, 11, 12)),
                    )
                val tickets = LottoGameGenerator.generate(manualNumbers)

                tickets.size shouldBe manualNumbers.size
                tickets.forEach { it.type shouldBe TicketType.Manual }
            }
        }
    },
)
