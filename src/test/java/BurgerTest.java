import TestData.TestBun;
import TestData.TestIngredient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun mockBun;
    @Mock
    Ingredient firstMockIngredient;

    @Mock
    Ingredient secondMockIngredient;

    @Mock
    Ingredient thirdMockIngredient;

    @Before
    public void initBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsToBurger() {
        burger.setBuns(mockBun);

        Bun expectedBun = mockBun;
        Bun actualBun = burger.bun;

        Assert.assertEquals("Failed to set Buns", expectedBun, actualBun);
    }

    @Test
    // проверить добавление ингредиента
    public void addIngredientToIngredientList() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        List<Ingredient> actualIngredients = burger.ingredients;

        expectedIngredients.add(firstMockIngredient);
        burger.addIngredient(firstMockIngredient);

        Assert.assertEquals("Failed to add Ingredients", expectedIngredients, actualIngredients);

    }

    @Test
    // проверить удаление ингредиента по индексу
    public void removeIngredientByIndexFromIngredientList() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        List<Ingredient> actualIngredients = burger.ingredients;

        expectedIngredients.add(0, firstMockIngredient);
        burger.addIngredient(firstMockIngredient);

        expectedIngredients.remove(0);
        burger.removeIngredient(0);

        Assert.assertEquals("Failed to remove ingredients by index", expectedIngredients, actualIngredients);

    }

    @Test
    // проверить перемещение ингредиента по индексу
    public void moveIngredientFromIndexToNewIndex() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        List<Ingredient> actualIngredients = burger.ingredients;

        expectedIngredients.add(0, firstMockIngredient);
        burger.addIngredient(firstMockIngredient);

        expectedIngredients.add(1, secondMockIngredient);
        burger.addIngredient(secondMockIngredient);

        expectedIngredients.add(2, thirdMockIngredient);
        burger.addIngredient(thirdMockIngredient);

        expectedIngredients.add(1, expectedIngredients.remove(0));
        burger.moveIngredient(1, 0);

        Assert.assertEquals("Failed to move ingredients by index", expectedIngredients, actualIngredients);
    }

    @Test
    // проверить расчет стоимости бургера с дельтой 0.001
    public void getPriceForBurger() {
        Mockito.when(mockBun.getPrice()).thenReturn(TestBun.getTestBunPrice());
        Mockito.when(firstMockIngredient.getPrice()).thenReturn(TestIngredient.getTestIngredientPrice());
        burger.setBuns(mockBun);
        burger.addIngredient(firstMockIngredient);
        burger.addIngredient(secondMockIngredient);
        burger.addIngredient(thirdMockIngredient);

        float expectedPriceForBun = mockBun.getPrice() * 2;
        float expectedPriceForIngredient = firstMockIngredient.getPrice() * TestIngredient.getTestIngredientCount();
        float expectedPriceForBurger = expectedPriceForBun + expectedPriceForIngredient;

        float actualPriceForBurger = burger.getPrice();

        Assert.assertEquals("Incorrect burger price", expectedPriceForBurger, actualPriceForBurger, 0.001);
    }
}
