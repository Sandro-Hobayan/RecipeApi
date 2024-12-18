package sandro.hobayan;

import java.util.List;

public class RecipeResponse {
    private List<Recipe> meals; // Ensure this matches the JSON key in the API response

    public List<Recipe> getMeals() {
        return meals;
    }

    public static class Recipe {
        private String strMeal;
        private String strMealThumb;
        private String idMeal;

        // Getters and setters
        public String getStrMeal() {
            return strMeal;
        }

        public String getStrMealThumb() {
            return strMealThumb;
        }

        public String getIdMeal() {
            return idMeal;
        }
    }
}
