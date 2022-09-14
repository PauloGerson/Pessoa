package com.example.pessoa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.pessoa.entity.Pessoa;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnIMC, btnEleitor, btnCargo;
    String peso, altura, idade,sexo,escolaridade;
    Pessoa person = new Pessoa();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled( true );



        btnIMC = findViewById(R.id.BtnImc);
        btnIMC.setOnClickListener(calcIMC());

        btnEleitor = findViewById(R.id.btnEleitor);
        btnEleitor.setOnClickListener(eleitor());

        btnCargo = findViewById(R.id.btnCargo);
        btnCargo.setOnClickListener(cargo());



        peso = getIntent().getStringExtra("peso");
        altura = getIntent().getStringExtra("altura");
        idade = getIntent().getStringExtra("idade");
        sexo = getIntent().getStringExtra("sexo").toUpperCase();
        escolaridade = getIntent().getStringExtra("escolaridade").toUpperCase();

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //identificar a ação de voltar a tela
            case android.R.id.home:
                //encerra a activity
                finish();
                break;
        }

        return super.onOptionsItemSelected( item );
    }



    public View.OnClickListener calcIMC(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float imcPeso = Float.parseFloat(peso);
                float imcAltura = Float.parseFloat(altura);


                AlertDialog dialog = new AlertDialog.Builder(getActivity()).create();
                dialog.setTitle("IMC");
                dialog.setMessage(person.IMC(imcPeso,imcAltura));
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                dialog.show();
            }
        };
    }

    public View.OnClickListener eleitor(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idadeEleitor = Integer.parseInt(idade);

                AlertDialog dialog = new AlertDialog.Builder(getActivity()).create();
                dialog.setTitle("Eleitor");
                dialog.setMessage(person.faixaEleitorial(idadeEleitor));
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                dialog.show();
            }
        };
    }


    public View.OnClickListener cargo(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idade12 = Integer.parseInt(idade);
                AlertDialog dialog = new AlertDialog.Builder(getActivity()).create();
                dialog.setTitle("Cargo");
                dialog.setMessage(person.cargo(sexo,idade12,escolaridade));
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                dialog.show();
            }
        };
    }


    public Context getActivity(){
        return this;
    }
}