package cn.how2j.springcloud.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cn.how2j.springcloud.pojo.Product;

//@FeignClient(value = "PRODUCT-DATA-SERVICE")   Feign是什么呢？Feign是对Ribbon的封装，使用注解的方式，调用起来更简单。。。 也是主流的方式~ value:注册中心的数据微服务的名称
/*
所谓的断路器，就是当被访问的微服务无法使用的时候，当前服务能够感知这个现象，并且提供一个备用的方案出来。
比如在这个例子里，数据微服务无法使用了，如果有了断路器，那么视图微服务就能够知道此事，并且展示给用户相关的信息。 而不会报错或者一直卡在那里~
 */
@FeignClient(value = "PRODUCT-DATA-SERVICE",fallback = ProductClientFeignHystrix.class) //表示,如果访问的PRODUCT-DATA-SERVICE不可用的话,就调用ProductClientFeignHystrix来进行反馈信息。
public interface ProductClientFeign {

    @GetMapping("/api/products")        //这路径要与数据微服务里面的接口地址映射一模一样
    public List<Product> listProdcuts();
}
