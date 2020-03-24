package com.spring.homeservice;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.function.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.spring.homeservice.controller.HomeController;
import com.spring.homeservice.model.Home;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	HomeController hCtrl;

	@Test
	public void getOne() {
		String one = hCtrl.getOne(1);
		assertEquals("raja", one);
	}

	@Test
	public void getAll() {
		List<Home> all = hCtrl.getAll();
		all.forEach(new Consumer<Home>() {

			@Override
			public void accept(Home t) {
				System.out.println(t.getId() + "--" + t.getName() + "--" + t.getPassword());
			}
		});
	}

	@Test
	public void getOneRecord() {
		hCtrl.getOneRecord(1);
	}

}
