package br.com.javasign.cipher.impl;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 00:08
 */
public class SignRSA extends SignAbstract {
    private static final String ALGORITHM = "RSA";
    private static final String ALGORITHM_MODE_PADDING = ALGORITHM + "/ECB/PKCS1Padding";

    public SignRSA() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Override
    public byte[] encrypt(byte[] dataToEncrypt, byte[] keyToEncrypt) {
        byte[] dataEncrypted = null;
        try {

            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyToEncrypt);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PublicKey key = keyFactory.generatePublic(keySpec);

            dataEncrypted = this.cipher(dataToEncrypt, ALGORITHM_MODE_PADDING, key);

        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return dataEncrypted;
    }

    @Override
    public byte[] decrypt(byte[] dataEncrypted, byte[] keyToDecrypt) {
        byte[] dataDecrypted = null;
        try {

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyToDecrypt);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PrivateKey key = keyFactory.generatePrivate(keySpec);

            dataDecrypted = this.decipher(dataEncrypted, ALGORITHM_MODE_PADDING, key);

        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return dataDecrypted;
    }
}
