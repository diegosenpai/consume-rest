package ec.com.orion.spring;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ec.com.orion.spring.model.JobResult;

@SpringBootApplication
public class ConsumeRestApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumeRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumeRestApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
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

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			ResponseEntity<JobResult> quote = restTemplate.exchange(
					"https://srvdatastage3.pronaca.corp:9443/ibm/iis/api/dscdesignerapi?api=getDSJobStatus&jobName=DWH_SA_EXT_FL_TH_DIMENSIONESCOMPANIA&projectName=DWH_PRODUCCION_AGR&hostName=srvdatastage3&getFullOutput=true&apiVersion=LATEST",
					HttpMethod.GET, new HttpEntity<JobResult>(createHeaders("diego", "prueba")), JobResult.class);
			log.info(quote.toString());
		};
	}
}
