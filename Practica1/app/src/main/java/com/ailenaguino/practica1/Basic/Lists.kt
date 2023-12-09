package com.ailenaguino.practica1.Basic

fun main() {
    val readOnly: List<String> = listOf("Monday", "Tuesday", "Wednesday")

    println(readOnly.last())
    println(readOnly.first())

    val example = readOnly.filter { it.contains("e") }
    println(example)

    readOnly.forEach { wd -> println("-$wd-") }

    val animals: MutableList<String> = mutableListOf("Cat", "Dog", "Rabbit")
    animals.add("Snake")
    animals.add(2, "Parrot")

    if (!animals.isEmpty()) {
        animals.forEach { println(it) }
    }


}