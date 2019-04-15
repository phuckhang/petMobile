Hello, this is a test project which is made by Phuc Khang.

1. In order to run the test, make sure the environments below are available:
- Install Java
- Install Maven
Refer: https://www.mkyong.com/maven/how-to-install-maven-in-windows/

2. Run automation test:
- Go to project's root folder which contains source code
	* Use following command line to run:
	    + By default, running on chrome: mvn clean test
            + Run on firefox: mvn -Dbrowser.name=firefox clean test

3. To see a report after running test:
- The test report is in following folder: ./src/test/java/reports/ExtentReport.html
	+ Open ExtentReport.html to see the report.



