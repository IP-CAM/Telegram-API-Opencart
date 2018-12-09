package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.BuyItem;

@Repository
public interface BuyItemRepository extends JpaRepository<BuyItem, Long> {
}
