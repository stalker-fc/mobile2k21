package ru.itmo.mobile2k21.second

import android.os.Handler
import android.os.Looper
import android.widget.TextView
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger


class Counter(
    val counterLabel: TextView,
    val updateIntervalMs: Long
) {
    val mainHandler: Handler = Handler(Looper.getMainLooper())
    val value: AtomicInteger = AtomicInteger(0)
    val isRunning: AtomicBoolean = AtomicBoolean(false)

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

    fun updateCounterLabel() {
        counterLabel.text = value.get().toString()
    }
}