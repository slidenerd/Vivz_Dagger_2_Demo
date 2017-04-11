package slidenerd.vivz.d2demo.component;

import javax.inject.Singleton;

import dagger.Component;
import slidenerd.vivz.d2demo.FragmentA;
import slidenerd.vivz.d2demo.FragmentB;
import slidenerd.vivz.d2demo.modules.StorageModule;

/**
 * Created by vivz on 11/09/15.
 */
@Singleton
@Component(modules = StorageModule.class)
public interface StorageComponent {
    void inject(FragmentA fragmentA);
    void inject(FragmentB fragmentB);
}
