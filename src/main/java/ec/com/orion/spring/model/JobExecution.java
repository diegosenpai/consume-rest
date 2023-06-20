package ec.com.orion.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JobExecution(String result, String JobStatus, String dataFlowName, String restApiName,
		boolean succeeded) {

}
