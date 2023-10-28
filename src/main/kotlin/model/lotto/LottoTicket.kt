package model.lotto

// Lotto Game 을 감싸는 일급 컬렉션
class LottoTicket(private val games: List<LottoGame>) {
    companion object {
        fun of(games: List<LottoGame>): LottoTicket {
            return LottoTicket(games)
        }
    }

    override fun toString(): String {
        return games.joinToString("\n")
    }
}
