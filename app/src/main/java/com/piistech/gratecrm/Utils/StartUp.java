package com.piistech.gratecrm.Utils;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import static com.piistech.gratecrm.Utils.Constant.REALM_MIGRATION_VERSION;

public class StartUp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        final RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(REALM_MIGRATION_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
        Realm.getInstance(configuration);
    }

    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }
}