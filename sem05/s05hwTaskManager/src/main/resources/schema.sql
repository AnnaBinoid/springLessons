CREATE TABLE tasks (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(255) NOT NULL,
    task_status ENUM('BEFORE_START', 'IN_PROGRESS', 'COMPLETED'),
    task_create_date TIMESTAMP
);