package kr.co.daontec.decrypt.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class Crypto {
    public static String alg = "AES/CBC/PKCS5Padding";

    public static String encryptToAES256(String text, String key, String iv) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        byte[] encryptedText = text.getBytes(StandardCharsets.UTF_8);

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec); // 인스턴스 초기화 (암호화 모드 : Cipher.ENCRYPT_MODE)

        byte[] encrypted = cipher.doFinal(encryptedText);

        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decryptToAES256(String text, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance(alg);
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

            byte[] decodedBytes = Base64.getDecoder().decode(text);
            byte[] decrypted = cipher.doFinal(decodedBytes);

            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "";
    }
}
