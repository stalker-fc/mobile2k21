package ru.itmo.mobile2k21.second.presenter

interface ICounterPresenter {
    fun start()
    fun stop()
    fun reset()
    fun slowDown()
    fun speedUp()
}