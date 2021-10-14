package cn.how2j.springcloud.springAop_ibuy.Impl;

import cn.how2j.springcloud.springAop_ibuy.IBuy;
import org.springframework.stereotype.Component;

@Component
public class Girl implements IBuy {
    @Override
    public String buy() {
        System.out.println("女孩买了一件漂亮的衣服");
        return "衣服";
    }
}
