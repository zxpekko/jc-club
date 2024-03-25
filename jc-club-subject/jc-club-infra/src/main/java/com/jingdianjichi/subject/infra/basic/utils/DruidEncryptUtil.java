package com.jingdianjichi.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @Author:zxp
 * @Description:数据库加密
 * @Date:19:02 2024/3/19
 */
public class DruidEncryptUtil {
    private static String publicKey;
    private static String privateKey;
    static {
        try {
            String[] strings = ConfigTools.genKeyPair(512);
            privateKey=strings[0];
            publicKey=strings[1];
            System.out.println("publicKey :"+publicKey);
            System.out.println("privateKey :"+privateKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }
    public static String encrypt(String planText) throws Exception {
        String encrypt = ConfigTools.encrypt(privateKey,planText);
        System.out.println("encrypt :"+encrypt);
        return encrypt;
    }
    public static String decrypt(String encryptTex) throws Exception {
        String decrypt = ConfigTools.decrypt(publicKey,encryptTex);
        System.out.println("decrypt :"+decrypt);
        return decrypt;
    }

    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("");
        System.out.println("encrypt :"+encrypt);
        System.out.println(ConfigTools.decrypt("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKjZ26fhDlgOSMGfmUGHXrNQnBRo8z3qccS4V5FHw8OH8SOgCLz+a3caA6h6CKbHKEfzx/b5yxrgur0UVb+OYxMCAwEAAQ==", "gLaE6POG3veRP25yrsfXsdIHQ6gFgMs6BKhVIicwWpauwsvquNXOdfcqyvLpsz9gK5IgPwmhJQt02dNYjSPTwA=="));
    }
}
