package model

import model.lotto.LottoGame
import model.lotto.LottoNumbers

fun generateFixtureLottoGames(count: Int): List<LottoGame> {
    if (count == 0) {
        return emptyList()
    }

    return List(count) {
        val selectedNumbers = (1..45).toList()
            .shuffled()
            .take(6)
            .sorted()
        LottoGame.Auto(LottoNumbers.from(selectedNumbers))
    }
}
