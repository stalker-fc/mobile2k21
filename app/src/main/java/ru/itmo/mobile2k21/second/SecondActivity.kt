package ru.itmo.mobile2k21.second

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import ru.itmo.mobile2k21.R


class SecondActivity : AppCompatActivity() {
    private lateinit var counterViews: List<ICounterView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        initCounters()

        val countersStart: Button = findViewById(R.id.counters_start)
        enableButton(countersStart)

        val countersStop: Button = findViewById(R.id.counters_stop)
        disableButton(countersStop)

        val countersReset: Button = findViewById(R.id.counters_reset)
        disableButton(countersReset)

        countersStart.setOnClickListener {
            for (counter in counterViews) counter.start()
            disableButton(countersStart)
            enableButton(countersStop)
            enableButton(countersReset)
        }

        countersStop.setOnClickListener {
            for (counter in counterViews) counter.stop()
            enableButton(countersStart)
            disableButton(countersStop)
            enableButton(countersReset)
        }

        countersReset.setOnClickListener {
            for (counter in counterViews) counter.reset()
            enableButton(countersStart)
            disableButton(countersStop)
            disableButton(countersReset)
        }
    }

    private fun initCounters() {
        val changeIntervalDeltaMs: Long = 50

        val firstCounterDelayMs: Long = 600
        val firstCounterView: CounterView = CounterView.instance(
            firstCounterDelayMs,
            changeIntervalDeltaMs
        )

        val secondCounterDelayMs: Long = 400
        val secondCounterView: CounterView = CounterView.instance(
            secondCounterDelayMs,
            changeIntervalDeltaMs
        )
        counterViews = listOf(firstCounterView, secondCounterView)

        val counters: LinearLayout = findViewById(R.id.counters)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(counters.id, firstCounterView)
        fragmentTransaction.add(counters.id, secondCounterView)
        fragmentTransaction.commit()
    }


    override fun onPause() {
        super.onPause()
        for (counter in counterViews) counter.reset()
    }

    private fun enableButton(button: Button) {
        button.isEnabled = true;
        button.setTextAppearance(R.style.secondTaskButton)
    }

    private fun disableButton(button: Button) {
        button.isEnabled = false;
        button.setTextAppearance(R.style.secondTaskButton_disabled)
    }
}