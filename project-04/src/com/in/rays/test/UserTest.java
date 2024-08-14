package com.in.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.in.rays.bean.UserBean;
import com.in.rays.model.UserModel;

public class UserTest {
  public static void main(String[] args) throws Exception {
	  //testSearch();
	//testAdd();
	 // testUpdate();
	  //testDelete();
	 // testfindByPk();
	  testAuth();
}
  public static void testAdd() throws Exception {
	  UserBean bean=new UserBean();
	  bean.setId(1);
	  bean.setFirstName("arjun");
	  bean.setLastName("sharma");
	  bean.setLogin("arjun@gmail.com");
	  bean.setPassword("124");
	  bean.setConfirmPassword("124");
	  bean.setDob(new Date());
	  bean.setMobileNo("9981597443");
	  bean.setRoleId(102);
	  bean.setGender("male");
	  bean.setCreatedBy("auth");
	  bean.setModifiedBy("auth");
	  bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	  bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	  
	  UserModel  model=new UserModel();
	  model.add(bean);
	 }
   public static void testUpdate() throws Exception {
	   UserBean bean=new UserBean();
	   bean.setFirstName("arjun");
		  bean.setLastName("sunjal");
		  bean.setLogin("arjun@gmail.com");
		  bean.setPassword("124");
		  bean.setConfirmPassword("124");
		  bean.setDob(new Date());
		  bean.setMobileNo("9981597443");
		  bean.setRoleId(102);
		  bean.setGender("male");
		  bean.setCreatedBy("auth");
		  bean.setModifiedBy("auth");
		  bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		  bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		  bean.setId(2);
	   UserModel model=new UserModel();
	   model.update(bean);
   }
   public static void testDelete() throws Exception {
	   UserModel model=new UserModel();
	  model.delete(2);
   }
   public static void testfindByPk() throws Exception {
	   UserModel model=new UserModel();
	   UserBean bean=model.findByPk(1);
	   if(bean !=null) {
	    System.out.print(bean.getId());
	   System.out.print(" "+bean.getFirstName());
	   System.out.print(" "+bean.getLastName());
	   System.out.print(" "+bean.getLogin());
	   System.out.print(" "+bean.getPassword());
	   System.out.print(" "+bean.getConfirmPassword());
	   System.out.print(" "+bean.getDob());
	   System.out.print(" "+bean.getMobileNo());
	   System.out.print(" "+bean.getRoleId());
	   System.out.print(" "+bean.getGender());
	   System.out.print(" "+bean.getCreatedBy());
	   System.out.print(" "+bean.getModifiedBy());
	   System.out.print(" "+bean.getCreatedDatetime());
	   System.out.print(" "+bean.getModifiedDatetime());
	   }else {
		   System.out.println("id not found...!");
	   }
	   
   }
   public static void testAuth()throws Exception {
	   UserModel model=new UserModel();
	   UserBean bean=model.authenticate("madhu@gmail.com", "123");
	   
	   if(bean!=null) {
	   System.out.print(bean.getId());
	   System.out.print(" "+bean.getFirstName());
	   System.out.print(" "+bean.getLastName());
	   System.out.print(" "+bean.getLogin());
	   System.out.print(" "+bean.getPassword());
	   System.out.print(" "+bean.getConfirmPassword());
	   System.out.print(" "+bean.getDob());
	   System.out.print(" "+bean.getMobileNo());
	   System.out.print(" "+bean.getRoleId());
	   System.out.print(" "+bean.getGender());
	   System.out.print(" "+bean.getCreatedBy());
	   System.out.print(" "+bean.getModifiedBy());
	   System.out.print(" "+bean.getCreatedDatetime());
	   System.out.print(" "+bean.getModifiedDatetime());
	   }else {
		   System.out.println("login and password not found");
	   }
	   
   }
   public static void testSearch() throws Exception {
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
	   UserBean bean=new UserBean();
	   //bean.setId(1);
	   bean.setDob(sdf.parse("2024/08/11"));
	   //bean.setFirstName("m");
	   
	   UserModel model=new UserModel();
	   List list=model.search(bean, 1, 2);
	   Iterator i=list.iterator();
	   
	   while(i.hasNext()) {
		   
		   bean=(UserBean)i.next();
		   
		   System.out.print(bean.getId());
		   System.out.print(" "+bean.getFirstName());
		   System.out.print(" "+bean.getLastName());
		   System.out.print(" "+bean.getLogin());
		   System.out.print(" "+bean.getPassword());
		   System.out.print(" "+bean.getConfirmPassword());
		   System.out.print(" "+bean.getDob());
		   System.out.print(" "+bean.getMobileNo());
		   System.out.print(" "+bean.getRoleId());
		   System.out.print(" "+bean.getGender());
		   System.out.print(" "+bean.getCreatedBy());
		   System.out.print(" "+bean.getModifiedBy());
		   System.out.print(" "+bean.getCreatedDatetime());
		   System.out.print(" "+bean.getModifiedDatetime());
		   
	   }
	   
	   
   }
}
