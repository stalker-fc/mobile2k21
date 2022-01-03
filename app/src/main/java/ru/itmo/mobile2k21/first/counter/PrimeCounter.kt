package ru.itmo.mobile2k21.first.counter

class PrimeCounter: ICounter {
    private var value: Int = 0
    override fun getNextValue(): Int {
        if (value < 2) {
            value = 2
            return value
        }

        var number: Int = value
        while (true) {
            number += 1
            if (isPrime(number)) {
                value = number
                return value
            }
        }
    }

    override fun setValue(value: Int) {
        this.value = value
    }

    override fun getValue(): Int {
        return value
    }

    private fun isPrime(number: Int): Boolean {
        for (i in 2..number / 2) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

}