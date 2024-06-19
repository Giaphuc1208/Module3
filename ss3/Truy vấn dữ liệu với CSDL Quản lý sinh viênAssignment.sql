select * from student where studentName like 'h%';

select * from class where month(StartDate) = 12;

select * from subject where credit between 3 and 5;

SET SQL_SAFE_UPDATES = 0;
update student set ClassID = 2 where StudentName = 'Hung';
SET SQL_SAFE_UPDATES = 1;
select * from student;

SELECT student.StudentName, subject.SubName, mark.Mark
FROM student
JOIN mark ON student.StudentID = mark.StudentID
JOIN subject ON mark.SubID = subject.SubID
ORDER BY mark.Mark DESC, student.StudentName ASC