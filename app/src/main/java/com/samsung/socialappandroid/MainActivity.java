package com.samsung.socialappandroid;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.samsung.socialappandroid.models.TestModel;
import com.samsung.socialappandroid.services.DatabaseService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    TextView logTextView;
    Button actionButton;
    Button actionButtonFromEdit;
    Button deleteActionButton;
    Button logOutButton;
    EditText referenceEditText;
    EditText valueEditText;

//    String ref = "user/test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkViews();
        logTextView.setMovementMethod(new ScrollingMovementMethod());
        addLogInfo("Init", "App is ready");
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(UUID.randomUUID().toString());
                strings.add(UUID.randomUUID().toString());

                // add data
                DatabaseService.addTestModel("users", new TestModel(
                        UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(),
                        new Random().nextInt(),
                        new Random().nextBoolean(),
                        strings,
                        new TestModel.TestInnerObject(
                                new TestModel.TestAnotherInnerObject(
                                        UUID.randomUUID().toString(),
                                        new Random().nextInt(),
                                        UUID.randomUUID().toString()
                                )
                        )
                )).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        addLogInfo("DATABASE", "Model generated");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });
//        actionButtonFromEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // get data
//                DatabaseService.getTestModel("users/???", new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        TestModel model = snapshot.getValue(TestModel.class);
//                        addLogInfo("DATABASE", model.toString());
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        addLogInfo("DATABASE", error.getMessage());
//                    }
//                });
//            }
//        });

        DatabaseService.getAllTestModels("users", new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                addLogInfo("ADDED",snapshot.getKey());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                addLogInfo("CHANGED",snapshot.getKey());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                addLogInfo("REMOVED",snapshot.getKey());
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                addLogInfo("MOVED",snapshot.getKey());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addLogInfo(String tag, String message) {
        StringBuilder builder = new StringBuilder();
        builder.append(
                logTextView.getText().toString()
        );
        builder.append("\n\n");
        builder.append(
                new Date().toLocaleString() + " " + tag + ": " + message + "."
        );

        logTextView.setText(builder.toString());
    }

    private void linkViews() {
        logTextView = findViewById(R.id.logTextView);

        actionButton = findViewById(R.id.actionButton);
        actionButton.setText("Set random value");
        actionButtonFromEdit = findViewById(R.id.actionButton2);
        actionButtonFromEdit.setText("Get value");
        deleteActionButton = findViewById(R.id.deleteActionButton);

        referenceEditText = findViewById(R.id.referenceEditText);
        valueEditText = findViewById(R.id.valueEditText);

        logOutButton = findViewById(R.id.buttonLogOut);
    }
}