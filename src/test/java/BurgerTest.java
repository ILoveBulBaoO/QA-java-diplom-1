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
import praktikum.IngredientType;

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
    // булочки для бургера
    public void setBunsToBurger() {
        burger.setBuns(mockBun);

        Bun expectedBun = mockBun;
        Bun actualBun = burger.bun;

        Assert.assertEquals("Failed to set Buns for burger", expectedBun, actualBun);
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

    @Test
    // проверить перемещение ингредиента по индексу
    public void moveIngredientFromIndexToNewIndex() {
        List<Ingredient> expectedIngredients = new ArrayList<>();
        List<Ingredient> actualIngredients = burger.ingredients;

        // add ingredients
        for (int i = 0; i < TestIngredient.getTestIngredientCount(); i++) {
            expectedIngredients.add(i, mockIngredient);
            burger.addIngredient(mockIngredient);
        }

        expectedIngredients.add(1, expectedIngredients.remove(0));
        burger.moveIngredient(1, 0);

        Assert.assertEquals("Failed to move ingredients by index", expectedIngredients, actualIngredients);
    }

    @Test
    // проверить расчет стоимости бургера с дельтой 0.001
    public void getPriceForBurger() {
        Mockito.when(mockBun.getPrice()).thenReturn(TestBun.getTestBunPrice());
        Mockito.when(mockIngredient.getPrice()).thenReturn(TestIngredient.getTestIngredientPrice());
        burger.setBuns(mockBun);

        // add ingredients
        for (int i = 0; i < TestIngredient.getTestIngredientCount(); i ++) {
            burger.addIngredient(mockIngredient);
        }

        float expectedPriceForBurger = getPriceForBugger(TestIngredient.getTestIngredientCount());
        float actualPriceForBurger = burger.getPrice();

        Assert.assertEquals("Incorrect burger price", expectedPriceForBurger, actualPriceForBurger, 0.001);
    }

    @Test
    // проверить получение квитанции
    public void getReceiptForBurger() {
        Mockito.when(mockBun.getName()).thenReturn(TestBun.getTestBunName());
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(mockIngredient.getName()).thenReturn(TestIngredient.getTestIngredientName());
        burger.setBuns(mockBun);

        // add ingredients
        for (int i = 0; i < TestIngredient.getTestIngredientCount(); i ++) {
            burger.addIngredient(mockIngredient);
        }

        StringBuilder stringBuilder = new StringBuilder(String.format("(==== %s ====)%n", mockBun.getName()));
        for (int i = 0; i < TestIngredient.getTestIngredientCount(); i ++) {
            stringBuilder.append(String.format("= %s %s =%n", mockIngredient.getType().toString().toLowerCase(),
                    mockIngredient.getName()));
        }

        stringBuilder.append(String.format("(==== %s ====)%n", mockBun.getName()));
        stringBuilder.append(String.format("%nPrice: %f%n", getPriceForBugger(TestIngredient.getTestIngredientCount())));

        String expectedReceipt = stringBuilder.toString();
        String actualReceipt = burger.getReceipt();

        Assert.assertEquals("Failed to get receipt", expectedReceipt, actualReceipt);

    }

    // приватный метод для расчета стоимости бургера с использованием мок объектов
    private float getPriceForBugger(int countOfIngredients) {
        float priceForBun = mockBun.getPrice() * 2;
        float priceForIngredient = mockIngredient.getPrice() * countOfIngredients;
        float burgerPrice = priceForBun + priceForIngredient;
        return burgerPrice;
    }
}


