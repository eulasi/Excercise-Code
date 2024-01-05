fun main() {
    // 1 - Start the bank system interface with print statements
    println("Bank Pal: Your Favorite Bank App")
    println("------------------------------------------")
    println("Welcome to your banking system.")
    println("What type of account would you like to create?")
    println("------------------------------------------")
    println("1. Debit account")
    println("2. Credit account")
    println("3. Checking account")
    // 2 - Create Variables for the bank account type and user account
    var accountType = "" // set value to empty string
    var userChoice = 0 // set value to zero
    // 3 - Create a bank account based on user input with a while loop
    while (accountType == "") {
        println("Choose an option (1, 2 or 3)")
        // simulates user input using random numbers
        userChoice = (1..5).random()
        println("The selected option is ${userChoice}.")

        when (userChoice) {
            1 -> accountType = "debit"
            2 -> accountType = "credit"
            3 -> accountType = "checking"
            else -> continue
        }
    }
    // 4 - Display account type
    println("You have created a ${accountType} account.")


    // 5 -  create a variable using the “var” keyword to store the account balance
    var accountBalance = (0..1000).random()
    // 6 - Print the account balance to the console. Use string interpolation to access the value
    println("The current balance is ${accountBalance} dollars.")
    // 7 - create a constant using the “val” keyword to store the amount of money used for account withdrawals and deposits
    val money = (0..1000).random()
    // 8 - Print the account balance and amount to be deposited/withdrawn to the console.
    println("The Amount you transferred is ${money} dollars.")
    // 9 - Create a variable for the output of the functions that we will define in the next step to handle the bank account’s operations such as deposits and withdrawals
    var output = 0
// Implement the withdrawal operation for generic and credit bank accounts
    // Name the function withdraw and assign it one parameter named amount. The amount parameter is an integer and the function would also return an integer, hence the definition would be withdraw(amount: Int): Int. The amount parameter and withdraw(...) function’s returned value represents the amount of money withdrawn from the account.
    fun withdraw(amount: Int): Int {
        // Use the subtraction assignment operator inside the body of the withdraw(...) function to subtract the value of the amount parameter from the value of the accountBalance variable and assign the result to the accountBalance variable. This means that you have withdrawn money from your bank account.
        accountBalance -= amount
        //Print the amount of money withdrawn from your bank account and the account’s updated balance to the console inside the withdraw(...) function’s body. Use string interpolation to access the value of the amount parameter and accountBalance variable inside the print statement.
        println("You successfully withdrew ${amount} dollars. The current balance is ${accountBalance} dollars.")
    // Return the amount parameter’s value from the withdraw(...) function inside the function’s body.
    return amount
    }
    // Call the withdraw(...) function with the money variable’s value as its argument and assign its result to the output variable.
    output = withdraw(money)
    // Print the output of the withdraw(...) function to the console. Use string interpolation to access the value of the output variable inside the print statement.
    println("The amount you withdraw is ${output} dollars.")

    // Implement the withdrawal operation for debit accounts
    fun debitWithdraw(amount: Int): Int {
        // Check if the accountBalance variable’s value is 0 to determine if there are funds available in the account
        if (accountBalance == 0) {
            // Print "Can't withdraw, no money on this account!" inside the if block.
            println("Can't withdraw, no money on this account!")
            // Return the accountBalance variable’s value.
            return accountBalance
            // Check if the amount parameter’s value is greater than the accountBalance variable value to evaluate if there is enough money in the account to perform the withdrawal.
        } else if (amount > accountBalance) {
            // Print "Not enough money on this account! The checking balance is ${accountBalance} dollars."
            println("Not enough money on this account! The current balance is ${accountBalance} dollars.")
            // Return 0 from the debitWithdraw(...) function inside the else if block. This means that no money has been withdrawn because the account’s balance is lower than the withdrawal amount.
            return 0
        } else {
            // call the withdraw(...) function with the amount parameter’s value as its argument and return its output from the debitWithdraw(...) function inside the else block. This means that the user can continue with the withdrawal because the amount of money they want to withdraw is less than or equal to the account’s balance.
            return withdraw(amount)
        }
    }

    // Call the debitWithdraw(...)  function with the value of the money variable as its argument and assign its result to the output variable.
    output = debitWithdraw(money)
    // Print the output of the debitWithdraw(...) function to the console. Use string interpolation to access the value of the output variable inside the print statement.
    println("The amount you withdrew is ${output} dollars.")

    // Implement the function that handles the logic of the deposit operation for generic and debit bank accounts.
    fun deposit(amount: Int): Int {
        accountBalance += amount
        println("You successfullly deposited ${amount} dollars. The current balance is ${accountBalance} dollars.")
        return amount
    }

    // Test the function that handles the logic of the deposit operation for generic and debit bank accounts
    output = deposit(money)
    println("The amount you deposited is ${output} dollars.")

    // Implement the function that handles the logic of the deposit operation for credit bank accounts.
    fun creditDeposit(amount: Int): Int {
        if (accountBalance == 0) {
            println("This account is completely paid off! Do not deposit money!")
            return accountBalance
        } else if (accountBalance + amount > 0) {
            println("Deposit failed, you tried to pay off an amount greater than the credit balance.")
            return 0
        } else if (amount == -accountBalance) {
            accountBalance = 0
            println("You have paid of this account!")
            return amount
        } else {
            return deposit(amount)
        }
    }

    // test function that handles the logic of the deposit operation for credit bank accounts.
    output = creditDeposit(money)
    println("The amount you deposited is ${output} dollars.")


    fun transfer(mode:String) {
        val transferAmount:Int

        when (mode) {
            "withdraw" -> {
                if (accountType == "debit") {
                    transferAmount = debitWithdraw(money)
                } else {
                    transferAmount = withdraw(money)
                }
                println("The amount you withdrew is ${transferAmount} dollars.")
            }
            else -> return
        }
    }

    var isSystemOpen = true
    var option = 0

    while (isSystemOpen == true) {
        println("What would you like to do?")
        println("1. Check bank account balance")
        println("2. Withdraw money")
        println("3. Deposit money")
        println("4. Close the system")
        println("Which option do you choose? (1, 2, 3 or 4)")

        option = (1..5).random()
        println("The selected option is ${option}.")

        when (option) {
            1 -> println("The current balance is ${accountBalance} dollars.")
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen = false
                println("The system is closed")
            }
            else -> continue
        }
    }
}