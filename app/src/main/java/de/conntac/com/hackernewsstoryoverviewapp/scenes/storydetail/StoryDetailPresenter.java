package de.conntac.com.hackernewsstoryoverviewapp.scenes.storydetail;

import javax.inject.Inject;

import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;

public class StoryDetailPresenter implements StoryDetailContract.Presenter {

    private StoryDetailContract.Interactor interactor;
    private StoryDetailContract.View view;
    private StoryDetailModel storyDetailModel;

    @Inject
    StoryDetailPresenter(StoryDetailContract.Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void detachComponents() {
        this.view = null;
        this.interactor = null;
    }

    @Override
    public void attachView(StoryDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void setStoryDetailModel(StoryDetailModel storyDetailModel) {
        this.storyDetailModel = storyDetailModel;
    }

    public StoryDetailModel getStoryDetailModel() {
        return storyDetailModel;
    }

}
