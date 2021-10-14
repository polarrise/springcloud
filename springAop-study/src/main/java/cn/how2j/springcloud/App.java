package cn.how2j.springcloud;

import cn.how2j.springcloud.springAop.IUserService;
import cn.how2j.springcloud.springAop.Impl.PersonServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 */
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAspectJAutoProxy  //添加@EnableAspectJAutoProxy注解来放开代理的使用
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new AnnotationConfigApplicationContext(App.class);
        IUserService bean = ac.getBean(IUserService.class);
        bean.log1();
        System.out.println("-------------------");
        bean.log2();

        System.out.println("********");
        PersonServiceImpl personService = ac.getBean(PersonServiceImpl.class);
        personService.show();

    }
}
