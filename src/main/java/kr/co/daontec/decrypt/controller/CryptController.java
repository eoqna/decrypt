package kr.co.daontec.decrypt.controller;

import kr.co.daontec.decrypt.service.CryptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CryptController {
    private final CryptService cryptService;

    @PostMapping("decrypt/cust-nm")
    public List<String> decryptCustNmByAES256(@RequestBody Map<String, String> request) {
        log.info("====================================================");

        return cryptService.decryptCustNmByKey(request.get("aes_key"), request.get("aes_iv"));
    }

    @PostMapping("encrypt/cust-nm")
    public String encryptCustNmByAES256(@RequestBody Map<String, String> request) {
        log.info("====================================================");

        return cryptService.encryptCustNmByKey(request.get("aes_key"), request.get("aes_iv"), request.get("cust_nm"));
    }
}
