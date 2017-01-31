README 
## Technology ##
## Dependencies ##


* java JDK 8+ (tested with 1.8.0_102)
* Selenium 2.53.0
* junit 1.4.1
* Maven 3.3.9



The automation framework chosen for this project is a Page Object frame work which is an efficient automation strategy with reusability and maintenance as its core objectives.  The Page Object framework has 5 major components the Base Object, the Page object, Test object, the BaseTest and Configuration.

### What is this repository for? ###

This is a brief summary of the Page Object framework.  



The Base page object has 5 jobs, it initializes the selenium web driver, stores the variable for the base url, stores the native selenium actions, stores the code for explicit waits (the time that you want the test to wait for the next step) and lastly it handles exception errors. The base page in general handles processes that are common to all tests and if any of these components or elements on the web page under test change we have a centralized place to make the change once and indirectly updates all affected tests to the new version of the code.

The Page object is module specific and contains locators and behavior specific to a given module.  It uses methods from the Base page which normalizes the code that makes writing the code closer to natural english and an indirect benefit is less chances for syntax errors. 

The the Test page is the object that uses all the supporting page objects to validate the business process or acceptance criteria.  

The configuration file contains the environment information such as what browser to use, what testing environment to point to and its where the BrowserStack information is stored and accessed.  

### How do I get set up? ###

1. Install Maven 3.3.9
1. Install the most Resent version of java.
 

Setup maven:

* cd /usr/local/apache-maven/apache-maven-3.3.9/
* M2_HOME=/usr/local/apache-maven/apache-maven-3.3.9/
* export PATH=$M2:$PATH
* M2=$M2_HOME/bin

**RUN VIA BROWSERSTACK**
** mvn clean test -Dhost=browserstack**

**RUN TESTS VIA LOCAL CHROME**
**mvn clean test -Dbrowser=chrome**

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact