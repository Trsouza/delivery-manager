package com.api.deliverymanager.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {

    @PreAuthorize("hasAnyAuthority('ROLE_ADM', 'ROLE_COMPANY', 'ROLE_EMPLOYEE')")
    @Retention(RUNTIME)
    @Target(METHOD)
    @interface CanAccessAnyAuthority { }

    @PreAuthorize("hasAuthority('ROLE_ADM')")
    @Retention(RUNTIME)
    @Target(METHOD)
    @interface CanAccessOnlyAuthorityAdministrator { }
    
    @PreAuthorize("hasAnyAuthority('ROLE_ADM', 'ROLE_COMPANY')")
    @Retention(RUNTIME)
    @Target(METHOD)
    @interface CanAccessOnlyAuthorityAdministratorOrCompany { }
}