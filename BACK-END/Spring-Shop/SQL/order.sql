-- Active: 1716532364401@@127.0.0.1@3306@shop
-- 주문 테이블
DROP TABLE IF EXISTS `ORDER` CASCADE;
CREATE TABLE `ORDER` (
  `ORDER_NO`    INT          NOT NULL AUTO_INCREMENT COMMENT '주문번호'    ,
  `SHIP_NAME`   VARCHAR(100) NOT NULL                COMMENT '받는사람이름',
  `ZIP_CODE`    VARCHAR(100) NOT NULL                COMMENT '우편번호',
  `COUNTRY`     VARCHAR(100) NOT NULL                COMMENT '국가',
  `ADDRESS`     VARCHAR(200) NOT NULL                COMMENT '주소',
  `DATE`        VARCHAR(200) NOT NULL                COMMENT '배송일자',
  `ORDER_PW`    VARCHAR(200) NULL                    COMMENT '주문 비밀번호',
  `USER_ID`     VARCHAR(10)           DEFAULT NULL   COMMENT '회원아이디',
  `TOTAL_PRICE` INT                   DEFAULT 0      COMMENT '총가격',
  `PHONE`       VARCHAR(20)           DEFAULT NULL   COMMENT '비회원 전화번호',
  PRIMARY KEY (`ORDER_NO`)
) COMMENT='주문';

