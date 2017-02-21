package test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringTest {

    @Autowired
    private MockMvc mockMvc;
   


    @Autowired
    private WebApplicationContext context;
    @Before
    public void setup() {
        this.mockMvc =   MockMvcBuilders
            .webAppContextSetup(context)
        //    .apply(documentationConfiguration(this.restDocumentation))
            .alwaysDo(print())
                //.alwaysDo(restHandler)
            .build();
    }
    @Test
    public void getHello() throws Exception {
    	 MvcResult result = this.mockMvc.perform(get("/helloWorld/hello"))
    	           // .contentType(MediaType.APPLICATION_JSON)
    	            .andExpect(status().isOk())
    	            .andReturn();
    	
    }
}