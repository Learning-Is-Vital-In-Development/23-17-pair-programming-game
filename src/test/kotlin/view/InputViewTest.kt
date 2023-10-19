package view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainAll
import java.io.ByteArrayInputStream

private const val WHITE_SPACE = " "

class InputViewTest : BehaviorSpec(
    {
        given("사용자의 입력을 받을 때") {
            val inputView = InputView()
            val strings = "12 32 2 1 4 5"
            val expected = strings.split(WHITE_SPACE).map { it.toInt() }
            `when`("$strings 번호를 입력하면") {
                System.setIn(ByteArrayInputStream(strings.toByteArray()))
                val actual = inputView.requestLottoNumber()
                then("$expected 리스트가 반환된다.") {
                    actual shouldContainAll expected
                }
            }
        }
    },
)
