package com.in.rays.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.in.rays.bean.RoleBean;
import com.in.rays.model.RoleModel;

public class RoleTest {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();
	}

	public static void testAdd() throws Exception {
		RoleBean bean = new RoleBean();
		bean.setId(1);
		bean.setName("prachi");
		bean.setDescription("description");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));

		RoleModel model = new RoleModel();
		model.add(bean);
	}

	public static void testUpdate() throws Exception {
		RoleBean bean = new RoleBean();
		bean.setName("priyanka");
		bean.setDescription("description");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		bean.setId(3);

		RoleModel model = new RoleModel();
		model.update(bean);

	}

	public static void testDelete() throws Exception {
		RoleModel model = new RoleModel();
		model.delete(4);
	}

	public static void testFindByPk() throws Exception {
		RoleModel model = new RoleModel();
		RoleBean bean = model.findByPk(1);
		if (bean != null) {
			System.out.print(" " + bean.getId());
			System.out.print(" " + bean.getName());
			System.out.print(" " + bean.getDescription());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.print(" " + bean.getModifiedDatetime());
		} else {
			System.out.println(" id not found ");
		}

	}

	public static void testSearch() throws Exception {
		
		RoleBean bean = new RoleBean();
		bean.setId(1);
		// bean.setName("m");

		RoleModel model = new RoleModel();
		List list = model.search(bean, 1, 1);
		Iterator i = list.iterator();
		while (i.hasNext()) {
			bean = (RoleBean) i.next();
			System.out.print(" " + bean.getId());
			System.out.print(" " + bean.getName());
			System.out.print(" " + bean.getDescription());
			System.out.print(" " + bean.getCreatedBy());
			System.out.print(" " + bean.getModifiedBy());
			System.out.print(" " + bean.getCreatedDatetime());
			System.out.print(" " + bean.getModifiedDatetime());

		}
	}
}
