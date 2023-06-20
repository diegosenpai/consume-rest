package ec.com.orion.spring.model;

public class JobData {

	private String api;
	private String jobName;
	private String projectName;
	private String hostName;

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public JobData(String api, String jobName, String projectName, String hostName) {
		super();
		this.api = api;
		this.jobName = jobName;
		this.projectName = projectName;
		this.hostName = hostName;
	}

	public String getUrl() {
		return String.format(
				"https://srvdatastage3.pronaca.corp:9443/ibm/iis/api/dscdesignerapi?api=%s&jobName=%s&projectName=%s&hostName=%s&getFullOutput=true&apiVersion=LATEST",
				api, jobName, projectName, hostName);

	}

}
