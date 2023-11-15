import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class TheCryptographer {
    public static String shiftForward(String message, String[] alphabet, int shift) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (Character.isLetter(currentChar)) {
                char baseChar = Character.isLowerCase(currentChar) ? 'a' : 'A';
                int index = (currentChar - baseChar +shift ) % 26;
                char decryptedChar = alphabet[index].charAt(0);
                if (Character.isUpperCase(currentChar)){
                    decryptedChar = Character.toUpperCase(decryptedChar);
                }
                decryptedMessage.append(decryptedChar);
            } else {
                decryptedMessage.append(currentChar);
            }
        }

        return decryptedMessage.toString();
    }
    public static String Base64Encrypt(String message){
        try {
            byte[] bytes = message.getBytes("UTF-8");
            String encoded = Base64.getEncoder().encodeToString(bytes);
            return encoded;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    public static String decodeBase64(String base64Data) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64Data);
            return new String(decodedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args){
        String[] letters = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        };
        boolean Continue = true;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to The Cryptographer's Lab. We have 3 options for you for cryptography: Caesar Cipher[1], Base64 Encrypt[2], Base64 Decrypt [3]");
        while (Continue){
            Integer scan = input.nextInt();
            if (scan == 1){
                System.out.println("Alrighty, we're gonna do some caesar cipher. Tell me the message and how many times you wanna shift.");
                String message = input.next();
                Integer number = input.nextInt();
                System.out.print("Here is your shifted message: ");
                System.out.println(shiftForward(message, letters, number));
            }else if (scan == 2){
                System.out.println("Give me your message");
                String encrypt = input.next();
                System.out.print("Here is your encrypted message: ");
                System.out.println(Base64Encrypt(encrypt));
            }
            else if(scan == 3){
                System.out.println("What do you want me to decrypt? Be sure you give me NO = sign");
                String decrypt = input.next();
                System.out.print("Here is your decrypted message: ");
                System.out.println(decodeBase64(decrypt));
            }
            else if(scan == 0){
                System.out.println("Aight, I stopped");
                Continue = false;
            }
            else{
                System.out.println("REALLY? GIVE ME EITHER 1, 2, OR 3!");
            }
            System.out.println("Next?");
        }
        
    }
}
