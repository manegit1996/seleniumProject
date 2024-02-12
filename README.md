This project is designed to enable automated testing of specific functionalities within a web store, such as validating the login form and conducting end-to-end tests for the selected product's purchase process.

## Necessary tools to have on Your machine for starting the project:
- git
 - node
- Java JDK: Provided download link: (https://www.oracle.com/java/technologies/downloads/)
  (I recommend setting the "JAVA_HOME" environment variable to the path of the Java JDK installation (check with echo $JAVA_HOME))
- Eclipse IDE
- Apache Maven (I recommend setting the "MAVEN_HOME" environment variable to the path of the Maven installation)

## Installation tools:
- Open a new terminal and install **Homebrew** on iOS (if You don't have):
  ```
    /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   ```
- Install Maven using Homebrew:
    ```
    brew install maven
    ```
- Install the TestNG plugin in Your Eclipse IDE:
  Help -> Install new Software -> add -> location: https://testng.org/testng-eclipse-update-site/
    
## Steps for opening the project from github through eclipse IDE
- Run Eclipse IDE
- Right click import..
- Git -> Projects from Git(with smart import)
- Clone URI
- Copy HTTPS repository path
- Paste the path under URI
- Choose local destination directory
- Right click on imported project -> maven -> Update project..

## Execute the tests 
- Run  `testng.xml` in the project to execute the tests

- After executing the tests, under `extent.xml` will be created test cases reports.
- Also, under Screenshot folder will be created `screenshots` for invalid login


## Contact information:
Please feel free to contact me at manojlovic.nikola@yahoo.com if you encounter any difficulties running the project
