# xformation

1st task:
Answer for 1st task can be found in Food Ordering directory.
In order to run it, it has to be build with Apache Maven, which generates executable jar file.
In order to add some data to Food Ordering System, add apropriate insert queries to "Food Ordering\src\main\resources\initial_data.sql" file before building project.

2nd task:
Answer for second question is:
	1. SELECT co.name FROM XF.Country co JOIN XF.City ci ON (co.CountryID = ci.CountryID) GROUP BY co.name HAVING sum(ci.population)>400; 
	2. SELECT DISTINCT co.name FROM XF.Country co JOIN XF.City ci ON (co.CountryID = ci.CountryID) RIGHT JOIN XF.Building b ON (ci.CityID = b.CityID);

it can be also found in sql file in directory SQL queries.

3rd task:
Answer for 3rd task can be found in directory MineSweeper.
There are prepared unit tests which can be run by command mvn test. Test content can be found in MineSweeper\src\test\java\com\xformation\task3\MineSweeperTest.java file.
