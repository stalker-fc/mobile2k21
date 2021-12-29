package ru.itmo.mobile2k21.second

import android.widget.TextView
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

class Counter(
    val mainExecutor: Executor,
    val counterLabel: TextView,
    counterDelayMs: Int
) {
    val isRunning: AtomicBoolean = AtomicBoolean(false)
    val value: AtomicInteger = AtomicInteger(0)
    val delayMs: AtomicInteger = AtomicInteger(counterDelayMs)


    fun start() {
        if (isRunning.get()) {
            return
        }

        isRunning.set(true)

        // Create an executor that executes tasks in a background thread.
        val backgroundExecutor = Executors.newSingleThreadScheduledExecutor()

        // Execute a task in the background thread.
        backgroundExecutor.execute {
            while (isRunning.get()) {
                value.getAndIncrement()
                Thread.sleep(delayMs.get().toLong())
                mainExecutor.execute {
                    counterLabel.text = value.get().toString()
                }
            }
        }
    }

    fun stop() {
        isRunning.set(false)
    }

    fun reset() {
        value.set(0)
        mainExecutor.execute {
            counterLabel.text = value.get().toString()
        }
    }

    fun updateDelay(counterDelayMs: Int) {
        delayMs.set(counterDelayMs)
    }
}