package ru.itmo.mobile2k21.second

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.R


class SecondActivity : AppCompatActivity() {
    private lateinit var counters: List<Counter>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)

        val firstCounterLabel: TextView = findViewById(R.id.first_counter)
        val firstCounterDelayMs: Long = 600
        val firstCounter = Counter(
            firstCounterLabel,
            firstCounterDelayMs
        )

        val secondCounterLabel: TextView = findViewById(R.id.second_counter)
        val secondCounterDelayMs: Long = 400
        val secondCounter = Counter(
            secondCounterLabel,
            secondCounterDelayMs
        )

        counters = mutableListOf(firstCounter, secondCounter)


        val countersStart: Button = findViewById(R.id.counters_start)
        enableButton(countersStart)

        val countersStop: Button = findViewById(R.id.counters_stop)
        disableButton(countersStop)

        val countersReset: Button = findViewById(R.id.counters_reset)
        disableButton(countersReset)

        countersStart.setOnClickListener {
            for (counter in counters) counter.start()
            disableButton(countersStart)
            enableButton(countersStop)
            enableButton(countersReset)
        }

        countersStop.setOnClickListener {
            for (counter in counters) counter.stop()
            enableButton(countersStart)
            disableButton(countersStop)
            enableButton(countersReset)
        }

        countersReset.setOnClickListener {
            for (counter in counters) counter.reset()
        }
    }

    override fun onPause() {
        super.onPause()
        for (counter in counters) counter.reset()
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