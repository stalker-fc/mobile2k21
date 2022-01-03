package ru.itmo.mobile2k21.second.counter

interface ICounterPresenter {
    fun start()
    fun stop()
    fun reset()
    fun slowDown()
    fun speedUp()
}