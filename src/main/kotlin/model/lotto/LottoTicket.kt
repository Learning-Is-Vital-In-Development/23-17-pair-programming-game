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

object LottoTicketGenerator {
    fun generate(count: Int): List<LottoTicket> {
        val allPossibleNumbers = (1..45).toList()
        return List(count) {
            val selectedNumbers = allPossibleNumbers.shuffled().take(6).sorted()
            val lottoNumbers = LottoNumbers.from(selectedNumbers)
            LottoTicket.of(lottoNumbers, TicketType.Auto)
        }
    }
}
