import com.demo.dao.SeckillDao;
import com.demo.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Administrator on 2017/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    @Autowired
  private SeckillDao seckillDao;
    @Test
    public void queryAll() throws Exception{
        List<Seckill> seckillList=seckillDao.queryAll(0,100);
        for (Seckill seckill:seckillList){
            System.out.println(seckill);
        }
    }
}
