package br.com.digitalhouse.androida5e1.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.androida5e1.R;
import br.com.digitalhouse.androida5e1.home.MainActivity;


public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutLastName;
    private TextInputLayout textInputLayoutAge;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validAndGo();

            }
        });
    }

    private void validAndGo() {
        String name = textInputLayoutName.getEditText().getText().toString();
        String lastname = textInputLayoutLastName.getEditText().getText().toString();
        String age = textInputLayoutAge.getEditText().getText().toString();

        if (name.isEmpty()){
            textInputLayoutName.setError("Nome não pode ser vazio");
            return;
        }

        if (lastname.isEmpty()){
            textInputLayoutLastName.setError("Sobrenome não pode ser vazio");
            return;
        }

        if (age.isEmpty()){
            textInputLayoutAge.setError("Idade não pode ser vazio");
            return;
        }

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("NAME",name);
        bundle.putString("LASTNAME",lastname);
        bundle.putString("AGE",age);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    private void initViews() {
        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        textInputLayoutLastName = findViewById(R.id.textInputLayoutLastName);
        textInputLayoutAge = findViewById(R.id.textInputLayoutAge);
        btnSend = findViewById(R.id.btnSend);
    }
}