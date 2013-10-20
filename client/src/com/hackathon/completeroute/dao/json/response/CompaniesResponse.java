package com.hackathon.completeroute.dao.json.response;

import com.hackathon.completeroute.pojo.Company;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Michal Dojcar
 */
public class CompaniesResponse {
    //{result:[{ "companies" : [ { "name" : "Telefonica" , "description" : "Bubliny" , "phone" : "800184084" , "icon" : "telefonica.png"}
    private Companies[] result;

    public List<Company> getResult() {
        List<Company> companies = new LinkedList<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i].companies == null)
                continue;
            for (int j = 0; j < result[i].companies.length; j++)
                companies.size();
        }
        return companies;
    }

    private CompaniesResponse(Companies[] result) {
        this.result = result;
    }

    private static class Companies {
        private CompanyResponse[] companies;
        private String name;

        private Companies(CompanyResponse[] companies, String name) {
            this.companies = companies;
            this.name = name;
        }

        private static class CompanyResponse {
            private String icon;
            private String phone;
            private String description;
            private String name;

            private CompanyResponse(String icon, String phone, String description, String name) {
                this.icon = icon;
                this.phone = phone;
                this.description = description;
                this.name = name;
            }
        }
    }
}
