package money

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class AmountTest : FunSpec({
    listOf(
        "2400",
        "3000",
        "4000"
    ).forEach {
        test("금액은 입력받으면 BigDecimal 자료형을 반환한다. 입력받은 금액 : $it") {
            Amount(it).stringAmount.toBigDecimal() shouldBe BigDecimal(it)
        }
    }

    listOf(
        "invalid amount",
        "유효하지 않은 숫자",
        "3k34j4",
        "k3333",
        "3333k"
    ).forEach {
        test("잘못된 문자열을 입력받으면 예외가 발생한다. 입력받은 문자 : $it") {
            shouldThrowExactly<IllegalArgumentException> {
                Amount(it)
            }
        }
    }
})
