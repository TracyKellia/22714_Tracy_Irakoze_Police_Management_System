package Tracy.web.controller;

import Tracy.web.model.Prisoner;
import Tracy.web.service.PrisonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PrisonerController {

	@Autowired
	private PrisonerService prisonerService;

	// display list of prisoners
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "prisonerName", "asc", model);
	}

	@GetMapping("/showNewPrisonerForm")
	public String showNewPrisonerForm(Model model) {
		// create model attribute to bind form data
		Prisoner prisoner = new Prisoner("John doe", "jack mae", "arrested for robbery", "Jane Smith");
		model.addAttribute("prisoner", prisoner);
		return "new_prisoner";
	}

	@PostMapping("/savePrisoner")
	public String savePrisoner(@ModelAttribute("prisoner") Prisoner prisoner) {
		// save prisoner to database
		prisonerService.savePrisoner(prisoner);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		// get prisoner from the service
		Prisoner prisoner = prisonerService.getPrisonerById(id);

		// set prisoner as a model attribute to pre-populate the form
		model.addAttribute("prisoner", prisoner);
		return "update_prisoner";
	}

	@GetMapping("/deletePrisoner/{id}")
	public String deletePrisoner(@PathVariable(value = "id") long id) {
		// call delete prisoner method
		this.prisonerService.deletePrisonerById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(
			@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;

		Page<Prisoner> page = prisonerService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Prisoner> listPrisoners = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listPrisoners", listPrisoners);
		return "index";
	}
}
