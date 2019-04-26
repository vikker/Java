Example of using maven, logback,  slf4j for building and logging a project.

Task for the project.
Create a Java application calculator which includes the following functionality:
1. The project is built using maven.
2. The application must be a jar file.
3. The application should write from 10 logs with priorities from info to error
(It is assumed that when the application is launched, information is recorded in the log that the application has started, displays the version, name, etc. When it is completed, information about the completion of the execution. There should not be one log in one method for the entire application)
4. You must use logback + slf4j
5. All logs should be in the / logs folder relative to the jar file.
6. Split log files:
● Logs with priority info - written only to the console
● warn priority logs — written only to a file called warning.log
● Logs with error priority - are written only to a file called error.log
7. Limit the maximum size of log files to 1 MB.

When starting the program, the following arguments will be passed through the environment variables:
number1 number2 operator

Examples of operands:
100 -100 +

The program should display the following message in the console and end:
number1 = 100 number2 = -100 operator = + result = 0
