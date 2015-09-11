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

<b>Step 1:</b>
Construct a module that knows how to create SharedPreferences object which will be used by Dagger. Since we need a context which should be Application Context as SharedPreferences tend to be used everywhere, make a constructor that accepts an object of your custom Application class. Notice the @Singleton annotation which indicates that only a single object of SharedPreferences will be supplied to everyone once its created.

![snap 2015-09-11 at 15 20 39](https://cloud.githubusercontent.com/assets/5139030/9812094/afd150b0-5898-11e5-8444-d01161b0d770.png)

<b>Step 2:</b>
Create a component interface called StorageComponent that has all the methods which simply specify where to inject the reference. Dagger 2 will generate the concrete implementation for your interface and fill the necessary code using your module that you created earlier in Step 1. Notice that we plan to use @Inject annotations inside Fragment A and Fragment B and therefore we have 2 methods inside our Component interface that exactly tell Dagger the list of all places where we need a SharedPreferences object. Also notice the modules annotation that tells Dagger to use our module declared in the earlier step to actually construct a SharedPreferences object when needed.

![snap 2015-09-11 at 15 24 25](https://cloud.githubusercontent.com/assets/5139030/9812184/35dfb688-5899-11e5-9320-80f0eb272cda.png)

<b>Step 3</b>

We add the @Inject annotations inside Fragment A and Fragment B where we want Dagger to supply us with a SharedPreferences object. Build the program at this point so that Dagger can generate an implementation for your component interface. We use this implementation in the next step.

![snap 2015-09-11 at 15 26 14](https://cloud.githubusercontent.com/assets/5139030/9812228/770059e2-5899-11e5-9b43-fd739ad01b07.png)

<b>Step 4</b>

In this step, Dagger has compiled our modules and components and generated an implementation of our component interface. Its name is DaggerStorageComponent in our case. Call its builder() method, supply an object of our StorageModule and finally call its build() method. 

![snap 2015-09-11 at 15 28 09](https://cloud.githubusercontent.com/assets/5139030/9812264/bad42d56-5899-11e5-8ec7-a74a16f13e46.png)

<b>Step 5</b>
Notice how we have passed a reference of Fragment A by getting our Activity, get our Application from our Activity, typecast it to our custom Application, get the component from that and simply call inject() method which was actually a part of our Component interface declared in Step 2. This is how the whole process works

![snap 2015-09-11 at 15 30 20](https://cloud.githubusercontent.com/assets/5139030/9812299/0ad5bb3a-589a-11e5-83e5-af481037f474.png)
