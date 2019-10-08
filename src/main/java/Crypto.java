import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Crypto {
    //encrypt file using symmetric key
   void fileProcessor(int cipherMode, String key, File inputFile, File outputFile){
	try {
	    Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(cipherMode, secretKey);

            FileOutputStream outputStream;
            try (FileInputStream inputStream = new FileInputStream(inputFile)) {
                byte[] inputBytes = new byte[(int) inputFile.length()];
                inputStream.read(inputBytes);
                byte[] outputBytes = cipher.doFinal(inputBytes);
                outputStream = new FileOutputStream(outputFile);
                outputStream.write(outputBytes);
            }
	    outputStream.close();

	    } catch (NoSuchPaddingException | NoSuchAlgorithmException 
                     | InvalidKeyException | BadPaddingException
	             | IllegalBlockSizeException | IOException e) {
            }
    }
    //encrypt text using symmetric key
    String fileProcessor(int cipherMode, String key, String input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
			try
			{
				byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				IvParameterSpec ivspec = new IvParameterSpec(iv);
				String salt = "thisisasalt";
				SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
				KeySpec spec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
				SecretKey tmp = factory.generateSecret(spec);
				SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
				Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
				cipher.init(cipherMode, secretKey, ivspec);
				return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes("UTF-8")));
			}
			catch (Exception e)
			{
				System.out.println("Error while encrypting: " + e.toString());
			}
			return null;
   }


    //method to get symmetric key from the file and decrypt it
    String SymmetricKey(String path) throws Exception {
   		path = path + "symmetricKey.txt";
   		BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
   		String line = reader.readLine();
		AsymmetricCryptography ac = new AsymmetricCryptography();
		PrivateKey key = ac.getPrivate("appFiles/KeyPair/privateKey");
		line = ac.decryptText(line,key);
		if (line.length() == 37) {
			line = line.substring(5);
		}
		if (line.length() == 40) {
			line = line.substring(8);
		}
		return line;
	}


}

