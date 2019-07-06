package de.conntac.com.hackernewsstoryoverviewapp.scenes.storiesoverview;

import java.util.ArrayList;
import java.util.List;

import de.conntac.com.hackernewsstoryoverviewapp.network.StoryDetailModel;
import de.conntac.com.hackernewsstoryoverviewapp.network.StoryModel;

public interface StoriesOverviewContract {

    interface Presenter {

        void attachView(StoriesOverviewContract.View view);

        void detachComponents();

        void getStories();

        void presentStoryIDs(List<Integer> storyIDs);

        void showError(String errorMessage);

        void presentStoryDetail(StoryDetailModel storyDetailModel, int arrayIndex);

    }

    interface Interactor {

        void setPresenter(StoriesOverviewContract.Presenter presenter);

        void getStoryIDsFromAPI();

        void getStoryDetail(String storyID, int arrayIndex);


    }

    interface View {

        void initializeStoryList(ArrayList<StoryModel> storyModels);

        void updateRow(int arrayIndex);

        void showProgress();

        void hideProgress();

    }

}
