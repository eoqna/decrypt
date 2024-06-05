package kr.co.daontec.decrypt.service;

import java.util.List;

public interface CryptService {
    List<String> decryptCustNmByKey(String key, String iv);
    String encryptCustNmByKey(String key, String iv, String custNm);
}
