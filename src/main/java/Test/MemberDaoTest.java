package Test;

import config.ApplicationConfig;
import dao.MemberDao;
import dao.MemberRoleDao;
import dto.Member;
import dto.MemberRole;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.MemberService;
import service.UserEntity;

import javax.sql.DataSource;
import java.sql.Connection;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MemberDaoTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    MemberDao memberDao;

    @Autowired
    MemberRoleDao memberRoleDao;

    @Autowired
    MemberService memberService;

    @Test
    public void configTest() throws Exception{
        // 아무 작업도 하지 않는다. 실행이 잘된다는 것은 Spring 설정이 잘 되어 있다는 것을 의미한다.
    }
    @Test
    public void connnectionTest() throws Exception{
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
        System.out.println(connection);
        //여기까지는 연결 잘됨
    }

    @Test
    public void getUser() throws Exception{
        Member member =memberDao.getMemberByEmail("sun545427@naver.com");
        Assert.assertNotNull(member);
        Assert.assertEquals("이선영", member.getName());
        System.out.println(member.getEMAIL()+member.getMEMBER_PASSWORD());
        //여기까지 구현 잘됨 데이터베이스에서 잘 가져오고 있다는뜻!
    }


//    @Test
//    public void getRoleUser() throws Exception{
//        Member member = (Member) memberRoleDao.getRoleByEmail("launcher37@naver.com");
//        Assert.assertNotNull(member);
//        Assert.assertEquals("주동호", member.getName());
//        System.out.println(member.getName());
//        //여기까지 구현 잘됨 데이터베이스에서 잘 가져오고 있다는뜻!
//    }
}
