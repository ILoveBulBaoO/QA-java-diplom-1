import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;
    private String name;
    private float price;
    @Before
    public void initBun() {
        bun = new Bun(name, price);
    }

    @Test
    // проверим, что метод getName возвращает имя
    public void checkGetNameTest() {
        String expectedName = bun.getName();
        String actualName = name;
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    // проверим, что метод getPrice возвращает цену с дельтой 0
    public void checkGetPriceTest() {
        float expectedPrice = bun.getPrice();
        float actualPrice = price;
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
