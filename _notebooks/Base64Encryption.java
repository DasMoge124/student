import java.util.Base64;

public class Base64Encryption {
    public static String encodeToBase64(String message) {
        try {
            byte[] bytes = message.getBytes("UTF-8");
            String encoded = Base64.getEncoder().encodeToString(bytes);
            return encoded;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle the exception appropriately in your application
        }
    }

    public static void main(String[] args) {
        String message = "Hello, World!";
        String encodedData = encodeToBase64(message);
        System.out.println("Encoded Data: " + encodedData);
    }
}
