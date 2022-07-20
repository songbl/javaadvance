package create.bulider.simple;

public class TestBuilder {


    public static void main (String args[]){

        Computer computer=new Computer.Builder("因特尔","三星")//创建内部类对象
                .setDisplay("三星24寸")
                .setKeyboard("罗技")    //最后调用builder()，创建外部类，对外展示得类对象，
                .setUsbCount(2)
                .build();


        System.out.println(    computer.toString());
    }

}
