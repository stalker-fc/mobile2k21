package ru.itmo.mobile2k21.second.task

import ru.itmo.mobile2k21.second.counter.ICounterView
import ru.itmo.mobile2k21.second.task.ITaskView

class TaskPresenter(private val taskView: ITaskView) : ITaskPresenter {
    override fun onStartButtonPressed() {
        taskView.startCounters()
        taskView.disableStartButton()
        taskView.enableStopButton()
        taskView.enableResetButton()
    }

    override fun onStopButtonPressed() {
        taskView.stopCounters()
        taskView.enableStartButton()
        taskView.disableStopButton()
        taskView.enableResetButton()
    }

    override fun onResetButtonPressed() {
        taskView.resetCounters()
        taskView.enableStartButton()
        taskView.disableStopButton()
        taskView.disableResetButton()
    }

}