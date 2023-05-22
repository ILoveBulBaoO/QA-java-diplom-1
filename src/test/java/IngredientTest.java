import TestData.TestIngredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private Ingredient ingredient;
    private String name = TestIngredient.getTestIngredientName();
    private float price = TestIngredient.getTestIngredientPrice();

    private IngredientType ingredientTypeFilling = IngredientType.FILLING;

    @Before
    public void initIngredient() {
        ingredient = new Ingredient(ingredientTypeFilling, name, price);
    }

    @Test
    // проверим, что метод getPrice() возвращает цену с дельтой 0
    public void getPriceReturnIngredientPriceWithDeltaZero() {
        float expectedPrice = price;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Incorrect ingredient price", expectedPrice, actualPrice, 0);
    }

    @Test
    // проверим, что метод getName() возвращает имя
    public void getNameReturnIngredientName() {
        String expectedName = name;
        String actualName = ingredient.getName();
        Assert.assertEquals("Incorrect ingredient name", expectedName, actualName);
    }

    @RunWith(Parameterized.class)
    public static class ParamIngredientTypeTest {
        private Ingredient ingredient;
        private IngredientType ingredientType;
        private String name;
        private float price;

        public ParamIngredientTypeTest(IngredientType ingredientType, String name, float price) {
            this.ingredientType = ingredientType;
            this.name = name;
            this.price = price;
        }

        @Before
        public void initIngredient() {
            ingredient = new Ingredient(ingredientType, name, price);
        }

        @Parameterized.Parameters(name = "Тестовые данные: type = {0}, name = {1}, price = {2}")
        public static Object[][] data() {
            return new Object[][] {
                    {IngredientType.SAUCE, TestIngredient.getTestIngredientName(), TestIngredient.getTestIngredientPrice()},
                    {IngredientType.FILLING, TestIngredient.getTestIngredientName(), TestIngredient.getTestIngredientPrice()}
            };
        }

        @Test
        // проверим, что метод getType() возвращает тип
        public void getTypeReturnIngredientType() {
            IngredientType expectedType = ingredientType;
            IngredientType actualType = ingredient.getType();
            Assert.assertEquals("Incorrect ingredient type", expectedType, actualType);
        }
    }

}
