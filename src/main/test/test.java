
import com.zking.model.User;

import com.zking.util.RedisTemplateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class test {

    private static final Logger logger = LogManager.getLogger("test");
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;



    @Test
    public void testLog4j(){
        logger.debug("test");
    }

    @Test
    public void  test1(){
        Jedis jedis = new Jedis("192.168.42.128",6379);
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
        //jedis.lpush("uuu","abc");
    }

    @Test
    public void  test2(){
        /*List<String> ls = new ArrayList<String>();
        ls.add("惊了");
        for (String l : ls) {
            System.out.println(l);
        }*/

        redisTemplateUtil.set("abc","q32");
       //redisTemplateUtil.setList("YU",ls);

        System.out.println(1);
    }

}
