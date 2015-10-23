package com.cleysonph.calculadoraimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtAltura;
    private TextView txtIMC;
    private Button btnCalcular;
    private TextView txtFrase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        txtIMC = (TextView) findViewById(R.id.txtIMC);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtFrase = (TextView) findViewById(R.id.txtFrase);
    }

    public void calcularIMC(View view){
        NumberFormat decimal = new DecimalFormat(".#");

        double peso = Double.parseDouble(edtPeso.getText().toString());
        double altura = Double.parseDouble(edtAltura.getText().toString());

        double imc = peso / (altura * altura);

        txtIMC.setText("Seu IMC: " + decimal.format(imc));

        if (imc < 16){
            txtFrase.setText("Você está com Magreza grave");
            txtFrase.setTextColor(getResources().getColor(R.color.red));
        } else if(imc < 17){
            txtFrase.setText("Você está com Magreza moderada");
            txtFrase.setTextColor(getResources().getColor(R.color.red));
        } else if (imc < 18.5){
            txtFrase.setText("Você está com Magreza leve");
            txtFrase.setTextColor(getResources().getColor(R.color.yellow));
        } else if(imc < 25){
            txtFrase.setText("Você está Saudável");
            txtFrase.setTextColor(getResources().getColor(R.color.green));
        } else if(imc < 30){
            txtFrase.setText("Você está com Sobrepeso");
            txtFrase.setTextColor(getResources().getColor(R.color.yellow));
        } else if(imc < 35){
            txtFrase.setText("Você está com Obesidade Grau I");
            txtFrase.setTextColor(getResources().getColor(R.color.red));
        } else if(imc < 40){
            txtFrase.setText("Você está com Obesidade Grau II (Severa)");
            txtFrase.setTextColor(getResources().getColor(R.color.red));
        } else {
            txtFrase.setText("Você está com Obesidade Grau III (Mórbida)");
            txtFrase.setTextColor(getResources().getColor(R.color.red));
        }
    }
}
