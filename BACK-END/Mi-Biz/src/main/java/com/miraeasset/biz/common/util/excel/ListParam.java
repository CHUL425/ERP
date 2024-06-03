package com.miraeasset.biz.common.util.excel;

import java.io.Serializable;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.exception.ParamException;

public class ListParam implements Serializable
{
	private static final long serialVersionUID = 1L;
	private final String columns[];
    private final List<Object> rows = new ArrayList<Object>();
    private int colSize;
    
    public ListParam(String columns[])  throws ParamException
    {
        if(columns == null)
            throw new ParamException("String array of columns is null.");
        if(columns.length == 0)
            throw new ParamException("Size of columns must be over 0.");
        colSize = columns.length;
        this.columns = new String[colSize];
        for(int i = 0; i < colSize; i++)
        {
            if(columns[i] == null)
                throw new ParamException(i + "-th element of column array is null.");
            //this.columns[i] = columns[i].toUpperCase();
            
            this.columns[i] = columns[i];
        }
    }

    public int rowSize()
    {
        return rows.size();
    }

    public int colSize()
    {
        return colSize;
    }

    private void checkRowIndex(int rowidx)
        throws ParamException
    {
        if(rowidx < 0 || rowidx > rows.size() - 1)
            throw new ParamException("Row index " + rowidx + " is out of range.");
        else
            return;
    }

    private void checkColIndex(int colidx)
        throws ParamException
    {
        if(colidx < 0 || colidx > colSize - 1)
            throw new ParamException("Column index " + colidx + " is out of range.");
        else
            return;
    }

    public String[] getColumns()
    {
        return columns;
    }

    public int findColumn(String col)
    {
        for(int i = 0; i < columns.length; i++)
            if(columns[i].equalsIgnoreCase(col))
                return i;

        return -1;
    }

    public int findRow(String col, Object value)
    {
        int index = -1;
        int colidx = findColumn(col);
        if(value == null && rows == null)
            return -1;
        for(int i = 0; rows != null && i < rows.size(); i++)
        {
            Object values[] = (Object[])rows.get(i);
            if((values[colidx] != null || value != null) && (values[colidx] == null || !values[colidx].equals(value)))
                continue;
            index = i;
            break;
        }

        return index;
    }

    public String getColumnName(int colidx)
        throws ParamException
    {
        checkColIndex(colidx);
        return columns[colidx];
    }

    public int addRow(Object values[])
        throws ParamException
    {
        if(values == null)
            throw new ParamException("Row value array must be not null");
        if(values.length != colSize)
        {
            throw new ParamException("Size of row value array must be column size");
        } else
        {
            rows.add(((Object) (values)));
            return rows.size() - 1;
        }
    }

    public Object[] getRow(int rowidx)
        throws ParamException
    {
        checkRowIndex(rowidx);
        return (Object[])rows.get(rowidx);
    }

    public Object[] getRow(String column, Object value)
        throws ParamException
    {
        int rowidx = findRow(column, value);
        return getRow(rowidx);
    }

    public int createRow()
    {
        rows.add(((Object) (new Object[colSize])));
        return rows.size() - 1;
    }

    public void setValue(int rowidx, String column, Object value)
        throws ParamException
    {
        int colidx = findColumn(column);
        if(colidx == -1)
        {
            return;
        } else
        {
            setValue(rowidx, colidx, value);
            return;
        }
    }

    public void setValue(String column1, String value1, String column2, Object value2)
        throws ParamException
    {
        int rowidx = findRow(column1, value1);
        setValue(rowidx, column2, value2);
    }

    public void setValue(int rowidx, int colidx, Object value)
        throws ParamException
    {
        checkRowIndex(rowidx);
        checkColIndex(colidx);
        Object values[] = (Object[])rows.get(rowidx);
        values[colidx] = value;
    }

    public void setValue(String column, Object value1, int colidx, Object value2)
        throws ParamException
    {
        int rowidx = findRow(column, value1);
        setValue(rowidx, colidx, value2);
    }

    public Param getParam(int rowidx)
        throws ParamException
    {
        Param param = new Param();
        Object values[] = getRow(rowidx);
        for(int i = 0; i < colSize; i++)
            param.addValue(columns[i], values[i]);

        return param;
    }

