public class A {
    public void Run(){
        System.out.println("Hi");
    }
}
class B extends A{
    public void Running(){
        super.Run();
    }
}
class Test{
    public static void main(String[] args){
        B b = new A();
    }
}