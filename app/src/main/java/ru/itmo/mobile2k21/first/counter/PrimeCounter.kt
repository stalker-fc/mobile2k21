package ru.itmo.mobile2k21.first.counter

class PrimeCounter: ICounter {
    private var value: Int = 0
    override fun getNextValue(): Int {
        if (value < 3) {
            value = 2
            return value
        }

        var number: Int = value
        var isPrimeFound = false
        while (!isPrimeFound) {
            number += 1
            if (isPrime(number)) {
                isPrimeFound = true
                value = number
            }
        }

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