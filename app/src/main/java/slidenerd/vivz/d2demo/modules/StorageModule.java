package slidenerd.vivz.d2demo.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import slidenerd.vivz.d2demo.MyApplication;

/**
 * Created by vivz on 11/09/15.
 */
@Module
public class StorageModule {
    private final MyApplication application;
    public StorageModule(MyApplication application){
        this.application = application;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
