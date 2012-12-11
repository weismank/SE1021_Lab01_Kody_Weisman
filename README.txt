Background
As many of you may know, twitter.com has become a popular communication tool for some. A post on twitter is called a tweet. A couple years ago I overheard some of my students lamenting that they couldn't toot instead of tweet. Since they were lazy students, I figured it was up to me to make this happen, and t00ter was born.

Details
ArrayList Requirement
This assignment is meant as a review of material covered in SE1011. You are required to use at least one ArrayList object.

Accessing the .jar File
For this assignment, you will need to make use of the lab1.jar file which contains two classes: T00t and T00ter classes.

In order to be able to access the classes in the .jar file:

Download the lab1.jar file and save it somewhere on your computer where you can find it.
Right-click on the project name in the Package Explorer and select Properties.
Select Java Build Path from the list on the left.
Click on the Libraries tab.
Then click on Add External JARs...
Browse the the location of the lab1.jar file and open it.
Click OK
Basic Program Flow
In addition, you'll need to create one class called Lab1 which should be in a package named the same as your MSOE username (e.g., taylor). Note: Do not place all of the functionality for your program in main. Prior to coding, decide on how you plan to encapsulate functionality into multiple methods. This class must contain your program that makes use of the T00t and T00ter classes to do the following:

Ask the user to enter 0, 1, or 2. If the user enters anything other than one of those three options, the program should reprompt the user to enter one of the three options (it should continue to do this forever).
If the user enters 0, then the program should exit.
If the user enters 1, then the program should use a T00ter object to get the most recent toots and display a number of statitics (see below) for them. Once this has been completed, the program should return to the prompt which asks the user to enter 0, 1, or 2.
If the user enters 2, then the program should prompt the user to enter a username and then use a T00ter object to get the most recent toots for that user (if the user exists) and display a number of statitics (see below) for them. Once this has been completed, the program should return to the prompt which asks the user to enter 0, 1, or 2.
Statistics
The program should display the following statistics related to the returned toots:

Total number of toots returned,
Number of toots containing " toot " (with any capitalization and allowing zero (0) in place of oh (o), e.g., "to0t" should be counted too)
Length of the longest toot
Length of the shortest toot
Average length of toots
Minimum time span between two toots*
Maximum time span between two toots*
* Submissions without functionality for the last two are encouraged; however, such submissions will receive an AB grade at best.

Acknowledgment
This laboratory assignment was developed by Dr. Chris Taylor.