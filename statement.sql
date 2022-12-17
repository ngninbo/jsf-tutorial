CREATE TABLE IF NOT EXISTS authors (id int PRIMARY KEY,
                                    name VARCHAR(25)
                                    );

INSERT INTO authors(id, name) VALUES(1, 'Rob Bal');
INSERT INTO authors(id, name) VALUES(2, 'John Carter');
INSERT INTO authors(id, name) VALUES(3, 'Chris London');
INSERT INTO authors(id, name) VALUES(4, 'Truman De Bal');
INSERT INTO authors(id, name) VALUES(5, 'Emile Capote');
INSERT INTO authors(id, name) VALUES(7, 'Breech Jabber');
INSERT INTO authors(id, name) VALUES(8, 'Bob Carter');
INSERT INTO authors(id, name) VALUES(9, 'Nelson Mand');
INSERT INTO authors(id, name) VALUES(10, 'Tennant Mark');

alter user user1 with password 'user1';

grant all on authors to user1;