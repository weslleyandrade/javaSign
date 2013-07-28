package br.com.javasign.cipher.impl;

import br.com.javasign.cipher.ISign;
import br.com.javasign.key.IKeyManager;
import br.com.javasign.key.bean.KeyBean;
import br.com.javasign.key.impl.KeyManagerAES;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Before;
import org.junit.Test;

import java.security.Security;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade Santos
 * Date: 26/07/13
 * Time: 17:20
 */
public class SignAESTest {
    private ISign sign = new SignAES();
    private IKeyManager keyManager = new KeyManagerAES();
    @Before
    public void setUp() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    public void testEncryptDecrypt() throws Exception {
        String str = "Test teste teste";
        KeyBean keyBean = this.keyManager.generateKeys();
        byte[] bStr = str.getBytes();
        byte[] encrypt =  this.sign.encrypt(bStr,keyBean.getKeyToEncrypt().getEncoded());
        byte[] decrypt =  this.sign.decrypt(encrypt,keyBean.getKeyToDecrypt().getEncoded());

        assertEquals(str,new String(decrypt));
    }
}
