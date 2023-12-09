package com.ailenaguino.practica1.Basic

val weekDays = arrayOf("Sunday", "Monday", "Tuesday")

fun main() {

    for(position in weekDays.indices){
        println(weekDays[position])
    }

    for((position,value) in weekDays.withIndex()){
        println("In the position $position there is the value $value")
    }

    for(wd in weekDays){
        println("Today is $wd")
    }
}

