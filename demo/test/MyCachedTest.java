import com.justin.ssm.po.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiashiqing on 17/6/3.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-bean.xml")
public class MyCachedTest {

    @Autowired
    private Student student;


    @Test
    public void Test() {
        System.out.println("---id---" + student.getId());
        System.out.println("---name---" + student.getName());
        System.out.println("---age---" + student.getAge());
    }


}
