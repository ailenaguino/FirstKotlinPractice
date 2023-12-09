package com.ailenaguino.practica1.Basic

fun main(){
        println(getMonth(1))
}

fun getMonth(month: Int):String = when(month){
        1 -> "January"
        2 -> {"February"}
        3, 4, 5 -> "March, April, May"
        in 6..12 -> "The rest"
        else -> "nope"
}

fun result(value:Any){
    when(value){
        is Int -> value + value
        is String -> println(value)
        is Boolean -> if(value) println("Es verdadero")
    }
}