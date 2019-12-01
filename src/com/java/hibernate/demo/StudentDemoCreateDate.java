package com.java.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.demo.entity.Student;
import com.java.utils.DateUtils;

public class StudentDemoCreateDate {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
													.addAnnotatedClass(Student.class)
													.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            Student student = new Student("Paully", "Doe", "paul@luv.com", theDateOfBirth);
			
			//start a transaction
			session.beginTransaction();
			
			// save transation
			System.out.println("saving Student Object");
			session.save(student);
			
			// commit tranaction
			session.getTransaction().commit();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			factory.close();
		}
	}

}
