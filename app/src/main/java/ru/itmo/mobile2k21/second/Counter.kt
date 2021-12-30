package ru.itmo.mobile2k21.second

import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max
import ru.itmo.mobile2k21.R


class Counter(
    private val counterLabel: TextView,
    private var updateIntervalMs: Long,
) {
    private val mainHandler: Handler = Handler(Looper.getMainLooper())

    private val deltaMs: Long = 50
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
        stop()
        value.set(0)
        updateCounterLabel()
    }

    fun slowDown() {
        updateIntervalMs += deltaMs
    }

    fun speedUp() {
        updateIntervalMs = max(this.updateIntervalMs - deltaMs, deltaMs)
    }


    private fun updateCounterLabel() {
        counterLabel.text = value.get().toString()
    }
}