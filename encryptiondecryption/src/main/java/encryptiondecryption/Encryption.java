package encryptiondecryption;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Encryption {
	
	    public static String calculateSHA256Hash(String string) {
	        try {
	            // Create an instance of the SHA-256 algorithm
	            MessageDigest sha256Digest = MessageDigest.getInstance("SHA-256");

	            // Convert the string to bytes
	            byte[] stringBytes = string.getBytes(StandardCharsets.UTF_8);

	            // Update the digest with the string bytes
	            byte[] hashBytes = sha256Digest.digest(stringBytes);

	            // Convert the hash bytes to hexadecimal representation
	            StringBuilder hexString = new StringBuilder();
	            for (byte hashByte : hashBytes) {
	                String hex = Integer.toHexString(0xff & hashByte);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }

	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public static void main(String[] args) {
	        String message = "123456";
	        String sha256Hash = calculateSHA256Hash(message);
	        System.out.println("SHA-256 Hash: " + sha256Hash);
	    }
	}



