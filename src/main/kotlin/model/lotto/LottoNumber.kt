package model.lotto

data class LottoNumber(val value: Int) {
    init {
        require(value in 1..45) { INVALID_LOTTO_NUMBER_MESSAGE }
    }

    companion object {
        private const val INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 1에서 45 사이여야 합니다."
    }
}
