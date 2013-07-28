package br.com.javasign.key.impl;

import br.com.javasign.key.bean.KeyBean;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 13:00
 */
public class KeyManagerAES extends KeyManagerAbstract {




    @Override
    public KeyBean generateKeys() {
        KeyBean keyBean = new KeyBean();
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES",this.config.getProvider());
            keyGenerator.init(128, new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();

            keyBean.setKeyToEncrypt(secretKey);
            keyBean.setKeyToDecrypt(secretKey);

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return keyBean;
    }
}
