package model.lotto

internal const val INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 1에서 45 사이여야 합니다."

data class LottoNumber(private val value: Int) {
    init {
        require(value in 1..45) { INVALID_LOTTO_NUMBER_MESSAGE }
    }

    override fun toString(): String {
        return value.toString()
    }
}
