CREATE TABLE BOOKS(
    ISBN VARCHAR(32) PRIMARY KEY,
    NAME VARCHAR(255),
    AUTHOR VARCHAR(255),
    COUNT_OF_COPY INT,
    IMG_URL TEXT
);

CREATE TABLE READERS(
    IIN VARCHAR(12) PRIMARY KEY,
    FNAME VARCHAR(255),
    LNAME VARCHAR(255)
);

CREATE TABLE READERS_BOOKS(
    READER_IIN VARCHAR(13),
    BOOK_ISBN VARCHAR(32),
    CONSTRAINT fk_reader_iin FOREIGN KEY (READER_IIN) REFERENCES READERS(IIN),
    CONSTRAINT fk_book_isbn FOREIGN KEY(BOOK_ISBN) REFERENCES BOOKS(ISBN)
);


INSERT INTO READERS(IIN, FNAME, LNAME)
VALUES
('010425550130', 'Azizbek', 'Seitmagambetov'),
('020727550967', 'Ibragim', 'Kuanyshbay'),
('020429550471', 'Ayan', 'Sultan');

INSERT INTO books(ISBN, NAME, AUTHOR, COUNT_OF_COPY, IMG_URL)
VALUES ('978-5-367-00490-8', 'A Brief History of Time Paperback', 'Stephen Hawking', 10,'https://images-na.ssl-images-amazon.com/images/I/51+GySc8ExL._SY344_BO1,204,203,200_.jpg' ),
('0-670-81302-8','It','Stephen King', 20,'https://images-na.ssl-images-amazon.com/images/I/41MnBgdydDL._SX323_BO1,204,203,200_.jpg' ),
('978-5496025416','Grokaem algoritmy', 'Aditya Bhargava', 50, 'https://cdn.f.kz/prod/815/814376_550.jpg')
