package ua.kpi.telegram.opencart.telegramopencart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.Goods;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Goods findByName(String name);
}
