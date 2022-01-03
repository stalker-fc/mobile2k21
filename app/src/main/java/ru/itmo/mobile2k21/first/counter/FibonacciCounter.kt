package ru.itmo.mobile2k21.first.counter

class FibonacciCounter: ICounter {
    private var previousValue: Int = 0
    private var currentValue: Int = 1

    override fun getNextValue(): Int {
        val result = currentValue
        currentValue += previousValue
        previousValue = result
        return result
    }

}