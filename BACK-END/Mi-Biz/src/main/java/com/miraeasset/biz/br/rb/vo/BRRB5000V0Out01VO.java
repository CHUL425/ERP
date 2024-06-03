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
public class BRRB5000V0Out01VO {
    @ExcelColumnInfo(notes = "기준년월")
    @ApiModelProperty(notes = "기준년월", example = "202301")
    private String basYm;
    @ExcelColumnInfo(notes = "매출"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "매출", example = "0")
    private BigDecimal revenue;
    @ExcelColumnInfo(notes = "비용"
    		,bodyStyle = @ExcelColumnStyle(excelCellStyleClass = DefaultExcelCellStyle.class, enumName = "RIGHT"))
    @ApiModelProperty(notes = "비용", example = "0")
    private BigDecimal expense;
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

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getExpense() {
        return expense;
    }

    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }

    public BigDecimal getSummation() {
        BigDecimal summation = BigDecimal.valueOf(0);
        summation = summation.add(revenue);
        summation = summation.subtract(expense);
        return summation;
    }

    public void setSummation(BigDecimal summation) {
        this.summation = summation;
    }
}
