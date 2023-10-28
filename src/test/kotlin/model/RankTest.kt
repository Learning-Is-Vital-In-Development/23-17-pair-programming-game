package model

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class RankTest : FreeSpec(
    {
        "1등" - {
            "6개 숫자 일치" {
                Rank.of(6, false) shouldBe Rank.FIRST
            }
        }

    },
)
