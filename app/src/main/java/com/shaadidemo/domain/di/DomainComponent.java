package com.shaadidemo.domain.di;

import com.shaadidemo.domain.DataRepository;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DomainModule.class})
public interface DomainComponent {

    DataRepository getDataRepo();

}
