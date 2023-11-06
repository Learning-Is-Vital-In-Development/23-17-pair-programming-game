package model.lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import model.generateFixtureLottoGames

class LottoTicketTest : FreeSpec(
    {
        "LottoTicket을 생성할 때" - {
            "1개의 로또 게임이 포함 될 수 있다." - {
                val count = 1
                val ticket = LottoTicket(generateFixtureLottoGames(count))
                ticket.games.size shouldBe count
            }

            "5개의 로또 게임이 포함 될 수 있다." - {
                val count = 5
                val ticket = LottoTicket(generateFixtureLottoGames(count))
                ticket.games.size shouldBe count
            }

            "로또 게임이 없으면 안된다." - {
                val games = generateFixtureLottoGames(0)
                println(games)
                shouldThrowExactly<IllegalArgumentException> {
                    LottoTicket(emptyList())
                }.message shouldBe REQUIRED_LEAST_ONE_GAME
            }

            "로또 게임이 6개 이상 포함되면 안된다." - {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoTicket(generateFixtureLottoGames(6))
                }.message shouldBe REQUIRED_MAXIMUM_FIVE_GAME
            }
        }
    },
)
