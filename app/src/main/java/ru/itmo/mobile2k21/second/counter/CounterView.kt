package ru.itmo.mobile2k21.second.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.itmo.mobile2k21.R


class CounterView : Fragment(), ICounterView {
    private lateinit var presenter: ICounterPresenter
    private var currentUpdateIntervalMs: Long = 0
    private var changeIntervalDeltaMs: Long = 0
    private lateinit var counterLabel: TextView
    private lateinit var slowDownButton: Button
    private lateinit var speedUpButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentUpdateIntervalMs = arguments?.getLong("currentUpdateIntervalMs") ?: 0
        changeIntervalDeltaMs = arguments?.getLong("changeIntervalDeltaMs") ?: 0

        presenter = CounterPresenter(this, currentUpdateIntervalMs, changeIntervalDeltaMs)

        counterLabel = view.findViewById(R.id.counter_label)
        slowDownButton = view.findViewById(R.id.counter_slow_down)
        speedUpButton = view.findViewById(R.id.counter_speed_up)

        slowDownButton.setOnClickListener { presenter.slowDown() }
        speedUpButton.setOnClickListener { presenter.speedUp() }
    }

    companion object {
        fun instance(currentUpdateIntervalMs: Long, changeIntervalDeltaMs: Long): CounterView {
            val data = Bundle()
            data.putLong("currentUpdateIntervalMs", currentUpdateIntervalMs)
            data.putLong("changeIntervalDeltaMs", changeIntervalDeltaMs)
            return CounterView().apply {
                arguments = data
            }
        }
    }

    override fun setLabelValue(value: Int) {
        counterLabel.text = value.toString()
    }

    override fun start() {
        presenter.start()
    }

    override fun stop() {
        presenter.stop()
    }

    override fun reset() {
        presenter.reset()
    }
}