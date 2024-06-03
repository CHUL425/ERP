package com.miraeasset.biz.br.rb.vo;

import com.miraeasset.biz.common.dao.ExcelColumnInfo;
import com.miraeasset.biz.common.dao.ExcelColumnStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultBodyStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultExcelCellStyle;
import com.miraeasset.biz.common.util.excel.style.DefaultHeaderStyle;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@DefaultHeaderStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "GREY_HEADER"))
@DefaultBodyStyle(style = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "BODY"))
public class BRRB4000V0Out01VO {
    @ExcelColumnInfo(notes = "기준년월")
    @ApiModelProperty(notes = "기준년월", example = "202301")
    private String basYm;
    @ExcelColumnInfo(notes = "사옥관리잡비"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "사옥관리잡비", example = "0")
    private BigDecimal officeAdministrationExpense;
    @ExcelColumnInfo(notes = "건물수선비"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "건물수선비", example = "0")
    private BigDecimal buildingRepairExpense;
    @ExcelColumnInfo(notes = "난방연료비"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "난방연료비", example = "0")
    private BigDecimal heatingFuelExpense;
    @ExcelColumnInfo(notes = "수도전기료"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "수도전기료", example = "0")
    private BigDecimal waterAndElectricityBill;
    @ExcelColumnInfo(notes = "소모품비"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "소모품비", example = "0")
    private BigDecimal consumableExpense;
    @ExcelColumnInfo(notes = "유지보수료"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "유지보수료", example = "0")
    private BigDecimal maintenanceFee;
    @ExcelColumnInfo(notes = "재산세금"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "재산세금", example = "0")
    private BigDecimal propertyTax;
    @ExcelColumnInfo(notes = "기타일반수수료"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "기타일반수수료", example = "0")
    private BigDecimal generalFee;
    @ExcelColumnInfo(notes = "합계"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "합계", example = "0")
    private BigDecimal summation;

    public String getBasYm() {
        return basYm;
    }

    public void setBasYm(String basYm) {
        this.basYm = basYm;
    }

    public BigDecimal getOfficeAdministrationExpense() {
        return officeAdministrationExpense;
    }

    public void setOfficeAdministrationExpense(BigDecimal officeAdministrationExpense) {
        this.officeAdministrationExpense = officeAdministrationExpense;
    }

    public BigDecimal getBuildingRepairExpense() {
        return buildingRepairExpense;
    }

    public void setBuildingRepairExpense(BigDecimal buildingRepairExpense) {
        this.buildingRepairExpense = buildingRepairExpense;
    }

    public BigDecimal getHeatingFuelExpense() {
        return heatingFuelExpense;
    }

    public void setHeatingFuelExpense(BigDecimal heatingFuelExpense) {
        this.heatingFuelExpense = heatingFuelExpense;
    }

    public BigDecimal getWaterAndElectricityBill() {
        return waterAndElectricityBill;
    }

    public void setWaterAndElectricityBill(BigDecimal waterAndElectricityBill) {
        this.waterAndElectricityBill = waterAndElectricityBill;
    }

    public BigDecimal getConsumableExpense() {
        return consumableExpense;
    }

    public void setConsumableExpense(BigDecimal consumableExpense) {
        this.consumableExpense = consumableExpense;
    }

    public BigDecimal getMaintenanceFee() {
        return maintenanceFee;
    }

    public void setMaintenanceFee(BigDecimal maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }

    public BigDecimal getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(BigDecimal propertyTax) {
        this.propertyTax = propertyTax;
    }

    public BigDecimal getGeneralFee() {
        return generalFee;
    }

    public void setGeneralFee(BigDecimal generalFee) {
        this.generalFee = generalFee;
    }

    public BigDecimal getSummation() {
        BigDecimal summation = BigDecimal.valueOf(0);
        summation = summation.add(officeAdministrationExpense);
        summation = summation.add(buildingRepairExpense);
        summation = summation.add(heatingFuelExpense);
        summation = summation.add(waterAndElectricityBill);
        summation = summation.add(maintenanceFee);
        summation = summation.add(consumableExpense);
        summation = summation.add(propertyTax);
        summation = summation.add(generalFee);
        return summation;
    }

    public void setSummation(BigDecimal summation) {
        this.summation = summation;
    }
}
