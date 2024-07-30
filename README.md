# Expense Tracker

Expense Tracker is an Android application designed to help users manage their personal finances by tracking their expenses and budgets. The app allows users to set a budget, add expenses, view their balance, and visualize expenses through charts. It also includes a settings menu for additional configurations.

## Features

- **Set Total Budget**: Users can set a total budget that they plan to manage.
- **Add Expenses**: Users can add expenses by specifying the amount and selecting a category.
- **Expense Categories**: Includes categories such as Food, Transport, Entertainment, Utilities, and Others.
- **View Balance**: Automatically calculates and displays the current balance based on expenses added.
- **Expense List**: Displays a list of all expenses added by the user.
- **Expense Chart**: Visualize the trend of expenses using a chart.
- **Reset Expenses**: Users can reset all expenses and start fresh.
- **Settings**: Configure default budget and notification preferences.
- **About**: Provides information about the app.

## Screenshots

![main_screen](https://github.com/user-attachments/assets/38ed1352-8560-46e6-8451-2e13eb86998c)
![expense_chart](https://github.com/user-attachments/assets/6540d7dc-0edd-40c2-8cf5-49fafbc37872)
![add_expense](https://github.com/user-attachments/assets/265359de-f3b2-446b-b961-8191620121e1)
![spinner](https://github.com/user-attachments/assets/a4427d7b-b822-4286-8575-1e1ae833e748)
![warning](https://github.com/user-attachments/assets/3f9e1617-5c91-465d-a871-40466914e5c4)
![menu](https://github.com/user-attachments/assets/d896464b-b788-49c8-a41c-acaa8cda10ce)
![settings](https://github.com/user-attachments/assets/0e958173-5305-40cf-9e56-d40ab213bf4f)
![about](https://github.com/user-attachments/assets/dbd29d70-8f29-416b-8ccd-8704dfbd0489)
## Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/expense-tracker.git
    ```

2. Open the project in Android Studio.

3. Build the project to download all dependencies.

4. Run the project on an emulator or physical device.

## Usage

1. **Set Budget**: Enter the total budget in the "Set Budget" section and click the "Set Budget" button.
2. **Add Expense**: Enter the expense amount, select a category from the dropdown, and click "Add Expense".
3. **View Expenses**: Click the "Show Expenses" button to view all added expenses.
4. **View Chart**: Click the "Show Chart" button to visualize the expense trend.
5. **Reset Expenses**: Click the "Reset" button to clear all expenses.
6. **Settings**: Click the menu button and select "Settings" to configure default budget and notification preferences.
7. **About**: Click the menu button and select "About" to view information about the app.

## Code Structure

- **MainActivity.kt**: The main activity that handles the primary functionalities of setting budget, adding expenses, showing expenses, and resetting expenses.
- **SettingsActivity.kt**: The activity that hosts the settings fragment for configuring preferences.
- **SettingsDialogFragment.kt**: A dialog fragment for displaying settings in a floating window.
- **Expense.kt**: Data class representing an expense.
- **ExpenseAdapter.kt**: RecyclerView adapter for displaying the list of expenses.
- **ExpenseChartDialog.kt**: Dialog fragment for displaying the expense chart.
- **AboutDialogFragment.kt**: Dialog fragment for displaying the about information.
- **res/layout/**: Contains XML layout files for activities and fragments.
- **res/xml/**: Contains XML files for preferences.

## Dependencies

- `androidx.appcompat:appcompat:1.2.0`
- `androidx.constraintlayout:constraintlayout:2.0.4`
- `androidx.preference:preference:1.1.1`
- `com.google.android.material:material:1.3.0`

## Contributing

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-branch`.
3. Make your changes and commit them: `git commit -m 'Add new feature'`.
4. Push to the branch: `git push origin feature-branch`.
5. Submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

## Contact

If you have any questions, feel free to contact me at [your email].
















