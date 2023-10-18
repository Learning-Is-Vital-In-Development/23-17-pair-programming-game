package view

internal const val INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요."
internal const val INPUT_MANUAL_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
internal const val INPUT_LOTTO_NUMBER_MESSAGE = "로또 번호를 입력해 주세요. (공백으로 구분)"

class OutputView {
    fun requestCapital() {
        println(INPUT_MONEY_MESSAGE)
    }

    fun printMessage(message: String) {
        println(message)
    }

    fun requestManualCount() {
        println(INPUT_MANUAL_INPUT_MESSAGE)
    }

    fun requestManualLottoNumber() {
        println(INPUT_LOTTO_NUMBER_MESSAGE)
    }
}
