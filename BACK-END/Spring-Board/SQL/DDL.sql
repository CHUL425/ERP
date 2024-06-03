-- Active: 1715921971096@@127.0.0.1@3306@lecture
DROP TABLE IF EXISTS BOARD;

CREATE TABLE `BOARD` (
  `NO`       INT          NOT NULL AUTO_INCREMENT           ,
  `TITLE`    VARCHAR(100) NOT NULL                          ,
  `WRITER`   VARCHAR(100) NOT NULL                          ,
  `CONTENT`  TEXT                                           ,
  `REG_DATE` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPD_DATE` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `VIEWS`    INT          NOT NULL DEFAULT '0'              ,
  PRIMARY KEY (`NO`)
) COMMENT='게시판';

DROP TABLE IF EXISTS FILE;

CREATE TABLE `file` (
  `NO`           INT         NOT NULL AUTO_INCREMENT           ,
  `PARENT_TABLE` VARCHAR(45) NOT NULL                          ,
  `PARENT_NO`    INT         NOT NULL                          ,
  `FILE_NAME`    TEXT        NOT NULL                          ,
  `ORIGIN_NAME`  TEXT                                          ,
  `FILE_PATH`    TEXT        NOT NULL                          ,
  `FILE_SIZE`    INT         NOT NULL DEFAULT '0'              ,
  `REG_DATE`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPD_DATE`     TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FILE_CODE`    INT         NOT NULL DEFAULT '0'              ,         
  PRIMARY KEY (`NO`)
) COMMENT='파일';

DROP TABLE REPLY;

-- * 댓글 - 게시글(board)에 종속된 테이블
CREATE TABLE REPLY (
    NO        INT          NOT NULL AUTO_INCREMENT PRIMARY KEY, -- 댓글번호
    BOARD_NO  INT          NOT NULL                           , -- 글번호
    PARENT_NO INT          NOT NULL                           , -- 부모번호
    WRITER    VARCHAR(100) NOT NULL                           , -- 작성자
    CONTENT   TEXT         NOT NULL                           , -- 내용
    REG_DATE  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP , -- 등록일자
    UPD_DATE  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP , -- 수정일자
    -- ⭐외래키 지정
    FOREIGN KEY (BOARD_NO) REFERENCES BOARD(NO) 
                           ON DELETE CASCADE  -- CASCADE, RESTRICT, SET NULL
                           ON UPDATE CASCADE 
) COMMENT='댓글';


-- BOARD, FILE 테이블 조인 조회
SELECT B.*
     , F.NO FILE_NO
     , F.FILE_NAME
     , F.FILE_PATH
     , F.FILE_CODE
  FROM BOARD B LEFT JOIN (SELECT *
                            FROM FILE
                           WHERE PARENT_TABLE = "BOARD"
                             AND FILE_CODE = 1          # FILE_CODE = 1 (대표 썸네일)
                         ) F
                    ON (B.NO = F.PARENT_NO)
;

-- 테이블 데이터 전체 삭제
TRUNCATE BOARD;
TRUNCATE FILE;
TRUNCATE REPLY;

INSERT INTO BOARD( TITLE, WRITER, CONTENT ) 
VALUES ('제목01','작성자01','내용01')
      ,('제목02','작성자02','내용02')
      ,('제목03','작성자03','내용03')
      ,('제목04','작성자04','내용04')
      ,('제목05','작성자05','내용05')

INSERT INTO BOARD (TITLE, WRITER, CONTENT)
SELECT TITLE, WRITER, CONTENT
FROM BOARD
;

-- 댓글 샘플 데이터
-- 글번호 : 273
INSERT INTO REPLY (BOARD_NO, PARENT_NO, WRITER, CONTENT)
VALUES ( 3, 0, '김조은', '댓글 내용1')
      ,( 3, 0, '김조은', '댓글 내용2')
      ,( 3, 0, '김조은', '댓글 내용3')
      ,( 3, 0, '김조은', '댓글 내용4')
      ,( 3, 0, '김조은', '댓글 내용5')
;


-- 게시글 목록 페이징
SELECT *
FROM BOARD
LIMIT #{index}, #{rows}
;

SELECT * FROM BOARD;

-- 게시글 목록 검색
SELECT * 
FROM BOARD
WHERE TITLE LIKE '%검색어%'
   OR WRITER LIKE '%검색어%'
   OR CONTENT LIKE '%검색어%'
;

-- 게시글 목록 - [검색] + [페이징]
SELECT * 
FROM BOARD
WHERE TITLE LIKE '%고양이%'
LIMIT 0, 10
;

-- 파일 조회
SELECT * FROM FILE;

-- 
SELECT *
FROM REPLY
WHERE BOARD_NO = 273;

-- 댓글 (reply) 테이블에 외래키 추가
ALTER TABLE REPLY
ADD CONSTRAINT FK_REPLY_BOARD_NO
FOREIGN KEY (BOARD_NO)
REFERENCES BOARD(NO)
ON DELETE CASCADE       -- 게시글 삭제 시, 종속된 댓글 삭제
;


-- 글번호 :279
SELECT * FROM BOARD WHERE NO = 3; 

-- 281번 글의 댓글
SELECT * 
FROM REPLY
WHERE BOARD_NO = 3;