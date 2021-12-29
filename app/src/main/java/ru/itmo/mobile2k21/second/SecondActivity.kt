package ru.itmo.mobile2k21.second

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import ru.itmo.mobile2k21.R
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import javax.xml.parsers.FactoryConfigurationError

class SecondActivity : AppCompatActivity() {
    private lateinit var firstCounter: Counter
    private lateinit var secondCounter: Counter
    private var firstCounterDelayMs: Long = 600
    private var secondCounterDelayMs: Long = 400


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)


        val firstCounterLabel: TextView = findViewById(R.id.first_counter)
        val secondCounterLabel: TextView = findViewById(R.id.second_counter)

        firstCounter = Counter(
            firstCounterLabel,
            firstCounterDelayMs
        )

        secondCounter = Counter(
            secondCounterLabel,
            secondCounterDelayMs
        )

        val countersStart: Button = findViewById(R.id.counters_start)
        countersStart.isEnabled = true;

        val countersStop: Button = findViewById(R.id.counters_stop)
        countersStop.isEnabled = false;

        val countersReset: Button = findViewById(R.id.counters_reset)
        countersReset.isEnabled = false;

        countersStart.setOnClickListener(View.OnClickListener { view ->
            firstCounter.start()
            secondCounter.start()
            countersStart.isEnabled = false;
            countersStop.isEnabled = true;
            countersReset.isEnabled = true;
            countersStart.setTextAppearance(R.style.secondTaskButton_disabled)
            countersStop.setTextAppearance(R.style.secondTaskButton)
            countersReset.setTextAppearance(R.style.secondTaskButton)
        })

        countersStop.setOnClickListener(View.OnClickListener { view ->
            firstCounter.stop()
            secondCounter.stop()
            countersStart.isEnabled = true;
            countersStop.isEnabled = false;
            countersReset.isEnabled = true;
            countersStart.setTextAppearance(R.style.secondTaskButton)
            countersStop.setTextAppearance(R.style.secondTaskButton_disabled)
            countersReset.setTextAppearance(R.style.secondTaskButton)
        })

        countersReset.setOnClickListener(View.OnClickListener { view ->
            firstCounter.reset()
            secondCounter.reset()
        })
    }

    override fun onPause() {
        super.onPause()
        firstCounter.stop()
        secondCounter.stop()
    }
}