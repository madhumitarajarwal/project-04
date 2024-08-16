package com.in.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.SQLException;

import com.in.rays.bean.FacultyBean;
import com.in.rays.connection.DataPool;

public class FacultyModel {
	
	public void add(FacultyBean bean) throws Exception {
		
	    Connection conn=DataPool.getConnection();
		PreparedStatement stmt=conn.prepareStatement(" insert into st_faculty values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        stmt.setLong(1, bean.getId());
        stmt.setString(2,bean.getFirstName());
        stmt.setString(3, bean.getLastName());
        stmt.setDate(4,new java.sql.Date(bean.getDob().getTime()));
        stmt.setString(5, bean.getGender());
        stmt.setString(6, bean.getMobileNo());
        stmt.setString(7, bean.getEmail());
        stmt.setLong(8, bean.getCollegeId());
        stmt.setString(9, bean.getCollegeName());
        stmt.setLong(10, bean.getCourseId());
        stmt.setString(11, bean.getCourseName());
        stmt.setLong(12, bean.getSubjectId());
        stmt.setString(13, bean.getSubjectName());
        stmt.setString(14, bean.getCreatedBy());
        stmt.setString(15, bean.getModifiedBy());
        stmt.setTimestamp(16, bean.getCreatedDatetime());
        stmt.setTimestamp(17, bean.getModifiedDatetime());
        int i=stmt.executeUpdate();
        System.out.println(" query added==>"+i);
        
  }

}
