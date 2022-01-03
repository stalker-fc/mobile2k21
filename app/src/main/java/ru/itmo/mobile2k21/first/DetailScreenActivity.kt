package ru.itmo.mobile2k21.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
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

//       TODO: google restore instance state
//        landscape layout
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