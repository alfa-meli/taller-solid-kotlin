package exercise3

interface Payment {
    fun pay()
}

class CashPayment : Payment {
    override fun pay() {
        println("Payment using cash")
    }
}

class BankPayment  {
     fun pay(account: Int) {
        println("Payment using bank account $account")
    }
}

fun processPayment(payment: Payment) {
    payment.pay()
}

fun main() {
    val cashPayment = CashPayment()
    processPayment(cashPayment)

    val bankPayment = BankPayment()
    //processPayment(bankPayment) // Does not compile
}
