package ec.com.orion.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JobResult(String JobStatus, String restApiName, RunResults runResults, boolean succeeded) {

}
