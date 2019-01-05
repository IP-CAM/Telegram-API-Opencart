package ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
    Goods findByName(String name);

    Long deleteByName(String name);

    Goods findById(long goodsId);

    List<Goods> findAllByParentCategory_Id(long categoryId);
}
