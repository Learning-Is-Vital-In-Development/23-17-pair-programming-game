package controller

import model.lotto.LottoCount
import model.lotto.LottoNumber
import model.lotto.LottoNumbers
import model.lotto.LottoTickets
import model.lotto.WinningNumbers
import model.money.Money
import view.InputView
import view.OutputView
import view.validInputView

class LottoApp(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val money = validInputView({ inputCapital() }) { outputView.printMessage(it) }
        val lottoCount: LottoCount = validInputView({ requestManualCount(money) }) { outputView.printMessage(it) }
        val lottoTickets = validInputView({ generateLottoTicket(lottoCount) }) { outputView.printMessage(it) }
        outputView.printLottoTickets(lottoTickets)

        val winningLottoNumbers = validInputView({ inputWinningNumber() }) { outputView.printMessage(it) }
        val bonusNumber = validInputView({ inputBonusNumber() }) { outputView.printMessage(it) }
        val winningNumbers = WinningNumbers(winningLottoNumbers, bonusNumber)

        // 당첨 계산
//        GameResult(LottoTicket(lottoTickets), winningNumbers)

        // 결과 출력
        // print(gameResult)
    }

    private fun inputBonusNumber(): LottoNumber {
        outputView.requestBonusNumber()
        return LottoNumber(inputView.requestBonusNumber())
    }

    private fun inputWinningNumber(): LottoNumbers {
        outputView.requestWinningNumber()
        return LottoNumbers.from(inputView.requestLottoNumber())
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

    private fun generateLottoTicket(lottoCount: LottoCount): LottoTickets {
        val manualNumbers = requestManualLottoNumbers(lottoCount.manualCount)
        val autoNumbers = requestAutoLottoNumbers(lottoCount.autoCount)
        return LottoTickets.of(manualNumbers, autoNumbers)
    }

    private fun requestManualLottoNumbers(manualCount: Int): List<LottoNumbers> {
        return (1..manualCount).map {
            outputView.requestManualLottoNumber()
            LottoNumbers.from(inputView.requestLottoNumber())
        }
    }

    private fun requestAutoLottoNumbers(autoCount: Int): List<LottoNumbers> {
        val allPossibleNumbers = (1..45).toList()
        return List(autoCount) {
            val selectedNumbers = allPossibleNumbers
                .shuffled()
                .take(6)
                .sorted()
            LottoNumbers.from(selectedNumbers)
        }
    }
}
