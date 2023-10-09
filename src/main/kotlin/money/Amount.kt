package money

import java.lang.IllegalArgumentException

class Amount(private val stringAmount: String) {
    private val integers = '0'..'9'

    init {
        if (stringAmount.isBlank()) {
            throw IllegalArgumentException("값이 비어있습니다.")
        }

        if (!isInteger(stringAmount)) {
            throw IllegalArgumentException("입력한 $stringAmount 값은 숫자여야 합니다.")
        }
    }

    fun getBigDecimal() = stringAmount.toBigDecimal()

    private fun isInteger(input: String) = input.all { it in integers }
}
