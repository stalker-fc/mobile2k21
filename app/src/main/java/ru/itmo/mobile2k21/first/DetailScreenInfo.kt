package ru.itmo.mobile2k21.first

import java.io.Serializable


data class DetailScreenInfo(
    val title: String,
    val description: String,
    val icon: DetailScreenIcon
) : Serializable
