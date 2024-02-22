/**
 *
 */

import java.util.InputMismatchException
import java.util.Scanner

fun main(args: Array<String>) {
    println("* * * Calculator * * *")
    println("Menu\n1. Tip Calculator\n2. Basic Arithmetic")

    val reader = Scanner(System.`in`)
    var valid = false

    while(!valid) {
        try {
            print(" -> ")
            var choice:Int = reader.nextInt()

            when (choice) {
                1 -> {
                    tipCalculator()
                    valid = true
                }

                2 -> {
                    arithmeticCalculator()
                    valid = true
                }
                else -> {
                    print("That is not a valid menu selection. Please try again.")
                }
            }
        } catch (e: InputMismatchException) {
            println("You didn't enter an integer. Please try again.")
            reader.nextLine()
        }
    }
}

fun tipCalculator() {

}

fun arithmeticCalculator() {

}