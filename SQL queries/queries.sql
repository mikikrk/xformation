SELECT co.name FROM XF.Country co JOIN XF.City ci ON (co.CountryID = ci.CountryID) GROUP BY co.name HAVING sum(ci.population)>400; 
SELECT DISTINCT co.name FROM XF.Country co JOIN XF.City ci ON (co.CountryID = ci.CountryID) RIGHT JOIN XF.Building b ON (ci.CityID = b.CityID);