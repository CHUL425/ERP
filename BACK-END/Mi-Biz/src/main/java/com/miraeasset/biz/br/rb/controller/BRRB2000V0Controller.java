package com.miraeasset.biz.br.rb.controller;

import com.fasoo.adk.packager.WorkPackager;
import com.miraeasset.biz.br.rb.service.BRRB2000V0Service;
import com.miraeasset.biz.br.rb.service.BRRB3000V0Service;
import com.miraeasset.biz.br.rb.service.BRRB4000V0Service;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0In00VO;
import com.miraeasset.biz.br.rb.vo.BRRB2000V0Out00VO;
import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.PropertyUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/br/rb/2000")
public class BRRB2000V0Controller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final BRRB2000V0Service brrb2000V0Service;
    private final BRRB3000V0Service brrb3000V0Service;
    private final BRRB4000V0Service brrb4000V0Service;


    public BRRB2000V0Controller(BRRB2000V0Service brrb2000V0Service, BRRB3000V0Service brrb3000V0Service, BRRB4000V0Service brrb4000V0Service) {
        this.brrb2000V0Service = brrb2000V0Service;
        this.brrb3000V0Service = brrb3000V0Service;
        this.brrb4000V0Service = brrb4000V0Service;
    }

    @ApiOperation(value = "사옥임대손익현황 전체 조회")
    @RequestMapping(value = "/office-rental-pl-status/get", method = RequestMethod.POST)
    public BRRB2000V0Out00VO getOfficeRentalPLStatus(@RequestBody BRRB2000V0In00VO brrb2000V0In00VO) {
        return brrb2000V0Service.getOfficeRentalPLStatus(brrb2000V0In00VO);
    }

    @ApiOperation(value = "사옥임대손익현황 건별 획득 API")
    @RequestMapping(value = "/office-rental-pl-status/get/value", method = RequestMethod.POST)
    public List<BRRB2000V0Out00VO> getOfficeRentalPLStatusValue(@RequestBody BRRB2000V0In00VO brrb2000V0In00VO) {
        List<BRRB2000V0Out00VO> result = new ArrayList<>();

        BigDecimal sumA = null;

        // 3000
        int index = 0;
        result.add(brrb3000V0Service.getDepositInterest(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getRentalSalesTaxInvoice(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getRentalSalesInvoice(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getRentalParkingFee(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getSelfBranchDepositInterest(brrb2000V0In00VO));
        result.add(brrb3000V0Service.getSelfBranchLeaseFee(brrb2000V0In00VO));
        sumA = BigDecimal.valueOf(0);
        for(int i = index; i < result.size(); i++) {
            sumA = sumA.add(result.get(i).getSumA());
        }
        BigDecimal sumRevenue = sumA;
        result.add(new BRRB2000V0Out00VO(0, 0, "매출합계", sumRevenue));

        // 4000
        index = result.size();
        result.add(brrb4000V0Service.getPropertyTax(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getOtherTaxesAndDuties(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getEstateTax(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getRoadOccupationFee(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getTrafficInducedBurdenFee(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getCorporateEqualResidentTax(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getHeatingFuelExpense(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getElectricityBill(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getWaterBill(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getGeneralFee(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getOfficeAdministrationExpense(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getConsumableExpense(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getBuildingRepairExpense(brrb2000V0In00VO));
        result.add(brrb4000V0Service.getMaintenanceFee(brrb2000V0In00VO));
        sumA = BigDecimal.valueOf(0);
        for(int i = index; i < result.size(); i++) {
            sumA = sumA.add(result.get(i).getSumA());
        }
        BigDecimal sumExpense = sumA;
        result.add(new BRRB2000V0Out00VO(0, 0, "비용합계", sumExpense));


        BigDecimal profitLoss = sumRevenue.subtract(sumExpense);
        result.add(new BRRB2000V0Out00VO(0, 0, "매출-비용", profitLoss));

        return result;
    }


    @ApiOperation(value = "사옥임대손익현황 엑셀다운로드")
    @RequestMapping(value = "/excel", method = RequestMethod.POST, consumes = "multipart/form-data")
    public @ResponseBody void getOfficeRentalPLStatusExcel(BRRB2000V0In00VO brrb2000V0In00VO, HttpServletResponse response) throws IOException, InvalidFormatException {

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


        String templateFileName = "BRRB2000V0ExcelDownloadTemplate.xlsx";
        String oSourceFile = classPathUrl + templateFileName;
//        oSourceFile = oSourceFile.replace("file:/", "");

        File src = new File(classPathUrl + "/temp/");
        if (!src.exists()) { src.mkdirs(); }

        String uuid = UUID.randomUUID().toString();
        String decryptFile = classPathUrl + "/temp/" + uuid + "_D.xlsx";
        String encryptFile = classPathUrl + "/temp/" + uuid + "_E.xlsx";

        try {
            WorkPackager fsa = new WorkPackager();
            // boolean iret = fsa.IsSupportFile(oHomeDir, FASOO_ID, oSourceFile);
            // log.info("iret: " + iret);
            // log.info(" === fsa.DoExtract 진행 === ");
            boolean bret = fsa.DoExtract(oHomeDir, FASOO_ID, oSourceFile, decryptFile);
            log.info("oSourceFile: " + oSourceFile);
            log.info("result : " + bret);
            log.info("error_code : " + fsa.getLastErrorNum());
            log.info("error_val : " + fsa.getLastErrorStr());

            Workbook workbook = WorkbookFactory.create(new File(decryptFile));
            Sheet sheet = workbook.getSheetAt(0);

            // 데이터 획득
            List<BigDecimal> dataList = new ArrayList<>();
            List<BRRB2000V0Out00VO> serviceResult = this.getOfficeRentalPLStatusValue(brrb2000V0In00VO);
            for(BRRB2000V0Out00VO brrb2000V0Out00VO : serviceResult) {
                dataList.add(brrb2000V0Out00VO.getSumA());
            }

            // 데이터 입력
            int startRownum = 1;
            int targetCellnum = 3;

            System.out.println("[LENGTH]: " + dataList.size());
            for (int i = 0; i < dataList.size(); i++) {
                Row row = sheet.getRow(i+startRownum);
                Cell cell = row.getCell(targetCellnum);
                cell.setCellValue(dataList.get(i).doubleValue());
                System.out.println("[" + i + "] INPUT" );
            }


            // 다운로드 및 후처리
            workbook.setForceFormulaRecalculation(true);
            FileOutputStream fileOutputStream = new FileOutputStream(encryptFile);
            workbook.write(fileOutputStream);
            if (workbook != null) workbook.close();
            if (fileOutputStream != null) fileOutputStream.close();

            // log.info(" === fsa.DoPackagingFsn2 진행 === ");
            fsa.DoPackagingFsn2(oHomeDir, FASOO_ID, decryptFile, encryptFile,
                    oSourceFile,
                    "admin",
                    "관리자",
                    "test", "아무개", "001", "팀_1",
                    "test", "아무개", "001", "팀_1", "2");

            // 미구현: 파일명 깨짐
            String downFileName = "사옥임대손익_" + DateUtil.getDate() + ".xlsx";
            downFileName = URLEncoder.encode(downFileName, "UTF-8");
            response.setHeader("Content-Disposition", "attachment; fileName=\""+downFileName +"\"");
            DateUtil.setResponseDownload(response, downFileName, encryptFile);
        } catch (Exception e) {
            log.error(e.getMessage());
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
