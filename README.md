# Vivz_Dagger_2_Demo
This demo shows you how to setup and use Dagger 2 Dependency Injection library in your Android apps

<b>The Main Gradle file</b>

![snap 2015-09-11 at 15 07 56](https://cloud.githubusercontent.com/assets/5139030/9811773/e8a5ff1e-5896-11e5-84fd-30f854d09255.png)

<b>The App Gradle file</b>

![snap 2015-09-11 at 15 09 12](https://cloud.githubusercontent.com/assets/5139030/9811794/13f22148-5897-11e5-8c81-d975dd065df6.png)

This is what you will see once you run the app in your device or emulator

![testgif](https://cloud.githubusercontent.com/assets/5139030/9811752/bec9957a-5896-11e5-9d4f-60ab8a406da0.gif)

<b>Step 0 :</b>
Ask yourself 3 questions
<ol>
<li>Which object do you want dagger to provide?</li>
<li>Where do you want dagger to provide this object?</li>
<li>How will you construct or provide this object?</li>
</ol>


Let's say we want SharedPreferences to be supplied to us by Dagger

<ol>
<li>
<p>Which object do you want dagger to provide?</p>
<p>Shared Preferences, create a module that returns a SharedPreferences object</p>
</li>

<li>
<p>Where do you want dagger to provide this object?</p>
<p>In 2 places, Fragment A and Fragment B in this app, use the @Inject annotation at both places and create a component that has 2 methods, where the first method takes a reference to Fragment A and the second method takes a reference to Fragment B so that Dagger can generate an implementation that extends your Component interface and use your module to construct the SharedPreferences object wherever required and supply it.</p>
</li>

<li>
<p>How will you construct or provide this object?</p>
<p>Create a method inside your module with a @Provides annotation that returns an object of the type you want dagger to provide, in our case, that type is SharedPreferences.</p>
</li>
<ol>






