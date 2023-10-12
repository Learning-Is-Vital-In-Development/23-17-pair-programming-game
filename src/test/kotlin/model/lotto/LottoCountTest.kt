package model.lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import model.money.Money
import model.money.PRICE
import view.NOT_ENOUGH_MONEY_MESSAGE
import java.math.BigDecimal

class LottoCountTest : FreeSpec(
    {
        "수동 로또 구매 개수를 입력할 때" - {
            "돈이 충분하지 않으면 에러가 발생한다" {
                val money = Money.ZERO
                val manualCount = 2
                val exception = shouldThrow<IllegalStateException> {
                    LottoCount.of(manualCount, money)
                }
                exception.message shouldBe NOT_ENOUGH_MONEY_MESSAGE
            }

            "돈이 충분하면 수동 로또 개수와 자동 로또 개수를 구매 가능 개수만큼만 반환한다" - {
                "나누어 떨어지는 경우 모든 액수를 구매에 사용한다" {
                    val money = PRICE * 3
                    val manualCount = 2
                    val lottoCount = LottoCount.of(manualCount, money)
                    lottoCount.manualCount shouldBe 2
                    lottoCount.autoCount shouldBe 1
                }

                "나누어 떨어지지 않는 경우 구매 가능한 최대 수량만 구매한다" {
                    val money = Money(BigDecimal.valueOf(12000))
                    val manualCount = 1
                    val lottoCount = LottoCount.of(manualCount, money)
                    lottoCount.manualCount shouldBe 1
                    lottoCount.autoCount shouldBe 1
                }
            }

            "수동 로또 개수가 0이면 자동 로또 개수만 반환한다" {
                val money = PRICE * 3
                val manualCount = 0
                val lottoCount = LottoCount.of(manualCount, money)
                lottoCount.manualCount shouldBe 0
                lottoCount.autoCount shouldBe 3
            }
        }
    },
)
