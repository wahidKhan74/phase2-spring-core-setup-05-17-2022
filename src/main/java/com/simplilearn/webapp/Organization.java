package com.simplilearn.webapp;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simplilearn.webapp.bean.Employee;

public class Organization {

	public static void main(String[] args) {
		
		// Tightly coupled object  :: create employee object
		// Employee  employee = new Employee();
		
		// initialize properties
		// employee.setId(10001);
		// employee.setName("John Smith");
		// employee.setDept("Engineering");
		// employee.setSalary(5656.565);
		
		// System.out.println(employee);
		
		// Spring IOC Container: Inversion of control 
		// Dependency Injection (DI) is a design pattern that 
		// removes the dependency from the programming code so that it can be easy to manage and test the application.
		
		// 1. Application Context container
		ApplicationContext context = new ClassPathXmlApplicationContext("employee-bean.xml");
		Employee empOne = (Employee) context.getBean("empOne");
		Employee empTwo = context.getBean("empTwo",Employee.class);
		
		System.out.println(empOne);
		System.out.println(empTwo);
		
		System.out.println("-------------------------");
		// 2. Bean Factory Container
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions("employee-bean.xml");
		
		Employee emplOne = (Employee) beanFactory.getBean("empOne");
		
		Employee emplTwo = beanFactory.getBean("empTwo",Employee.class);
		
		System.out.println(emplOne);
		System.out.println(emplTwo);
	}

}
