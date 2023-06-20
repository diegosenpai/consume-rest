package ec.com.orion.spring.service;

import ec.com.orion.spring.model.JobData;
import ec.com.orion.spring.model.JobExecution;

public interface JobOperator {

	JobExecution callJob(JobData data);

}
