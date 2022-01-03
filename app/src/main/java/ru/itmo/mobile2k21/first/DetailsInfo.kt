package ru.itmo.mobile2k21.first

import java.io.Serializable


data class DetailsInfo(
    val title: String,
    val description: String,
    val icon: DetailsIcon
) : Serializable
