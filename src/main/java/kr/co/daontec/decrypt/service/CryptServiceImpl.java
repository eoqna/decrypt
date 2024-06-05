package kr.co.daontec.decrypt.service;

import kr.co.daontec.decrypt.entity.RegistrationEntity;
import kr.co.daontec.decrypt.repository.CryptRepository;
import kr.co.daontec.decrypt.util.Crypto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CryptServiceImpl implements CryptService {
    private final CryptRepository cryptRepository;

    @Override
    public List<String> decryptCustNmByKey(String key, String iv) {
        List<RegistrationEntity> data = cryptRepository.findAllCustNm();
        List<String> result = new ArrayList<>();

        try {
            for(RegistrationEntity entity : data) {
                result.add(Crypto.decryptToAES256(entity.getCustNm(), key, iv));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return result;
    }

    @Override
    public String encryptCustNmByKey(String key, String iv, String custNm) {
        try {
            log.info("Cust Name : {}, AES_KEY : {}, AES_IV : {}", custNm, key, iv);
            return Crypto.encryptToAES256(custNm, key, iv);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return null;
    }
}
