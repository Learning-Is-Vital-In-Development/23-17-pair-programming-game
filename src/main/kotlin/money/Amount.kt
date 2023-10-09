package money

class Amount(val stringAmount: String) {
    private val integers = '0'..'9'

    init {
        if (!isInteger(stringAmount)) {
            throw java.lang.IllegalArgumentException("입력한 $stringAmount 값은 숫자여야 합니다.")
        }
    }

    fun getBigDecimal() = stringAmount.toBigDecimal()

    private fun isInteger(input: String) = input.all { it in integers }
}
