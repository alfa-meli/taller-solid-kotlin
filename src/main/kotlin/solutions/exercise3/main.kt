package solutions.exercise3

interface Payment {
    fun pay()
}

class CashPayment : Payment {
    override fun pay() {
        println("Payment using cash")
    }
}

class BankPayment {
    fun pay(account: Int) {
        println("Payment using bank account $account")
    }
}

fun processPayment(payment: Payment) {
    payment.pay()
}

class BankPaymentAdapter(private val bankPayment: BankPayment, private val bankAccount: Int) : Payment {
    override fun pay() {
        bankPayment.pay(bankAccount)
    }
}

fun main() {
    val cash = CashPayment()
    processPayment(cash)

    val bank = BankPaymentAdapter(BankPayment(), 12345)
    processPayment(bank)
}
