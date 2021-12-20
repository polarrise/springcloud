package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 @Component:把当前类对象存入Spring容器中,相当于在xml中配置一个bean标签.value属性指定bean的id,默认使用当前类的首字母小写的类名.
 @Controller,@Service,@Repository 三个注解都是@Component的衍生注解,作用及属性都是一模一样的.只是提供了更加明确语义.@Controller用于表现层,@Service用于业务层，@Repository用于持久层。
 */
@Component
public class ProductClientFeignHystrix implements ProductClientFeign{

    @Override
    public List<Product> listProdcuts() {
        List<Product> result = new ArrayList<>();
        result.add(new Product(0,"产品数据微服务不可用",0));
        return result;
    }
}
