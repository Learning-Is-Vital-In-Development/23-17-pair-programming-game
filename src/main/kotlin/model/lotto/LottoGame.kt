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

object LottoTicketGenerator {
    fun generate(count: Int): List<LottoGame> {
        val allPossibleNumbers = (1..45).toList()
        return List(count) {
            val selectedNumbers = allPossibleNumbers.shuffled().take(6).sorted()
            val lottoNumbers = LottoNumbers.from(selectedNumbers)
            LottoGame.of(lottoNumbers, TicketType.Auto)
        }
    }

    fun generate(manualNumbers: List<LottoNumbers>): List<LottoGame> {
        return manualNumbers.map { lottoNumbers ->
            LottoGame.of(lottoNumbers, TicketType.Manual)
        }
    }
}
