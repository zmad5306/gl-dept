package com.example.gl.dept;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class DeptApplicationTests {

//	@Test
//	public void contextLoads() {
//	}
	
	@Test
	public void smokeTest() {
		assertEquals(1, 1);
	}

}
