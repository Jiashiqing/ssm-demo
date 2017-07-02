import com.justin.ssm.po.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jiashiqing on 17/6/3.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-bean.xml")
public class SpringBeanTest {
//    public static void main(String[] args) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-bean.xml");
//        Animal animal = (Animal) ac.getBean("animal");
//        System.out.println(animal.speak());
//    }

//    @Resource(name = "person")
//    private Person person;

    @Resource(name = "animal")
    private Animal animal;

//    @Test
//    public void beanPersonTest(){
//        System.out.println("------"+person.getName());
//    }

    @Test
    public void beanAnimalTest() {
        System.out.println("------" + animal.speak());
    }


}
