package by.training.java.grodno.az.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.training.java.grodno.az.data.model.Coefficient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-spring-context.xml")
public class CoefficientServiceTest {
	
	@Autowired
	private CoefficientService service;
	
	public void insertTest(){
		Coefficient coefficient=new Coefficient();
		
	}

}
