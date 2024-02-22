/**
 * @author abbybrown
 * @date 02/20/24
 * @filename Main.kt
 *
 *      Simple Calculator Program
 *
 *      User is able to choose between a tip calculator and an arithmetic calculator.
 *      There is significant validity checking to ensure that the program won't
 *      break upon invalid input.
 */

import java.text.NumberFormat
import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) {
    // create a scanner for reading in user input
    val reader = Scanner(System.`in`)
    var valid = false

    // while loop lets the program run until user stops it
    while(!valid) {
        try {
            println("\n* * * Calculator * * *")
            println("Menu\n1. Tip Calculator\n2. Basic Arithmetic\n3. Quit")
            print("Your Selection: ")
            var choice:Int = reader.nextInt()

            // switch case for each calculator option
            when (choice) {
                1 -> {
                    tipCalculator(reader)
                }

                2 -> {
                    arithmeticCalculator(reader)
                }

                3 -> {
                    println("Thank you for using our services! Goodbye.")
                    valid = true
                }

                else -> {
                    print("That is not a valid menu selection. Please try again.")
                }
            }

        // catch any case where the user doesn't enter an integer and let them try again
        } catch (e: InputMismatchException) {
            println("You didn't enter an integer. Please try again.")
            reader.nextLine()
        }
    }
}

/**
 * Tip Calculator function that allows the user to enter the number
 * of people in their party, bill price, and desired tip amount.
 *
 * Function prints the calculated information to the console.
 *
 * Parameters
 * ----------
 *      reader : Scanner
 *          A scanner to read in the user's input
 */
fun tipCalculator(reader: Scanner) {
    println("\n* Welcome to Tip Calculator *")

    var numPeople: Int
    var totalBill: Float
    var tipPercentage: Float

    try {
        print("Enter the number of people in your party: ")
        numPeople = reader.nextInt()
        if (numPeople <= 0) {
            println("Number of people must be a positive integer. Please try again.")
            return
        }

        print("Enter the total bill: $")
        totalBill = reader.nextFloat()
        if (totalBill <= 0) {
            println("Total bill must be a positive number. Please try again.")
            return
        }

        print("Enter tip percentage: ")
        tipPercentage = reader.nextFloat()
        if (tipPercentage < 0 || tipPercentage > 100) {
            println("Tip percentage must be between 0 and 100. Please try again.")
            return
        }
    } catch (e: InputMismatchException) {
        println("Invalid input. Please enter a valid number.")
        reader.nextLine()
        return
    }

    val calculate: Float = (totalBill / numPeople) * (tipPercentage / 100)
    val newTotal: Float = (calculate * numPeople) + totalBill

    // create a numeric to currency thing
    // https://stackoverflow.com/questions/45592109/how-can-i-convert-numbers-to-currency-format-in-android
    val COUNTRY: String = "US"
    val LANGUAGE: String = "en"
    val calculateStr: String = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY)).format(calculate)
    val newTotalStr: String = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY)).format(newTotal)

    // do a cool wait thing to make it seem like the program is thinking
    // https://medium.com/@mkcode0323/thread-sleep-vs-delay-kotlin-coroutines-73650f3294c0
    print("Calculating ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)

    println("\nEach person in your party of $numPeople owes $calculateStr for a new bill total of $newTotalStr.")
}

/**
 * Arithmetic Calculator function that allows the user to enter two
 * numbers to multiply, subtract, add, divide, or raise to the power of.
 *
 * Function prints the calculated information to the console.
 *
 * Parameters
 * ----------
 *      reader : Scanner
 *          A scanner to read in the user's input
 */
fun arithmeticCalculator(reader: Scanner) {
    println("* Welcome to Arithmetic Calculator *")

    var numOne: Float
    var numTwo: Float
    var operation: Char

    try {
        print("Enter the first number to calculate: ")
        numOne = reader.nextFloat()

        print("Enter the second number to calculate: ")
        numTwo = reader.nextFloat()

        print("Enter the operation to use (*+-/^): ")
        operation = reader.next().single()

    // validate all inputs match their types
    } catch (e: InputMismatchException) {
        println("Invalid input. Please enter a valid number.")
        reader.nextLine()
        return
    }

    val answer: Float

    // switch case to correctly check for operators and perform the math
    when(operation) {
        '+' -> {
            answer = numOne + numTwo
        }

        '-' -> {
            answer = numOne - numTwo
        }

        '*' -> {
            answer = numOne * numTwo
        }

        '/' -> {
            answer = numOne / numTwo
        }

        '^' -> {
            answer = numOne.toDouble().pow(numTwo.toDouble()).toFloat()
        }

        else -> {
            println("Operation selected is not valid. Please try again.")
            // allow the user to return to menu and start over
            return
        }
    }

    // show the calculated values after waiting (to build suspense)
    print("Calculating ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)

    println("The answer to $numOne $operation $numTwo is $answer.")
}
