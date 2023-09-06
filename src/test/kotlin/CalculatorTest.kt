import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FreeSpec({

    val calculator = Calculator()

    "addition" - {
        "should add two numbers" {
            calculator.sum(2, 4) shouldBe 6
        }
    }

})
