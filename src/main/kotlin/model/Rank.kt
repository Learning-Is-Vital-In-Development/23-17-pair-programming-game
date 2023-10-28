package model

import model.money.Money
import java.math.BigDecimal

enum class Rank(earningMoney: Money) {
    FIRST(Money(BigDecimal.valueOf(2_000_000_000))),
    SECOND(Money(BigDecimal.valueOf(50_000_000))),
    THIRD(Money(BigDecimal.valueOf(5_000_000))),
    FOURTH(Money(BigDecimal.valueOf(50_000))),
    FIFTH(Money(BigDecimal.valueOf(5_000))),
    MISS(Money.ZERO),
    ;

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): Rank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (bonusMatch) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
        }
    }
}
