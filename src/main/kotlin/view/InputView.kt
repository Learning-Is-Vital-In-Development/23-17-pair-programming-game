package view

import money.Money
import java.math.BigDecimal

fun <T> validInputView(
    supplier: () -> T,
    consumer: (String) -> Unit
): T {
    return try {
        supplier.invoke()
    } catch (e: IllegalArgumentException) {
        consumer.invoke(e.message!!)
        validInputView(supplier, consumer)
    }
}

class InputView {
    fun requestMoney(): Money {
        return Money(BigDecimal(readln().toInt()))
    }
}
