package controller

import model.lotto.LottoCount
import model.lotto.LottoNumbers
import model.money.Money
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val money = validInputView({ inputCapital() }) { outputView.printMessage(it) }
        val lottoCount: LottoCount = validInputView({ inputManualCount(money) }) { outputView.printMessage(it) }
        validInputView({ inputManualLottoNumber(lottoCount) }) { outputView.printMessage(it) }
    }

    private fun inputCapital(): Money {
        outputView.requestCapital()
        return Money(inputView.requestAmount())
    }

    private fun inputManualCount(money: Money): LottoCount {
        outputView.requestManualCount()
        val manualCount = inputView.requestAmount().toInt()
        return LottoCount.of(manualCount, money)
    }

    private fun inputManualLottoNumber(lottoCount: LottoCount): List<LottoNumbers> {
        return (1..lottoCount.manualCount)
            .map {
                outputView.requestManualLottoNumber()
                inputView.requestLottoNumber()
            }
            .map { LottoNumbers.from(it) }
    }
}
