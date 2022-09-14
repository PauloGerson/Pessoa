package com.example.pessoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.pessoa.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    EditText peso, altura,idade, escolaridade, sexo;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        escolaridade = findViewById(R.id.inputEscolaridade);
        peso = findViewById(R.id.inputpeso);
        altura = findViewById(R.id.inputAltura);
        idade = findViewById(R.id.inputIdade);
        sexo = findViewById(R.id.inputSexo);


        btn = findViewById(R.id.button2);
        btn.setOnClickListener(acaobtn());
    }

    public View.OnClickListener acaobtn(){
        return new Button.OnClickListener() {
            public void onClick(View v) {
                //aqui estou usando o intent para enviar dados para a activity principal
                Intent intent = new Intent(getActivity(), MainActivity.class);

                //Nessa linha eu pego o valor de cada input meu atraves do name, e mando como uma String
                intent.putExtra("peso", peso.getText().toString());
                intent.putExtra("altura", altura.getText().toString());
                intent.putExtra("idade", idade.getText().toString());
                intent.putExtra("escolaridade", escolaridade.getText().toString());
                intent.putExtra("sexo", sexo.getText().toString());

                startActivity(intent);

            }

        };
    }

    public Context getActivity(){
        return this;
    }
}