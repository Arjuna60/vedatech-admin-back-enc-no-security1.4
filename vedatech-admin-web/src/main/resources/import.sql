
-- INSERT INTO  accounting_type (id, name, account, balance ) VALUES ('1', 'Caja', '1010001', 6000.25);
-- INSERT INTO  accounting_type (id, name, account, balance ) VALUES ('2', 'Bancos Nacionales', '1010003', 10000.25);

-- INSERT INTO  sub_account (id, name_account, account_number, balance, account_type_id ) VALUES ('1', 'Banorte AXE','101000101', 5000.00, 2);
-- INSERT INTO  sub_account (id, name_account, account_number, balance, account_type_id ) VALUES ('2', 'Santander','101000102', 5000.00, 2);
-- INSERT INTO  sub_account (id, name_account, account_number, balance, account_type_id ) VALUES ('3', 'Scotiank Bank','101000103', 5000.00, 2);




-- INSERT INTO  account_policy (id, concept, credit, debit, balance, sub_account_id ) VALUES ('1', 'Comisiones', 100.25, 0.00, 5000.00, 1);



-- INSERT INTO banks (id, name_bank, account_number, balance, sub_account_id) VALUES('1', 'Banorte', '049051913', '10000.50', 1);
-- INSERT INTO banks (id, name_bank, account_number, balance, sub_account_id) VALUES('2', 'Santander', '989999455', '10000.50', 1);




/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');





