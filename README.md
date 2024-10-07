- 👋 Hi, I’m @meetshwethagit

<!---
meetshwethagit/meetshwethagit is a ✨ special ✨ repository because its `README.md` (this file) appears on your GitHub profile.
You can click the Preview link to take a look at your changes.
--->
# Password Generator Test Automation

This project automates the testing of the password generator at https://www.security.org/password-generator/ using Selenium WebDriver and TestNG.

## Prerequisites

- Java JDK 11 or higher
- Maven or Gradle (for dependency management)
- Chrome browser (version 95+)
- ChromeDriver (automatically managed via WebDriverManager)

## Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/meetshwethagit/meetshwethagit
2. Project Setup
•	Framework: Use a hybrid TestNG and Selenium WebDriver framework.
•	Languages: Java
•	Browsers: Use WebDriverManager to manage drivers for Chrome, Firefox, Edge.
•	Tools:
o	Maven for dependency management
o	TestNG for test execution
o	Selenium for web interaction

## Dependencies 
3.Dependencies

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.tests.centerfield2</groupId>
  <artifactId>RPasswordGeneratorFramework</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  <dependencies>
		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-server -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-server</artifactId>
			<version>3.141.59</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
		<dependency>
			<groupId>io.github.bonigarcia</groupId>
			<artifactId>webdrivermanager</artifactId>
			<version>5.7.0</version>
		</dependency>

		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.9.9</version>
		</dependency>
 </dependencies>
 
</project>

## Locators

Type	Value
Text 	Id = “password”
Button	Title = “Copy Password”
Button	Title = “Generate Password”
Bar	class='PasswordGenerator_pg_password_strength_bar__6L--n'
Number	Id = “passwordLength”
Range	id='passwordLengthRange'
checkbox	id='option-lowercase'
checkbox	Id=’option-uppercase’
checkbox	Id=’option-numbers’
checkbox	Id=’option-symbols’
Button	Title = ‘Copy Password’


1. Functional Tests (Happy Path)
•	Test 1: Generate Password with All Checkboxes Enabled
o	Steps:
1.	Select all checkboxes (uppercase, lowercase, numbers, symbols).
2.	Set password length to a valid value (e.g., 12).
3.	Click on "Generate Password."
4.	Verify that the password meets all the selected criteria.
•	Test 2: Generate Password with Only Uppercase and Lowercase Enabled
o	Steps:
1.	Enable uppercase and lowercase checkboxes, disable numbers and symbols.
2.	Set password length to a valid value (e.g., 10).
3.	Generate password and verify that it contains only uppercase and lowercase letters.
2. Edge and Negative Test Cases
•	Test 3: No Checkboxes Selected (Edge Case)
o	Steps:
1.	Disable all checkboxes (uppercase, lowercase, numbers, symbols).
2.	Try to generate a password.
3.	Verify that no password is generated or the appropriate error is displayed.
•	Test 4: Generate Password with Maximum Length (Edge Case)
o	Steps:
1.	Set the password length to the maximum allowed value (e.g., 100 characters).
2.	Enable all checkboxes.
3.	Generate password and verify the length is correct.
•	Test 5: Generate Password with Minimum Length (Edge Case)
o	Steps:
1.	Set the password length to 1.
2.	Enable all checkboxes.
3.	Generate password and verify the length is correct.
•	Test 6: Invalid Input for Password Length (Negative Test)
o	Steps:
1.	Input a non-numeric value (e.g., "abc") for the password length.
2.	Verify that the application handles invalid input gracefully with an error or message.
3. Cross-Browser Testing
•	Run the tests across multiple browsers (Chrome, Firefox, Edge).

**Out-scope :**
1.	Firefox, Edge browser will not be implemented as part of this release .
2.	Generator password strength will not be implemented as part of this release.
![image](https://github.com/user-attachments/assets/cbec9270-f506-48a0-87ae-c32ca1067860)





