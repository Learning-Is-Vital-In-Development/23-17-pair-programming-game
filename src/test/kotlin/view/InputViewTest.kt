package view

import org.junit.jupiter.api.Test

class InputViewTest {

    @Test
    fun name() {
        val inputView = InputView()
        val ints = inputView.requestLottoNumber()
        println(ints)
    }
}
