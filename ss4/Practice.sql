use QuanLySinhVien;
SELECT * FROM quanlysinhvien.class;
insert into Class (ClassName, StartDate, Status)
values('C0224G1', '2024-02-28', 0),
	  ('C0324H1', '2024-05-20', 1);

SELECT * FROM quanlysinhvien.student;
insert into student (StudentName,Address,Phone,Status,ClassID)
values ('Gia Phuc', 'Da Nang', '0708123456', 0, 1),
		('Hong Quang','Ha Tinh','033123456',1,2),
        ('Truong Hoi','Hue','01233445566',1,2),
        ('Bao Ky','Hue','0100120202',1,2),
        ('Van Sy','Quang Nam','02020202000',1,1),
        ('Duong Nhat','Phu Yen','121231232',1,2),
        ('Trung Hieu','Quang Tri','121312312',1,2);
        
SELECT * FROM quanlysinhvien.subject;
insert into subject (SubName, Credit, Status)
values ('Java', 5,1),
	   ('PHP', 4, 0),
       ('MySQL', 3,1),
       ('Javascript', 3, 1);
       
SELECT * FROM quanlysinhvien.mark;
insert into mark (SubID, StudentID, Mark, ExamTimes)
	   values (4 , 1, 80.5, 1),
			  (1,2,65.8,1),
              (2,3,30,1);
              


-- Bước 1: Sử dụng hàm count để hiển thị số lượng sinh viên ở từng nơi
select Address, count(StudentID) as 'Số lượng học viên'
from student
group by Address;

-- Bước 2: Tính điểm trung bình các môn học của mỗi học viên bằng cách sử dụng hàm AVG
SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

-- Bước 3:  Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15
SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

SELECT S.StudentId,S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) > 15;

-- Bước 4: Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName;

SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);insert into mark (SubID, StudentID, Mark, ExamTimes)     values (4 , 1, 80.5, 1),      (1,2,65.8,1),               (2,3,30,1),               (1, 4, 75,1),               (3, 5, 100,1),               (4, 1, 30, 2),               (4, 6, 80, 1),               (1, 7, 80, 1)
