package com.in.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.in.rays.bean.MarksheetBean;
import com.in.rays.model.MarksheetModel;

public class MarksheetTest {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testFindByPk();
		// testUpdate();
		// testDelete();
		//testSearch();
		//testFindByRollNo();
	}

	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(3);
		bean.setRollNo("101");
		bean.setStudentId(11);
		bean.setName("madhu");
		bean.setPhysics(90);
		bean.setChemistry(99);
		bean.setMaths(97);
		bean.setCreatedBy("madhu@gmail.com");
		bean.setModifiedBy("madhu@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setRollNo("102");
		bean.setStudentId(12);
		bean.setName("monika");
		bean.setPhysics(80);
		bean.setChemistry(89);
		bean.setMaths(91);
		bean.setCreatedBy("madhu@gmail.com");
		bean.setModifiedBy("madhu@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(2);

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.delete(3);
	}

	public static void testFindByPk() throws Exception {
	   MarksheetModel model=new MarksheetModel();
	   MarksheetBean bean=model.findByPk(1);
	   if(bean!=null) {
		   System.out.print(" " + bean.getId());
		   System.out.print(" " + bean.getRollNo());
		   System.out.print(" " + bean.getStudentId());
		   System.out.print(" " + bean.getName());
		   System.out.print(" "+ bean.getPhysics());
		   System.out.print(" "+ bean.getChemistry());
		   System.out.print(" "+ bean.getMaths());
		   System.out.print(" "+ bean.getCreatedBy());
		   System.out.print(" "+bean.getModifiedBy());
	       System.out.print(" "+bean.getCreatedDatetime());
	       System.out.print(" "+bean.getModifiedDatetime());
																				 
	   }else {
		   System.out.println(" id not found ..");
	   }
   }
	public static void testFindByRollNo() throws Exception {
		   MarksheetModel model=new MarksheetModel();
		   MarksheetBean bean=model.findByRollNo("101");
		   if(bean!=null) {
			   System.out.print(" " + bean.getId());
			   System.out.print(" " + bean.getRollNo());
			   System.out.print(" " + bean.getStudentId());
			   System.out.print(" " + bean.getName());
			   System.out.print(" "+ bean.getPhysics());
			   System.out.print(" "+ bean.getChemistry());
			   System.out.print(" "+ bean.getMaths());
			   System.out.print(" "+ bean.getCreatedBy());
			   System.out.print(" "+bean.getModifiedBy());
		       System.out.print(" "+bean.getCreatedDatetime());
		       System.out.print(" "+bean.getModifiedDatetime());
																					 
		   }else {
			   System.out.println(" rollno not found ..");
		   }
	   }
	public static void testSearch() throws Exception {
		  MarksheetModel model=new MarksheetModel();
		  MarksheetBean bean=new MarksheetBean();
		  //bean.setId(1);
		 // bean.setName("m");
		  List list=model.search(bean, 1, 2);
		  Iterator i=list.iterator();
		  while(i.hasNext()) {
			  bean=(MarksheetBean) i.next();
			  System.out.print(" " + bean.getId());
			   System.out.print(" " + bean.getRollNo());
			   System.out.print(" " + bean.getStudentId());
			   System.out.print(" " + bean.getName());
			   System.out.print(" "+ bean.getPhysics());
			   System.out.print(" "+ bean.getChemistry());
			   System.out.print(" "+ bean.getMaths());
			   System.out.print(" "+ bean.getCreatedBy());
			   System.out.print(" "+bean.getModifiedBy());
		       System.out.print(" "+bean.getCreatedDatetime());
		       System.out.print(" "+bean.getModifiedDatetime());
			  
		  }
		  
		
	}
}
