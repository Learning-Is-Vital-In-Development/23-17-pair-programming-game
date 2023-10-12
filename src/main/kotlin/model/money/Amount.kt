package model.money

import view.EMPTY_VALUE_ERROR_MESSAGE
import view.INVALID_NUMBER_FORMAT_MESSAGE

class Amount(private val stringAmount: String) {
    private val integers = '0'..'9'

    init {
        require(stringAmount.isNotBlank()) { EMPTY_VALUE_ERROR_MESSAGE }
        require(stringAmount.isInt()) { INVALID_NUMBER_FORMAT_MESSAGE }
    }

    fun getBigDecimal() = stringAmount.toBigDecimal()

    private fun String.isInt() = this.all { it in integers }
}
