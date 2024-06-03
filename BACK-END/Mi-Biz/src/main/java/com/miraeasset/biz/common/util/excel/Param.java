package com.miraeasset.biz.common.util.excel;

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.miraeasset.biz.common.util.DateUtil;
import com.miraeasset.biz.common.util.excel.exception.ParamException;

public class Param implements IDTO
{
	
	private static final long serialVersionUID = 1L;
	private final HashMap<String, Object> map = new HashMap<String, Object>();
	
    public Param(){}

    private String toUpper(String key)
    {
        if(key == null) 
        	return null;
        else 
        	//return key.toUpperCase();
        	return key.trim();
    }

    public void addValue(String key, Object value)
    {
        map.put(toUpper(key), value);
    }

    public void addValue(String key, int value)
    {
        map.put(toUpper(key), new Integer(value));
    }

    public void addValue(String key, byte value)
    {
        map.put(toUpper(key), new Byte(value));
    }

    public void addValue(String key, short value)
    {
        map.put(toUpper(key), new Short(value));
    }

    public void addValue(String key, long value)
    {
        map.put(toUpper(key), new Long(value));
    }

    public void addValue(String key, float value)
    {
        map.put(toUpper(key), new Float(value));
    }

    public void addValue(String key, double value)
    {
        map.put(toUpper(key), new Double(value));
    }

    public void addValue(String key, boolean value)
    {
        map.put(toUpper(key), new Boolean(value));
    }
    
    public boolean containsKey(String key)
    {
        return map.containsKey(toUpper(key));
    }

    public Object getValue(String key)
    {
        return map.get(toUpper(key));
    }

    public Object getValue(String key, Object defaultValue)
    {
        Object result = getValue(key);
        if(result == null)
            result = defaultValue;
        return result;
    }

    public String getString(String key)
    {
        Object v = map.get(toUpper(key));
        if(v == null)
            return null;
        else
            return v.toString();
    }

    public String getString(String key, String defaultValue)
    {
        String result = defaultValue;
        Object v = map.get(toUpper(key));
        
        if(v != null) {
        	if(v instanceof Clob) {
        		try {
					result= DateUtil.getCLOB((Clob)v);
				} catch (Exception e) {
					e.printStackTrace();
				}
        	}
        	else {
        		result = v.toString();
        	}
            
        }
        
        return result;
    }

    public int getInt(String key)
        throws ParamException
    {
        Object v;
        v = map.get(toUpper(key));
        if(v == null)
            return 0;
        try{
        if(v instanceof Number)
            return ((Number)v).intValue();
        return (new BigDecimal(v.toString())).intValue();
        }
        catch(NumberFormatException e){
        	 throw new ParamException("Param.getInt() : value '" + v.toString() + "' of key '" + key + "' is not number.", 0);
        }
       
        //throw new ParamException("Param.getInt() : key '" + key + "' doesn't exist or value is null.", 1);
    }

    public int getInt(String key, int defaultValue)
        throws ParamException
    {
        int result = defaultValue;
        try
        {
            result = getInt(key);
        }
        catch(ParamException e)
        {
            return defaultValue;
        }
        return result;
    }
    
    public byte getByte(String key)
        throws ParamException
    {
        Object v;
        v = map.get(toUpper(key));
        if(v == null)//�ش纯���� ���ٸ�
        	return 1;
        
        try{
        if(v instanceof Number) 
            return ((Number)v).byteValue();
        
        return (new BigDecimal(v.toString())).byteValue();
        }
        catch(NumberFormatException e){
        	
        }
        throw new ParamException("Param.getByte() : value '" + v.toString() + "' of key '" + v + "' is not number.", 0);
        //throw new ParamException("Param.getByte() : key '" + key + "' doesn't exist or value is null.", 1);
    }

    public byte getByte(String key, byte defaultValue)
        throws ParamException
    {
        byte result = defaultValue;
        try
        {
            result = getByte(key);
        }
        catch(ParamException e)
        {
            return defaultValue;
        }
        return result;
    }
   
    public short getShort(String key)
        throws ParamException
    {
        Object v;
        v = map.get(toUpper(key));
        //if(v == null)
        //    break MISSING_BLOCK_LABEL_93;
        try{
        if(v instanceof Number)
            return ((Number)v).shortValue();
        return (new BigDecimal(v.toString())).shortValue();
        }
        catch(NumberFormatException e){
        	throw new ParamException("Param.getShort() : value '" + v.toString() + "' of key '" + key + "' is not number.", 0);
        }
        
    }
    
