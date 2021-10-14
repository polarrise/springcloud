package cn.how2j.springcloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cn.how2j.springcloud.pojo.Product;

@FeignClient(value = "PRODUCT-DATA-SERVICE")   //Feign是什么呢？Feign是对Ribbon的封装，使用注解的方式，调用起来更简单。。。 也是主流的方式~ value:注册中心的数据微服务的名称
public interface ProductClientFeign {

    @GetMapping("/products")
    public List<Product> listProdcuts();
}
