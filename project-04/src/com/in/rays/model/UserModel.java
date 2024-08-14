package com.in.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.in.rays.bean.UserBean;
import com.in.rays.connection.DataPool;

public class UserModel {
	public long pk() throws Exception {
		long pk=0;
		Connection conn=DataPool.getConnection();
		PreparedStatement stmt=conn.prepareStatement(" select max(id) from st_user ");
		ResultSet r=stmt.executeQuery();
		while(r.next()) {
		 pk=r.getLong(1);	
		}
		return  pk+1;
		
	}
   public void add(UserBean bean) throws Exception {
	  int pk= (int) pk();
	   Connection conn=DataPool.getConnection();
	   PreparedStatement stmt=conn.prepareStatement(" insert into st_user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	  
	  stmt.setLong(1, pk);
	  stmt.setString(2, bean.getFirstName());
	  stmt.setString(3, bean.getLastName());
	  stmt.setString(4, bean.getLogin());
	  stmt.setString(5, bean.getPassword());
	  stmt.setString(6, bean.getConfirmPassword());
	  stmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));
	  stmt.setString(8, bean.getMobileNo());
	  stmt.setLong(9, bean.getRoleId());
	  stmt.setString(10, bean.getGender());
	  stmt.setString(11, bean.getCreatedBy());
	  stmt.setString(12, bean.getModifiedBy());
	  stmt.setTimestamp(13, bean.getCreatedDatetime());
	  stmt.setTimestamp(14,bean.getModifiedDatetime());
	  int i= stmt.executeUpdate();
	  DataPool.closeConnection(conn);
	  System.out.println("query added=>"+i);
	  
   }
   public void update(UserBean bean) throws Exception {
	   Connection conn=DataPool.getConnection();
	   PreparedStatement stmt=conn.prepareStatement(
	   " update st_user set first_name=?,last_name=?,login=?,password=? , confirm_password=?,dob=?,mobile_no=?,role_id=?,gender=?,created_by=?,modified_by=? ,created_datetime=?,modified_datetime=? where id =? "); 
	   stmt.setString(1, bean.getFirstName());
		  stmt.setString(2, bean.getLastName());
		  stmt.setString(3, bean.getLogin());
		  stmt.setString(4, bean.getPassword());
		  stmt.setString(5, bean.getConfirmPassword());
		  stmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		  stmt.setString(7, bean.getMobileNo());
		  stmt.setLong(8, bean.getRoleId());
		  stmt.setString(9, bean.getGender());
		  stmt.setString(10, bean.getCreatedBy());
		  stmt.setString(11, bean.getModifiedBy());
		  stmt.setTimestamp(12, bean.getCreatedDatetime());
		  stmt.setTimestamp(13,bean.getModifiedDatetime());
		  stmt.setLong(14,bean.getId());
		  
		  int i= stmt.executeUpdate();
		  DataPool.closeConnection(conn);
		  System.out.println("query updated=>"+i);
	   
   }
   public  void delete(long id) throws Exception {
	   Connection conn=DataPool.getConnection();
	   PreparedStatement stmt=conn.prepareStatement(" delete from st_user where id=? ");
	     stmt.setLong(1, id);
	     int i=stmt.executeUpdate();
	     DataPool.closeConnection(conn);
	     System.out.println("query delete=>"+i);
		
   }
   public UserBean  findByPk(long id) throws Exception {
	   Connection conn=DataPool.getConnection(); 
	   PreparedStatement stmt=conn.prepareStatement(" select * from st_user where id=? ");
	   stmt.setLong(1, id);
	   ResultSet r= stmt.executeQuery();
	   UserBean bean=null;
	   while(r.next()) {
		   bean=new UserBean();
		   bean.setId(r.getLong(1));
		   bean.setFirstName(r.getString(2));
		   bean.setLastName(r.getString(3));
		   bean.setLogin(r.getString(4));
		   bean.setPassword(r.getString(5));
		   bean.setConfirmPassword(r.getString(6));
		   bean.setDob(r.getDate(7));
		   bean.setMobileNo(r.getString(8));
		   bean.setRoleId(r.getLong(9));
		   bean.setGender(r.getString(10));
		   bean.setCreatedBy(r.getString(11));
		   bean.setModifiedBy(r.getString(12));
		   bean.setCreatedDatetime(r.getTimestamp(13));
		   bean.setModifiedDatetime(r.getTimestamp(14));
	   }
	return bean;
	   
   }
   public UserBean authenticate(String login ,String password ) throws Exception {
	   Connection conn=DataPool.getConnection();
	   PreparedStatement stmt=conn.prepareStatement(" select * from st_user where login=? and password=? ");
	   stmt.setString(1,login);
	   stmt.setString(2, password);
	   ResultSet r=stmt.executeQuery();
	   UserBean bean=null;
	   while(r.next()) {
		   bean=new UserBean();
		   bean.setId(r.getLong(1));
		   bean.setFirstName(r.getString(2));
		   bean.setLastName(r.getString(3));
		   bean.setLogin(r.getString(4));
		   bean.setPassword(r.getString(5));
		   bean.setConfirmPassword(r.getString(6));
		   bean.setDob(r.getDate(7));
		   bean.setMobileNo(r.getString(8));
		   bean.setRoleId(r.getLong(9));
		   bean.setGender(r.getString(10));
		   bean.setCreatedBy(r.getString(11));
		   bean.setModifiedBy(r.getString(12));
		   bean.setCreatedDatetime(r.getTimestamp(13));
		   bean.setModifiedDatetime(r.getTimestamp(14));   
	   }
	return bean;
	   
	   
   }
   public List search(UserBean bean,int pageNo,int pageSize)throws Exception {
	   Connection conn=DataPool.getConnection(); 
	   StringBuffer sql=new StringBuffer(" select * from st_user where 1=1 ");
	  
	   if(bean !=null) {
		   
		   if(bean.getId()>0) {
			   sql.append(" and id = " +bean.getId());
		   }
		   
		   if(bean.getFirstName()!=null && bean.getFirstName().length()>0) {
			   sql.append(" and first_name like '" +bean.getFirstName()+ " %'");
		   }
		   if(bean.getDob()!=null && bean.getDob().getTime()>0) {
			   sql.append(" and dob like '"+new java.sql.Date(bean.getDob().getTime())+"%'");
		   }
		   
		 
	   }
	  if(pageSize > 0) {
		  pageNo=(pageNo-1) * pageSize ;
		  sql.append(" limit " + pageNo + " ," + pageSize);
	  } 
	  System.out.println("sql=>"+sql);
	  
	   PreparedStatement stmt=conn.prepareStatement(sql.toString());
	   ResultSet r=stmt.executeQuery();
	   List list=new ArrayList();
	   
	   while(r.next()) {
		   bean.setId(r.getLong(1));
		   bean.setFirstName(r.getString(2));
		   bean.setLastName(r.getString(3));
		   bean.setLogin(r.getString(4));
		   bean.setPassword(r.getString(5));
		   bean.setConfirmPassword(r.getString(6));
		   bean.setDob(r.getDate(7));
		   bean.setMobileNo(r.getString(8));
		   bean.setRoleId(r.getLong(9));
		   bean.setGender(r.getString(10));
		   bean.setCreatedBy(r.getString(11));
		   bean.setModifiedBy(r.getString(12));
		   bean.setCreatedDatetime(r.getTimestamp(13));
		   bean.setModifiedDatetime(r.getTimestamp(14));  
		   list.add(bean);
		   }
	   return list;
   }
}
