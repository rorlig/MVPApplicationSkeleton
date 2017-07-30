package com.rorlig.injection.component;

import dagger.Subcomponent;
import com.rorlig.injection.PerFragment;
import com.rorlig.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}
