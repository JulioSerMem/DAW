CREATE TABLE t1 (
    id INT UNSIGNED PRIMARY KEY,
    datos VARCHAR(16)
);

CREATE TABLE t2 (
    id INT UNSIGNED
);

CREATE TABLE t3 (
    datos VARCHAR(16),
    id INT UNSIGNED
);

INSERT INTO t1 VALUES (1, 'A');
INSERT INTO t1 VALUES (2, 'B');
INSERT INTO t1 VALUES (30, 'C');

INSERT INTO t2 VALUES (10);
INSERT INTO t2 VALUES (20);
INSERT INTO t2 VALUES (3); 


DELIMITER $$
CREATE OR REPLACE PROCEDURE InsertarMenorID()
BEGIN
    DECLARE fin INT DEFAULT 0;
    DECLARE a VARCHAR(10);
    DECLARE b,c INT;

    DECLARE cur1 CURSOR FOR SELECT id, datos FROM t1;
    DECLARE cur2 CURSOR FOR SELECT id FROM t2;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;

    OPEN cur1;
    OPEN cur2;

    WHILE fin = 0 DO
        FETCH cur1 INTO b, a;
        FETCH cur2 INTO c;

        IF fin = 0 THEN
            IF b < c THEN
                INSERT INTO t3 VALUES (a, b);
            ELSE
                INSERT INTO t3 VALUES (a, c);    
            END IF;
        END IF;

    END WHILE;

    CLOSE cur1;
    CLOSE cur2;

END $$
DELIMITER ;
call InsertarMenorID();
SELECT * FROM t3;