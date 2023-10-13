package model.lotto

import view.INVALID_LOTTO_NUMBER_COUNT_MESSAGE

class LottoNumbers private constructor(private val numbers: List<LottoNumber>) {
    companion object {
        fun from(numbers: List<Int>): LottoNumbers {
            check(numbers.size == 6) { INVALID_LOTTO_NUMBER_COUNT_MESSAGE }
            val lottoNumbers = numbers.map { LottoNumber(it) }
            return LottoNumbers(lottoNumbers)
        }
    }
}
