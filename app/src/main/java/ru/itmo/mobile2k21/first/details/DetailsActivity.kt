package ru.itmo.mobile2k21.first.details

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.R
import ru.itmo.mobile2k21.first.FieldNames
import ru.itmo.mobile2k21.first.counter.FibonacciCounter
import ru.itmo.mobile2k21.first.counter.NaturalCounter
import ru.itmo.mobile2k21.first.counter.PrimeCounter

class DetailsActivity : AppCompatActivity() {
    private lateinit var info: DetailsInfo

    private val naturalCounter: NaturalCounter = NaturalCounter()
    private val fibonacciCounter: FibonacciCounter = FibonacciCounter()
    private val primeCounter: PrimeCounter = PrimeCounter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        info = intent.extras?.get(FieldNames.detailScreenInfo) as DetailsInfo

        val title: TextView = findViewById(R.id.detail_screen_title)
        title.text = info.title

        val description: TextView = findViewById(R.id.detail_screen_description)
        description.text = info.description

        val icon: ImageView = findViewById(R.id.detail_screen_icon)
        icon.setImageResource(getIconResource(info.icon))

        val naturalCounterButton: Button = findViewById(R.id.natural_counter_button)
        val naturalCounterLabel: TextView = findViewById(R.id.natural_counter_label)
        naturalCounterButton.setOnClickListener {
            val value = naturalCounter.getNextValue()
            naturalCounterLabel.text = value.toString()
        }

        val fibonacciCounterButton: Button = findViewById(R.id.fibonacci_counter_button)
        val fibonacciCounterLabel: TextView = findViewById(R.id.fibonacci_counter_label)
        fibonacciCounterButton.setOnClickListener {
            val value = fibonacciCounter.getNextValue()
            fibonacciCounterLabel.text = value.toString()
        }

        val primeCounterButton: Button = findViewById(R.id.prime_counter_button)
        val primeCounterLabel: TextView = findViewById(R.id.prime_counter_label)
        primeCounterButton.setOnClickListener {
            val value = primeCounter.getNextValue()
            primeCounterLabel.text = value.toString()
        }

        if (savedInstanceState != null) {
            naturalCounter.setValue(savedInstanceState.getInt(FieldNames.naturalCounterValue))
            fibonacciCounter.setValue(savedInstanceState.getInt(FieldNames.fibonacciCounterValue))
            primeCounter.setValue(savedInstanceState.getInt(FieldNames.primeCounterValue))

            naturalCounterLabel.text = naturalCounter.getValue().toString()
            fibonacciCounterLabel.text = fibonacciCounter.getValue().toString()
            primeCounterLabel.text = primeCounter.getValue().toString()
        }
    }


    private fun getIconResource(icon: DetailsIcon): Int {
        return when (icon) {
            DetailsIcon.rocket -> R.drawable.ic_rocket
            DetailsIcon.atom -> R.drawable.ic_atom
            DetailsIcon.car -> R.drawable.ic_car
            DetailsIcon.guy -> R.drawable.ic_guy
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(FieldNames.naturalCounterValue, naturalCounter.getValue())
        savedInstanceState.putInt(FieldNames.fibonacciCounterValue, fibonacciCounter.getValue())
        savedInstanceState.putInt(FieldNames.primeCounterValue, primeCounter.getValue())
    }
}