package cn.how2j.springcloud.springAop_ibuy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Configuration可理解为用spring的时候xml里面的<beans>标签
 * @Bean可理解为用spring的时候xml里面的<bean>标签
 * @ComponentScan 的作用就是根据定义的扫描路径，把符合扫描规则的类装配到spring容器中,basePackageClasses: 用于指定某个类的包的路径进行扫描
 * @EnableAspectJAutoProxy注解，启用了 AOP 功能
 */
@Configuration
@ComponentScan(basePackageClasses = {cn.how2j.springcloud.springAop_ibuy.IBuy.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
