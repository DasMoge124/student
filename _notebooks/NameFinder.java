import java.lang.String;
public class NameFinder{
    public static String firstName(String name){
        String firstName = "";        
        //First name
        int spaceIndex = name.indexOf(" ");
        for (int i = 0; i<spaceIndex;i++){
            firstName += name.charAt(i);
        }
        return firstName;
    }
    public static String lastName(String name){
        String lastName = "";        
        //Last name
        int spaceIndex = name.indexOf(" ");
        for (int i = spaceIndex+1; i<name.length(); i++){
            lastName += name.charAt(i);
        }
        return lastName;
    }
    public static void main(String[] args){
        String name = "Ratchet Hammer";
        System.out.println(firstName(name));
        System.out.println(lastName(name));
    }
}
