package model.lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoGameGeneratorTest : FreeSpec(
    {
        "LottoGameGenerator 생성" - {
            "일정 수의 로또 게임 생성" {
                val count = 5
                val lottoGames = LottoGameGenerator.generate(count)

                lottoGames.size shouldBe count
            }

            "수동 로또 게임 생성" {
                val manualNumbers =
                    listOf(
                        LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6)),
                        LottoNumbers.from(listOf(7, 8, 9, 10, 11, 12)),
                    )
                val manualGames = LottoGameGenerator.generate(manualNumbers)

                manualGames.size shouldBe manualNumbers.size
                manualGames.forEach { it.type shouldBe TicketType.Manual }
            }
        }
    },
)