    public Param getParam(String column, Object value)
        throws ParamException
    {
        int rowidx = findRow(column, value);
        return getParam(rowidx);
    }

    public int addParam(Param param)
        throws ParamException
    {
        if(param == null)
            throw new ParamException("Can't add null Param");
        int newrow = createRow();
        for(int i = 0; i < columns.length; i++)
            setValue(newrow, columns[i], param.getValue(columns[i]));

        return rows.size() - 1;
    }

    public Object getValue(int rowidx, String column)
        throws ParamException
    {
        int colidx = findColumn(column);
        if(colidx == -1)
            return null;
        else
            return getValue(rowidx, colidx);
    }
    
    public String getValue(int rowidx, String column,String defaultvalue) throws ParamException
	{
    	String result=null;
	    int colidx = findColumn(column);
	    if(colidx == -1){
	        return defaultvalue;
	    }
	    
	    if(getValue(rowidx, colidx)==null){
	    	return defaultvalue;
	    }
	    
	    if(getValue(rowidx, colidx) instanceof Clob){
	    	try {
				result= DateUtil.getCLOB((Clob)getValue(rowidx, colidx));
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    else {
	    	result=getValue(rowidx, colidx).toString();
	    }
	    
	    if(result==null) return defaultvalue;
	    else return result;
	}
    
    public String getValueSlash(int rowidx, String column,String target) throws ParamException
	{
    	String result=null;
	    int colidx = findColumn(column);
	    if(colidx == -1)
	        return "";
	    if(getValue(rowidx, colidx) instanceof String)
	    	result= getValue(rowidx, colidx).toString().replaceAll(target, "\\\\"+target);
	    
	    if(result==null) return "";
	    else return result;
	}

    public Object getValue(String column1, Object value, String column2) throws ParamException
    {
        int rowidx = findRow(column1, value);
        if(rowidx == -1)
            return null;
        else
            return getValue(rowidx, column2);
    }

    public Object getValue(int rowidx, int colidx)
        throws ParamException
    {
        checkRowIndex(rowidx);
        checkColIndex(colidx);
        Object values[] = (Object[])rows.get(rowidx);
        return values[colidx];
    }
    

    public Object getValue(String column, Object value, int colidx)
        throws ParamException
    {
        int rowidx = findRow(column, value);
        if(rowidx == -1)
            return null;
        else
            return getValue(rowidx, colidx);
    }

    public void clear()
    {
        rows.clear();
    }

    public void remove(int rowidx)
        throws ParamException
    {
        checkRowIndex(rowidx);
        rows.remove(rowidx);
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\t[column:");
        for(int i = 0; i < columns.length; i++)
            sb.append(columns[i]).append(",");

        sb.append("\n");
        for(int i = 0; i < rows.size(); i++)
        {
            Object values[] = (Object[])rows.get(i);
            sb.append("\t[").append(i).append(":");
            for(int j = 0; j < values.length; j++)
            {
                sb.append(values[j]);
                if(j < values.length - 1)
                    sb.append(",");
            }

            sb.append("]\n");
        }

        sb.append("]");
        return sb.toString();
    }
    
    public List<Map<String,Object>> toListMap() {
    	
		List<Map<String, Object>> result=new ArrayList<Map<String, Object>>();
		
		for(int i=0;i<rowSize();i++) {
			Map<String,Object> temp = new LinkedHashMap<String, Object>();
			for(int j=0;j<columns.length;j++) {
	    		//ErrorLogger.debug("::column name:::::::"+columns[j]+"::::camel converting:::"+convert2CamelCase(columns[j]));
	    		temp.put(columns[j], getValue(i,columns[j],""));	
			}
			result.add(temp);
		}
		
		return result;
    }
    
    public String toCsv(String split) {
    	StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<rowSize();i++) {
			for(int j=0;j<columns.length;j++) {
	    		sb.append((j==0?"":split)+getValue(i,columns[j],""));
			}
			
			sb.append("\r\n");
		}
		
		return sb.toString();
    }
}
