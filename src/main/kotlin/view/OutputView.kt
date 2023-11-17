package view

import model.lotto.LottoGame
import model.lotto.LottoTickets

internal const val INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요."
internal const val INPUT_MANUAL_INPUT_MESSAGE = "수동으로 구매할 로또 게임 수를 입력해 주세요."
internal const val INPUT_LOTTO_NUMBER_MESSAGE = "로또 번호를 입력해 주세요. (공백으로 구분)"
internal const val INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요. (공백으로 구분)"
internal const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."

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

    fun printLottoTickets(lottoTickets: LottoTickets) {
        printLottoGames(lottoTickets.asLottoGames())
        println("총 ${lottoTickets.elements.size}장의 티켓을 구매했습니다.")
    }

    private fun printLottoGames(lottoGames: List<LottoGame>) {
        val manualGames = lottoGames.filterIsInstance<LottoGame.Manual>()
        val autoGames = lottoGames.filterIsInstance<LottoGame.Auto>()
        println("수동으로 ${manualGames.size}게임, 자동으로 ${autoGames.size}게임을 구매하셨습니다.")
        if (manualGames.isNotEmpty()) {
            println("수동으로 구매한 로또 번호")
            manualGames.forEach { println(it.numbers) }
        }
        if (autoGames.isNotEmpty()) {
            println("자동으로 구매한 로또 번호")
            autoGames.forEach { println(it.numbers) }
        }
    }

    fun requestWinningNumber() {
        println(INPUT_WINNING_NUMBER)
    }

    fun requestBonusNumber() {
        println(INPUT_BONUS_NUMBER)
    }
}
