package view

import model.lotto.LottoTicket
import model.lotto.TicketType

internal const val INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요."
internal const val INPUT_MANUAL_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
internal const val INPUT_LOTTO_NUMBER_MESSAGE = "로또 번호를 입력해 주세요. (공백으로 구분)"
internal const val INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요. (공백으로 구분)"

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

    fun printLottoTickets(lottoTickets: List<LottoTicket>) {
        val manualTickets = lottoTickets.filter { it.type == TicketType.Manual }
        val autoTickets = lottoTickets.filter { it.type == TicketType.Auto }
        println("수동으로 ${manualTickets.size}장, 자동으로 ${autoTickets.size}장을 구매하셨습니다.")
        if (manualTickets.isNotEmpty()) {
            println("수동으로 구매한 로또 번호")
            manualTickets.forEach { println(it.numbers) }
        }
        if (autoTickets.isNotEmpty()) {
            println("자동으로 구매한 로또 번호")
            autoTickets.forEach { println(it.numbers) }
        }
    }

    fun requestWinningNumber() {
        println(INPUT_WINNING_NUMBER)
    }
}
