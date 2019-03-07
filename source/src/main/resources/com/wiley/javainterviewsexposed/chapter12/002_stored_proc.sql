DELIMITER //

CREATE PROCEDURE annual_salary_raise (
   IN percent INT,
   OUT total_updated INT
)
BEGIN
  SELECT COUNT(*)
  INTO total_updated
  FROM salaries
  WHERE last_update_date < DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

  UPDATE salaries
  SET annual_salary = annual_salary * ((100 + percent) / 100),
      last_update_date = CURDATE()
  WHERE last_update_date < DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
END //


CREATE PROCEDURE annual_salary_raise_transactional   (
   IN percent INT,
   OUT total_updated INT
)
BEGIN
  START TRANSACTION;
  SELECT COUNT(*)
  INTO total_updated
  FROM salaries
  WHERE last_update_date < DATE_SUB(CURDATE(), INTERVAL 1 YEAR);

  UPDATE salaries
  SET annual_salary = annual_salary * ((100 + percent) / 100), last_update_date = CURDATE()
  WHERE last_update_date < DATE_SUB(CURDATE(), INTERVAL 1 YEAR);
  COMMIT;
END //

DELIMITER ;

