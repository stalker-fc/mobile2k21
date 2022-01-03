package ru.itmo.mobile2k21.second.task

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import ru.itmo.mobile2k21.R
import ru.itmo.mobile2k21.second.counter.CounterView


class TaskView : AppCompatActivity(), ITaskView {
    private lateinit var presenter: ITaskPresenter
    private lateinit var countersStart: Button
    private lateinit var countersStop: Button
    private lateinit var countersReset: Button

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
            presenter.start()
        }

        countersStop.setOnClickListener {
            presenter.stop()
        }

        countersReset.setOnClickListener {
            presenter.reset()
        }
    }

    private fun initCounters() {
        val changeIntervalDeltaMs: Long = 50

        val firstCounterDelayMs: Long = 600
        val firstCounterView: CounterView = CounterView.instance(
            firstCounterDelayMs,
            changeIntervalDeltaMs
        )
        presenter.addCounter(firstCounterView)

        val secondCounterDelayMs: Long = 400
        val secondCounterView: CounterView = CounterView.instance(
            secondCounterDelayMs,
            changeIntervalDeltaMs
        )
        presenter.addCounter(secondCounterView)

        val counters: LinearLayout = findViewById(R.id.counters)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(counters.id, firstCounterView)
        fragmentTransaction.add(counters.id, secondCounterView)
        fragmentTransaction.commit()
    }

    override fun onPause() {
        super.onPause()
        presenter.reset()
    }

    private fun enableButton(button: Button) {
        button.isEnabled = true;
        button.setTextAppearance(R.style.secondTaskButton)
    }

    private fun disableButton(button: Button) {
        button.isEnabled = false;
        button.setTextAppearance(R.style.secondTaskButton_disabled)
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