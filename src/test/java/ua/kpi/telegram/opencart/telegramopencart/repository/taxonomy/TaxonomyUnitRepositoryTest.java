package ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.TaxonomyUnit;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TaxonomyUnitRepositoryTest {
    private static final String TEST_GOODS_NAME_1 = "testGoods1";

    private static final String TEST_GOODS_NAME_2 = "testGoods2";

    private static final String TEST_CATEGORY_NAME_1 = "testCategory1";

    private static final String TEST_CATEGORY_NAME_2 = "testCategory2";

    private static final String TEST_CATEGORY_NAME_3 = "testCategory3";

    private static Category TEST_CATEGORY_3 = new Category();

    private static Category TEST_CATEGORY_2 = new Category();

    private static Category TEST_CATEGORY_1 = new Category();

    private static Goods TEST_GOODS_1;

    private static Goods TEST_GOODS_2;

    @Autowired
    private TaxonomyUnitRepository taxonomyUnitRepository;

    @Before
    public void setUp() {
        TEST_CATEGORY_1 = new Category();
        TEST_CATEGORY_2 = new Category();
        TEST_CATEGORY_3 = new Category();

        TEST_GOODS_1 = new Goods();
        TEST_GOODS_2 = new Goods();

        TEST_CATEGORY_1.setName(TEST_CATEGORY_NAME_1);
        TEST_CATEGORY_2.setName(TEST_CATEGORY_NAME_2);
        TEST_CATEGORY_3.setName(TEST_CATEGORY_NAME_3);

        TEST_GOODS_1.setName(TEST_GOODS_NAME_1);
        TEST_GOODS_2.setName(TEST_GOODS_NAME_2);

        TEST_CATEGORY_1.addToCategory(TEST_CATEGORY_2);
        TEST_CATEGORY_2.addToCategory(TEST_CATEGORY_3);
        TEST_CATEGORY_2.addToCategory(TEST_GOODS_1);
        TEST_CATEGORY_3.addToCategory(TEST_CATEGORY_3);

        taxonomyUnitRepository.save(TEST_CATEGORY_1);
        taxonomyUnitRepository.save(TEST_CATEGORY_2);
        taxonomyUnitRepository.save(TEST_CATEGORY_3);
        taxonomyUnitRepository.save(TEST_GOODS_1);
        taxonomyUnitRepository.save(TEST_GOODS_2);
    }

    @Test
    public void shouldReturnTestGoods2() {
        TaxonomyUnit taxonomyUnit = taxonomyUnitRepository.findByName(TEST_GOODS_NAME_2);

        assertEquals(TEST_GOODS_2, taxonomyUnit);
    }

    @Test
    public void shouldReturnTestCategory3() {
        TaxonomyUnit taxonomyUnit = taxonomyUnitRepository.findByName(TEST_CATEGORY_NAME_3);

        assertEquals(TEST_CATEGORY_3, taxonomyUnit);
    }
}