package ru.itmo.mobile2k21.second.counter

import android.os.Handler
import android.os.Looper
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

    private val counterRunnable: Runnable = Runnable {
        while (isRunning.get()) {
            counterModel.value.getAndIncrement()
            mainHandler.post(counterLabelUpdater)
            Thread.sleep(currentUpdateIntervalMs)
        }
    }

    private val counterLabelUpdater: Runnable = Runnable {
        counterView.setLabelValue(counterModel.value.get())
    }


    override fun start() {
        if (isRunning.get()) {
            return
        }
        isRunning.set(true)
        Thread(counterRunnable).start()
    }

    override fun stop() {
        isRunning.set(false)
    }

    override fun reset() {
        stop()
        counterModel.value.set(0)
        mainHandler.post(counterLabelUpdater)
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
}