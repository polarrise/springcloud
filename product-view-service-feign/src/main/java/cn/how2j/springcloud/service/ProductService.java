package cn.how2j.springcloud.service;


import cn.how2j.springcloud.client.ProductClientFeign;
import cn.how2j.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientFeign productClientFeign;

    @GetMapping("/products")
    public List<Product> listProducts(){
        return productClientFeign.listProdcuts();
    }
}
