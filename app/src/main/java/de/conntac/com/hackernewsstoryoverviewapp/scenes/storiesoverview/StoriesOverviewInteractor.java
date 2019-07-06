package de.conntac.com.hackernewsstoryoverviewapp.scenes.storiesoverview;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import de.conntac.com.hackernewsstoryoverviewapp.network.APIResponseListener;
import de.conntac.com.hackernewsstoryoverviewapp.network.NetworkHelper;
import de.conntac.com.hackernewsstoryoverviewapp.network.NetworkManager;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;

public class StoriesOverviewInteractor implements StoriesOverviewContract.Interactor {

    @Inject
    NetworkManager networkManager;
    @Inject
    Gson gson;

    StoriesOverviewContract.Presenter presenter;

    @Inject
    StoriesOverviewInteractor() {

    }

    @Override
    public void setPresenter(StoriesOverviewContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getStoryIDsFromAPI() {
        networkManager.get(NetworkHelper.getStoryIDs, new APIResponseListener() {
            @Override
            public void onSuccess(String responseBody) {
                Type listType = new TypeToken<List<Integer>>() {
                }.getType();
                List<Integer> storyIDs = gson.fromJson(responseBody, listType);
                presenter.presentStoryIDs(storyIDs);
            }

            @Override
            public void onFailure(String errorMessage) {
                presenter.showError(errorMessage);
            }
        });
    }

    @Override
    public void getStoryDetail(final String storyID, final int arrayIndex) {
        String requestURL = NetworkHelper.getStoryDetailURL(storyID);
        networkManager.get(requestURL, new APIResponseListener() {
            @Override
            public void onSuccess(String responseBody) {
                StoryDetailModel storyDetailModel = gson.fromJson(responseBody, StoryDetailModel.class);
                presenter.presentStoryDetail(storyDetailModel, arrayIndex);
            }

            @Override
            public void onFailure(String errorMessage) {
                presenter.showError(errorMessage);
            }
        });
    }

}
