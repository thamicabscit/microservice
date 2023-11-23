package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.controller.Controller;
import com.example.entity.Entity;
import com.example.repo.Repo;

@SpringBootTest
class Demo11ApplicationTests {

	@Autowired
	private Controller cont;

	@MockBean
	private Repo repo;

	@Test
	public void employeetest() {
		Entity emp = new Entity();

		emp.setName("Jai");
		emp.setAge(23);
		emp.setSalary(35000.0);

		String name = emp.getName();
		int age = emp.getAge();
		double salary = emp.getSalary();

		assertEquals("Jai", name);
		assertEquals(23, age);
		assertEquals(35000.0, salary, 0.01);
	}

	
	@Test
    public void testGet() {
        List<Entity> emp = new ArrayList<>();
        when(repo.findAll()).thenReturn(emp);

        List<Entity> result = cont.getEmp();

        verify(repo, times(1)).findAll();
    }
	
	
//	@Test
//    public void testDelete() {
//		
//        int empId = 12; 
//
//        cont.delete(empId);
//
//        verify(repo, times(1)).deleteById(empId);
//    }
}
