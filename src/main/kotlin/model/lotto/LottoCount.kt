package model.lotto

import model.money.Money
import model.money.PRICE
import view.NOT_ENOUGH_MONEY_MESSAGE

class LottoCount(
    val manualCount: Int,
    val autoCount: Int,
) {
    companion object {
        fun of(
            manualCount: Int,
            money: Money,
        ): LottoCount {
            val totalCount = money / PRICE
            val autoCount = totalCount - manualCount
            check(autoCount >= 0) { NOT_ENOUGH_MONEY_MESSAGE }
            return LottoCount(manualCount, autoCount)
        }
    }
}
