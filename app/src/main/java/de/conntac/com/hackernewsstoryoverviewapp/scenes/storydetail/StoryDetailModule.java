package de.conntac.com.hackernewsstoryoverviewapp.scenes.storydetail;

import dagger.Module;
import dagger.Provides;
import de.conntac.com.hackernewsstoryoverviewapp.injection.context.ActivityScope;

@Module
public class StoryDetailModule {

    @Provides
    @ActivityScope
    StoryDetailContract.Presenter providesStoryDetailPresenter(
            StoryDetailPresenter storyDetailPresenter) {
        return storyDetailPresenter;
    }

    @Provides
    @ActivityScope
    StoryDetailContract.Interactor providesStoryDetailInteractor(
            StoryDetailInteractor storyDetailInteractor) {
        return storyDetailInteractor;
    }

}
