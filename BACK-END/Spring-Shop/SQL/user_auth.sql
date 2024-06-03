-- user_auth : 권한 테이블
DROP TABLE IF EXISTS `USER_AUTH` CASCADE;

CREATE TABLE `USER_AUTH` (
  `AUTH_NO` INT          NOT NULL AUTO_INCREMENT COMMENT '권한번호',
  `USER_ID` VARCHAR(100) NOT NULL                COMMENT '아이디',
  `AUTH`    VARCHAR(100) NOT NULL                COMMENT '권한 (ROLE_USER, ROLE_ADMIN, ...)',
PRIMARY KEY(AUTH_NO)                      
) COMMENT='회원_권한';


-- 기본 데이터
-- 사용자 
-- * 권한 : ROLE_USER
INSERT INTO USER_AUTH ( USER_ID,  AUTH )
VALUES ( 'user', 'ROLE_USER' );

-- 관리자
-- * 권한 : ROLE_USER, ROLE_ADMIN
INSERT INTO USER_AUTH ( USER_ID,  AUTH )
VALUES ( 'admin', 'ROLE_USER' );

INSERT INTO USER_AUTH ( USER_ID,  AUTH )
VALUES ( 'admin', 'ROLE_ADMIN' );