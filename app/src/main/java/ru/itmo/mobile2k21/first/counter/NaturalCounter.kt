package ru.itmo.mobile2k21.first.counter

class NaturalCounter : ICounter {
    private var value: Int = 0

    override fun getNextValue(): Int {
        value += 1
        return value
    }

    override fun setValue(value: Int) {
        this.value = value
    }

    override fun getValue(): Int {
        return value
    }
}