package com.in.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.in.rays.bean.RoleBean;
import com.in.rays.connection.DataPool;
import com.in.rays.exception.DuplicateRecordException;

public class RoleModel {
	public long pk() throws Exception {
		long pk=0;
	Connection conn= DataPool.getConnection();
	PreparedStatement stmt=conn.prepareStatement(" select max(id) from st_role ");
	ResultSet r=stmt.executeQuery();
	while(r.next()) {
		pk=r.getLong(1);
	}
		return pk+1;
		
	}
   public void add(RoleBean bean) throws DuplicateRecordException, Exception {
	  int pk=(int)pk();
	  Connection conn= DataPool.getConnection();
	  PreparedStatement stmt=conn.prepareStatement(" insert into st_role values(?,?,?,?,?,?,?)");
	    stmt.setLong(1, pk);
	    stmt.setString(2,bean.getName());
	    stmt.setString(3, bean.getDescription());
	    stmt.setString(4, bean.getCreatedBy());
	    stmt.setString(5, bean.getModifiedBy());
	    stmt.setTimestamp(6, bean.getCreatedDatetime());
	    stmt.setTimestamp(7, bean.getModifiedDatetime());
	    int i=stmt.executeUpdate();
	    DataPool.closeConnection(conn);
	    System.out.println("query added=>"+i);
	   
	    
   }
   public void update(RoleBean bean) throws Exception {
	   Connection conn= DataPool.getConnection();
	   PreparedStatement stmt=conn.prepareStatement(" update  st_role set name=? ,description=? ,created_by=? ,modified_by=? ,created_datetime=? ,modified_datetime=? where id=?");
	   
	    stmt.setString(1,bean.getName());
	    stmt.setString(2, bean.getDescription());
	    stmt.setString(3, bean.getCreatedBy());
	    stmt.setString(4, bean.getModifiedBy());
	    stmt.setTimestamp(5, bean.getCreatedDatetime());
	    stmt.setTimestamp(6, bean.getModifiedDatetime());
	    stmt.setLong(7, bean.getId());
	    int i=stmt.executeUpdate();
	    DataPool.closeConnection(conn);
	    System.out.println("query updated=>"+i);
	   
   }

public void delete(long id) throws Exception {
	 Connection conn= DataPool.getConnection();
	 PreparedStatement stmt=conn.prepareStatement(" delete from st_role where id=?");
	stmt.setLong(1,id);
	int i=stmt.executeUpdate();
	DataPool.closeConnection(conn);
	System.out.println("query deleted=>"+i);
}
public RoleBean  findByPk(long id) throws Exception {
	 Connection conn= DataPool.getConnection();
	 PreparedStatement stmt=conn.prepareStatement(" select * from st_role where id=? ");
	 stmt.setLong(1, id);
	 ResultSet r=stmt.executeQuery();
	 RoleBean bean=null;
	 while(r.next()) {
		 bean=new RoleBean();
		 bean.setId(r.getLong(1));
		 bean.setName(r.getString(2));
		 bean.setDescription(r.getString(3));
		 bean.setCreatedBy(r.getString(4));
		 bean.setModifiedBy(r.getString(5));
		 bean.setCreatedDatetime(r.getTimestamp(6));
		 bean.setModifiedDatetime(r.getTimestamp(7));
		
	 }
	 DataPool.closeConnection(conn);
	return bean;
}
public List search(RoleBean bean,int pageNo,int pageSize) throws Exception {
	 Connection conn= DataPool.getConnection();
	 StringBuffer sql=new StringBuffer(" select * from st_role where 1=1 ");
	 
	 if(bean!=null) {
		 if(bean.getId()>0) {
			sql.append(" and id ="+bean.getId()); 
		 }
		 if(bean.getName()!=null && bean.getName().length()>0) {
			 sql.append(" and name like '"+bean.getName()+"%'");
		 }
	 }
	 if(pageSize>0) {
		 pageNo=(pageNo-1)*pageSize;
		 sql.append("  limit  " + pageNo + " ," + pageSize);
	 }
	 System.out.println("sql=>"+sql);
	 
	PreparedStatement stmt=conn.prepareStatement(sql.toString());
	ResultSet r=stmt.executeQuery();
	List list=new ArrayList();
    while(r.next()) {
    	 bean=new RoleBean();
		 bean.setId(r.getLong(1));
		 bean.setName(r.getString(2));
		 bean.setDescription(r.getString(3));
		 bean.setCreatedBy(r.getString(4));
		 bean.setModifiedBy(r.getString(5));
		 bean.setCreatedDatetime(r.getTimestamp(6));
		 bean.setModifiedDatetime(r.getTimestamp(7));
		list.add(bean);	
    }
    
	return list;
	
}
}