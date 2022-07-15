CREATE DATABASE IF NOT EXISTS tenantcatalog2;
CREATE TABLE IF NOT EXISTS tenantcatalog2.tenants (
   id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   tenant_id VARCHAR(255) NOT NULL UNIQUE,
   driver_class_name VARCHAR(255),
   url VARCHAR(255) NOT NULL,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   initialize BIT(1) NOT NULL,
   created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO tenantcatalog2.tenants (tenant_id, url,username, password, driver_class_name, initialize)
VALUES ("tenant_1", "jdbc:mysql://localhost:3306/db1", "root", "root", "com.mysql.cj.jdbc.Driver", true);
INSERT INTO tenantcatalog2.tenants (tenant_id, url,username, password, driver_class_name, initialize)
VALUES ("tenant_2", "jdbc:mysql://localhost:3306/db2", "root", "root", "com.mysql.cj.jdbc.Driver", true);

CREATE DATABASE IF NOT EXISTS db1;
CREATE DATABASE IF NOT EXISTS db2;

CREATE TABLE if not exists db1.products (
   id bigint PRIMARY KEY,
   name VARCHAR(255)
);
CREATE TABLE if not exists db2.products (
   id bigint PRIMARY KEY,
   name VARCHAR(255)
);
INSERT INTO db1.products VALUES (1,"abc");
INSERT INTO db2.products VALUES (1,"xyz");