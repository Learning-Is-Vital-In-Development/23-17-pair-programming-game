package view

class Number(private val stringNumber: String) {
    private val integers = '0'..'9'

    init {
        require(stringNumber.isNotBlank()) { "번호가 비어있을 수 없습니다." }
        require(stringNumber.isInt()) { INVALID_NUMBER_FORMAT_MESSAGE }
    }

    fun getInt() = stringNumber.toInt()

    private fun String.isInt() = this.all { it in integers }
}
