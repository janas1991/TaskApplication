
package com.crud.tasks.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    @Value("${admin.name}")
    private String adminName;

    @Value("${admin.mail}")
    private String adminMail;

    @Value("{admin.company}")
    private String adminCompany;

    public String getAdminName() {
        return adminName;
    }

    public String getAdminMail() {
        return adminMail;
    }

    public String getAdminCompany() {
        return adminCompany;
    }
}