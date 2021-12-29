package ru.itmo.mobile2k21.second

import android.os.Handler
import android.os.Looper
import android.widget.TextView
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max


class Counter(
    val counterLabel: TextView,
    var updateIntervalMs: Long
) {
    private val deltaMs: Long = 50
    private val mainHandler: Handler = Handler(Looper.getMainLooper())
    private val value: AtomicInteger = AtomicInteger(0)
    private val isRunning: AtomicBoolean = AtomicBoolean(false)

    private val counter: Runnable = object : Runnable {
        override fun run() {
            if (isRunning.get()) {
                value.getAndIncrement()
                updateCounterLabel()
                mainHandler.postDelayed(this, updateIntervalMs)
            }
        }
    }

    fun start() {
        if (isRunning.get()) {
            return
        }
        isRunning.set(true)
        mainHandler.post(counter)
    }

    fun stop() {
        isRunning.set(false)
        mainHandler.removeCallbacks(counter)
    }

    fun reset() {
        value.set(0)
        updateCounterLabel()
    }

    fun slowDown() {
        updateIntervalMs += deltaMs
    }

    fun speedUp() {
        updateIntervalMs = max(updateIntervalMs - deltaMs, deltaMs)
    }


    private fun updateCounterLabel() {
        counterLabel.text = value.get().toString()
    }
}