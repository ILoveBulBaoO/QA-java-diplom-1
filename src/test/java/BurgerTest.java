import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
    Ingredient mockIngredient;

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

        expectedIngredients.add(mockIngredient);
        burger.addIngredient(mockIngredient);

        Assert.assertEquals("Failed to add Ingredients", expectedIngredients, actualIngredients);

    }

    @Test
    // проверить удаление ингредиента по индексу
    public void removeIngredientByIndexFromIngredientList() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        List<Ingredient> actualIngredients = burger.ingredients;

        expectedIngredients.add(0, mockIngredient);
        burger.addIngredient(mockIngredient);

        expectedIngredients.remove(0);
        burger.removeIngredient(0);

        Assert.assertEquals("Failed to remove ingredients by index", expectedIngredients, actualIngredients);

    }


}