    public short getShort(String key, short defaultValue)
        throws ParamException
    {
        short result = defaultValue;
        try
        {
            result = getShort(key);
        }
        catch(ParamException e)
        {
            return defaultValue;
        }
        return result;
    }
    public long getLong(String key)
        throws ParamException
    {
        Object v;
        v = map.get(toUpper(key));
        //if(v == null)
        //    break MISSING_BLOCK_LABEL_93;
        try{
        if(v instanceof Number)
            return ((Number)v).longValue();
        return (new BigDecimal(v.toString())).longValue();
        }
        catch(NumberFormatException e){
        	throw new ParamException("Param.getLong() : value '" + v.toString() + "' key '" + key + "' is not number.", 0);
        }
    }

    public long getLong(String key, long value)
        throws ParamException
    {
        long result = value;
        try
        {
            result = getLong(key);
        }
        catch(ParamException e)
        {
            return value;
        }
        return result;
    }

    public float getFloat(String key)
        throws ParamException
    {
        Object v;
        v = map.get(toUpper(key));
        //if(v == null)
        //    break MISSING_BLOCK_LABEL_93;
        try{
        if(v instanceof Number)
            return ((Number)v).floatValue();
        return (new BigDecimal(v.toString())).floatValue();
        }
        catch(NumberFormatException e){
        	 throw new ParamException("Param.getFloat() : value '" + v.toString() + "' of key '" + key + "' is not number.", 0);
        }
       
    }

    public float getFloat(String key, float value)
        throws ParamException
    {
        float result = value;
        try
        {
            result = getFloat(key);
        }
        catch(ParamException e)
        {
            return value;
        }
        return result;
    }

    public double getDouble(String key)
        throws ParamException
    {
        Object v;
        v = map.get(toUpper(key));
        //if(v == null)
        //    break MISSING_BLOCK_LABEL_93;
        try{
        if(v instanceof Number)
            return ((Number)v).doubleValue();
        return (new BigDecimal(v.toString())).doubleValue();
        }
        catch(NumberFormatException e){
        	throw new ParamException("Param.getDouble() : value '" + v.toString() + "' of key '" + key + "' is not number.", 0);
        }
    }

    public double getDouble(String key, double value)
        throws ParamException
    {
        double result = value;
        try
        {
            result = getDouble(key);
        }
        catch(ParamException e)
        {
            return value;
        }
        return result;
    }
    
    public boolean getBoolean(String key)
        throws ParamException
    {
        Object v = map.get(toUpper(key));
        if(v != null)
            return Boolean.valueOf(v.toString()).booleanValue();
        else
            throw new ParamException("Param.getBoolean() : key '" + key + "' doesn't exist or value is null.", 1);
    }

    public boolean getBoolean(String key, boolean defaultValue)
    {
        boolean result = defaultValue;
        try
        {
            result = getBoolean(key);
        }
        catch(ParamException e) { }
        return result;
    }
	
    public ListParam getListParam(String key) throws ParamException
    {
    	try{
    		ListParam list = (ListParam)map.get(toUpper(key));
        return list;
    	}
    	catch(ClassCastException e){
    		throw new ParamException("Param.getParamList() : value of key '" + key + "' is not ListParam");
    	}
        
    }

    public void clear()
    {
        map.clear();
    }

    public void remove(String key)
    {
        map.remove(toUpper(key));
    }

    public String[] keys()
    {
        Set<String> keys = map.keySet();
        String keylist[] = new String[keys.size()];
        return (String[])keys.toArray(keylist);
    }

    public Map<String, Object> getMap()
    {
        return map;
    }

    public void addParam(Param param)
    {
        if(param != null)
            map.putAll(param.getMap());
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        Iterator<String> iter = map.keySet().iterator();
        //sb.append("---key대문자로 변경..==>");
        while(iter.hasNext()) 
        {
            String key = (String)iter.next();
            Object value = map.get(key);
            sb.append(key).append("=").append(value);
            if(iter.hasNext())
                sb.append(",");
        }
        
        //sb.append("]");
        return sb.toString();
    }
    
    public void view(){
    	
    }
}
