package asw.participants_original.acceso;

import asw.Application;
import asw.participants_original.acceso.GetParticipantInfoController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class GetParticipantInfoControllerTest {

    @Autowired
    @Mock
    private GetParticipantInfoController getParticipantInfoController;

    private MockMvc mock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mock = MockMvcBuilders.standaloneSetup(getParticipantInfoController).build();
    }

    @Test
    public void getInfoParticipant() throws Exception {
        this.mock.perform(post("/user")).andExpect(status().isUnsupportedMediaType());
        this.mock.perform(post("/user").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest());
    }

}