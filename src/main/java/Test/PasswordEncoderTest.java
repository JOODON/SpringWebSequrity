package Test;

import config.ApplicationConfig;
import config.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
public class PasswordEncoderTest {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    public void passwordEncode() throws Exception{
        System.out.println(passwordEncoder.encode("kkjjss103@"));
    }
    //Password Encoder값을 설정해주는거!
    @Test
    public void passwrodTest() throws Exception{
        String encodePasswd="$2a$10$USbExG2YOZJqu5rR9eWAqO3NqwjS6c8uI0c695cnURA2gxqRnx41O";
        String password="1234";
        boolean test=passwordEncoder.matches(password,encodePasswd);
        //아마도 테스트라는 객체에 매치해서 비교해주는거가틈!
        System.out.println(test);
    }
}
