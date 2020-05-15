package com.lucaaslb.Jokenpo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JokenpoApplication.class)
@AutoConfigureMockMvc
public class JokenpoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void helloApp() throws Exception {
		mvc.perform(get("/Jokenpô API Online!")).andExpect(status().isOk());
	}

}