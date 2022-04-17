package cn.how2j.springcloud.designpattern.sington;

/**
 * @author Jinbiao
 * @date 2022/4/12
 * @apiNote
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        instance1.print();
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance1==instance2);
    }
}

enum EnumSingleton{
    INSTANCE;
    public void print(){
        System.out.println("xxxx");
    }
}
