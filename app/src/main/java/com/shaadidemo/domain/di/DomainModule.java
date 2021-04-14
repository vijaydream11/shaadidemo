package com.shaadidemo.domain.di;

import com.shaadidemo.domain.DataRepository;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DomainModule {

    @Singleton
    @Provides
    public DataRepository provideDataRepo(){
        return new DataRepository();
    }
}
