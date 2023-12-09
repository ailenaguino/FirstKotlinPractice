package com.ailenaguino.practica1.Basic

var namePepe = "Pepe"

fun main() {
    basicIf()
    basicIf()
    nestedIf("dog")
    nestedIf("snake")
    andOrIf("cat", true)
}

fun basicIf() {
    if (namePepe == "Pepe") {
        namePepe = "Pepa"
        println("El nombre es $namePepe")
    } else {
        println("El nombre ahora es $namePepe")
    }
}

fun nestedIf(animal: String) {
    if (animal == "dog") {
        println("It's a dog!")
    } else if (animal == "cat") {
        println("It's a cat!")
    } else {
        println("Isn't one of the expected animals")
    }
}

fun andOrIf(animal: String, isHappy: Boolean) {
    if (animal == "dog" || (animal == "cat" && isHappy)) {
        println("It's a happy cat or a dog")
    }
}