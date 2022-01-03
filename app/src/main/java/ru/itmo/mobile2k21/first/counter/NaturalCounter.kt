package ru.itmo.mobile2k21.first.counter

class NaturalCounter : ICounter {
    private var currentValue: Int = 0

    override fun getNextValue(): Int {
        currentValue += 1
        return currentValue
    }
}