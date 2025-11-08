package com.levinzonr.template.android.core.extensions

fun String.without(value: String) = replace(value, "")

val String.withoutSpaces: String get() = without(" ")
