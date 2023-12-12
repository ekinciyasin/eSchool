
INSERT INTO users (id, username, password, first_name, last_name )
VALUES
    (30, 'teacher1', '$2a$10$uTsILOvTmcFL6.p5z4Hd9e0nHbktAl7PJILsNdd5/DIgYlf2eGJfG', 'John', 'Doe');

-- Inserting a teacher
INSERT INTO teacher (id, user_id, subject_taught)
VALUES
    (1,30, 'Mathematics');

INSERT INTO user_roles (user_id, role)
VALUES (30, 'ROLE_TEACHER');
