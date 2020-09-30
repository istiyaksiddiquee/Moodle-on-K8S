INSERT INTO t_audit(audit_id, user_id, affected_table, performed_operation, audit_msg)
VALUES(1, 1, 't_user', 'CREATE', 'Super user created');

INSERT INTO t_user(user_id, audit_id, first_name, last_name, user_name, email_id, password, address)
VALUES(1, 1, 'Istiyak', 'Siddiquee', 'istiyaksiddiquee', 'siddiquee@google.com', '123456', 'dummy address');