package ru.itmo.mobile2k21.second

import android.os.Handler
import android.os.Looper
import android.widget.TextView
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max

class CounterPresenter(
    private val counterConfig: CounterConfig
) {
    private val mainHandler: Handler = Handler(Looper.getMainLooper())

    private val counterModel: CounterModel = CounterModel(AtomicInteger(0))

    private val isRunning: AtomicBoolean = AtomicBoolean(false)

    private val counterView: CounterView = CounterView()

    private val counterThread: Runnable = object : Runnable {
        override fun run() {
            if (isRunning.get()) {
                counterModel.value.getAndIncrement()
                updateCounterLabel()
                mainHandler.postDelayed(this, counterConfig.currentUpdateIntervalMs)
            }
        }
    }

    fun start() {
        if (isRunning.get()) {
            return
        }
        isRunning.set(true)
        mainHandler.post(counterThread)
    }

    fun stop() {
        isRunning.set(false)
        mainHandler.removeCallbacks(counterThread)
    }

    fun reset() {
        stop()
        counterModel.value.set(0)
        updateCounterLabel()
    }

    fun slowDown() {
        counterConfig.currentUpdateIntervalMs += counterConfig.changeIntervalDeltaMs
    }

    fun speedUp() {
        counterConfig.currentUpdateIntervalMs = max(
            this.counterConfig.currentUpdateIntervalMs - counterConfig.changeIntervalDeltaMs,
            counterConfig.changeIntervalDeltaMs
        )
    }

    private fun updateCounterLabel() {
        counterView.setLabelValue(counterModel.value.get())
    }

}