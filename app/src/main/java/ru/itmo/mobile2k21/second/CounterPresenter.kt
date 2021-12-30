package ru.itmo.mobile2k21.second

import android.os.Handler
import android.os.Looper
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max

class CounterPresenter(
    private val counterView: ICounterView,
    private val counterConfig: CounterConfig
) : ICounterPresenter {
    private val mainHandler: Handler = Handler(Looper.getMainLooper())

    private val counterModel: CounterModel = CounterModel(AtomicInteger(0))

    private val isRunning: AtomicBoolean = AtomicBoolean(false)

    private val counterThread: Runnable = object : Runnable {
        override fun run() {
            if (isRunning.get()) {
                counterModel.value.getAndIncrement()
                updateCounterLabel()
                mainHandler.postDelayed(this, counterConfig.currentUpdateIntervalMs)
            }
        }
    }

    override fun start() {
        if (isRunning.get()) {
            return
        }
        isRunning.set(true)
        mainHandler.post(counterThread)
    }

    override fun stop() {
        isRunning.set(false)
        mainHandler.removeCallbacks(counterThread)
    }

    override fun reset() {
        stop()
        counterModel.value.set(0)
        updateCounterLabel()
    }

    override fun slowDown() {
        counterConfig.currentUpdateIntervalMs += counterConfig.changeIntervalDeltaMs
    }

    override fun speedUp() {
        counterConfig.currentUpdateIntervalMs = max(
            this.counterConfig.currentUpdateIntervalMs - counterConfig.changeIntervalDeltaMs,
            counterConfig.changeIntervalDeltaMs
        )
    }

    private fun updateCounterLabel() {
        counterView.setLabelValue(counterModel.value.get())
    }

}