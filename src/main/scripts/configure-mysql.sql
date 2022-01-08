CREATE DATABASE spring_recipes_dev;
CREATE DATABASE spring_recipes_prod;

CREATE USER 'spring_recipes_dev_user'@'localhost' IDENTIFIED BY 'mihailo';
CREATE USER 'spring_recipes_prod_user'@'localhost' IDENTIFIED BY 'mihailo';

GRANT SELECT ON spring_recipes_dev.* to 'spring_recipes_dev_user'@'localhost';
GRANT INSERT ON spring_recipes_dev.* to 'spring_recipes_dev_user'@'localhost';
GRANT DELETE ON spring_recipes_dev.* to 'spring_recipes_dev_user'@'localhost';
GRANT UPDATE ON spring_recipes_dev.* to 'spring_recipes_dev_user'@'localhost';
GRANT SELECT ON spring_recipes_prod.* to 'spring_recipes_prod_user'@'localhost';
GRANT INSERT ON spring_recipes_prod.* to 'spring_recipes_prod_user'@'localhost';
GRANT DELETE ON spring_recipes_prod.* to 'spring_recipes_prod_user'@'localhost';
GRANT UPDATE ON spring_recipes_prod.* to 'spring_recipes_prod_user'@'localhost';