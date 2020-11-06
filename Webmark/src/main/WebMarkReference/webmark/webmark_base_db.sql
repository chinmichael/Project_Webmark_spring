DROP USER webmark CASCADE;

CREATE USER webmark IDENTIFIED BY kosea;

GRANT CONNECT, RESOURCE, DBA TO webmark;

GRANT CREATE SESSION TO webmark;

ALTER USER webmark ACCOUNT UNLOCK;

conn webmark/kosea;

CREATE TABLE accountwm (
	user_id		VARCHAR2(100)	NOT NULL,
	user_pw		CLOB		NOT NULL,
	user_name	VARCHAR2(100)	NOT NULL,
	user_nick		VARCHAR2(100)	NOT NULL,
	e_mail		VARCHAR2(200)	UNIQUE,
	user_type		CHAR(1)		DEFAULT '0'	CHECK(user_type IN ('0', '1')),
	/*user_avatar	BLOB,*/
	create_date	DATE		DEFAULT SYSDATE,
	reset_time	DATE,
	reset_key		VARCHAR2(4000),
	CONSTRAINT PK_accountwm		PRIMARY KEY(user_id)
);

CREATE TABLE saltwm (
	user_id		VARCHAR2(100)	PRIMARY KEY,
	e_mail		VARCHAR2(200)	NOT NULL,
	salt		VARCHAR2(4000)	NOT NULL,
	CONSTRAINT FK_saltwm1		FOREIGN KEY(user_id)	REFERENCES accountwm	ON DELETE CASCADE,
	CONSTRAINT FK_saltwm2		FOREIGN KEY(e_mail)	REFERENCES accountwm	ON DELETE CASCADE
);

CREATE TABLE category (
	cat_num		NUMBER		NOT NULL,
	user_id		VARCHAR2(100)	NOT NULL,
	cat_name		VARCHAR2(100)	NOT NULL, /*디폴트로 할 지 고민*/
	/*depth		NUBMER		DEFAULT 0, */
	/*upper_name	VARCHAR2(100),	*/
	CONSTRAINT PK_category		PRIMARY KEY(cat_num),
	CONSTRAINT FK_category		FOREIGN KEY(user_id)	REFERENCES accountwm	ON DELETE CASCADE
);

CREATE SEQUENCE category_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE urlwm (
	url_num		NUMBER		NOT NULL,
	cat_num		NUMBER		NOT NULL,
	url_address	CLOB		NOT NULL,
	url_name		VARCHAR2(100)	NOT NULL,  /*디폴트로 할 지 고민*/
	url_access	CHAR(1)		DEFAULT '0'	CHECK(url_access IN ('0', '1')),
	tag		VARCHAR2(1000),
	CONSTRAINT PK_urlwm		PRIMARY KEY(url_num),
	CONSTRAINT FK_urlwm		FOREIGN KEY(cat_num)	REFERENCES category	ON DELETE CASCADE
);

CREATE SEQUENCE urlwm_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE notice (
	notice_num	NUMBER		NOT NULL,
	user_id		VARCHAR2(100),
	notice_title	VARCHAR2(1000)	NOT NULL,
	notice_contents	CLOB,
	write_date	DATE		DEFAULT SYSDATE,
	notice_attach	CLOB,
	CONSTRAINT PK_noitce		PRIMARY KEY(notice_num),
	CONSTRAINT FK_notice		FOREIGN KEY(user_id)	REFERENCES accountwm	ON DELETE SET NULL
);

CREATE SEQUENCE notice_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE board (
	board_num	NUMBER		NOT NULL,
	user_id		VARCHAR2(100)	NOT NULL,
	board_title	VARCHAR2(1000)	NOT NULL,
	board_contents	CLOB,
	write_date	DATE		DEFAULT SYSDATE,
	board_attach	CLOB,
	CONSTRAINT PK_board		PRIMARY KEY(board_num),
	CONSTRAINT FK_board		FOREIGN KEY(user_id)	REFERENCES accountwm	ON DELETE CASCADE 
);

CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE commentwm (
	comment_num	NUMBER		NOT NULL,
	board_num	NUMBER		NOT NULL,
	user_id		VARCHAR2(100)	NOT NULL,
	comment_contents	CLOB		NOT NULL,
	write_date	DATE		DEFAULT SYSDATE,
	CONSTRAINT PK_commentwm	PRIMARY KEY(comment_num),
	CONSTRAINT FK_commentwm1	FOREIGN KEY(board_num)	REFERENCES board		ON DELETE CASCADE,
	CONSTRAINT FK_commentwm2	FOREIGN KEY(user_id)	REFERENCES accountwm	ON DELETE CASCADE
);

CREATE SEQUENCE commentwm_seq START WITH 1 INCREMENT BY 1;

COMMIT;