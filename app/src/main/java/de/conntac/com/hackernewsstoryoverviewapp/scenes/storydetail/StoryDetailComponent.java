package de.conntac.com.hackernewsstoryoverviewapp.scenes.storydetail;

import dagger.Component;
import de.conntac.com.hackernewsstoryoverviewapp.injection.component.AppComponent;
import de.conntac.com.hackernewsstoryoverviewapp.injection.context.ActivityScope;

@ActivityScope
@Component(modules = StoryDetailModule.class, dependencies = AppComponent.class)
public interface StoryDetailComponent {

    void inject(StoryDetailFragment storyDetailFragment);

}
