import TestData.TestBun;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {
    private Bun bun;
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Позитивные и негативные данные для теста: имя булочки = {0}, цена булочки = {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Test bun Name", 100.0f},
                {" TestBunName", 100.0f},
                {"TestBunName ", 100.0f},
                {"TestBunName", 100.0f},
                {"", 100.0f},
                {null, 100.0f},
                {"0987654321", 100.0f},
                {"@#$%^", 100.0f},
                {"Test bun Name", 0f},
                {"Test bun Name", -100.0f},
                {"Test bun Name", Float.MAX_VALUE},
                {"Test bun Name", Float.MIN_VALUE},
                {"Test bun Name", 0.01f},
                {"Test bun Name", -0.01f}
        };
    }

    @Before
    public void initBun() {
        bun = new Bun(name, price);
    }

    @Test
    // проверим, что метод getName() возвращает имя
    public void getNameReturnBunName() {
        String expectedName = name;
        String actualName = bun.getName();
        Assert.assertEquals("Невалидное имя булочки",expectedName, actualName);
    }

    @Test
    // проверим, что метод getPrice() возвращает цену с дельтой 0
    public void getPriceReturnBunPriceWithDeltaZero() {
        float expectedPrice = price;
        float actualPrice = bun.getPrice();
        Assert.assertEquals("Невалидная стоимость булочки", expectedPrice, actualPrice, 0);
    }
}
