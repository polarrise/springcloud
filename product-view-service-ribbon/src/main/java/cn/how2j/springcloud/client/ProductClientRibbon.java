package cn.how2j.springcloud.client;

import cn.how2j.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 访问注册好的数据微服务了。 springcloud 提供了两种方式，一种是 Ribbon，一种是 Feign。
 * Ribbon 是使用 restTemplate 进行调用，并进行客户端负载均衡。什么是客户端负载均衡呢？ 在前面注册数据微服务里，注册了8001和8002两个微服务， Ribbon会从注册中心获知这个信息，然后由 Ribbon 这个客户端自己决定是调用哪个，这个就叫做客户端负载均衡。
 * Feign 是什么呢？ Feign 是对 Ribbon的封装，调用起来更简单。。。
 *
 * @Component:把当前类对象存入Spring容器中,相当于在xml中配置一个bean标签.value属性指定bean的id,默认使用当前类的首字母小写的类名.
 * @Controller,@Service,@Repository 三个注解都是@Component的衍生注解,作用及属性都是一模一样的.只是提供了更加明确语义.@Controller用于表现层,@Service用于业务层，@Repository用于持久层。
 *
 */
@Component
public class ProductClientRibbon {

    @Autowired
    RestTemplate restTemplate;

    public List<Product> listProdcuts() {
        /*
Ribbon 客户端， 通过 restTemplate 访问 http://PRODUCT-DATA-SERVICE/products ， 而product-data-service既不是域名也不是ip地址，而是数据服务在eureka注册中心的名称。
注意看，这里只是指定了要访问的 微服务名称，但是并没有指定端口号到底是 8001, 还是 8002.
         */
        return restTemplate.getForObject("http://product-data-service/products", List.class);
    }

}
