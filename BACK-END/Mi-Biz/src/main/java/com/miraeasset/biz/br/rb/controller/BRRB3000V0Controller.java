package com.miraeasset.biz.br.rb.controller;

import com.fasoo.adk.packager.WorkPackager;
import com.miraeasset.biz.br.rb.service.BRRB3000V0Service;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0In00VO;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0In01VO;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0Out00VO;
import com.miraeasset.biz.br.rb.vo.BRRB3000V0Out01VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.PropertyUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/br/rb/3000")
public class BRRB3000V0Controller {
    private final BRRB3000V0Service brrb3000V0Service;
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public BRRB3000V0Controller(BRRB3000V0Service brrb3000V0Service) {
        this.brrb3000V0Service = brrb3000V0Service;
    }

    @ApiOperation(value = "매출추이 조회")
    @RequestMapping(value = "/revenue-trend/get", method = RequestMethod.POST)
    public List<BRRB3000V0Out01VO> getRevenueTrend(@RequestBody BRRB2000V0In01VO brrb2000V0In01VO) {
        return brrb3000V0Service.getRevenueTrend(brrb2000V0In01VO);
    }


    @ApiOperation(value = "매출추이 엑셀다운로드")
    @RequestMapping(value = "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getRevenueTrendExcel(BRRB2000V0In01VO brrb2000V0In01VO, HttpServletResponse response) throws IOException, InvalidFormatException {

        // 미구현: 프로퍼티 사용 안했음
        String oHomeDir;
        String strFld = "";
        String FASOO_ID = PropertyUtil.getProperty("FASOO_ID");
        String SECURITY_LEVEL = PropertyUtil.getProperty("SECURITY_LEVEL");

        if(PropertyUtil.getProperty("SYSTEM_NAME").equals("local")) {
            oHomeDir = PropertyUtil.getProperty("LOC_FASOO_PATH");
        } else {
            oHomeDir = PropertyUtil.getProperty("SEV_FASOO_PATH");
            strFld = "/";
        }

        /* [20231026] 클래스 경로 사용하던 것을 NAS로 변경 */
//        ClassPathResource classPathResource = new ClassPathResource("template/");
//        String classPathUrl = strFld + classPathResource.getURL().toString().replace("file:/", "");
        String classPathUrl;
        if(PropertyUtil.getProperty("SYSTEM_NAME").equals("local")) {
            classPathUrl = PropertyUtil.getProperty("LOC_DOWNLOAD_PATH") + "/template/";
        } else {
            classPathUrl = PropertyUtil.getProperty("SEV_DOWNLOAD_PATH") + "/template/";
        }


        String templateFileName = "BRRB3000V0ExcelDownloadTemplate.xlsx";
        String oSourceFile = classPathUrl + templateFileName;
//        oSourceFile = oSourceFile.replace("file:/", "");

        File src = new File(classPathUrl + "/temp/");
        if (!src.exists()) { src.mkdirs(); }

        String uuid = UUID.randomUUID().toString();
        String decryptFile = classPathUrl + "/temp/" + uuid + "_D.xlsx";
        String encryptFile = classPathUrl + "/temp/" + uuid + "_E.xlsx";


        try {
            WorkPackager fsa = new WorkPackager();
            boolean bret = fsa.DoExtract(oHomeDir, FASOO_ID, oSourceFile, decryptFile);
            System.out.println("oSourceFile: " + oSourceFile);
            System.out.println("result : " + bret);
            System.out.println("error_code : " + fsa.getLastErrorNum());
            System.out.println("error_val : " + fsa.getLastErrorStr());

            Workbook workbook = WorkbookFactory.create(new File(decryptFile));
            Sheet sheet = workbook.getSheetAt(0);

            // 데이터 획득
            List<BRRB3000V0Out01VO> serviceResult = this.getRevenueTrend(brrb2000V0In01VO);

            // 데이터 입력 - 시작 Row
            int startRownum = 1;

            for (BRRB3000V0Out01VO brrb3000V0Out01VO : serviceResult) {
                String basYm = "";
                int iBasM = 0;

                long rentalDepositInterest = 0;
                long rentalRentalFee = 0;
                long selfDepositInterest = 0;
                long selfRentalFee = 0;
                long summation = 0;

                try {
                    basYm = brrb3000V0Out01VO.getBasYm();
                    rentalDepositInterest = brrb3000V0Out01VO.getRentalDepositInterest().longValue();
                    rentalRentalFee = brrb3000V0Out01VO.getRentalRentalFee().longValue();
                    selfDepositInterest = brrb3000V0Out01VO.getSelfDepositInterest().longValue();
                    selfRentalFee = brrb3000V0Out01VO.getSelfRentalFee().longValue();
                    summation = brrb3000V0Out01VO.getSummation().longValue();

                    if (basYm.equals("합계")) {
                        iBasM = 13;
                    } else {
                        iBasM = Integer.parseInt(basYm.substring(4));
                    }

                    // log.info("########################[iBasM]: " + iBasM);
                    // log.info("########################[basYm]: " + basYm);
                    // log.info("########[rentalDepositInterest]: " + rentalDepositInterest);
                    // log.info("##############[rentalRentalFee]: " + rentalRentalFee);
                    // log.info("##########[selfDepositInterest]: " + selfDepositInterest);
                    // log.info("################[selfRentalFee]: " + selfRentalFee);
                    // log.info("####################[summation]: " + summation);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Row row = sheet.getRow(startRownum + iBasM);

                Cell cell0 = row.getCell(0);
                cell0.setCellValue(basYm);

                Cell cell1 = row.getCell(1);
                cell1.setCellValue(rentalDepositInterest);

                Cell cell2 = row.getCell(2);
                cell2.setCellValue(rentalRentalFee);

                Cell cell3 = row.getCell(3);
                cell3.setCellValue(selfDepositInterest);

                Cell cell4 = row.getCell(4);
                cell4.setCellValue(selfRentalFee);

                Cell cell5 = row.getCell(5);
                cell5.setCellValue(summation);

                // System.out.println("[" + i + "] INPUT");
            }


            // 다운로드 및 후처리
            workbook.setForceFormulaRecalculation(true);
            FileOutputStream fileOutputStream = new FileOutputStream(encryptFile);
            workbook.write(fileOutputStream);
            if (workbook != null) workbook.close();
            if (fileOutputStream != null) fileOutputStream.close();

            fsa.DoPackagingFsn2(oHomeDir, FASOO_ID, decryptFile, encryptFile,
                    oSourceFile,
                    "admin",
                    "관리자",
                    "test", "아무개", "001", "팀_1",
                    "test", "아무개", "001", "팀_1", SECURITY_LEVEL);

            // 미구현: 파일명 깨짐
            String downFileName = "매출추이_" + DateUtil.getDate() + ".xlsx";
            downFileName = URLEncoder.encode(downFileName, "UTF-8");
            response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
            DateUtil.setResponseDownload(response, downFileName, encryptFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            File delete_decryptFile = new File(decryptFile);
            File delete_encryptFile = new File(encryptFile);

            if (delete_decryptFile.exists()) {
                delete_decryptFile.delete();
            }
            if (delete_encryptFile.exists()) {
                delete_decryptFile.delete();
            }
        }

    }
}
