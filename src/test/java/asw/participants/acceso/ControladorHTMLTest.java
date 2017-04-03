package asw.participants.acceso;

import asw.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ControladorHTMLTest {

    @Autowired
    @Mock
    private ControladorHTML controladorHTML;

    private MockMvc mock;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mock = MockMvcBuilders.standaloneSetup(controladorHTML).build();
    }

    @Test
    public void getHTML() throws Exception {
        //this.mock.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void getHTMLChange() throws Exception {
        //this.mock.perform(get("/changeInfo")).andExpect(status().isOk());
    }

    @Test
    public void postHTML() throws Exception {
        this.mock.perform(post("/user","email=pablo@gmail.es","password=111111")).andExpect(status().isBadRequest());
    }

    @Test
    public void edad() {
        //TODO This test is not correct :/
        assertThat(controladorHTML.edad("1970-01-01")).isEqualTo(0);
    }

}