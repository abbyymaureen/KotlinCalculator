/**
 *
 */

import java.text.NumberFormat
import java.util.*
import kotlin.math.pow


fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    var valid = false

    while(!valid) {
        try {
            println("\n* * * Calculator * * *")
            println("Menu\n1. Tip Calculator\n2. Basic Arithmetic\n3. Quit")
            print("Your Selection: ")
            var choice:Int = reader.nextInt()

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
        } catch (e: InputMismatchException) {
            println("You didn't enter an integer. Please try again.")
            reader.nextLine()
        }
    }
}

fun tipCalculator(reader: Scanner): Unit {
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

    val COUNTRY: String = "US"
    val LANGUAGE: String = "en"
    val calculateStr: String = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY)).format(calculate)
    val newTotalStr: String = NumberFormat.getCurrencyInstance(Locale(LANGUAGE, COUNTRY)).format(newTotal)

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
    } catch (e: InputMismatchException) {
        println("Invalid input. Please enter a valid number.")
        reader.nextLine()
        return
    }

    val answer: Float

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
            return // Return here to avoid printing the result when operation is invalid
        }
    }

    print("Calculating ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)
    print(". ")
    Thread.sleep(500)

    // Print the result after the "Calculating..." message
    println("The answer to $numOne $operation $numTwo is $answer.")
}
