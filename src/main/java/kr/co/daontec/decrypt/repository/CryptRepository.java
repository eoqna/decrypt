package kr.co.daontec.decrypt.repository;

import kr.co.daontec.decrypt.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CryptRepository extends JpaRepository<RegistrationEntity, String> {
    @Query(value = "SELECT " +
            "rgst_id, cust_nm " +
            "FROM tb_r_registration " +
            "WHERE info_1 != ''" +
            "ORDER BY info_1", nativeQuery = true)
    List<RegistrationEntity> findAllCustNm();
}