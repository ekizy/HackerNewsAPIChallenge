package de.conntac.com.hackernewsstoryoverviewapp.scenes.storiesoverview;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryModel;

public class StoriesOverviewPresenter implements StoriesOverviewContract.Presenter {

    private StoriesOverviewContract.Interactor interactor;
    private StoriesOverviewContract.View view;
    private ArrayList<StoryModel> storyModels;

    @Inject
    StoriesOverviewPresenter(StoriesOverviewContract.Interactor interactor) {
        this.interactor = interactor;
        this.interactor.setPresenter(this);
    }

    @Override
    public void attachView(StoriesOverviewContract.View view) {
        this.view = view;
    }

    @Override
    public void detachComponents() {
        this.view = null;
        this.interactor = null;
    }

    @Override
    public void getStories() {
        if (view != null) {
            view.showProgress();
        }

        interactor.getStoryIDsFromAPI();
    }

    @Override
    public void presentStoryDetail(StoryDetailModel storyDetailModel, int arrayIndex) {
        storyModels.get(arrayIndex).setStoryDetailModel(storyDetailModel);
        if (view != null) {
            view.updateRow(arrayIndex);
        }
    }

    @Override
    public void presentStoryIDs(List<Integer> storyIDs) {
        storyModels = new ArrayList<>();

        for (int arrayIndex = 0; arrayIndex < storyIDs.size(); arrayIndex++) {
            int storyId = storyIDs.get(arrayIndex);
            StoryModel storyModel = new StoryModel(storyIDs.get(arrayIndex));
            storyModels.add(storyModel);
            interactor.getStoryDetail(Integer.toString(storyId), arrayIndex);
        }

        if (view != null) {
            view.hideProgress();
            view.initializeStoryList(storyModels);
        }
    }

    @Override
    public void showError(String errorMessage) {
        Log.e("Service Error", errorMessage);
    }

}
