import com.demo.dao.SeckillDao;
import com.demo.dao.UserDao;
import com.demo.dao.UserRoleDao;
import com.demo.entity.Role;
import com.demo.entity.Seckill;
import com.demo.entity.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring/spring-dao.xml"})
public class Test {
    @Autowired
    UserDao userDao;

    @Autowired
    SeckillDao seckillDao;

    @Autowired
    UserRoleDao userRoleDao;
    @org.junit.Test
    public void aVoid(){
        User user=new User();
        user.setUsername("de");
        user.setPassword("54564");
        userDao.save(user);
    }
    @org.junit.Test
    public void findByUserName(){
        User user=new User();
        user.setUsername("de");
        user.setPassword("54564");
        userDao.save(user);
userRoleDao.setRoleByUserId(user.getId());
List<Role> list=userRoleDao.getRoleByUserId(user.getId());

    }
    @org.junit.Test
    public void aVoid1(){
        List<Seckill> list=seckillDao.queryAll(0,10);
    }

}
