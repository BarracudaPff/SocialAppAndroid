package com.samsung.socialappandroid.services;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.FirebaseDatabase;
import com.samsung.socialappandroid.models.User;

public class UserService {
    public static User createUser(AuthResult authResult) {
        return new User(
                "",
                authResult.getUser().getEmail(),
                "",
                authResult.getUser().getMetadata().getCreationTimestamp()
        );
    }

    public static void storeUser(User user) {
        FirebaseDatabase.getInstance("https://socail-app-eceff-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("users")
                .push()
                .setValue(user);
    }
}
