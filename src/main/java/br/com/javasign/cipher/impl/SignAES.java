package br.com.javasign.cipher.impl;

import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Key;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 26/07/13
 * Time: 17:17
 */
public class SignAES extends SignAbstract {

    private static final String ALGORITHM = "AES";
    private static final String ALGORITHM_MODE_PADDING = ALGORITHM + "/ECB/PKCS7Padding";

    public SignAES() {
        super();
    }

    @Override
    public byte[] encrypt(byte[] dataToEncrypt, byte[] keyToEncrypt) {
        byte[] dataEncrypted = null;
        try {
            Key key = this.convertKey(keyToEncrypt);

            dataEncrypted = this.cipher(dataToEncrypt,ALGORITHM_MODE_PADDING,key);

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return dataEncrypted;
    }

    @Override
    public byte[] decrypt(byte[] dataEncrypted, byte[] keyToDecrypt) {
        byte[] dataDecrypted = null;
        try {

            Key key = this.convertKey(keyToDecrypt);

            dataDecrypted = this.decipher(dataEncrypted,ALGORITHM_MODE_PADDING,key);

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return dataDecrypted;
    }

    private Key convertKey(byte[] key){
        return new SecretKeySpec(key,ALGORITHM);
    }
}
