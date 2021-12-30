package ru.itmo.mobile2k21.second

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.itmo.mobile2k21.R

class CounterView : AppCompatActivity(), ICounterView {
    private lateinit var presenter: ICounterPresenter
    private lateinit var counterLabel: TextView
    private lateinit var slowDownButton: Button
    private lateinit var speedUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.counter_item)

        counterLabel = findViewById(R.id.counter_label)
        slowDownButton = findViewById(R.id.counter_slow_down)
        speedUpButton = findViewById(R.id.counter_speed_up)

        slowDownButton.setOnClickListener { presenter.slowDown() }
        speedUpButton.setOnClickListener { presenter.speedUp() }
    }

    override fun setLabelValue(value: Int) {
        counterLabel.text = value.toString()
    }

    fun setPresenter(presenter: ICounterPresenter) {
        this.presenter = presenter
    }
}