public class CaesarCipher {
    public static String decrypt(String message, String[] alphabet) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (Character.isLetter(currentChar)) {
                char baseChar = Character.isLowerCase(currentChar) ? 'a' : 'A';
                int index = (currentChar - baseChar +3 ) % 26;
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

    public static void main(String[] args) {
        String[] letters = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        };

        String message1 = "Kfzb gly!";
        String message2 = "zlab zlab zlab";
        String message3 = "prmbozxifcoxdfifpqfzbumfxifalzflrp";

        System.out.println("Decrypted Message 1: " + decrypt(message1, letters));
        System.out.println("Decrypted Message 2: " + decrypt(message2, letters));
        System.out.println("Decrypted Message 3: " + decrypt(message3, letters));
    }
}
