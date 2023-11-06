package model.lotto

// LottoTicket 의 일급 컬렉션
class LottoTickets(
    val elements: List<LottoTicket>,
) {
    companion object {
        fun of(manualNumbers: List<LottoNumbers>, autoNumbers: List<LottoNumbers>): LottoTickets {
            val manualGames = manualNumbers.map { LottoGame.Manual(it) }.toList()
            val autoGames = autoNumbers.map { LottoGame.Auto(it) }.toList()
            val tickets = (manualGames + autoGames).chunked(5).map { LottoTicket.of(it) }
            return LottoTickets(tickets)
        }
    }

    // FIXME: temporary implementation
    fun asLottoGames(): List<LottoGame> {
        return elements.flatMap { it.games }
    }
}
