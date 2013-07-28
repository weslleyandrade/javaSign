package br.com.javasign.cipher.impl;

import br.com.javasign.cipher.ISign;
import br.com.javasign.config.Config;

import javax.crypto.Cipher;
import java.security.GeneralSecurityException;
import java.security.Key;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 01:16
 */
abstract class SignAbstract implements ISign {
    private final Config config;
    SignAbstract() {
        this.config = Config.getInstance();
    }

    private byte[] cipher(byte[] data, String algorithm,int mode,Key key) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(algorithm, this.config.getProvider());

        cipher.init(mode,key);

        return cipher.doFinal(data);
    }

    byte[] cipher(byte[] data, String algorithm, Key key) throws GeneralSecurityException {
         return this.cipher(data,algorithm,Cipher.ENCRYPT_MODE,key);
    }

    byte[] decipher(byte[] data, String algorithm, Key key) throws GeneralSecurityException {
        return this.cipher(data,algorithm,Cipher.DECRYPT_MODE,key);
    }

}
