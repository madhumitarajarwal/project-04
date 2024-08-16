package com.in.rays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.in.rays.bean.FacultyBean;

public class FacultyTest {
	public static void main(String[] args) {

	}

	public static void testAdd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		FacultyBean bean = new FacultyBean();
		bean.setId(1);
		bean.setFirstName("anuradha");
		bean.setLastName("sharma");
		try {
			bean.setDob(sdf.parse("2018/05/02"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setGender("female");
		bean.setMobileNo("9981597448");
		bean.setEmail("anu@gmail.com");
		bean.setCollegeId(101);
		bean.setCollegeName("DAVV");
		bean.setSubjectId(101);
		bean.setCreatedBy("madhu@gmail.com");
		bean.setModifiedBy("madhu@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

	}

}
