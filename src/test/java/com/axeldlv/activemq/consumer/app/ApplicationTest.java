package com.axeldlv.activemq.consumer.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.axeldlv.activemq.consumer.app.controller.WebController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicationTest.class)
@AutoConfigureMockMvc
public class ApplicationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
    private WebController userController;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void testGetApplication() throws Exception {
		this.mockMvc.perform(get("/"))
		.andExpect(status().isOk());
	}

	@Configuration
    @EnableWebMvc
    public static class TestConfiguration {

        public WebController contactController() {
            return new WebController();
        }
 
    }
	
}
