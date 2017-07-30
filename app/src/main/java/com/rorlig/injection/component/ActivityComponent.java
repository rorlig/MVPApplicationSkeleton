package com.rorlig.injection.component;

import dagger.Subcomponent;
import com.rorlig.features.detail.DetailActivity;
import com.rorlig.features.main.MainActivity;
import com.rorlig.injection.PerActivity;
import com.rorlig.injection.module.ActivityModule;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(DetailActivity detailActivity);
}
