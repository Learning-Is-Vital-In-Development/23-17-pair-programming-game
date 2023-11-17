package model.lotto

internal const val REQUIRED_LEAST_ONE_GAME = "최소 한 게임 이상 포함되어야 합니다."
internal const val REQUIRED_MAXIMUM_FIVE_GAME = "최대 다섯 게임만 포함될 수 있습니다."

class LottoTicket(val games: List<LottoGame>) {
    init {
        require(games.isNotEmpty()) { REQUIRED_LEAST_ONE_GAME }
        require(games.size < 6) { REQUIRED_MAXIMUM_FIVE_GAME }
    }

    override fun toString(): String {
        return games.joinToString("\n")
    }
}
