package com.example.studentregistrationform;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declare variables for UI elements
    private EditText editTextFirstname, editTextMiddlename, editTextLastname, editTextPhone, editTextAddress, editTextEmail, editTextPassword, editTextRePassword;
    private RadioGroup radioGroupGender;
    private Spinner spinnerCourse;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable Edge-to-Edge functionality
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set the content view to the activity_main.xml layout
        setContentView(R.layout.activity_main);

        // Initialize UI elements with correct IDs
        editTextFirstname = findViewById(R.id.editTextFirstname);
        editTextMiddlename = findViewById(R.id.editTextMiddlename);
        editTextLastname = findViewById(R.id.editTextLastname);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRePassword = findViewById(R.id.editTextRePassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set onClick listener for the submit button
        buttonSubmit.setOnClickListener(v -> submitForm());
    }

    private void submitForm() {
        // Get input values
        String firstname = editTextFirstname.getText().toString().trim();
        String middlename = editTextMiddlename.getText().toString().trim();
        String lastname = editTextLastname.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String rePassword = editTextRePassword.getText().toString().trim();
        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        RadioButton selectedGenderButton = findViewById(selectedGenderId);
        String gender = selectedGenderButton.getText().toString();
        String course = spinnerCourse.getSelectedItem().toString();

        // Validate inputs
        if (firstname.isEmpty() || lastname.isEmpty() || phone.isEmpty() || address.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty() || selectedGenderId == -1) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(rePassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simulate form submission
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
        // You can add your logic to handle successful registration here
    }
}
