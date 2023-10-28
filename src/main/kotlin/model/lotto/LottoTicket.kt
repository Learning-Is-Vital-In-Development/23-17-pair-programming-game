package model.lotto

class LottoTicket(val games: List<LottoGame>) {
    companion object {
        fun of(games: List<LottoGame>): LottoTicket {
            return LottoTicket(games)
        }
    }

    override fun toString(): String {
        return games.joinToString("\n")
    }
}
