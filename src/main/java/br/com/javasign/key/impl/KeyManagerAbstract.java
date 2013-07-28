package br.com.javasign.key.impl;

import br.com.javasign.config.Config;
import br.com.javasign.key.IKeyManager;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 28/07/13
 * Time: 12:33
 */
abstract class KeyManagerAbstract implements IKeyManager {

    final Config config;

    KeyManagerAbstract(){
        this.config = Config.getInstance();
    }

}
