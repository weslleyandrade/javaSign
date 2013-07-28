package br.com.javasign.cipher;

/**
 * Created with IntelliJ IDEA.
 * User: Weslley Andrade
 * Date: 26/07/13
 * Time: 18:34
 */
public interface ISign {
    byte[] encrypt(byte[] dataToEncrypt, byte[] keyToEncrypt);
    byte[] decrypt(byte[] dataEncrypted, byte[] keyToEncrypt);
}
