package com.ailenaguino.practica1.Basic

fun main() {
    //EX1
    val morningNotif = 51
    val eveningNotif = 135

    printNotificationSummary(morningNotif)
    printNotificationSummary(eveningNotif)

    //EX2
    val child = 5
    val adult = 28
    val senior = 87
    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(isMonday, child)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(isMonday, adult)}.")
    println("The movie ticket price for a person aged $senior is \$${ticketPrice(isMonday, senior)}.")

}

fun ticketPrice(isMonday: Boolean, age: Int): Int {
    return when (age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 61..100 -> 20
        else -> -1
    }
}

fun printNotificationSummary(notif: Int) {
    if (notif < 100 && notif > 0) {
        println("You have $notif notifications")
    } else {
        println("You have 99+ notifications")
    }
}
