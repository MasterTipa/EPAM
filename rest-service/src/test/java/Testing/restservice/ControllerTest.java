package Testing.restservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void testStandartParams() throws Exception {
        String uri = "/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertNotEquals(400, status);
    }
    @Test
    public void testNegativeNum1() throws Exception {
        String uri = "/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .param("num1", "-1000").param("num2", "1")).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }
    @Test
    public void testNegativeNum2() throws Exception {
        String uri = "/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .param("num1", "200").param("num2", "-2000")).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }
    @Test
    public void testNegativeNum3() throws Exception {
        String uri = "/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .param("num1", "300").param("num2", "30")
                .param("num2","-3000")).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
    @Test
    public void testOverfullParams() throws Exception {
        String uri = "/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .param("num1", "400a").param("num2", "40b")
                .param("num2","-4c")).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

}