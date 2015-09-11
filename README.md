# Vivz_Dagger_2_Demo
This demo shows you how to setup and use Dagger 2 Dependency Injection library in your Android apps

The Main Gradle file

![snap 2015-09-11 at 15 07 56](https://cloud.githubusercontent.com/assets/5139030/9811773/e8a5ff1e-5896-11e5-84fd-30f854d09255.png)

The App Gradle file

![snap 2015-09-11 at 15 09 12](https://cloud.githubusercontent.com/assets/5139030/9811794/13f22148-5897-11e5-8c81-d975dd065df6.png)

This is what you will see once you run the app in your device or emulator

![testgif](https://cloud.githubusercontent.com/assets/5139030/9811752/bec9957a-5896-11e5-9d4f-60ab8a406da0.gif)

Step 0 : Ask yourself 3 questions
1) Which object do you want dagger to provide?
2) Where do you want dagger to provide this object?
3) How will you construct or provide this object?


Let's say we want SharedPreferences to be supplied to us by Dagger

1)Which object do you want dagger to provide?
Ans) Shared Preferences, create a module that returns a SharedPreferences object

2) Where do you want dagger to provide this object?
Ans) In 2 places, Fragment A and Fragment B in this app, use the @Inject annotation at both places and create a component that has 2 methods, where the first method takes a reference to Fragment A and the second method takes a reference to Fragment B so that Dagger can generate an implementation that extends your Component interface and use your module to construct the SharedPreferences object wherever required and supply it.

3) How will you construct or provide this object?
Ans) Create a method inside your module with a @Provides annotation that returns an object of the type you want dagger to provide, in our case, that type is SharedPreferences.






