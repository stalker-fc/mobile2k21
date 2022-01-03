package ru.itmo.mobile2k21.second.counter

import android.os.Handler
import android.os.Looper
import ru.itmo.mobile2k21.second.counter.CounterModel
import ru.itmo.mobile2k21.second.counter.ICounterPresenter
import ru.itmo.mobile2k21.second.counter.ICounterView
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max

class CounterPresenter(
    private val counterView: ICounterView,
    private var currentUpdateIntervalMs: Long,
    private val changeIntervalDeltaMs: Long,
) : ICounterPresenter {
    private val mainHandler: Handler = Handler(Looper.getMainLooper())

    private val counterModel: CounterModel = CounterModel(AtomicInteger(0))

    private val isRunning: AtomicBoolean = AtomicBoolean(false)

    private val counterThread: Runnable = object : Runnable {
        override fun run() {
            if (isRunning.get()) {
                counterModel.value.getAndIncrement()
                updateCounterLabel()
                mainHandler.postDelayed(this, currentUpdateIntervalMs)
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
        currentUpdateIntervalMs += changeIntervalDeltaMs
    }

    override fun speedUp() {
        this.currentUpdateIntervalMs = max(
            this.currentUpdateIntervalMs - this.changeIntervalDeltaMs,
            this.changeIntervalDeltaMs
        )
    }

    private fun updateCounterLabel() {
        counterView.setLabelValue(counterModel.value.get())
    }

}