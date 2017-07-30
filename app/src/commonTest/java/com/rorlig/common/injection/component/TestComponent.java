package com.rorlig.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import com.rorlig.common.injection.module.ApplicationTestModule;
import com.rorlig.injection.component.AppComponent;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends AppComponent {
}
