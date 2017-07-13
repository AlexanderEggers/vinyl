package com.acando.vinyl.structure

import dagger.Module
import javax.inject.Singleton
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Provides
import com.acando.vinyl.db.ArticleDao
import android.arch.lifecycle.ViewModelProvider
import com.acando.vinyl.MainActivity
import com.acando.vinyl.db.AppDatabase
import com.acando.vinyl.db.ShoppingCartDao
import com.acando.vinyl.viewmodel.AppViewModelFactory

@Module(subcomponents = arrayOf(ViewModelSubComponent::class))
class AppModule {

    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun provideContext(mainActivity: MainActivity): Context {
        return mainActivity
    }

    @Singleton
    @Provides
    fun provideArticleDao(db: AppDatabase): ArticleDao {
        return db.articleDao()
    }

    @Singleton
    @Provides
    fun provideShoppingCartDao(db: AppDatabase): ShoppingCartDao {
        return db.shoppingCartDao()
    }

    @Singleton
    @Provides
    fun provideViewModelFactory(subComponent: ViewModelSubComponent.Builder): ViewModelProvider.Factory {
        return AppViewModelFactory(subComponent.build())
    }
}