package ru.itmo.mobile2k21.second.task

import ru.itmo.mobile2k21.second.counter.ICounterView

interface ITaskPresenter {
    fun addCounter(counter: ICounterView)
    fun start()
    fun stop()
    fun reset()
}