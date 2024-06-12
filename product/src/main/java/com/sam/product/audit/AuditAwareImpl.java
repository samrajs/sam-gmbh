package com.sam.product.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String>
{
    //public Optional<String> getCurrentAuditor() {
    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor.
     */

    public Optional<String> getCurrentAuditor() {
        return Optional.of("ACCOUNTS_MS");
    }
	
}
