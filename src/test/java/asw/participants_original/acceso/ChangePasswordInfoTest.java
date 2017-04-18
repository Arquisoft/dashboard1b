package asw.participants_original.acceso;

import asw.Application;
import asw.participants_original.acceso.ChangePasswordInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ChangePasswordInfoTest {

    private ChangePasswordInfo changePasswordInfo;

    @Before
    public void setUp() throws Exception {
        changePasswordInfo = new ChangePasswordInfo("prueba");
    }

    @Test
    public void getMsg() throws Exception {
        assertThat(changePasswordInfo.getMsg()).isEqualTo("prueba");
    }

    @Test
    public void testToString() throws Exception {
        assertThat(changePasswordInfo.toString()).isEqualTo("ChangeInfo [ message: prueba]");
    }

}