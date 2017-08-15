package com.dapr.aaronbond.androidprofexercise.di;


import com.dapr.aaronbond.androidprofexercise.di.scope.MainActivityScope;

import dagger.Component;

@MainActivityScope
@Component(modules = MainActivityModule.class, dependencies = BasicAppComponent.class)
public interface MainActivityComponent {
}
