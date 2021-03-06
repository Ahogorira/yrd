import com.zking.quartz.AutoMoney;
import com.zking.util.RedisTemplateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

    @Test
    public void test11()throws Exception{
        //1，任务调度器(Scheduler),从工厂中获取调度的实例
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        //设置任务开始时间
        Date startDate = new Date();
        startDate.setTime(startDate.getTime()+3000);

        //设置任务的结束时间
        Date endDate = new Date();
        //设置任务结束时间推迟5秒
        endDate.setTime(endDate.getTime()+5000);

        //2，任务实例（JobDetail）通过JobBuilder类获取
        JobDetail jobDetail = JobBuilder.newJob()//加载任务类完成绑定，该类必须实现Job接口
                .withIdentity("job1", "group1")//参数1：任务的名称（唯一） 参数2：任务组的名称
                .build();
        //3,触发器,定时器（Trigger） 通过TriggerBuider获取
        Trigger build = TriggerBuilder.newTrigger()
                .withIdentity("tigger1", "group1")//参数1.触发器名称，参数2：触发器组的名称
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))//5秒后重复执行
                .build();
        //4,让调度器关联任务和触发器
        defaultScheduler.scheduleJob(jobDetail,build);
        //启动
        defaultScheduler.start();
    }

    /**
     * 纯java发送短信接口调用
     * @param path
     * @throws Exception
     */
    public static void main(String path[]) throws Exception {

        Map<String,Object> map = new HashMap<>();
        map.put("name","是的");
        map.put("code","123456");
        URL u = new URL("http://route.showapi.com/28-1?showapi_appid=90784&mobile=16680913747&content={%22name%22:%22卧槽%22,%22code%22:%2249791%22}&tNum=T170317004265&big_msg=1&showapi_sign=36bb53e6712946d5b8bfd554e602cd17");
        InputStream in = u.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = in .read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } finally {
            if ( in != null) {
                in .close();
            }
        }
        byte b[] = out.toByteArray();
        System.out.println(new String(b, "utf-8"));
    }

}
