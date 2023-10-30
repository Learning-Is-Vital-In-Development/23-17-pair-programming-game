package controller

import model.lotto.LottoCount
import model.lotto.LottoGameGenerator
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

    // FIXME: 테스트 용이성이나 객체지향 관점에서 Ticket 은 LottoTicket 이 직접 생성해줘야하지 않을까요?
    private fun generateLottoTicket(lottoCount: LottoCount): LottoTickets {
        val manualNumbers = requestManualLottoNumbers(lottoCount.manualCount)
        val manualGames = LottoGameGenerator.generate(manualNumbers)
        val autoGames = LottoGameGenerator.generate(lottoCount.autoCount)
        return LottoTickets.createWithGames(manualGames + autoGames)
    }

    private fun requestManualLottoNumbers(manualCount: Int): List<LottoNumbers> {
        return (1..manualCount).map {
            outputView.requestManualLottoNumber()
            LottoNumbers.from(inputView.requestLottoNumber())
        }
    }
}
