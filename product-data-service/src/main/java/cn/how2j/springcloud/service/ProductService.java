package cn.how2j.springcloud.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.how2j.springcloud.pojo.Product;
/**
@Component:把当前类对象存入Spring容器中,相当于在xml中配置一个bean标签.value属性指定bean的id,默认使用当前类的首字母小写的类名.
@Controller,@Service,@Repository 三个注解都是@Component的衍生注解,作用及属性都是一模一样的.只是提供了更加明确语义.@Controller用于表现层,@Service用于业务层，@Repository用于持久层。
 */
@Service
public class ProductService {
    @Value("${server.port}")      //读取配置文件的属性
    String port;

    public List<Product> listProducts(){
        List<Product> ps = new ArrayList<>();
        ps.add(new Product(1,"product a from port:"+port, 50));
        ps.add(new Product(2,"product b from port:"+port, 150));
        ps.add(new Product(3,"product c from port:"+port, 250));
        return ps;
    }
}
