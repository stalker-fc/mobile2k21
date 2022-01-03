package ru.itmo.mobile2k21.first

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.R
import ru.itmo.mobile2k21.first.counter.FibonacciCounter
import ru.itmo.mobile2k21.first.counter.NaturalCounter
import ru.itmo.mobile2k21.first.counter.PrimeCounter

class DetailScreenActivity : AppCompatActivity() {
    private lateinit var info: DetailScreenInfo

    private val naturalCounter: NaturalCounter = NaturalCounter()
    private val fibonacciCounter: FibonacciCounter = FibonacciCounter()
    private val primeCounter: PrimeCounter = PrimeCounter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)
        info = intent.extras?.get(FieldNames.detailScreenInfo) as DetailScreenInfo

        val title: TextView = findViewById(R.id.detail_screen_title)
        title.text = info.title

        val description: TextView = findViewById(R.id.detail_screen_description)
        description.text = info.description

        val icon: ImageView = findViewById(R.id.detail_screen_icon)
        icon.setImageResource(getIcon(info.icon))


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

//       TODO: google restore instance state
//        landscape layout
    }


    private fun getIcon(icon: DetailScreenIcon): Int {
        return when (icon) {
            DetailScreenIcon.rocket -> R.drawable.ic_rocket
            DetailScreenIcon.atom -> R.drawable.ic_atom
            DetailScreenIcon.car -> R.drawable.ic_car
            DetailScreenIcon.guy -> R.drawable.ic_guy
        }
    }

//    override fun onSaveInstanceState(savedInstanceState: Bundle) {
//        super.onSaveInstanceState(savedInstanceState)
//        // Save UI state changes to the savedInstanceState.
//        // This bundle will be passed to onCreate if the process is
//        // killed and restarted.
//        savedInstanceState.putBoolean("MyBoolean", true)
//        savedInstanceState.putDouble("myDouble", 1.9)
//        savedInstanceState.putInt("MyInt", 1)
//        savedInstanceState.putString("MyString", "Welcome back to Android")
//        // etc.
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        // Restore UI state from the savedInstanceState.
//        // This bundle has also been passed to onCreate.
//        val myBoolean = savedInstanceState.getBoolean("MyBoolean")
//        val myDouble = savedInstanceState.getDouble("myDouble")
//        val myInt = savedInstanceState.getInt("MyInt")
//        val myString = savedInstanceState.getString("MyString")
//    }
//
//    fun onViewStateRestored(@Nullable savedInstanceState: Bundle) {
//        super.onViewStateRestored(savedInstanceState)
//        // Restore UI state from the savedInstanceState.
//        // This bundle has also been passed to onCreate.
//        val myBoolean = savedInstanceState.getBoolean("MyBoolean")
//        val myDouble = savedInstanceState.getDouble("myDouble")
//        val myInt = savedInstanceState.getInt("MyInt")
//        val myString = savedInstanceState.getString("MyString")
//    }
}