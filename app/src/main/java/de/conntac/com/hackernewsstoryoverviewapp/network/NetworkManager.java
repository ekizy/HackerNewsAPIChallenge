package de.conntac.com.hackernewsstoryoverviewapp.network;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.Objects;

import javax.inject.Singleton;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class NetworkManager {

    private HackerNewsApiInterface apiInterface;

    public NetworkManager(HackerNewsApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public void get(String url, final APIResponseListener listener) {
        apiInterface.getJSONData(url).enqueue(produceCallback(listener));
    }

    private Callback<ResponseBody> produceCallback(final APIResponseListener listener) {
        return new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        listener.onSuccess(Objects.requireNonNull(response.body()).string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    listener.onFailure("Response is not successful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                listener.onFailure(t.getLocalizedMessage());
            }
        };
    }

}
