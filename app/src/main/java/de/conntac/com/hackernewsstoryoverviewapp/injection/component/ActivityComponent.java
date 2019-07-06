package de.conntac.com.hackernewsstoryoverviewapp.injection.component;

import dagger.Component;
import de.conntac.com.hackernewsstoryoverviewapp.injection.context.ActivityScope;
import de.conntac.com.hackernewsstoryoverviewapp.injection.module.ActivityModule;

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ActivityModule.class})
interface ActivityComponent {

}
