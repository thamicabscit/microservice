package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Entity;

@SpringBootTest
class Demo11ApplicationTests {

	@Test
	public void employeetest()
	{
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

	 
 }

