package com.in.rays.test;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.in.rays.bean.CourseBean;
import com.in.rays.model.CourseModel;

public class CourseTest {
  public static void main(String[] args) throws Exception {
	//testAdd();
	 // testUpdate();
	  //testFindByPk();
	  testSearch();
}
  public static void testAdd() throws Exception {
	  CourseBean bean= new CourseBean();
	  bean.setId(1);
	  bean.setName("BCA");
	  bean.setDuration("2015-2019");
	  bean.setDescription("Bachelor of Computer Applications");
	  bean.setCreatedBy("madhu@gmail.com");
	  bean.setModifiedBy("madhu@gmail.com");
	  bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	  bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	  CourseModel model=new CourseModel();
	  model.add(bean);
	  
  }
  public static void testUpdate() throws Exception {
	  CourseBean bean= new CourseBean();
	  
	  bean.setName("BCA");
	  bean.setDuration("2019-2022");
	  bean.setDescription("Bachelor of Computer Applications");
	  bean.setCreatedBy("madhu@gmail.com");
	  bean.setModifiedBy("madhu@gmail.com");
	  bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	  bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	  bean.setId(1);
	  CourseModel model=new CourseModel();
	  model.update(bean);
  }
  public static void testFindByPk() throws Exception {
	  CourseModel model=new CourseModel();
	  CourseBean bean= model.findByPk(1);
	  if(bean!=null) {
	  System.out.print(" "+bean.getId());
	  System.out.print(" "+bean.getName());
	  System.out.print(" "+bean.getDuration());
	  System.out.print(" "+bean.getDescription());
	  System.out.print(" "+bean.getCreatedBy());
	  System.out.print(" "+bean.getModifiedBy());
	  System.out.print(" "+bean.getCreatedDatetime());
	  System.out.print(" "+bean.getModifiedDatetime());
	  }else {
		  System.out.println("id not found");
	  }
	  
  }
  public static void testSearch() throws Exception {
	  CourseBean bean=new CourseBean();
	  CourseModel model=new CourseModel();
	 List list= model.search(bean, 1, 2);
	 Iterator i=list.iterator();
	 while(i.hasNext()) {
		 bean=(CourseBean) i.next();
		 System.out.print(" "+bean.getId());
		  System.out.print(" "+bean.getName());
		  System.out.print(" "+bean.getDuration());
		  System.out.print(" "+bean.getDescription());
		  System.out.print(" "+bean.getCreatedBy());
		  System.out.print(" "+bean.getModifiedBy());
		  System.out.print(" "+bean.getCreatedDatetime());
		  System.out.print(" "+bean.getModifiedDatetime());
	 }
	  
  }
}
