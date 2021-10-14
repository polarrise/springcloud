package cn.how2j.springcloud.springAop_ibuy;

import cn.how2j.springcloud.springAop_ibuy.Impl.Boy;
import cn.how2j.springcloud.springAop_ibuy.Impl.Girl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

    /**
     * 使用AnnotationConfigApplicationContext可以实现基于Java的配置类加载Spring的应用上下文。避免使用application.xml进行配置。相比XML配置，更加便捷。
     * 使用AOP:我们并没有修改 Boy和Girl类的Buy方法，也没有修改测试类的代码,就在切点做了前置通知
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Boy boy = context.getBean("boy",Boy.class);
        Girl girl = (Girl) context.getBean("girl");
        boy.buy();
//        girl.buy();
    }
}
