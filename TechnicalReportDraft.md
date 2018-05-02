**Matts Macros**
**Matthew Glynn**
**May 5, 2018**

### Abstract
&nbsp;&nbsp;&nbsp;&nbsp; Currently, the problem that lies within apps that help users keep track of macros, is the lack of user friendliness. Each app, does a good job highlighting certain aspects of what the app should include; however, not one has perfected every aspect of the app that will allow ease of use for the user. The goal of this project is to provide the user with the most ergonomic macros app possible.


### Table of Contents
#### Introduction
#### Design, Development and Test
#### Results
#### Conclusions
#### References


### Introduction and Product Overview
&nbsp;&nbsp;&nbsp;&nbsp; What are macronutrients, otherwise known as macros? Macronutrients are the largest class of nutrients the body requires and is made up of proteins, carbohydrates, and fats. These three factors make up calories, per gram of protein and carbohydrates make up 4 calories and per gram of fat makes up 9 calories. The amounts and ratio of macronutrients a person need vary depending on age, gender, lifestyle and health goals. It is a lot easier for an individual to achieve goals by keeping track of their macros rather than calories as a whole.  

&nbsp;&nbsp;&nbsp;&nbsp; Currently, there are plenty of macros apps on the market that help individuals keep track of daily macros. However, it's rare to find an app that utilizes each feature to its full potential making it less user friendly. "Matts Macros" is an android app that provides the essential features for an individual to keep track of daily macros, along with making them user friendly. Features in this app include:

&nbsp;&nbsp;&nbsp;&nbsp; •	Visual display of current macro goals and remaining numbers for the day.   
&nbsp;&nbsp;&nbsp;&nbsp; •	Ability to calculate recommended macros based on health goals (gain weight, lose weight, maintain weight).   
&nbsp;&nbsp;&nbsp;&nbsp; •	Ability to allow the user to insert specific values based on the meals they eat, that will calculate how many macros  
&nbsp;&nbsp;&nbsp;&nbsp; have been consumed during the day and how many macros are left, based on their goal.   
&nbsp;&nbsp;&nbsp;&nbsp; •	Ability to save specific meals for future use based on a given name and macro numbers.  
&nbsp;&nbsp;&nbsp;&nbsp; •	Ability to access saved meals. 

### Design, Development and Test
&nbsp;&nbsp;&nbsp;&nbsp; The design of the project consist of two components, the database and the Android application. The database is a cloud-hosted database on Firebase. Data is stored as JSON and synchronized in realtime to every connected client. The application is composed of four activities.

&nbsp;&nbsp;&nbsp;&nbsp;    The database keeps track of all information for the user, including macro goals, daily macros and saved meals. The application saves information into the datbase and also reads information from the database. An example of an individuals information that is store in the databse can be seen below in figure 1. 

![Database Photo](https://github.com/glynnmd/CapstoneProject/blob/master/Database.png)

**figure 1**

&nbsp;&nbsp;&nbsp;&nbsp; As for the application, previously mentioned, it is composed of four activities. The main activity gives the user a visual representation of the macro goals they have set in place and a progress bar that gives them an idea of their remaining macros. The second activity allows the user to obtain their macro goals based on their age, height, weight, lifestyle and goal. The algorithm used to calculate the individuals macros is based on the Katch-McArdle equation, which is considered more accurate than other common formulas. The thrid activity allows the user to save food for future use. Values are inserted based on a given name and corresponding macro values. The final activity consist of two tabs. The first tab allows users to insert values that will increase their daily value; this will change the display on the main activity, increasing the progress bars. Furthermore, the second tab in the activity gives the user a list of saved meals that was inserted into the database. 

### Results
&nbsp;&nbsp;&nbsp;&nbsp; Initially the project had much more features; however, more problems occured than expected. One major problem included the lack of knowledge in Android Studio. The first few weeks were spent learning the basics of Android Studio. After that, the biggest issue was reading and writing from the database. The documentation for Firebase was hard to read and not informative to an individual who has never worked with Firebase before. Once all the components that wrote to the database were completed, the next challenge was to read that information and display it in the app. 


### Conclusions
&nbsp;&nbsp;&nbsp;&nbsp; Hello


### References
&nbsp;&nbsp;&nbsp;&nbsp; Hello 

