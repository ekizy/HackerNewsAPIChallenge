package de.conntac.com.hackernewsstoryoverviewapp.network;

public interface APIResponseListener {

    void onSuccess(String responseBody);

    void onFailure(String errorMessage);

}
