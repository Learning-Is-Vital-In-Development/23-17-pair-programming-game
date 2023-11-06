package model.lotto

class LottoTicket(val games: List<LottoGame>) {
    companion object {
        fun of(lottoNumbers: List<LottoGame>): LottoTicket {
            return LottoTicket(lottoNumbers.map { it }.toList())
        }
    }

    override fun toString(): String {
        return games.joinToString("\n")
    }
}
