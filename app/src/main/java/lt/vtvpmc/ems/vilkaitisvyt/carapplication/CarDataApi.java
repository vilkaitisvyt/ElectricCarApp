package lt.vtvpmc.ems.vilkaitisvyt.carapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CarDataApi {

    @GET("api/mobile/public/availablecars")
    Call<List<Car>> getCars();
}
