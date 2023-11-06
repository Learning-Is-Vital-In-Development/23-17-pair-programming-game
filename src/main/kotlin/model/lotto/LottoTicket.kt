package model.lotto

class LottoTicket(val games: List<LottoGame>) {
    companion object {
        fun of(lottoNumbers: List<LottoNumbers>): LottoTicket {
            return LottoTicket(lottoNumbers.map { LottoGame.of(it, TicketType.Manual) }.toList())
        }
    }

    override fun toString(): String {
        return games.joinToString("\n")
    }
}
