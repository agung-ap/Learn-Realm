package id.developer.agungaprian.crudtemplate.apps;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by agungaprian on 06/07/17.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //initialisasi database realm
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .deleteRealmIfMigrationNeeded()
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
