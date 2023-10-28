package model.lotto

// LottoTicket 의 일급 컬렉션
class LottoTickets(
    val elements: List<LottoTicket>,
) {
    companion object {
        fun of(elements: List<LottoTicket>): LottoTickets {
            return LottoTickets(elements)
        }

        fun createWithGames(elements: List<LottoGame>): LottoTickets {
            val tickets = elements.chunked(5).map { LottoTicket.of(it) }
            return LottoTickets(tickets)
        }
    }

    // FIXME: temporary implementation
    fun asLottoGames(): List<LottoGame> {
        return elements.flatMap { it.games }
    }
}
