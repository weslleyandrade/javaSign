package br.com.javasign.key.impl;

import br.com.javasign.key.IKeyManager;
import br.com.javasign.key.bean.KeyBean;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 13:07
 */
public class KeyManagerRSATest {
    private IKeyManager keyManager = new KeyManagerRSA();

    @Test
    public void testGenerateKeys() throws Exception {
        KeyBean keyBean = this.keyManager.generateKeys();
        assertNotNull(keyBean.getKeyToEncrypt());
        assertNotNull(keyBean.getKeyToDecrypt());
    }
}
