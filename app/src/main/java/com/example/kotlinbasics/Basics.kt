package com.example.kotlinbasics

fun main() {

    var season = 3
    when(season) {
        1 -> println("spring")
        2 -> println("summer")
        4 -> println("winter")
    }

    var month = 3
    when(month) {
        in 1..3 -> println("spring")
        in 6..8 -> println("summer")
        12, 1, 2 -> println("winter")
    }

    var x = 1

    do{
        print("$x")
        x++

    }while (x <= 10)

    for(i in 1 until 10) {
        print("$i ")
    }

}