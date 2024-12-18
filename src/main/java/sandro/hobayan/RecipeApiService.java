package sandro.hobayan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApiService {
    @GET("filter.php")
    Call<RecipeResponse> getRecipesByArea(@Query("a") String area);
}
