package de.conntac.com.hackernewsstoryoverviewapp.scenes.storiesoverview;

import dagger.Component;
import de.conntac.com.hackernewsstoryoverviewapp.injection.component.AppComponent;
import de.conntac.com.hackernewsstoryoverviewapp.injection.context.ActivityScope;

@ActivityScope
@Component(modules = StoriesOverviewModule.class, dependencies = AppComponent.class)
public interface StoriesOverviewComponent {

    void inject(StoriesOverviewFragment storiesOverviewFragment);

}
