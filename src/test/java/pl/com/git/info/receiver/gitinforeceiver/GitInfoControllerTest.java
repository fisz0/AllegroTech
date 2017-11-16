package pl.com.git.info.receiver.gitinforeceiver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitinforeceiverApplication.class)
@WebAppConfiguration
public class GitInfoControllerTest {

    private MockMvc mockMvc;

    private static final String userName = "fisz0";
    private static final String repositoryName = "AllegroTech";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getRepository() throws Exception {
        mockMvc.perform(get("/repositories/" + userName + "/" + repositoryName)).andExpect(status().isOk());
    }

    @Test
    public void repositoryNotFound() throws Exception {
        mockMvc.perform(get("/repositories/" + userName + "/" + repositoryName + "2")).andExpect(status().is4xxClientError());
    }

    @Test
    public void userNotFound() throws Exception {
        mockMvc.perform(get("/repositories/" + userName + "3/" + repositoryName)).andExpect(status().is4xxClientError());
    }
}