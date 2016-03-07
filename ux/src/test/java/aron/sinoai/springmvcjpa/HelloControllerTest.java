package aron.sinoai.springmvcjpa;

import aron.sinoai.springmvcjpa.spring.HelloController;
import aron.sinoai.springmvcjpa.spring.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

//testing framework is like that: uses exception rather assertion
@SuppressWarnings({"ProhibitedExceptionDeclared", "JUnitTestMethodWithNoAssertions", "SuppressionAnnotation"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class HelloControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/testHello"))
                .andExpect(status().isOk())
                .andExpect(view().name(HelloController.HELLO_VIEW_TAG))
                .andExpect(model().attribute(HelloController.MESSAGE_PARAMETER_TAG, is(HelloController.SAMPLE_TEXT)));
    }
}
