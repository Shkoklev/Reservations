package com.sorsix.interns.reservations.api;

import com.sorsix.interns.reservations.model.Company;
import com.sorsix.interns.reservations.model.Owner;
import com.sorsix.interns.reservations.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompanies(@RequestParam(value = "type", required = false) String type,
                                      @RequestParam(value = "place", required = false) String place,
                                      @RequestParam(value = "query", required = false) String query) {
        if(query != null) {
            return companyService.getCompaniesByQuery(query);
        }
        return companyService.getCompanies(type, place);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        return companyService.getCompany(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String name) {
        return companyService.getCompanyByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
