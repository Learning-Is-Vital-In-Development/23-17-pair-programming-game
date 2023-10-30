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

        "2등" - {
            "5개 숫자 일치, 보너스 숫자 일치" {
                Rank.of(5, true) shouldBe Rank.SECOND
            }
        }

        "3등" - {
            "5개 숫자 일치" {
                Rank.of(5, false) shouldBe Rank.THIRD
            }
        }

        "4등" - {
            "4개 숫자 일치" {
                Rank.of(4, false) shouldBe Rank.FOURTH
            }
        }

        "5등" - {
            "3개 숫자 일치" {
                Rank.of(3, false) shouldBe Rank.FIFTH
            }
        }

        (0..2).forEach {
            "$it 개일 경우는 MISS" - {
                Rank.of(it, false) shouldBe Rank.MISS
            }
        }
    },
)
