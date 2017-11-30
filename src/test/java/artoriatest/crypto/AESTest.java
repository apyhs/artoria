package artoriatest.crypto;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import artoria.codec.Base64;
import artoria.crypto.AES;

public class AESTest {

    @Test
    public void test1() throws Exception {
        byte[] key = RandomStringUtils.randomAscii(32).getBytes();
        byte[] iv = RandomStringUtils.randomAscii(16).getBytes();
        System.out.println("key = " + new String(key));
        System.out.println("iv = " + new String(iv));
        AES aes = AES.on(AES.ECB_PKCS_5_PADDING, key);
        byte[] bytes = aes.encrypt("你好，Java！");
        System.out.println(Base64.encodeToString(bytes));
        System.out.println(new String(aes.decrypt(bytes)));
        AES aes1 = AES.on(AES.CBC_PKCS_5_PADDING, key).setIv(iv);
        byte[] bytes1 = aes1.encrypt("你好，Java！");
        System.out.println(Base64.encodeToString(bytes1));
        System.out.println(new String(aes1.decrypt(bytes1)));
    }

    @Test
    public void test2() throws Exception {
        byte[] key = RandomStringUtils.randomAscii(32).getBytes();
        byte[] iv = RandomStringUtils.randomAscii(16).getBytes();
        System.out.println("key = " + new String(key));
        System.out.println("iv = " + new String(iv));
        AES aes = AES.on(AES.ECB_NO_PADDING, key);
        byte[] bytes = aes.encrypt("你好，Java！1");
        System.out.println(Base64.encodeToString(bytes));
        System.out.println(new String(aes.decrypt(bytes)));
        AES aes1 = AES.on(AES.CBC_NO_PADDING, key).setIv(iv);
        byte[] bytes1 = aes1.encrypt("你好，Java！1");
        System.out.println(Base64.encodeToString(bytes1));
        System.out.println(new String(aes1.decrypt(bytes1)));
    }

}