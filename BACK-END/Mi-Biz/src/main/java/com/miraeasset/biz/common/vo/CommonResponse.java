package com.miraeasset.biz.common.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CommonResponse {

	private List<Object> data;
	
	public CommonResponse(){
		this.data = new ArrayList();
	}
	
	public CommonResponse (Object data){
		this.data = new ArrayList();
		this.data.add(data);
	}
	
	public void result(Object data){
		this.data.add(data);
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}
	
	public void addData(Object data){
		this.data.add(data);
	}
}
