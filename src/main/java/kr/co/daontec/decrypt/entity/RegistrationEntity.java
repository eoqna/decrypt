package kr.co.daontec.decrypt.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_r_registration")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RegistrationEntity {
    @Id
    private int rgstId;
    private String custNm;
}
