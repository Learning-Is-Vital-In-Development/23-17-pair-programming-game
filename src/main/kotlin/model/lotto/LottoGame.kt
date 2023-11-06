package model.lotto

sealed class LottoGame(val numbers: LottoNumbers) {
    class Manual(manualNumbers: LottoNumbers) : LottoGame(manualNumbers)
    class Auto(autoNumbers: LottoNumbers) : LottoGame(autoNumbers)

    override fun toString(): String {
        return numbers.toString()
    }
}
