package view

internal const val EMPTY_VALUE_ERROR_MESSAGE = "값이 비어있습니다."
internal const val INVALID_NUMBER_FORMAT_MESSAGE = "입력한 값은 숫자여야 합니다."

class Amount(private val stringAmount: String) {
    private val integers = '0'..'9'

    init {
        require(stringAmount.isNotBlank()) { EMPTY_VALUE_ERROR_MESSAGE }
        require(stringAmount.isInt()) { INVALID_NUMBER_FORMAT_MESSAGE }
    }

    fun getBigDecimal() = stringAmount.toBigDecimal()

    private fun String.isInt() = this.all { it in integers }
}
