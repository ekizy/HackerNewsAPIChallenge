package de.conntac.com.hackernewsstoryoverviewapp.injection.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import de.conntac.com.hackernewsstoryoverviewapp.network.HackerNewsApiInterface;
import de.conntac.com.hackernewsstoryoverviewapp.network.NetworkHelper;
import de.conntac.com.hackernewsstoryoverviewapp.network.NetworkManager;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    HackerNewsApiInterface providesApiInterface(Retrofit retrofit) {
        return retrofit.create(HackerNewsApiInterface.class);
    }

    @Provides
    @Singleton
    NetworkManager providesNetworkManager(HackerNewsApiInterface apiInterface) {
        return new NetworkManager(apiInterface);
    }

}