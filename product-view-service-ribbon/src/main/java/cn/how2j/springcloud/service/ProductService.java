package cn.how2j.springcloud.service;


import cn.how2j.springcloud.client.ProductClientRibbon;
import cn.how2j.springcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public List<Product> listProducts(){
        return productClientRibbon.listProdcuts();   //调用Ribbon, 是使用 restTemplate 进行调用，并进行客户端负载均衡

    }
}
