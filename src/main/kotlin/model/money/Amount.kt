package model.money

class Amount(private val stringAmount: String) {
    private val integers = '0'..'9'

    init {
        require(stringAmount.isNotBlank()) { EMPTY_VALUE_ERROR }
        require(stringAmount.isInt()) { INVALID_INPUT_ERROR_PREFIX + stringAmount + INVALID_INPUT_ERROR_SUFFIX }
    }

    fun getBigDecimal() = stringAmount.toBigDecimal()

    private fun String.isInt() = this.all { it in integers }

    companion object {
        private const val EMPTY_VALUE_ERROR = "값이 비어있습니다."
        private const val INVALID_INPUT_ERROR_PREFIX = "입력한"
        private const val INVALID_INPUT_ERROR_SUFFIX = "값은 숫자여야 합니다."
    }
}
