package ru.itmo.mobile2k21.second.model

import ru.itmo.mobile2k21.second.view.ICounterView

data class TaskModel (
    var counterViews: List<ICounterView>
)