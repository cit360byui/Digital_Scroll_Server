use scroll;

DROP TABLE IF EXISTS article;
CREATE TABLE article 
( id			INT PRIMARY KEY AUTO_INCREMENT
, author		VARCHAR(30) 	NOT NULL	DEFAULT 'anonymous'
, publish_date	DATE 			NOT NULL
, content		TEXT		 	NOT NULL
, image			VARCHAR(256)	NOT NULL
, headline		VARCHAR(50)		NOT NULL
, category		VARCHAR(30)		NOT NULL	DEFAULT 'general'
, active_flag	VARCHAR(1)		NOT NULL	DEFAULT 'Y'
);