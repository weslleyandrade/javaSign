package br.com.javasign.key.bean;

import java.security.Key;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 13:31
 */
public class KeyBean {
    private Key keyToEncrypt;
    private Key keyToDecrypt;

    public Key getKeyToEncrypt() {
        return keyToEncrypt;
    }

    public void setKeyToEncrypt(Key keyToEncrypt) {
        this.keyToEncrypt = keyToEncrypt;
    }

    public Key getKeyToDecrypt() {
        return keyToDecrypt;
    }

    public void setKeyToDecrypt(Key keyToDecrypt) {
        this.keyToDecrypt = keyToDecrypt;
    }
}
