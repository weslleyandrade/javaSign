package br.com.javasign.cipher.impl;

import br.com.javasign.cipher.ISign;
import br.com.javasign.key.IKeyManager;
import br.com.javasign.key.bean.KeyBean;
import br.com.javasign.key.impl.KeyManagerRSA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 00:10
 */
public class SignRSATest {
    private ISign sign = new SignRSA();
    private IKeyManager keyManager = new KeyManagerRSA();

    @Test
    public void testEncryptDecrypt() throws Exception {
        String str = "Test teste teste";
        byte[] bStr = str.getBytes();

        KeyBean keyBean = this.keyManager.generateKeys();

        byte[] encrypt =  this.sign.encrypt(bStr,keyBean.getKeyToEncrypt().getEncoded());
        byte[] decrypt =  this.sign.decrypt(encrypt,keyBean.getKeyToDecrypt().getEncoded());


        assertEquals(str,new String(decrypt));

    }
}
