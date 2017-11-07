import com.lanou.aop1.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/7.
 */
public class XMLAOPTest {

    private ApplicationContext ctx;

    @Before
    public void init(){
        //加载Spring的配置容器
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void aopTest(){
        UserDao userDao = (UserDao) ctx.getBean("userDao");
        System.out.println(userDao.getClass().getName());
        userDao.insert();
        System.out.println("------");
        userDao.delete();
    }
}
