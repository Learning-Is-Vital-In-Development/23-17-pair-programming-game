package money

class Amount(private val stringAmount: String) {
    private val integers = '0'..'9'

    init {
        require(stringAmount.isNotBlank()) { "값이 비어있습니다." }
        require(stringAmount.isInt()) { "입력한 $stringAmount 값은 숫자여야 합니다." }
    }

    fun getBigDecimal() = stringAmount.toBigDecimal()

    private fun String.isInt() = this.all { it in integers }
}
