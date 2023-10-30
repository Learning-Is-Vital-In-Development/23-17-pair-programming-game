package view

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

private const val WHITE_SPACE = " "

class InputView {
    fun requestAmount(): BigDecimal {
        val amount = Amount(readln())
        return amount.getBigDecimal()
    }

    fun requestLottoNumber(): List<Int> {
        return readln()
            .split(WHITE_SPACE)
            .map { Number(it) }
            .map { it.getInt() }
    }

    fun requestBonusNumber(): Int {
        return Number(readln()).getInt()
    }
}
