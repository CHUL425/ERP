-- 입출고 테이블
DROP TABLE IF EXISTS `PRODUCT_IO` CASCADE;

CREATE TABLE `PRODUCT_IO` (
  `IO_NO`      INT          NOT NULL AUTO_INCREMENT            COMMENT '입출고번호',
  `PRODUCT_ID` VARCHAR(100) NOT NULL                           COMMENT '상품아이디',
  `ORDER_NO`   INT                   DEFAULT  NULL             COMMENT '주문번호',
  `AMOUNT`     INT                   DEFAULT  NULL             COMMENT '입출고량',
  `TYPE`       VARCHAR(100)          DEFAULT NULL              COMMENT '입고(IN),출고(OUT)',
  `IO_DATE`    TIMESTAMP    NULL     DEFAULT CURRENT_TIMESTAMP COMMENT '입출고날짜',
  `USER_ID`    VARCHAR(10)           DEFAULT NULL              COMMENT '회원아이디',
  PRIMARY KEY (`IO_NO`),
  KEY `PRODUCT_ID_FK` (`PRODUCT_ID`),
  KEY `PRODUCT_ID_FK_1` (`ORDER_NO`),
  CONSTRAINT `PRODUCT_ID_FK` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `PRODUCT` (`PRODUCT_ID`),
  CONSTRAINT `ORDER_NO_FK` FOREIGN KEY (`ORDER_NO`) REFERENCES `ORDER` (`ORDER_NO`)
) COMMENT='상품 입출고';


INSERT INTO `product_io`(`PRODUCT_ID`, `ORDER_NO`, `AMOUNT`, `TYPE`, `USER_ID`)
                 VALUES ('P100001', 1, 1000, 'OUT', 'joeun');

INSERT INTO `product_io`(`PRODUCT_ID`, `ORDER_NO`, `AMOUNT`, `TYPE`, `USER_ID`)
                 VALUES ('P100002', 1, 1000000, 'OUT', 'joeun');

