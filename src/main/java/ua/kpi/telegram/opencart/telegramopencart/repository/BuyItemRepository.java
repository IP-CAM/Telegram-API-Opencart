package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;

public interface BuyItemRepository extends JpaRepository<BuyItem, Long> {
}
