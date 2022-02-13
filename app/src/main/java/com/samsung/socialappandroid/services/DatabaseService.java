package com.samsung.socialappandroid.services;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.firebase.ui.database.ClassSnapshotParser;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.samsung.socialappandroid.models.TestModel;
import com.samsung.socialappandroid.models.User;

import java.util.Date;
import java.util.UUID;

public class DatabaseService {
    public static FirebaseDatabase getDatabase() {
        return FirebaseDatabase.getInstance("https://socail-app-eceff-default-rtdb.europe-west1.firebasedatabase.app");
    }

    public static Task<Void> addTestModel(String ref, TestModel model) {
        return getDatabase()
                .getReference(ref)
                .push()
                .setValue(model);
    }

    public static void getTestModel(String ref, ValueEventListener listener) {
        getDatabase()
                .getReference(ref)
                .addListenerForSingleValueEvent(listener);
    }

    public static void getAllTestModels(String ref, ChildEventListener listener) {
        getDatabase()
                .getReference(ref)
                .orderByChild("booleanValue")
                .addChildEventListener(listener);
    }

    public static Task<Void> remove(String ref) {
        return getDatabase()
                .getReference(ref)
                .removeValue();
    }

    public static FirebaseRecyclerOptions<User> getUserOptions() {
        Query query = getDatabase().getReference("new-users");
        ClassSnapshotParser<User> parser = new ClassSnapshotParser<>(User.class);

        return new FirebaseRecyclerOptions.Builder<User>()
                .setQuery(query, parser)
                .build();
    }

    public static void createRandomNewUser() {
        getDatabase()
                .getReference("new-users")
                .push()
                .setValue(
                        new User(
                                UUID.randomUUID().toString().substring(0, 10),
                                UUID.randomUUID().toString().substring(0, 10),
                                UUID.randomUUID().toString()
                                        + UUID.randomUUID().toString()
                                        + UUID.randomUUID().toString(),
                                new Date().getTime()
                        )
                );
    }
}
