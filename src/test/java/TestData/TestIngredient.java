package TestData;

import praktikum.IngredientType;

public class TestIngredient {
    private static String testIngredientName = "test ingredient name";
    private static float testIngredientPrice = 20.0f;
    private static int testIngredientCount = 3;

    public static String getTestIngredientName() {
        return testIngredientName;
    }

    public static float getTestIngredientPrice() {
        return testIngredientPrice;
    }

    public static int getTestIngredientCount() {
        return testIngredientCount;
    }
}