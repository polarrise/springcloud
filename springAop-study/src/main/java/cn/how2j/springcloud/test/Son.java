package cn.how2j.springcloud.test;

/**
 如果子类重写了父类的一般方法，创建了这个子类对象时，父类的方法会被覆盖，如果用Fu fu=new Zi()进行调用fu.Show()时，这时应该输出子类的show方法。
 但是父类的static方法，和final方法，以及private方法不能被覆盖，因为和对象没关系，只和类有关系
 */
public class Son  extends  Father{

    public void test(){
        System.out.println("Son");
    }

    public static void main(String[] args) {
        Father fa=new Son();
        fa.test();
    }
}
