
public class MyCaesar {
    public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private int n; // shift steps (right shift)

    public MyCaesar(int shiftSteps) {
        this.n = shiftSteps;
    }

    // Method to encrypt a character
    public char encryptChar(char c) {
        if (Character.isUpperCase(c)) {
            int index = c - 'A';
            int newIndex = (index + n) % 26;
            return ALPHABET[newIndex];
        } else {
            return c; // Return non-alphabet characters as-is
        }
    }

    // Method to encrypt a text
    public String encrypt(String input) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : input.toCharArray()) {
            encryptedText.append(encryptChar(c));
        }

        return encryptedText.toString();
    }

    // Method to decrypt a character
    public char decryptChar(char c) {
        if (Character.isUpperCase(c)) {
            int index = c - 'A';
            int newIndex = (index - n + 26) % 26;
            return ALPHABET[newIndex];
        } else {
            return c; // Return non-alphabet characters as-is
        }
    }

    // Method to decrypt a text
    public String decrypt(String input) {
        StringBuilder decryptedText = new StringBuilder();

        for (char c : input.toCharArray()) {
            decryptedText.append(decryptChar(c));
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        MyCaesar caesar = new MyCaesar(3); // Example: Shift by 3 positions

        // Test encrypt and decrypt methods
        String originalText = "HELLO WORLD";
        String encryptedText = caesar.encrypt(originalText);
        String decryptedText = caesar.decrypt(encryptedText);

        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}

