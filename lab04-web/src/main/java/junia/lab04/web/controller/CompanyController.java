package junia.lab04.web.controller;

import junia.lab04.core.entity.Company;
import junia.lab04.core.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CompanyController {
    private CompanyService companyService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    public CompanyController(CompanyService companyService) {
        LOGGER.info("CompanyController constructor called");
        LOGGER.debug("Parameter : {}", companyService.toString());
        this.companyService = companyService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListOfCompanies(ModelMap modelMap){
        LOGGER.info("CompanyController getListOfCompanies called");
        LOGGER.debug("Parameter : {}", modelMap.toString());
        List<Company> listOfCompanies = companyService.findAllWithProjects();
        LOGGER.trace("listOfCompanies created : {}", listOfCompanies.toString());
        modelMap.addAttribute("companies",listOfCompanies);
        LOGGER.debug("modelMap changed : {}", modelMap.toString());
        return "companiesList";

    }
    @RequestMapping("/form")
    public String getForm(ModelMap modelMap){
        LOGGER.info("CompanyController getForm called");
        LOGGER.debug("Parameter : {}", modelMap.toString());
        Company company = new Company();
        modelMap.addAttribute("company", company);
        LOGGER.debug("modelMap changed : {}", modelMap.toString());
        return "companyForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm (@ModelAttribute("company") Company company ){
        LOGGER.info("CompanyController submitForm called");
        LOGGER.debug("Parameter : {}", companyService.toString());
        companyService.save(company);
        LOGGER.debug("companyService changed : {}", companyService.toString());
        return "redirect:list";
    }
    @RequestMapping("/{id}/delete")
    public String deleteEntry (@PathVariable("id") long id){
        LOGGER.info("CompanyController deleteEntry called");
        LOGGER.debug("Parameter : {}", id);
        companyService.deleteById(id);
        LOGGER.debug("Parameter : {}", companyService.toString());
        return"redirect:/list";
    }

}
