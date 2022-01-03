package ru.itmo.mobile2k21.second.counter

import java.util.concurrent.atomic.AtomicInteger

data class CounterModel(
    var value: AtomicInteger
)
