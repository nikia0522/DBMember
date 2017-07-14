--id, password, name, ssn, regdate
SELECT * FROM Member;--dml
SELECT * FROM Member WHERE name='홍길동';
SELECT COUNT(*) AS count FROM MEMBER;
INSERT INTO Member(id, name, password, ssn, regdate) VALUES ('cho1', '조현진', '1', '931119-2234567', SYSDATE);

UPDATE Member
SET name='홍길동'
WHERE id='brian'

