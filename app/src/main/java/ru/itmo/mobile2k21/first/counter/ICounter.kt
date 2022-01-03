package ru.itmo.mobile2k21.first.counter

interface ICounter {
    fun getNextValue() : Int
    fun setValue(value: Int)
    fun getValue() : Int
}