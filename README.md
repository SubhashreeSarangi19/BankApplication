# Console-Based Banking Application

## Overview

This is a console-based Banking Application built in Java, designed to simulate basic banking functionalities. It provides users with options to register, login, open accounts, make deposits and withdrawals, check balance, and view account statements. For savings accounts, it also calculates and adds monthly interest.

## Features

1. **User Registration & Login**
   - Register a new user with a username and password.
   - Login functionality verifies credentials for secure access.

2. **Account Opening**
   - Open a new bank account with unique account numbers.
   - Account details include the holder's name, account type (savings or checking), and initial deposit amount.

3. **Transaction Processing**
   - Perform deposit and withdrawal transactions on an account.
   - Prevent overdrafts by ensuring withdrawals do not exceed the balance.
   - Log each transaction with a unique ID, date, type (deposit/withdrawal), and amount.

4. **Statement Generation**
   - Generate an account statement showing transaction history with details such as date, type, and amount.

5. **Interest Calculation**
   - Monthly interest is calculated and added to savings accounts.
   - Fixed interest rate applied once per month for simplicity.

6. **Balance Check**
   - View the current balance for each account.

## Class Structure

1. **`User`**: Represents each user in the system with a username, password, and list of bank accounts.
2. **`BankAccount`**: Stores account details, handles transactions (deposit/withdrawal), and manages balance and interest.
3. **`Transaction`**: Represents individual transactions with a unique ID, date, type, and amount.
4. **`BankingApp`**: The main driver class for handling user interaction, managing menus, and invoking relevant features.

## Workflow

- **Register** a new user with a unique username and password.
- **Login** with registered credentials.
- **Open** an account by providing account holder details, account type, and initial deposit.
- **Deposit** or **withdraw** funds as desired.
- **Check balance** or view statement for transaction history.
- **Add monthly interest** to savings accounts (automated calculation).
- **Logout** to end the session.

## How to Run

1. **Compile all classes**:
   ```bash
   javac *.java
