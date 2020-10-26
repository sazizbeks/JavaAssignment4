CREATE TABLE BOOKS(
    ISBN VARCHAR(32) PRIMARY KEY,
    NAME VARCHAR(255),
    AUTHOR VARCHAR(255),
    COUNT_OF_COPY INT
);

CREATE TABLE READERS(
    ID INT PRIMARY KEY,
    FNAME VARCHAR(255),
    LNAME VARCHAR(255)
);

CREATE TABLE READERS_BOOKS(
    READER_ID INT REFERENCES READERS(ID),
    BOOK_ISBN VARCHAR(32) REFERENCES BOOKS(ISBN)
);


INSERT INTO READERS(ID, FNAME, LNAME)
VALUES
(1, 'Azizbek', 'Seitmagambetov'),
(2, 'Ibragim', 'Kuanyshbay'),
(3, 'Ayan', 'Sultan');

INSERT INTO books(ISBN, NAME, AUTHOR, COUNT_OF_COPY)
VALUES
('978-5-367-00490-8', 'A Brief History of Time Paperback', 'Stephen Hawking', 10),
('0-670-81302-8','It','Stephen King', 20),
('978-5496025416','Grokaem algoritmy. Illyustrirovannoe posobie dlya programmistov i lyubopytstvuyuschih', 'Aditya Bhargava', 50);