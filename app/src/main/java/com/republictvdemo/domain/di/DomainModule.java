package com.republictvdemo.domain.di;

import com.republictvdemo.domain.DataRepository;
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
