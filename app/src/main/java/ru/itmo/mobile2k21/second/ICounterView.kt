package ru.itmo.mobile2k21.second

interface ICounterView {
    var presenter: ICounterPresenter

    fun setLabelValue(value: Int)
}