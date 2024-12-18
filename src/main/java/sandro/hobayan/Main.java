package sandro.hobayan;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main {
    public static void main(String[] args) {
        fetchRecipesByArea("Filipino");
    }

    private static void fetchRecipesByArea(String area) {
        RecipeApiService apiService = ApiClient.getClient().create(RecipeApiService.class);
        Call<RecipeResponse> call = apiService.getRecipesByArea(area);
        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RecipeResponse recipeResponse = response.body();
                    if (recipeResponse.getMeals() != null) {
                        for (RecipeResponse.Recipe recipe : recipeResponse.getMeals()) {
                            System.out.println("Title: " + recipe.getStrMeal());
                            System.out.println("Meal ID: " + recipe.getIdMeal());
                            System.out.println("Thumbnail: " + recipe.getStrMealThumb());
                            System.out.println("-----");
                        }
                    } else {
                        System.out.println("No recipes found for the specified area.");
                    }
                } else {
                    System.out.println("Response Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });
    }
}
