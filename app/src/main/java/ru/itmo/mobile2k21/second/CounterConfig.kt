package ru.itmo.mobile2k21.second

data class CounterConfig(
    val counterId: Int,
    var currentUpdateIntervalMs: Long,
    val changeIntervalDeltaMs: Long,
)
