package com.in.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.in.rays.bean.CourseBean;
import com.in.rays.connection.DataPool;

public class CourseModel {
	public long nextPk() throws Exception {
		long pk=0;
		Connection conn=DataPool.getConnection();
		   PreparedStatement stmt=conn.prepareStatement(" select max(id) from st_course ");
		   ResultSet r= stmt.executeQuery();
		   while(r.next()) {
			   pk=r.getLong(1);
		   }
		return pk+1;
		
	}
   public void add(CourseBean bean) throws Exception {
	   long pk=nextPk();
	   Connection conn=DataPool.getConnection();
	   PreparedStatement stmt=conn.prepareStatement(" insert into st_course values(?,?,?,?,?,?,?,?)");
	   stmt.setLong(1, pk);
	   stmt.setString(2, bean.getName());
	   stmt.setString(3, bean.getDuration());
	   stmt.setString(4, bean.getDescription());
	   stmt.setString(5, bean.getCreatedBy());
	   stmt.setString(6, bean.getModifiedBy());
	   stmt.setTimestamp(7, bean.getCreatedDatetime());
	   stmt.setTimestamp(8, bean.getModifiedDatetime());
	   int i=stmt.executeUpdate();
	   System.out.println("query added===>"+i);

   }
   public void update(CourseBean bean) throws Exception {
	   Connection conn=DataPool.getConnection();
	   PreparedStatement stmt=conn.prepareStatement(" update st_course set name=?,duration=?,description=?, created_by=? ,modified_by=? ,created_datetime=? ,modified_datetime=? where id=?");
	   
	   stmt.setString(1, bean.getName());
	   stmt.setString(2, bean.getDuration());
	   stmt.setString(3, bean.getDescription());
	   stmt.setString(4, bean.getCreatedBy());
	   stmt.setString(5, bean.getModifiedBy());
	   stmt.setTimestamp(6, bean.getCreatedDatetime());
	   stmt.setTimestamp(7, bean.getModifiedDatetime());
	   stmt.setLong(8, bean.getId());
	   
	  
	   int i=stmt.executeUpdate();
	   DataPool.closeConnection(conn);
	   System.out.println("query added===>"+i);
   }
   public CourseBean findByPk(long id) throws Exception {
	   Connection conn=DataPool.getConnection();
	   PreparedStatement stmt=conn.prepareStatement(" select * from st_course where id=? ");  
	   stmt.setLong(1, id);
	   ResultSet r=stmt.executeQuery();
	   CourseBean bean=null;
	   while(r.next()) {
		   bean=new CourseBean();
		   bean.setId(r.getLong(1));
		   bean.setName(r.getString(2));
		   bean.setDuration(r.getString(3));
		   bean.setDescription(r.getString(4));
		   bean.setCreatedBy(r.getString(5));
		   bean.setModifiedBy(r.getString(6));
		   bean.setCreatedDatetime(r.getTimestamp(7));
		   bean.setModifiedDatetime(r.getTimestamp(8));
	   }
	return bean;
	   
   }
   public List search(CourseBean bean,int pageNo,int pageSize) throws Exception {
	   Connection conn=DataPool.getConnection();
	  
	   StringBuffer sql=new StringBuffer(" select * from st_course where 1=1 ");
	   
	   if(bean!=null) {
		   
		   if(bean.getId()>0) {
			   sql.append(" and id = "+bean.getId());
		      }
		   if(bean.getName()!=null && bean.getName().length()>0) {
			  sql.append(" and name like '" + bean.getName()+"%'"); 
		     }
		   if(bean.getDuration()!=null && bean.getDuration().length()>0) {
			   sql.append( " and duration like '"+bean.getDuration()+"%'");
		   }
	   }
	   if(pageSize>0) {
		   
		   pageNo = (pageNo-1) * pageSize;
		   sql.append(" limit " + pageNo + " ," + pageSize);
	    }
	   System.out.println("sql==>"+sql);
	   
	   PreparedStatement stmt=conn.prepareStatement(sql.toString());
	   ResultSet r=stmt.executeQuery();
	   List list=new ArrayList();
	   while(r.next()) {
		   bean=new CourseBean();
		   bean.setId(r.getLong(1));
		   bean.setName(r.getString(2));
		   bean.setDuration(r.getString(3));
		   bean.setDescription(r.getString(4));
		   bean.setCreatedBy(r.getString(5));
		   bean.setModifiedBy(r.getString(6));
		   bean.setCreatedDatetime(r.getTimestamp(7));
		   bean.setModifiedDatetime(r.getTimestamp(8));
		   list.add(bean);
		   }
	return list;
	   
	   
	   
   }
}
