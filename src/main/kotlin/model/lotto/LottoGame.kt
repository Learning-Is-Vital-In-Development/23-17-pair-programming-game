package model.lotto

enum class TicketType {
    Manual,
    Auto,
}

data class LottoGame(
    val numbers: LottoNumbers,
    val type: TicketType,
) {
    companion object {
        fun of(
            numbers: LottoNumbers,
            type: TicketType,
        ): LottoGame {
            return LottoGame(numbers, type)
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
