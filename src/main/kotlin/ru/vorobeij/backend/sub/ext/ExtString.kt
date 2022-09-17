package ru.vorobeij.backend.sub.ext

fun String?.toIntOr(defaultValue: Int) = this?.toInt() ?: defaultValue
