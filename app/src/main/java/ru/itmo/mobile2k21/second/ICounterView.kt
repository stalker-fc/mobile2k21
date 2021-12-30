package ru.itmo.mobile2k21.second

interface ICounterView {
    fun setLabelValue(value: Int)
    fun start()
    fun stop()
    fun reset()
}