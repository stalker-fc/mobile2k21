package ru.itmo.mobile2k21.second

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.R


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        val firstCounterId = 1
        val firstCounterDelayMs: Long = 600
        val firstCounterConfig = CounterConfig(
            firstCounterId,
            firstCounterDelayMs
        )

        val secondCounterId = 2
        val secondCounterDelayMs: Long = 400
        val secondCounterConfig = CounterConfig(
            secondCounterId,
            secondCounterDelayMs
        )

        val counterConfigs = mutableListOf(firstCounterConfig, secondCounterConfig)

        val adapter = CounterAdapter(this, counterConfigs)

        val countersListView: ListView = findViewById(R.id.counters_listview)
        countersListView.adapter = adapter

        val countersStart: Button = findViewById(R.id.counters_start)
        enableButton(countersStart)

        val countersStop: Button = findViewById(R.id.counters_stop)
        disableButton(countersStop)

        val countersReset: Button = findViewById(R.id.counters_reset)
        disableButton(countersReset)

        countersStart.setOnClickListener {
            for (counter in counterAdapter.counters) counter.start()
            disableButton(countersStart)
            enableButton(countersStop)
            enableButton(countersReset)
        }

        countersStop.setOnClickListener {
            for (counter in counterAdapter.counters) counter.stop()
            enableButton(countersStart)
            disableButton(countersStop)
            enableButton(countersReset)
        }

        countersReset.setOnClickListener {
            for (counter in counterAdapter.counters) counter.reset()
            enableButton(countersStart)
            disableButton(countersStop)
            disableButton(countersReset)
        }
    }

    override fun onPause() {
        super.onPause()
        for (counter in counterAdapter.counters) counter.reset()
    }

    private fun enableButton(button: Button) {
        button.isEnabled = true;
        button.setTextAppearance(R.style.secondTaskButton)
    }

    private fun disableButton(button: Button) {
        button.isEnabled = false;
        button.setTextAppearance(R.style.secondTaskButton_disabled)
    }

    private fun speedUp() {

    }

    private fun slowDown() {

    }


}