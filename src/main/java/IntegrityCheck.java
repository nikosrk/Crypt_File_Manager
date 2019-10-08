import javax.crypto.Cipher;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.PublicKey;


public class IntegrityCheck {

    //Create encrypted signature for integrity check
     String signature(String path) throws Exception {
        String files = null;
        StringBuilder tempSignature = new StringBuilder();
        File folder = new File(path);
        File[] listofFiles = folder.listFiles();
        for(int i = 0; i < listofFiles.length; i++) {
            files = listofFiles[i].getName();
            //skip files that we dont need in the encrypted signature
            if((files.equals("encryptedSignature.txt")) || (files.equals("symmetricKey.txt"))){
                continue;
            }
            else {
                byte[] buffer = new byte[8192];
                int count;
                MessageDigest digest = MessageDigest.getInstance("SHA-224");
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "/" + files));
                while ((count = bis.read(buffer)) > 0) {
                    digest.update(buffer, 0, count);
                }
                bis.close();
                String Union = getChecksum(digest, new File(path + "/" + files));
                MessageDigest md = MessageDigest.getInstance("SHA-224");
                byte[] bytes = md.digest(Union.getBytes(StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < bytes.length; j++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                String generated = sb.toString();
                tempSignature.append(generated);
            }
        }
        String Signature = tempSignature.toString();
        AsymmetricCryptography ac = new AsymmetricCryptography();
        PublicKey publicKey = ac.getPublic("appFiles/KeyPair/privateKey");
        Signature = ac.encryptText(Signature, publicKey);

        Crypto crypto = new Crypto();
        String key = crypto.SymmetricKey(path);
        String EncryptedSignature = crypto.fileProcessor(Cipher.ENCRYPT_MODE,key,Signature);
        return EncryptedSignature;


    }
    //Method to create the <file,digest> string
    private static String getChecksum(MessageDigest digest, File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[1024];
        int bytesCount = 0;
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };
        fis.close();
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }


}
