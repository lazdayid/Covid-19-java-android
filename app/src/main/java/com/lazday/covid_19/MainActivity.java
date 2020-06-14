package com.lazday.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewResult);
        progressBar = findViewById(R.id.progressBar);

        getDataFromApi();
    }

    private void getDataFromApi() {

        showLoading(true);

        ApiService.endpoint().getData()
                .enqueue(new Callback<List<MainModel>>() {
                    @Override
                    public void onResponse(Call<List<MainModel>> call, Response<List<MainModel>> response) {
                        Log.d( TAG, response.toString());
                        if (response.isSuccessful()) {
                            showLoading(false);
                            List<MainModel> results = response.body();
                            showResult( results );
                        }
                    }

                    @Override
                    public void onFailure(Call<List<MainModel>> call, Throwable t) {
                        Log.d( TAG, t.toString());
                        showLoading(false);
                    }
                });

    }

    private void showLoading(Boolean loading){
        if (loading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    private void showResult(List<MainModel> mainModel){
        MainModel result = mainModel.get(0);
        textView.setText(
                "Positif: " + result.getPositif() + "\nSembuh: " + result.getSembuh() +
                        "\nMeninggal: " + result.getMeninggal()
        );
    }
}
