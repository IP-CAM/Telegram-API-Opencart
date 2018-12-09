package ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Category;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class CategoryRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    private Category category1;

    private Category category2;

    private static final String CATEGORY1_NAME = "category1";

    private static final String CATEGORY2_NAME = "category2";

    @Before
    public void setUp() {
        category1 = new Category(CATEGORY1_NAME, "testCategory1");
        category2 = new Category(CATEGORY2_NAME, "testCategory2");

        Goods goods1 = new Goods("goods1", "desc1", 123);
        Goods goods2 = new Goods("goods2", "desc2", 123);
        Goods goods3 = new Goods("goods3", "desc3", 123);
        Goods goods4 = new Goods("goods4", "desc4", 12);

        category1.addToCategory(goods1);
        category1.addToCategory(goods2);

        category1.addToCategory(category2);
        category2.addToCategory(goods3);
        category2.addToCategory(goods4);

        testEntityManager.persist(category1);
    }

    @Test
    public void shouldReturnCategory1OnFindingCategoryByName() {
        Category category = categoryRepository.findByName(CATEGORY1_NAME);

        assertEquals(category1, category);
    }

    @Test
    public void shouldReturnCategory2OnFindingCategoryByName() {
        Category category = categoryRepository.findByName(CATEGORY2_NAME);

        assertEquals(category2, category);
    }

    @Test
    public void shouldReturnCategory1WhenGettingParentOfCategory2() {
        Category category = categoryRepository.findByName(CATEGORY2_NAME);

        assertEquals(category1, category.getParentCategory());
    }

    @Test
    public void shouldReturnCorrectGoodsOnCategory2() {
        Category category = categoryRepository.findByName(CATEGORY2_NAME);

        assertEquals(category2.getTaxonomyUnits(), category.getTaxonomyUnits());
    }
}
