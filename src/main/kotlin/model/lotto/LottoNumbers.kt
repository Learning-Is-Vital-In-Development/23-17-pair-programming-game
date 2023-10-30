package model.lotto

internal const val INVALID_LOTTO_NUMBER_COUNT_MESSAGE = "로또 번호는 6개여야 합니다."
internal const val INVALID_LOTTO_NUMBER_DUPLICATE_MESSAGE = "로또 번호는 중복될 수 없습니다."

class LottoNumbers private constructor(private val numbers: List<LottoNumber>) {
    companion object {
        fun from(numbers: List<Int>): LottoNumbers {
            check(numbers.size == 6) { INVALID_LOTTO_NUMBER_COUNT_MESSAGE }
            check(numbers.distinct().size == 6) { INVALID_LOTTO_NUMBER_DUPLICATE_MESSAGE }
            val lottoNumbers = numbers.map { LottoNumber(it) }
            return LottoNumbers(lottoNumbers)
        }
    }

    fun matchCount(winningNumbers: LottoNumbers): Int {
        return numbers.count { winningNumbers.numbers.contains(it) }
    }

    fun matchBonus(bonusNumber: LottoNumber): Boolean {
        return numbers.contains(bonusNumber)
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]") { it.toString() }
    }
}
