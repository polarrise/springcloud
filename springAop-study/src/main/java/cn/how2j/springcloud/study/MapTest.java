package cn.how2j.springcloud.study;

import cn.how2j.springcloud.springAop_ibuy.IBuy;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("1",1);
        System.out.println(map.get("1"));

        Test test =message -> System.out.println("ibuy"+message);
        test.buy("boll");

         Test test1=new Test() {
             @Override
             public void buy(String message) {
                 System.out.println("Test的buy执行--");
             }
         };
        test1.buy("1");
    }
}
