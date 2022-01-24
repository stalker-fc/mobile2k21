package ru.itmo.mobile2k21.second.task

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import ru.itmo.mobile2k21.R
import ru.itmo.mobile2k21.second.counter.CounterView
import ru.itmo.mobile2k21.second.counter.ICounterView


class TaskView : AppCompatActivity(), ITaskView {
    private lateinit var presenter: ITaskPresenter
    private lateinit var countersStart: Button
    private lateinit var countersStop: Button
    private lateinit var countersReset: Button
    private var counterViews: MutableList<ICounterView> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        presenter = TaskPresenter(this)

        initCounters()

        countersStart = findViewById(R.id.counters_start)
        countersStop = findViewById(R.id.counters_stop)
        countersReset = findViewById(R.id.counters_reset)

        enableStartButton()
        disableStopButton()
        disableResetButton()

        countersStart.setOnClickListener {
            presenter.onStartButtonPressed()
        }

        countersStop.setOnClickListener {
            presenter.onStopButtonPressed()
        }

        countersReset.setOnClickListener {
            presenter.onResetButtonPressed()
        }
    }

    private fun initCounters() {
        val changeIntervalDeltaMs: Long = 50

        val firstCounterDelayMs: Long = 600
        val firstCounterView: CounterView = CounterView.instance(
            firstCounterDelayMs,
            changeIntervalDeltaMs
        )
        counterViews.add(firstCounterView)

        val secondCounterDelayMs: Long = 400
        val secondCounterView: CounterView = CounterView.instance(
            secondCounterDelayMs,
            changeIntervalDeltaMs
        )
        counterViews.add(secondCounterView)

        val counters: LinearLayout = findViewById(R.id.counters)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(counters.id, firstCounterView)
        fragmentTransaction.add(counters.id, secondCounterView)
        fragmentTransaction.commit()
    }

    override fun onPause() {
        super.onPause()
        presenter.onResetButtonPressed()
    }

    private fun enableButton(button: Button) {
        button.isEnabled = true
        button.setTextAppearance(R.style.secondTaskButton)
    }

    private fun disableButton(button: Button) {
        button.isEnabled = false
        button.setTextAppearance(R.style.secondTaskButton_disabled)
    }

    override fun startCounters() {
        for (counter in counterViews) counter.start()
    }

    override fun stopCounters() {
        for (counter in counterViews) counter.stop()
    }

    override fun resetCounters() {
        for (counter in counterViews) counter.reset()
    }

    override fun enableStartButton() {
        enableButton(countersStart)
    }

    override fun disableStartButton() {
        disableButton(countersStart)
    }

    override fun enableStopButton() {
        enableButton(countersStop)
    }

    override fun disableStopButton() {
        disableButton(countersStop)
    }

    override fun enableResetButton() {
        enableButton(countersReset)
    }

    override fun disableResetButton() {
        disableButton(countersReset)
    }
}