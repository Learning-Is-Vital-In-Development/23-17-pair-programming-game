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
        val lottoTickets = validInputView({ generateLottoTickets(lottoCount) }) { outputView.printMessage(it) }
        outputView.printLottoTickets(lottoTickets)

        // 당첨 번호 입력
        val winningNumbers = validInputView({ inputWinningNumber() }) { outputView.printMessage(it) }
        // 보너스 볼 입력
        val bonusNumber = validInputView({ inputBonusNumber() }) { outputView.printMessage(it) }

        // 당첨 계산
        // GameResult()

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
