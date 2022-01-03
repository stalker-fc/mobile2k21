package ru.itmo.mobile2k21.second.presenter

import ru.itmo.mobile2k21.second.view.ICounterView
import ru.itmo.mobile2k21.second.view.ITaskView

class TaskPresenter(private val taskView: ITaskView) : ITaskPresenter {
    private var counterViews: MutableList<ICounterView> = mutableListOf()

    override fun addCounter(counter: ICounterView) {
        counterViews.add(counter)
    }

    override fun start() {
        for (counter in counterViews) counter.start()
        taskView.disableStartButton()
        taskView.enableStopButton()
        taskView.enableResetButton()

    }

    override fun stop() {
        for (counter in counterViews) counter.stop()
        taskView.enableStartButton()
        taskView.disableStopButton()
        taskView.enableResetButton()
    }

    override fun reset() {
        for (counter in counterViews) counter.reset()
        taskView.enableStartButton()
        taskView.disableStopButton()
        taskView.disableResetButton()
    }

}