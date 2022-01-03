package ru.itmo.mobile2k21.second.task

import ru.itmo.mobile2k21.second.view.ICounterView

data class TaskModel (
    var counterViews: List<ICounterView>
)