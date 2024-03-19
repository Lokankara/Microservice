CREATE TABLE department
(
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(255),
    manager_id      INT,
    FOREIGN KEY (manager_id) REFERENCES Employee (employeeid)
);

INSERT INTO Department (department_id, department_name, manager_id)
VALUES (1, 'Sales Manager', 2),
       (2, 'IT Manager', 6),
       (3, 'General Manager', 1);


SELECT TABLE_NAME, COLUMN_NAME
FROM information_schema.COLUMNS
WHERE COLUMN_NAME LIKE '%vendor%'
