import TestData.TestBun;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private Bun bun;
    private String name = TestBun.getTestBunName();
    private float price = TestBun.getTestBunPrice();
    @Before
    public void initBun() {
        bun = new Bun(name, price);
    }

    @Test
    // проверим, что метод getName() возвращает имя
    public void getNameReturnBunName() {
        String expectedName = name;
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    // проверим, что метод getPrice() возвращает цену с дельтой 0
    public void getPriceReturnBunPriceWithDeltaZero() {
        float expectedPrice = price;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
