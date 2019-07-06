package de.conntac.com.hackernewsstoryoverviewapp.scenes.storydetail;

import com.google.gson.Gson;

import javax.inject.Inject;

import de.conntac.com.hackernewsstoryoverviewapp.network.NetworkManager;

public class StoryDetailInteractor implements StoryDetailContract.Interactor {

    @Inject
    NetworkManager networkManager;
    @Inject
    Gson gson;

    StoryDetailContract.Presenter presenter;

    @Inject
    StoryDetailInteractor() {

    }

    @Override
    public void setPresenter(StoryDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

}
