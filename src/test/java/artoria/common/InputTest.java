package artoria.common;

import artoria.entity.Student;
import artoria.logging.Logger;
import artoria.logging.LoggerFactory;
import artoria.random.RandomUtils;
import artoria.time.DateUtils;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Date;

public class InputTest {
    private static Logger log = LoggerFactory.getLogger(InputTest.class);

    @Test
    public void test1() {
        Input<Date> input = new Input<Date>();
        input.setCurrentUser(RandomUtils.nextObject(Student.class));
        input.setPaging(new Paging(1, 15));
        input.setData(new Date());
        Student currentUser = (Student) input.getCurrentUser();
        Paging paging = input.getPaging();
        Date data = input.getData();
        log.info(JSON.toJSONString(currentUser));
        log.info("{}", paging);
        log.info(DateUtils.format(data));
    }

}
