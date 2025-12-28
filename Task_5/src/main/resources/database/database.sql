DROP TABLE IF EXISTS students;

CREATE TABLE students (
                          id INTEGER PRIMARY KEY AUTOINCREMENT,
                          record_book_number TEXT NOT NULL UNIQUE,
                          last_name TEXT NOT NULL,
                          first_name TEXT NOT NULL,
                          patronymic TEXT NOT NULL,
                          birth_date TEXT NOT NULL
);

INSERT INTO students (record_book_number, last_name, first_name, patronymic, birth_date) VALUES
                                                                                             ('RB001','Shevchenko','Ivan','Ivanovych','2004-01-15'),
                                                                                             ('RB002','Koval','Olena','Petrivna','2003-02-03'),
                                                                                             ('RB003','Melnyk','Taras','Andriyovych','2005-03-21'),
                                                                                             ('RB004','Bondarenko','Iryna','Ivanivna','2004-04-09'),
                                                                                             ('RB005','Tkachenko','Maksym','Serhiyovych','2003-05-28'),
                                                                                             ('RB006','Kravchenko','Sofia','Olehivna','2004-07-02'),
                                                                                             ('RB007','Romanenko','Danylo','Viktorovych','2005-07-19'),
                                                                                             ('RB008','Polishchuk','Kateryna','Andriyivna','2004-08-11'),
                                                                                             ('RB009','Boyko','Artem','Mykolayovych','2003-08-25'),
                                                                                             ('RB010','Moroz','Alina','Serhiyivna','2004-09-05'),
                                                                                             ('RB011','Marchenko','Nazar','Olehivych','2005-09-17'),
                                                                                             ('RB012','Sydorenko','Yulia','Ivanivna','2003-10-01'),
                                                                                             ('RB013','Lysenko','Bohdan','Petrovych','2004-10-22'),
                                                                                             ('RB014','Savchenko','Anastasia','Romanivna','2005-11-09'),
                                                                                             ('RB015','Rudenko','Mykhailo','Andriyovych','2003-11-30'),
                                                                                             ('RB016','Pavlenko','Vladyslav','Serhiyovych','2004-12-12'),
                                                                                             ('RB017','Hrytsenko','Oksana','Mykhaylivna','2005-12-27'),
                                                                                             ('RB018','Kozak','Illia','Olehivych','2004-01-29'),
                                                                                             ('RB019','Zaitsev','Polina','Pavlivna','2003-02-14'),
                                                                                             ('RB020','Bila','Denys','Ivanovych','2005-03-07');