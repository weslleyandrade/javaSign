package br.com.javasign.key.impl;

import br.com.javasign.key.bean.KeyBean;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 12:31
 */
public class KeyManagerRSA extends KeyManagerAbstract {



    @Override
    public KeyBean generateKeys() {
        KeyBean keyBean = new KeyBean();

        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", this.config.getProvider());
            keyPairGenerator.initialize(256, new SecureRandom());
            KeyPair keys = keyPairGenerator.generateKeyPair();
            keyBean.setKeyToDecrypt(keys.getPrivate());
            keyBean.setKeyToEncrypt(keys.getPublic());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return keyBean;
    }
}
