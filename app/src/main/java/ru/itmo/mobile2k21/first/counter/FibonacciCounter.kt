package ru.itmo.mobile2k21.first.counter

import kotlin.math.round
import kotlin.math.sqrt

class FibonacciCounter: ICounter {
    private var previousValue: Int = 0
    private var currentValue: Int = 0

    override fun getNextValue(): Int {
        if (currentValue == 0)
            currentValue = 1

        val result = currentValue
        currentValue += previousValue
        previousValue = result
        return result
    }

    override fun setValue(value: Int) {
        currentValue = value
        previousValue = round(value / ((1 + sqrt(5.0)) / 2.0)).toInt();
    }

    override fun getValue(): Int {
        return currentValue
    }

}