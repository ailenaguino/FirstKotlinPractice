package com.ailenaguino.practica1.Basic

val name = "Pedro" //con val el valor no cambia
val age: Int = 30
var age2 = 40
var d = 50.9

fun main() {
    sayName()
    suma()
    println(sumaConParametros(2, 6))
    resta()
    resta(20)

}

fun suma() {
    age2 = 60
    println(age2 + d.toInt())//esto da 110
}

fun sumaConParametros(num1: Int, num2: Int) = num1 + num2

fun sayName(): Boolean {
    println("Tu nombre es $name")
    return true
}

fun resta(num1: Int = 16, num2: Int = 10): Int {
    return num1 - num2
}