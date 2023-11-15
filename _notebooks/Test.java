class Company{
    public String Name;
    public Company(String name){
        this.Name = name;
    }
}
class Workplace extends Company{
    public String name;
    public Workplace(String companyName, String Name){
        super(companyName);
        this.name = Name;
    }
}
class Worker extends Workplace{
    String name;
    public Worker(String companyName, String workplaceName, String name){
        super(companyName, workplaceName);
    }
}
public class Test{
    public void main(String[] args){
        System.out.println("Hell0o");
    }
}