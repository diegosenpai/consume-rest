package ec.com.orion.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CompanyData(String stageName, Long rowsReturnet, String status) {

}
