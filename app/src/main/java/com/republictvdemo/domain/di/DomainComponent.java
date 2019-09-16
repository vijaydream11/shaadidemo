package com.republictvdemo.domain.di;

import com.republictvdemo.domain.DataRepository;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DomainModule.class})
public interface DomainComponent {

    DataRepository getDataRepo();

}
