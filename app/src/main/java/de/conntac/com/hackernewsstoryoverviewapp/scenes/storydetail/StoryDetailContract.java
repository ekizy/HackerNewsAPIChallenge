package de.conntac.com.hackernewsstoryoverviewapp.scenes.storydetail;

import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;

public interface StoryDetailContract {

    interface Presenter {

        void attachView(StoryDetailContract.View view);

        void detachComponents();

        void setStoryDetailModel(StoryDetailModel storyDetailModel);

        StoryDetailModel getStoryDetailModel();
    }

    interface Interactor {

        void setPresenter(StoryDetailContract.Presenter presenter);

    }

    interface View {

    }

}
