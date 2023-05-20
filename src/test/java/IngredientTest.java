import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.PrimitiveIterator;

public class IngredientTest {
    private Ingredient ingredient;
    private String name;
    private float price;

    @Mock
    IngredientType mockIngredientType;

    @Before
    public void initIngredient() {
        ingredient = new Ingredient(mockIngredientType, name, price);
    }

    @Test
    // проверим, что метод getPrice() возвращает цену с дельтой 0
    public void checkGetPriceTest() {
        float expectedPrice = ingredient.getPrice();
        float actualPrice = price;
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    // проверим, что метод getName() возвращает имя
    public void checkGetNameTest() {
        String expectedName = ingredient.getName();
        String actualName = name;
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    // проверим, что метод getType() возвращает тип
    public void checkGetTypeTest() {
        IngredientType expectedType = ingredient.getType();
        IngredientType actualType = mockIngredientType;
        Assert.assertEquals(expectedType, actualType);
    }
}
