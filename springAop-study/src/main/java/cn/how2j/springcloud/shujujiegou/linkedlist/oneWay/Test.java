package cn.how2j.springcloud.shujujiegou.linkedlist.oneWay;

import java.util.Arrays;

/**
 * @author jinbiao
 * @date 2021/12/7
 * @apiNote
 */
public class Test {

    public Node test(Node head){
        Node odd = head;          //odd为奇数节点
        Node even = head.next;
        odd.next = even.next;

        System.out.println(head);
        return head;
    }
    public int [] test1(int [] arr){
        System.out.println(arr);     //arr指向内存地址:[I@87aac27
        int[] temp = arr;           //temp:[1,2,3],   arr:[1,2,3]
        int[] temp1 = arr;          //temp1:[1,2,3],   arr:[1,2,3]
        System.out.println(temp);  //temp指向内存地址:[I@87aac27

        temp[0]=2;                 //temp:[2,2,3],  arr:[2,2,3]   temp  和arr都为数组地址的引用,指向同一个内存地址([I@87aac27),所以修改了temp的值就是修改了arr的值。。
        int [] tempArr={4,5,6};
        System.out.println(tempArr);  //tempArr指向内存地址->[I@3e3abc88
        temp=tempArr;            //temp:[4,5,6]   ,arr:[2,2,3]
        Arrays.stream(temp).forEach(a->{
            System.out.print(a);      //temp:456
        });
        Arrays.stream(temp1).forEach(a->{
            System.out.print(a);    //temp1:223
        });
        arr=null;             //arr:null
        return arr;
    }

    public int [] test3(int [] arr){
        System.out.println(arr);
        int[] temp = arr.clone();     //通过数组的clone方法,temp和arr引用在内存中的指向就不同了！   arr:[I@2e817b38 ,temp:[I@c4437c4
        System.out.println(temp);

        temp[0]=2;
        Arrays.stream(temp).forEach(a->{
            System.out.print(a);
        });
       return arr;
    }
    public static void main(String[] args) {
        //Node node3=new Node(3);
        //Node node2=new Node(2,node3);
        //Node node1=new Node(1,node2);
        //
        //new Test().test(node1);

        int []arr1={1,2,3};
        int[] ints1 = new Test().test1(arr1);
        System.out.println(ints1);


        //System.out.println();
        //int []arr2={1,2,3};
        //int[] ints2 = new Test().test3(arr2);
        //System.out.println();
        //Arrays.stream(ints2).forEach(a->{
        //    System.out.print(a);
        //});
    }


}
class Node {
    int val;           //存储的数据对象
    Node next;    //下一个节点对象的引用
    Node(int x) {
        val = x;
        next = null;
    }
    Node(int x, Node node) {
        val = x;
        next = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
