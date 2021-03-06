package ru.itmo.mobile2k21.second.task

import android.widget.Button

interface ITaskView {
    fun startCounters()
    fun stopCounters()
    fun resetCounters()
    fun enableStartButton()
    fun disableStartButton()
    fun enableStopButton()
    fun disableStopButton()
    fun enableResetButton()
    fun disableResetButton()
}