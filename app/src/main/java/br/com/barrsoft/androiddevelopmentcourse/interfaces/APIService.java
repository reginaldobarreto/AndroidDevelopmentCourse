package br.com.barrsoft.androiddevelopmentcourse.interfaces;

import java.util.List;
import br.com.barrsoft.androiddevelopmentcourse.models.RocketModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("launches")
    //chamada para os models
    Call <List<RocketModel>> getRocket(@Query("order") String order, @Query("launch_year") String launch_year);
}
