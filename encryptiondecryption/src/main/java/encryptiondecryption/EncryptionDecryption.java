package encryptiondecryption;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
public class EncryptionDecryption {
	

	    public static String encrypt(String plaintext, String key) throws Exception {
	        // Create a SecretKeySpec using the provided key
	        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

	        // Create a cipher instance for AES
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

	        // Encrypt the plaintext
	        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

	        // Encode the encrypted bytes as Base64
	        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

	        return encryptedText;
	    }

	    public static String decrypt(String encryptedText, String key) throws Exception {
	        // Create a SecretKeySpec using the provided key
	        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

	        // Create a cipher instance for AES
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);

	        // Decode the Base64 encrypted text
	        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

	        // Decrypt the encrypted bytes
	        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

	        // Convert the decrypted bytes to plaintext
	        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);

	        return decryptedText;
	    }

	    public static void main(String[] args) {
	        try {
	            String plaintext = "1234";
	            String key = "ThisIsASecretKey";

	            // Encryption
	            String encryptedText = encrypt(plaintext, key);
	            System.out.println("Encrypted Text: " + encryptedText);

	            // Decryption
	            String decryptedText = decrypt(encryptedText, key);
	            System.out.println("Decrypted Text: " + decryptedText);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


