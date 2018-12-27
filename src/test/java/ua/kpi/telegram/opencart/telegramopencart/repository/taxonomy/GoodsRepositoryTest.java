package ua.kpi.telegram.opencart.telegramopencart.repository.taxonomy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kpi.telegram.opencart.telegramopencart.domain.model.taxonomy.Goods;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class GoodsRepositoryTest {
    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    private Goods savedGoods;

    private final static String TEST_GOODS = "TestGoods";

    @Before
    public void setUp() {
        savedGoods = new Goods();
        savedGoods.setName(TEST_GOODS);

        testEntityManager.persist(savedGoods);
    }

    @Test
    public void shouldRemoveOneItem() {
        long removedItems = goodsRepository.deleteByName(TEST_GOODS);

        assertEquals(removedItems, 1);
    }

    @Test
    public void shouldReturnSavedGoodsOnFindByName() {
        Goods goods = goodsRepository.findByName(TEST_GOODS);

        assertEquals(savedGoods, goods);
    }
}
