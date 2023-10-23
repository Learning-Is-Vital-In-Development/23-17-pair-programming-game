package model.lotto

enum class TicketType {
    Manual,
    Auto,
}

data class LottoTicket(
    val numbers: LottoNumbers,
    val type: TicketType,
) {
    companion object {
        fun of(
            numbers: LottoNumbers,
            type: TicketType,
        ): LottoTicket {
            return LottoTicket(numbers, type)
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }
}

