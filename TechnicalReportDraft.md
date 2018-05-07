# Matts Macros
Matthew Glynn

May 5, 2018

## Abstract
&nbsp;&nbsp;&nbsp;&nbsp; Macros are nutrients that the body requires, including proteins, carbohydrates and fats. Counting macros is a way that an individual can keep track of what they're eating and help achieve a specific goal, such as losing weight, maintaining weight and gaining weight. Currently on the market are plenty of macros app; however, while each app does a good job highlighting certain aspects of what the app should include, not one has perfected every aspect of the app that will allow ease of use for the user. The goal of this project is to provide the user with the most ergonomic macros app possible.

#### Keywords 
Macros, carbs, fats, proteins, app, features

## Table of Contents
- [Introduction and Overview](#introduction-and-product-overview)
     - [Intro](#intro)
     - [Goal](#goal)
     - [Problems and Risks](#problems-and-risks)
- [Development](#design-development-and-test)
     - [Design](#design)
     - [Development](#development)
     - [Test](#test)
- [Result](#results)
- [Conclusions](#conclusions)
- [References](#references)


## Introduction and Product Overview

### Intro
&nbsp;&nbsp;&nbsp;&nbsp; What are macronutrients, otherwise known as macros? Macronutrients are the largest class of nutrients the body requires and is made up of proteins, carbohydrates, and fats. These three factors make up your calories. Per gram of protein and carbohydrates make up 4 calories and per gram of fat makes up 9 calories. The amounts and ratio of macronutrients a person need vary depending on age, gender, lifestyle and health goals. It is a lot easier for an individual to achieve goals by keeping track of their macros rather than calories as a whole.  


### Goal
&nbsp;&nbsp;&nbsp;&nbsp; Currently, there are plenty of macros apps on the market that help individuals keep track of daily macros. However, it's rare to find an app that utilizes each feature to its full potential, making it less user friendly. For an individual to design an app that can compete with big competitors is a great challenge. However, "Matts Macros" is an android app that provides the essential features for an individual to keep track of daily macros, along with making them user friendly. In hope that users will see the simplicity and user friendliness of the app is a much better choice that the alternative. The features within this app include:
- Visual display of current macro goals and remaining numbers for the day.   
- Ability to calculate recommended macros based on health goals (gain weight, lose weight, maintain weight).   
- Ability to allow the user to insert specific values based on the meals they eat, that will calculate how many macros have been consumed during the day and how many macros are left, based on their goal.   
- Ability to save specific meals for future use based on a given macro name and numbers.  
- Ability to access saved meals. 

### Problems and Risks 
&nbsp;&nbsp;&nbsp;&nbsp; Throughout the production of the project a few issues were considered. One of the biggest issues was the lack of experience with Android Studio. Prior to the capstone course, I had zero experience with Android Studio and there was risk of learning how to use it and being able to produce a sufficient final project. As the app was being mad, that risk became less of an issue due to the fact that Android Studio is somewhat simplistic and more challenge activities had plenty of online tutorials that could lead me in the right direction. 

&nbsp;&nbsp;&nbsp;&nbsp; "Matts Macros" required a way for the app to save the users' information for future use. This posed as an issue due to the lack of knowledge and experience with databases. The app needed an easy database management system that would allow communication between the app and the database to be easy and efficient. During the production of "Matts Macros", an individual mentioned Firebase, a cloud-hosted database in which data is synced across all clients in real time. After looking into it, it seemed like a great solution to a big problem. Adding Firebase to Android Studio wasn't an issue at all; however, using it became a bigger issue. There was a lot of conflict with communicating between the app and the database.  

&nbsp;&nbsp;&nbsp;&nbsp; Writing to the database had minor issues, such as writing the right data types.  Occasional bugs would cause it to write a string type instead of a long type. Reading from the database took a lot of time away from the project. The biggest problem with writing from the database was accessing specific information, iterating through that information and then using that within the app. Each solution to a problem, lead to another problem that would take hours to resolve. After weeks of figuring out how to properly communicate between the two, the final product began to take form. Essentially, resolving all of my issues. 


## Design, Development and Test

### Design
&nbsp;&nbsp;&nbsp;&nbsp; The design of the project consist of two components, the database and the Android application. The database is a cloud-hosted database on Firebase. Data is stored as JSON and synchronized in real time to every connected client. The database keeps track of all information for the user, including macro goals, daily macros and saved meals. The application saves information into the database and also reads information from the database. An example of an individuals information that is store in the database can be seen below.

![Database Photo](https://github.com/glynnmd/CapstoneProject/blob/master/Database.png)


### UI Design
&nbsp;&nbsp;&nbsp;&nbsp; Most of the applications design was focused on the ease of use for the user. Overall, the app uses linear views, view pages and a navigation bar. The linear views allowed for items to be organized in a vertical/horizontal manner, to provide the user with a visually pleasing experience. The view pagers allowed the user to switch between relevant activities with ease. The navigation bar combined both the visual aspect and the ease of use. It provided a way for the user to see which activity they were in and an easy way of navigating between activities. 

For reference, other popular macros apps were examined and pointers were taken to see how exactly a functional app sound look and work. Once of the biggest challenges was deciding a color scheme that is unique and pleasing to look at. Several template  schemes were considered, until ultimately a custom scheme was designed. The design consists of white, light blue and black. Both the white and light blue look good mixed with black, because they're easy to examine the features/text of the app. An example of the scheme can be found below. 

<a href="url"><img src="https://github.com/glynnmd/CapstoneProject/blob/master/HomeScreen.png" align="center" height="500" width="280" ></a> 


### Development
&nbsp;&nbsp;&nbsp;&nbsp; Initially, the project started out slow. There was a lot of research done in the beginning to familarize myself with Android Studio. The "skateboard" prototype was completed within two weeks, which gave me plenty of time to learn a thing or two about Android Studio. The next process was to design the first two activities and communicate between them. Once simplistic layouts were produced and information was transfering between activities, I could really start designing the other activities. 

&nbsp;&nbsp;&nbsp;&nbsp; Production started increasing on the project, because I became more accustomed to Android Studio. Eventaully the layouts of the four main activities were completed and the next stage was to use the database within the app. Prodution hit a huge hault due to complicating errors with reading from the database. One of the biggest problems was accesses through a specific section of information and iterating through that information. Each section had an additional subsection that needed to be iterated through, increasing the complexity of the problem. However, once that problem was concluded, the project was near completion. The final stage included cleaning up code and finalizing the design of the layouts. 


### Test
&nbsp;&nbsp;&nbsp;&nbsp; During the beginning stages, I personally did some manual tests to make sure that I was designing the application correctly. The testing was done manually because the logcat in Android Studio provided error messages that would allow me to know exactly where the problem was at any given moment of using the app.

&nbsp;&nbsp;&nbsp;&nbsp; After most of the features were implemented, several individuals were asked to manually test the app. First, the testers were asked to simply use the app as a common user would. This gave me insight on if users were able to understand the purpose of the app and how to use it. Next, they were asked to simply "break the app." Having several individials use the app and trying to find errors and exploits, allowed me to know that my app wouldn't unexpectedly shut down, due to some error in the code. 


## Results
&nbsp;&nbsp;&nbsp;&nbsp; Initially the project had many more features; however, more problems occurred than expected. One major problem included the lack of knowledge in Android Studio. The first few weeks were spent learning the basics of Android Studio. After that, the biggest issue was writing to and reading from the database. The documentation for Firebase was hard to read and not informative to an individual who has never worked with Firebase before. Once all the components that wrote to the database were completed, the next challenge was to read that information and display it in the app. The lack of knowledge in Android Studio and writing from the database became an issue together. More advanced knowledge of Android Studio was needed to display the information; however, there were a lot of issues with reading from the database. Firebase has multiple ways of reading from the database, but doesn't provide information on how to iterate through the information. After hours and hours of watching YouTube videos, the issues started to die out and the app began hitting its final stages. 

&nbsp;&nbsp;&nbsp;&nbsp; As for the application features, it is composed of four activities. The main activity gives the user a visual representation of the macro goals they have set in place and a progress bar that gives them an idea of their remaining macros. The second activity allows the user to obtain their macro goals based on their age, height, weight, lifestyle and goal. The algorithm used to calculate the individual macros is based on the Katch-McArdle equation [5], which is considered more accurate than other common formulas. Below are screenshots of the suggestions activity and the home screen and how they communicate.

<a href="url"><img src="https://github.com/glynnmd/CapstoneProject/blob/master/Suggestions.png" align="center" height="500" width="350" ></a>
<a href="url"><img src="https://github.com/glynnmd/CapstoneProject/blob/master/HomeScreen2.png" align="center" height="500" width="350" ></a>

&nbsp;&nbsp;&nbsp;&nbsp; The thrid activity allows the user to save food for future use. Values are inserted based on a given name and corresponding macro values. The final activity consists of two tabs. The first tab allows users to insert values that will increase their daily value; this will change the display on the main activity, increasing the progress bars. Furthermore, the second tab in the activity gives the user a list of saved meals that was inserted into the database. Found below are examples of each activity and how they communicate among one another. 

<a href="url"><img src="https://github.com/glynnmd/CapstoneProject/blob/master/SavedMeals.png" align="center" height="500" width="280" ></a>
<a href="url"><img src="https://github.com/glynnmd/CapstoneProject/blob/master/ManualEntry.png" align="center" height="500" width="280" ></a>
<a href="url"><img src="https://github.com/glynnmd/CapstoneProject/blob/master/Savemeals.png" align="center" height="500" width="280" ></a>



&nbsp;&nbsp;&nbsp;&nbsp; The final product included all of the necessary functions needed for a proper macros app; however, there were a few features that I wish could have been implemented to make the app more user friendly, but were not able to be implemented due to the lack of time. Below are all of the feature that were originally planned and which ones made it into the final product. 

- [x] Visual display of current macro goals and remaining numbers for the day.
- [x] Ability to calculate recommended macros based on health goals (gain weight, lose weight, maintain weight). 
- [x] Ability to allow the user to insert specific values based on the meals they eat, that will calculate how many macros have been consumed during the day and how many macros are left, based on their goal.
- [x] Ability to save specific meals for future use based on a given macro name and numbers.
- [x] Ability to access saved meals. 
- [ ] Ability to recommend types of food to eat based on their diet.
- [ ] Ability to change the language of the app.
- [ ] An option that shows the macros of specific foods. Instead of the user having to google how many carbs, fats and
     proteins. 
- [ ] Macros reset daily, automatically


## Conclusions
&nbsp;&nbsp;&nbsp;&nbsp; Overall, I feel like the project could use a little more work. If I had another week to sit down and finish up some features I wanted to have, I would consider the project completely done. I believe that if I would've sat down and learned the "ins and outs" of Android Studio and Firebase, prior to writing code, the project would've gone a little more smoother. If I have time in the future, I would love to actually work on this more and maybe have an app that could be put on the market. 


## References

[1] [Android Studio](https://developer.android.com/studio/)

[2] [Firebase](https://firebase.google.com/)

[3] [Coding With Mitch](https://www.youtube.com/channel/UCoNZZLhPuuRteu02rh7bzsw)

[4] [Android Design](https://developer.android.com/design/)

[5] [Katch-McArdle](http://www.burnthefatinnercircle.com/members/Katch-McArdle-Calorie-Calculator-For-Men-And-Women.cfm)

