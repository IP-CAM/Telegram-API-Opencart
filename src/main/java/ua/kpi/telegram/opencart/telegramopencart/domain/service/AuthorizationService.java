package ua.kpi.telegram.opencart.telegramopencart.domain.service;

public interface AuthorizationService {
    boolean hasTaxonomyUnitChangeAccess(String authentication);

    boolean hasRoleChangeChangeAccess(String authentication);
}
