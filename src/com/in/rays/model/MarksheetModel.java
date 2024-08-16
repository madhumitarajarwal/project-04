package com.in.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.in.rays.bean.MarksheetBean;
import com.in.rays.connection.DataPool;
import com.in.rays.exception.DuplicateRecordException;

public class MarksheetModel {
	public Integer nextPk() throws Exception {
		int pk=0;
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" select max(id) from st_marksheet");
		ResultSet r=stmt.executeQuery();
		while(r.next()) {
			pk=(int) r.getLong(1);
		}
		return pk+1;
		
	}
	public void add(MarksheetBean bean) throws Exception {
		MarksheetBean existBean=findByRollNo(bean.getRollNo());
		if(existBean!=null) {
			throw new DuplicateRecordException("rollno already exist");
		}
		
		int pk=nextPk();
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" insert into st_marksheet values(?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setLong(1, pk);
		stmt.setString(2, bean.getRollNo());
		stmt.setLong(3, bean.getStudentId());
		stmt.setString(4, bean.getName());
		stmt.setInt(5, bean.getPhysics());
		stmt.setInt(6, bean.getChemistry());
		stmt.setInt(7, bean.getMaths());
		stmt.setString(8, bean.getCreatedBy());
		stmt.setString(9, bean.getModifiedBy());
		stmt.setTimestamp(10, bean.getCreatedDatetime());
		stmt.setTimestamp(11, bean.getModifiedDatetime());
		int i = stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println(" query added==>" + i);

	}
	public void update(MarksheetBean bean) throws Exception {
		MarksheetBean existBean = findByRollNo(bean.getRollNo());
		
		if(existBean!=null && existBean.getRollNo()!=bean.getRollNo()) {
			throw new DuplicateRecordException("Roll No is already exist");
		}
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" update st_marksheet set roll_no=?,student_id=?,name=?,physics=?,chemistry=?,maths=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime=? where id=? ");
		stmt.setString(1, bean.getRollNo());
		stmt.setLong(2, bean.getStudentId());
		stmt.setString(3, bean.getName());
		stmt.setInt(4, bean.getPhysics());
		stmt.setInt(5, bean.getChemistry());
		stmt.setInt(6, bean.getMaths());
		stmt.setString(7, bean.getCreatedBy());
		stmt.setString(8, bean.getModifiedBy());
		stmt.setTimestamp(9, bean.getCreatedDatetime());
		stmt.setTimestamp(10, bean.getModifiedDatetime());
		stmt.setLong(11, bean.getId());
		int i = stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println(" query updated==>" + i);
		
	}
	public void delete(long id) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" delete  from st_marksheet where id=? ");
		stmt.setLong(1, id);
		int i=stmt.executeUpdate();
		DataPool.closeConnection(conn);
		System.out.println(" query deleted==>" + i);
		
	}
	public MarksheetBean findByPk(long id) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" select * from st_marksheet where id=? ");
		stmt.setLong(1, id);
		ResultSet r=stmt.executeQuery();
		MarksheetBean bean=null;
		while(r.next()) {
			bean=new MarksheetBean();
			bean.setId(r.getLong(1));
			bean.setRollNo(r.getString(2));
			bean.setStudentId(r.getLong(3));
			bean.setName(r.getString(4));
			bean.setPhysics(r.getInt(5));
			bean.setChemistry(r.getInt(6));
			bean.setMaths(r.getInt(7));
			bean.setCreatedBy(r.getString(8));
			bean.setModifiedBy(r.getString(9));
			bean.setCreatedDatetime(r.getTimestamp(10));
			bean.setModifiedDatetime(r.getTimestamp(11));
		}
		return bean;
		
	}
	public MarksheetBean findByRollNo(String roll_no) throws Exception {
		Connection conn = DataPool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(" select * from st_marksheet where roll_no=? ");
		stmt.setString(1, roll_no);
		ResultSet r=stmt.executeQuery();
		MarksheetBean bean=null;
		while(r.next()) {
			bean=new MarksheetBean();
			bean.setId(r.getLong(1));
			bean.setRollNo(r.getString(2));
			bean.setStudentId(r.getLong(3));
			bean.setName(r.getString(4));
			bean.setPhysics(r.getInt(5));
			bean.setChemistry(r.getInt(6));
			bean.setMaths(r.getInt(7));
			bean.setCreatedBy(r.getString(8));
			bean.setModifiedBy(r.getString(9));
			bean.setCreatedDatetime(r.getTimestamp(10));
			bean.setModifiedDatetime(r.getTimestamp(11));
		}
		return bean;
		
	}
	public List search(MarksheetBean bean,int pageNo,int pageSize) throws Exception {
		Connection conn = DataPool.getConnection();
		StringBuffer sql=new StringBuffer(" select * from st_marksheet where 1=1 ");
		if(bean!=null) {
			if(bean.getId()>0) {
				sql.append(" and id= "+bean.getId());
			}
			if(bean.getName()!=null && bean.getName().length()>0) {
				sql.append(" and name like '"+bean.getName()+"%'");
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			sql.append("  limit "+ pageNo + ","+ pageSize);
		}
		System.out.println("sql=>"+sql);
		PreparedStatement stmt = conn.prepareStatement(sql.toString());
		ResultSet r=stmt.executeQuery();
		List list=new ArrayList();
		while(r.next()) {
			bean=new MarksheetBean();
			bean.setId(r.getLong(1));
			bean.setRollNo(r.getString(2));
			bean.setStudentId(r.getLong(3));
			bean.setName(r.getString(4));
			bean.setPhysics(r.getInt(5));
			bean.setChemistry(r.getInt(6));
			bean.setMaths(r.getInt(7));
			bean.setCreatedBy(r.getString(8));
			bean.setModifiedBy(r.getString(9));
			bean.setCreatedDatetime(r.getTimestamp(10));
			bean.setModifiedDatetime(r.getTimestamp(11));
			list.add(bean);
		}
		
		return list;
		
		
	}
}
