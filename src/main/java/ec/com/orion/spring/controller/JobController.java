package ec.com.orion.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.com.orion.spring.model.JobData;
import ec.com.orion.spring.model.JobExecution;
import ec.com.orion.spring.service.JobOperator;

@RequestMapping("/job")
@Controller
public class JobController {

	@Autowired
	public JobOperator jobOperator;

	@GetMapping
	public String proccessRequest(RedirectAttributes redirectAttributes) {
		JobData jobData = new JobData("runDSJob", "DWH_SA_EXT_FL_TH_DIMENSIONESCOMPANIA", "DWH_PRODUCCION_AGR",
				"srvdatastage3");
		JobExecution result = jobOperator.callJob(jobData);
		if (result.isSucceeded()) {
			redirectAttributes.addFlashAttribute("message", result.generarMensaje());
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", result.generarMensaje());
		}
		return "redirect:/";
	}

}
