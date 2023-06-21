package ec.com.orion.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobExecution {

	private String result;
	private String JobStatus;
	private String dataFlowName;
	private String restApiName;
	private boolean succeeded;

	public JobExecution(String result, String jobStatus, String dataFlowName, String restApiName, boolean succeeded) {
		super();
		this.result = result;
		JobStatus = jobStatus;
		this.dataFlowName = dataFlowName;
		this.restApiName = restApiName;
		this.succeeded = succeeded;
	}

	
	
	public JobExecution() {
		
	}



	public String getResult() {
		return result;
	}

	public String getJobStatus() {
		return JobStatus;
	}

	public String getDataFlowName() {
		return dataFlowName;
	}

	public String getRestApiName() {
		return restApiName;
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public String generarMensaje() {
		if (succeeded) {
			return String.format("Servicio ejecutado correctamente. Result:%s, jobStatus:%s, dataFlowName:%s", result,
					JobStatus, dataFlowName);
		}
		return String.format("Error al ejecutar el servicio. Detalle:%s-%s", result,JobStatus);
	}

}
