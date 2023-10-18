package model.lotto

import model.money.Money
import model.money.PRICE

internal const val NEGATIVE_NUMBER_ERROR_MESSAGE = "입력한 값은 숫자여야 합니다."
internal const val NOT_ENOUGH_MONEY_MESSAGE = "금액이 부족합니다"

class LottoCount(
    val manualCount: Int,
    val autoCount: Int,
) {
    companion object {
        fun of(manualCount: Int, money: Money): LottoCount {
            require(manualCount >= 0) { NEGATIVE_NUMBER_ERROR_MESSAGE }
            val totalCount = money / PRICE
            val autoCount = totalCount - manualCount
            check(autoCount >= 0) { NOT_ENOUGH_MONEY_MESSAGE }
            return LottoCount(manualCount, autoCount)
        }
    }
}
