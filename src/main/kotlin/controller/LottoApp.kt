package controller

import money.Money
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val money = validInputView({ inputCapital() }) { outputView.printMessage(it) }
    }

    private fun inputCapital(): Money {
        outputView.requestCapital()
        return inputView.requestMoney()
    }
}
