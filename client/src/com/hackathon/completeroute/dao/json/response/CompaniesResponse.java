package com.hackathon.completeroute.dao.json.response;

import com.hackathon.completeroute.pojo.Company;

import java.util.List;

/**
 * @author Michal Dojcar
 */
public class CompaniesResponse {
    //{result:[{ "companies" : [ { "name" : "Telefonica" , "description" : "Bubliny" , "phone" : "800184084" , "icon" : "telefonica.png"}
    private Companies[] result;

    public List<Company> getResult() {
        return null;
    }

    private CompaniesResponse(Companies[] result) {
        this.result = result;
    }

    private static class Companies {
        private CompanyResponse[] companyResponses;
        private Companies(CompanyResponse[] companyResponses) {
            this.companyResponses = companyResponses;
        }

        private static class CompanyResponse {
            private String name;
            private String description;
            private String phone;
            private String icon;
        }
    }
}
