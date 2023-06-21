package ec.com.orion.spring.service;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import ec.com.orion.spring.model.JobData;
import ec.com.orion.spring.model.JobExecution;
import ec.com.orion.spring.model.JobResult;

@Service
public class OnDemandJobOperator implements JobOperator {

	private RestTemplate restTemplate;

	public OnDemandJobOperator(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}

	@Override
	public JobExecution callJob(JobData data) {
		JobExecution okResult;
		try {
			ResponseEntity<JobExecution> calling = restTemplate.exchange(data.getUrl(), HttpMethod.GET,
					new HttpEntity<JobResult>(createHeaders("dwco.candrade", "Pronaca0202")), JobExecution.class);
			okResult = calling.getBody();
		} catch (RestClientException e) {
			return new JobExecution("Error al ejecutar job", e.getMessage(), "Error", "Error", false);
		}
		return okResult;
	}

}
