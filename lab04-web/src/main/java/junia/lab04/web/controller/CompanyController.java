package junia.lab04.web.controller;

import junia.lab04.core.entity.Company;
import junia.lab04.core.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListOfCompanies(ModelMap modelMap){
        List<Company> listOfCompanies = companyService.findAllWithProjects();
        modelMap.addAttribute("companies",listOfCompanies);
        return "companiesList";

    }
    @RequestMapping("/form")
    public String getForm(ModelMap modelMap){
        Company company = new Company();
        modelMap.addAttribute("company", company);
        return "companyForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm (@ModelAttribute("company") Company company ){
        companyService.save(company);
        return "redirect:list";
    }
    @RequestMapping("/*/delete")
    public String deleteEntry (Company company){
        companyService.deleteById(company.getId());
        return"redirect:list";
    }

}
