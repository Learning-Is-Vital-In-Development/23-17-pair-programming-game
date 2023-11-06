package model.lotto

// LottoTicket 의 일급 컬렉션
class LottoTickets(
    val elements: List<LottoTicket>,
) {
    companion object {
        fun of(manualNumbers: List<LottoNumbers>, autoNumbers: List<LottoNumbers>): LottoTickets {
            val lottoNumbers = manualNumbers + autoNumbers
            val tickets = lottoNumbers.chunked(5).map { LottoTicket.of(it) }
            return LottoTickets(tickets)
        }
    }

    // FIXME: temporary implementation
    fun asLottoGames(): List<LottoGame> {
        return elements.flatMap { it.games }
    }
}
