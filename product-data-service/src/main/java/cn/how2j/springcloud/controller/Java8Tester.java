package cn.how2j.springcloud.controller;

public class Java8Tester {
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a,int b,MathOperation mathOperation){
        return mathOperation.operation(a,b);
    }
    /*2 */
    final static String salutation = "Hello! ";

    /*3 */
    public interface Converter<T1, T2> {
        void convert(int i);
    }

    public static void main(String[] args) {
        Java8Tester tester=new Java8Tester();
        //可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
        MathOperation add = (int a, int b) -> a + b;     //用类型int声明
        MathOperation sub=(a,b)->a-b;                   //不用类型声明

        // 可选的参数圆括号：一个参数无需定义圆括号,但多个参数需要定义圆括号。
        MathOperation mutipli=(a,b)-> {               // 大括号中的返回语句     可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
            return a * b;
        };
        MathOperation divid=(a,b)->a/b;             // 没有大括号及返回语句

        System.out.println("10 + 5 = "+tester.operate(10,5,add));
        System.out.println("10 - 5 = " +tester.operate(10,5,sub));
        System.out.println("10 * 5 = " +tester.operate(10,5,mutipli));
        System.out.println("10 / 5 = " +tester.operate(10,5,divid));

        // 不用括号( 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。)
        GreetingService greetService1 = message -> System.out.println("Hello " + message);  //message:入参。   '->' :相当于实现了接口中的方法，输出 System.out.println("Hello " + message)

        // 用括号
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);  //message:入参。 '->' :相当于实现了接口中的方法，输出 System.out.println("Hello " + message):

        greetService1.sayMessage("Runoob");  //Hello Runoob
        greetService2.sayMessage("Google"); //Hello Google

        /*2 */
        GreetingService greetService3 = message -> System.out.println(salutation + message);

        greetService3.sayMessage("WangJinbiao");
        //====================相当于下面==============================
        GreetingService g = new GreetingService() {
            @Override
            public void sayMessage(String message) {
//                salutation="111";        lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在lambda 内部修改定义在域外的局部变量，否则会编译错误。
                System.out.println(salutation + message);
            }
        };
        g.sayMessage("WangJinbiao");
        //====================相当于下面==============================

        /*3
        int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        s.convert(2);
        num = 5;
        */

    }
}
