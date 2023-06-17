package ec.com.orion.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RunResults(CompanyData LN_SF_DIMENSIONES_COMPANIA) {

}
