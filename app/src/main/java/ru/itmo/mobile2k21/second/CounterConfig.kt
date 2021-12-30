package ru.itmo.mobile2k21.second

data class CounterConfig(
    var currentUpdateIntervalMs: Long,
    val changeIntervalDeltaMs: Long,
)
