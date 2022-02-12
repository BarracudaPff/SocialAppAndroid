package com.samsung.socialappandroid;

//import android.content.Intent;
//import android.os.Bundle;
//import android.text.method.ScrollingMovementMethod;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.samsung.socialappandroid.auth.SignInActivity;
//import com.samsung.socialappandroid.services.AuthService;
//
//import java.util.Date;
import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("ALL")
public class MainActivityDeprecated extends AppCompatActivity {
//    TextView logTextView;
//    Button actionButton;
//    Button actionButtonFromEdit;
//    Button deleteActionButton;
//    Button logOutButton;
//    EditText referenceEditText;
//    EditText valueEditText;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        linkViews();
//        logTextView.setMovementMethod(new ScrollingMovementMethod());
//
//        actionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                makeRequest("Hello World!", "message");
//            }
//        });
//
//        actionButtonFromEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                makeRequest();
//            }
//        });
//
//        deleteActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                delete();
//            }
//        });
//
//        logOutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AuthService.logOut();
//                startActivity(new Intent(getBaseContext(), SignInActivity.class));
//            }
//        });
//
//        addLogInfo("Init", "App is ready");
//
//        listenChanges("");
//    }
//
//    private void delete() {
//        if (referenceEditText.getText().toString().isEmpty()) {
//            Toast.makeText(this, "Reference is empty!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        addLogInfo("Delete", "Remove value from" + referenceEditText.getText().toString());
//
//        FirebaseDatabase.getInstance("https://socail-app-eceff-default-rtdb.europe-west1.firebasedatabase.app")
//                .getReference(referenceEditText.getText().toString())
//                .removeValue()
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        addLogInfo("Delete", "Value removed successfully");
//                    }
//                });
//    }
//
//    private void listenChanges(String reference) {
//        FirebaseDatabase database = FirebaseDatabase.getInstance("https://socail-app-eceff-default-rtdb.europe-west1.firebasedatabase.app");
//        DatabaseReference ref = database.getReference(reference);
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                addLogInfo("Data Changed", snapshot.toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                addLogInfo("Error", error.getMessage());
//            }
//        });
//    }
//
//    private void addLogInfo(String tag, String message) {
//        StringBuilder builder = new StringBuilder();
//        builder.append(
//                logTextView.getText().toString()
//        );
//        builder.append("\n\n");
//        builder.append(
//                new Date().toLocaleString() + " " + tag + ": " + message + "."
//        );
//
//        logTextView.setText(builder.toString());
//    }
//
//    private void makeRequest() {
//        if (referenceEditText.getText().toString().isEmpty()) {
//            Toast.makeText(this, "Reference is empty!", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance("https://socail-app-eceff-default-rtdb.europe-west1.firebasedatabase.app");
//        DatabaseReference myRef = database.getReference(referenceEditText.getText().toString());
//
//        addLogInfo("Request", "Request to "
//                + referenceEditText.getText().toString()
//                + " with value "
//                + valueEditText.getText().toString()
//        );
//        myRef.setValue(valueEditText.getText().toString())
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void unused) {
//                        addLogInfo("Request", "Send successfully");
//                    }
//                });
//    }
//
//    private void linkViews() {
//        logTextView = findViewById(R.id.logTextView);
//
//        actionButton = findViewById(R.id.actionButton);
//        actionButtonFromEdit = findViewById(R.id.actionButton2);
//        deleteActionButton = findViewById(R.id.deleteActionButton);
//
//        referenceEditText = findViewById(R.id.referenceEditText);
//        valueEditText = findViewById(R.id.valueEditText);
//
//        logOutButton =  findViewById(R.id.buttonLogOut);
//    }
//
//    @Deprecated
//    private void makeRequest(String value, String refernce) {
//        FirebaseDatabase database = FirebaseDatabase.getInstance("https://socail-app-eceff-default-rtdb.europe-west1.firebasedatabase.app");
//        DatabaseReference myRef = database.getReference(refernce);
//
//        myRef.setValue(value);
//    }
}