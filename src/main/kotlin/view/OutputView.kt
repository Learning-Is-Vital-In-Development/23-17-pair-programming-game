package view

const val EMPTY_VALUE_ERROR_MESSAGE = "값이 비어있습니다."
const val INVALID_NUMBER_FORMAT_MESSAGE = "입력한 값은 숫자여야 합니다."

class OutputView {
    fun requestCapital() {
        println("구입금액을 입력해 주세요.")
    }

    fun printMessage(message: String) {
        println(message)
    }
}
