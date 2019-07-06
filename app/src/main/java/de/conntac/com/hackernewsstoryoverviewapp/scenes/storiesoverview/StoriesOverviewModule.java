package de.conntac.com.hackernewsstoryoverviewapp.scenes.storiesoverview;

import dagger.Module;
import dagger.Provides;
import de.conntac.com.hackernewsstoryoverviewapp.injection.context.ActivityScope;

@Module
public class StoriesOverviewModule {

    @Provides
    @ActivityScope
    StoriesOverviewContract.Presenter providesStoriesOverviewPresenter(
            StoriesOverviewPresenter storiesOverviewPresenter) {
        return storiesOverviewPresenter;
    }

    @Provides
    @ActivityScope
    StoriesOverviewContract.Interactor providesStoriesOverviewInteractor(
            StoriesOverviewInteractor storiesOverviewInteractor) {
        return storiesOverviewInteractor;
    }

}
