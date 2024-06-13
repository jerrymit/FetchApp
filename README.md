<p align="center">
  <img src="https://github.com/jerrymit/FetchApp/blob/master/FetchApp.PNG" alt="FetchApp Screenshot">
</p>

# FetchApp
FetchApp is an Android application developed in Kotlin that demonstrates the use of Retrofit to fetch and display a list of items from a remote server. The app groups items by 'listId' and filters out entries with empty or null names.

# Features
• Data Fetching: Utilizes Retrofit to load data from a remote JSON file.<br>
• Data Filtering and Sorting: Filters out items with null or blank names and sorts items by 'listId' and then by 'name'.<br>
• User Interface: Provides a clean and simple UI to display the filtered and sorted items using a RecyclerView.<br>

# Prerequisites
Before running this project, make sure you have:<br>
• Android Studio<br>
• Android SDK set up on your development environment<br>

# Setup and Installation
• Clone the repository:<br>
git clone https://github.com/yourusername/fetchapp.git<br>
• Open the project in Android Studio.<br>
• Sync the project with Gradle files.<br>
• Run the application on your device or emulator.<br>

# Usage
The main interface includes a button to toggle the display of fetched data. Upon clicking 'Show Results', the app fetches data from the server, processes it as per the requirements, and displays it. You can hide the results by clicking the same button, now labeled 'Close'.

# Contributing
Feel free to fork the project and submit pull requests. You can also open issues for bugs or new features you think would improve the application.
