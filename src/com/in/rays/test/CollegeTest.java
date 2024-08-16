package com.in.rays.test;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.in.rays.bean.CollegeBean;
import com.in.rays.model.CollegeModel;

public class CollegeTest {
public static void main(String[] args) throws Exception {
	//testAdd();
	//testDelete();
	testUpdate();
	//testfindbypk();
	//testSearch();
}
public static void testAdd() throws Exception {
   CollegeBean bean=new CollegeBean();
   CollegeModel model=new CollegeModel();
	bean.setId(2);
	bean.setName("DAVV");
	bean.setAddress("vijay nagar");
	bean.setState("mp");
	bean.setCity("indore");
	bean.setPhoneNo("9177730112");
	bean.setCreatedBy("admin");
	bean.setModifiedBy("admin");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
	model.add(bean);
}
public static void testUpdate() throws Exception {
	CollegeBean bean=new CollegeBean();
	CollegeModel model=new CollegeModel();
	bean.setName("DAVV");
	bean.setAddress("vijay nagar");
	bean.setState("mp");
	bean.setCity("indore");
	bean.setPhoneNo("9177730112");
	bean.setCreatedBy("madhu@gmail.com");
	bean.setModifiedBy("madhu@gmail.com");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	bean.setId(1);
	model.update(bean);
	
}
public static void testDelete()throws Exception{
	CollegeModel model=new CollegeModel();
	model.delete(2);
	
}
public static void testfindbypk() throws Exception {
	
	CollegeModel model=new CollegeModel();
	CollegeBean bean= model.findbypk(1);
	if(bean!=null) {
		System.out.print(" " +bean.getId());
		System.out.print(" " +bean.getName());
		System.out.print(" " +bean.getAddress());
		System.out.print(" " +bean.getState());
		System.out.print(" " +bean.getCity());
		System.out.print(" " +bean.getPhoneNo());
		System.out.print(" " +bean.getCreatedBy());
		System.out.print(" " +bean.getModifiedBy());
		System.out.print(" " +bean.getCreatedDatetime());
		System.out.print(" " +bean.getModifiedDatetime());
		
		
	}else {
		System.out.println("oop..! id not found ");
	}
	
}
public static void testSearch() throws Exception {
	CollegeBean bean= new CollegeBean();
	bean.setId(1);
	CollegeModel model=new CollegeModel();
	List list=model.search(bean, 1, 2);
	Iterator i=list.iterator();
	while(i.hasNext()) {
		bean=(CollegeBean) i.next();
		System.out.print(" " +bean.getId());
		System.out.print(" " +bean.getName());
		System.out.print(" " +bean.getAddress());
		System.out.print(" " +bean.getState());
		System.out.print(" " +bean.getCity());
		System.out.print(" " +bean.getPhoneNo());
		System.out.print(" " +bean.getCreatedBy());
		System.out.print(" " +bean.getModifiedBy());
		System.out.print(" " +bean.getCreatedDatetime());
		System.out.print(" " +bean.getModifiedDatetime());
	}
	
	
}
}
