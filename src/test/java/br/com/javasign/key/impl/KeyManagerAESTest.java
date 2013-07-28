package br.com.javasign.key.impl;

import br.com.javasign.key.IKeyManager;
import br.com.javasign.key.bean.KeyBean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 13:14
 */
public class KeyManagerAESTest {
    private IKeyManager keyManager = new KeyManagerAES();

    @Test
    public void testGenerateKeys() throws Exception {
        KeyBean keyBean = this.keyManager.generateKeys();
        assertEquals(keyBean.getKeyToEncrypt(),keyBean.getKeyToDecrypt());
    }
}
