-- Active: 1716532364401@@127.0.0.1@3306@shop
-- user : 회원 테이블

DROP TABLE IF EXISTS `USER` CASCADE;

CREATE TABLE `USER` (
  `USER_ID`   VARCHAR(100) NOT NULL                          ,
  `PASSWORD`  VARCHAR(200) NOT NULL                          ,
  `NAME`      VARCHAR(100) NOT NULL                          ,
  `EMAIL`     VARCHAR(200)          DEFAULT NULL             ,
  `IMAGE`     VARCHAR(250)          DEFAULT NULL             ,
  `ENABLED`   INT                   DEFAULT 1                ,
  `CREATEDAT` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATEDAT` TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_ID`)
) COMMENT='회원';


-- 기본 데이터
-- NoOpPasswordEncoder - 암호화 없이 로그인
-- 사용자
INSERT INTO USER ( USER_ID, PASSWORD, NAME, EMAIL )
VALUES ( 'user', '123456', '사용자', 'user@mail.com' );

-- 관리자
INSERT INTO USER ( USER_ID, PASSWORD, NAME, EMAIL )
VALUES ( 'admin', '123456', '관리자', 'admin@mail.com' );

DELETE USER;


-- BCryptPasswordEncoder - 암호화 시
-- 사용자
INSERT INTO USER ( USER_ID, PASSWORD, NAME, EMAIL )
VALUES ( 'user', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '사용자', 'user@mail.com' );

-- 관리자
INSERT INTO USER ( USER_ID, PASSWORD, NAME, EMAIL )
VALUES ( 'admin', '$2a$12$TrN..KcVjciCiz.5Vj96YOBljeVTTGJ9AUKmtfbGpgc9hmC7BxQ92', '관리자', 'admin@mail.com' );