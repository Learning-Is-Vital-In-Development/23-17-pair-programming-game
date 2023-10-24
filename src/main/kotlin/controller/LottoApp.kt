package controller

import model.lotto.LottoCount
import model.lotto.LottoNumbers
import model.lotto.LottoTicket
import model.lotto.LottoTicketGenerator
import model.money.Money
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val money = validInputView({ inputCapital() }) { outputView.printMessage(it) }
        val lottoCount: LottoCount = validInputView({ requestManualCount(money) }) { outputView.printMessage(it) }
        validInputView(
            {
                val lottoTickets = generateLottoTickets(lottoCount)
                outputView.printLottoTickets(lottoTickets)
            },
        ) { outputView.printMessage(it) }
    }

    private fun inputCapital(): Money {
        outputView.requestCapital()
        return Money(inputView.requestAmount())
    }

    private fun requestManualCount(money: Money): LottoCount {
        outputView.requestManualCount()
        val manualCount = inputView.requestAmount().toInt()
        return LottoCount.of(manualCount, money)
    }

    private fun generateLottoTickets(lottoCount: LottoCount): List<LottoTicket> {
        val manualTicketNumbers = requestManualLottoNumbers(lottoCount.manualCount)
        val manualTickets = LottoTicketGenerator.generate(manualTicketNumbers)
        val autoTickets = LottoTicketGenerator.generate(lottoCount.autoCount)
        return manualTickets + autoTickets
    }

    private fun requestManualLottoNumbers(manualCount: Int): List<LottoNumbers> {
        return (1..manualCount).map {
            outputView.requestManualLottoNumber()
            LottoNumbers.from(inputView.requestLottoNumber())
        }
    }
}
