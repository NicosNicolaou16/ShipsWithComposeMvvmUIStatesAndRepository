package com.nicos.ships.di.handing_error

import android.content.Context
import com.nicos.ships.utils.base_classes.HandlingError
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HandlingErrorModule {

    @Singleton
    @Provides
    fun getHandleError(@ApplicationContext context: Context) = HandlingError(context)
}