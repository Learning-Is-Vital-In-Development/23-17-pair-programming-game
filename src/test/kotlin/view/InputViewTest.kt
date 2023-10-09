package view

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayInputStream
import java.math.BigDecimal

class InputViewTest : FunSpec({
    val inputView = InputView()
    beforeEach {
        println("Hello from $it")
    }

    listOf(
        "2400", "3000", "4000"
    ).forEach {
        test("입력받은 금액은 숫자다. 입력받은 금액 : $it") {
            val input = ByteArrayInputStream(it.toByteArray())
            System.setIn(input)
            inputView.requestAmount() shouldBe BigDecimal(it)
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
            val input = ByteArrayInputStream(it.toByteArray())
            System.setIn(input)

            shouldThrowExactly<IllegalArgumentException> {
                inputView.requestAmount()
            }
        }
    }
})


