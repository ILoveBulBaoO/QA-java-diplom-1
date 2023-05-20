import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private Ingredient ingredient;
    private String name;
    private float price;

    IngredientType ingredientType;

    @Before
    public void initIngredient() {
        ingredient = new Ingredient(ingredientType, name, price);
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
        IngredientType actualType = ingredientType;
        Assert.assertEquals(expectedType, actualType);
    }
}
