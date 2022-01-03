package ru.itmo.mobile2k21.second.presenter

import ru.itmo.mobile2k21.second.view.ICounterView

interface ITaskPresenter {
    fun addCounter(counter: ICounterView)
    fun start()
    fun stop()
    fun reset()
}