package controller

import model.lotto.LottoCount
import model.lotto.LottoNumbers
import model.lotto.LottoTicket
import model.lotto.TicketType
import model.money.Money
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val money = validInputView({ inputCapital() }) { outputView.printMessage(it) }
        val lottoCount: LottoCount = validInputView({ inputManualCount(money) }) { outputView.printMessage(it) }
        validInputView(
            {
                val lottoTickets = inputManualLottoTickets(lottoCount)
                val autoTickets = generateAutoLottoTickets(lottoCount.autoCount)
                outputView.printLottoTickets(lottoTickets + autoTickets)
            },
        ) { outputView.printMessage(it) }
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

    private fun inputManualLottoTickets(lottoCount: LottoCount): List<LottoTicket> {
        return (1..lottoCount.manualCount)
            .map {
                outputView.requestManualLottoNumber()
                val lottoNumbers = LottoNumbers.from(inputView.requestLottoNumber())
                LottoTicket.of(lottoNumbers, TicketType.Manual)
            }
    }

    private fun generateAutoLottoTickets(autoCount: Int): List<LottoTicket> {
        val allPossibleNumbers = (1..45).toList()
        return List(autoCount) {
            val selectedNumbers = allPossibleNumbers.shuffled().take(6)
            val lottoNumbers = LottoNumbers.from(selectedNumbers)
            LottoTicket(lottoNumbers, TicketType.Auto)
        }
    }
}
