package lt.vtvpmc.ems.vilkaitisvyt.carapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<Car> carData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);


        // Getting data from internet
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://development.espark.lt/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CarDataApi carDataApi = retrofit.create(CarDataApi.class);

        Call<List<Car>> call = carDataApi.getCars();

        // Call execution on background thread
        call.enqueue(new Callback<List<Car>>() {

            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                if(!response.isSuccessful()) {
                    return;
                }

                List<Car> cars = response.body();
                carData.addAll(cars);
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                t.getMessage();
            }
        });

        CarAdapter adapter = new CarAdapter();
        adapter.setContext(getApplicationContext());
        adapter.getCars().addAll(carData);
        listView.setAdapter(adapter);

        // Button to display cars on google maps

        Button mapButton = findViewById(R.id.toMapBttn);
        mapButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MapsActivity.class);
                startIntent.putExtra("lt.vtvpmc.ems.vilkaitisvyt.carapplication.CARS", (Serializable) carData);
                startActivity(startIntent);
            }
        });
    }
}
