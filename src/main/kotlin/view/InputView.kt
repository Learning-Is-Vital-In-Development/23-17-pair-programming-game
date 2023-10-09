package view

import java.math.BigDecimal

fun <T> validInputView(
    supplier: () -> T,
    consumer: (String) -> Unit,
): T {
    return try {
        supplier.invoke()
    } catch (e: IllegalArgumentException) {
        consumer.invoke(e.message!!)
        validInputView(supplier, consumer)
    }
}

class InputView {
    private val integers = '0'..'9'
    fun requestAmount(): BigDecimal {
        val amount = readln();
        if (!isInteger(amount)) {
            throw java.lang.IllegalArgumentException("입력한 $amount 값은 숫자여야 합니다.")
        }
        return amount.toBigDecimal()
    }
    private fun isInteger(input: String) = input.all { it in integers }
}
