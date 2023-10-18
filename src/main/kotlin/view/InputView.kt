package view

import model.money.Amount
import java.math.BigDecimal

fun <T> validInputView(
    supplier: () -> T,
    consumer: (String) -> Unit,
): T {
    return try {
        supplier.invoke()
    } catch (e: Exception) {
        consumer.invoke(e.message!!)
        validInputView(supplier, consumer)
    }
}

private const val EMPTY = " "

class InputView {
    fun requestAmount(): BigDecimal {
        val amount = Amount(readln())
        return amount.getBigDecimal()
    }

    fun requestLottoNumber(): List<Int> {
        return readln().split(EMPTY).map { it.toInt() }
    }
}
