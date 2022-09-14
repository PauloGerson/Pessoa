package com.example.pessoa.entity;

import android.widget.Toast;

public class Pessoa {
    private String nome;
    private int idade;
    private String escolaridade, sexo;
    private float peso,altura;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    //Metodos

     public String faixaEleitorial(int faixaEleitor){
        String result = "";

        if(faixaEleitor < 16){
            result = "Não eleitor";
        }
        else if (faixaEleitor >= 18 && faixaEleitor <=65){
            result = "Eleitor obrigatorio";
        }
        else if(faixaEleitor >= 16 && faixaEleitor <=17 || faixaEleitor > 65){
            result = "Eleitor facultativo";
        }

        return  result;

        }


        public String IMC(float peso, float altura){

            float imc = peso / (altura * altura);
            String result = null;

            if(imc < 18.5){
                  result = "Você está abaixo do seu peso ideal";
            }
            else if(imc >= 18.5 && imc <=  24.9){
                result = "Parabéns, você está em seu peso normal";
            }
            else if(imc > 24.9){
                result =  "Você está acima de seu peso (sobrepeso).";
            }

            return result;

        }

        public String cargo(String sexo, int idade, String escolaridade ){
            System.out.println("teste: " + sexo + idade + escolaridade);

            String cargo = null;

            if(sexo.equals("FEMININO") && idade < 25 && escolaridade.equals("MÉDIO")){
                 cargo = "Recepcionista";
            }
             /*else if(sexo.equalsIgnoreCase("Masculino") && idade > 40 && escolaridade.equalsIgnoreCase("FUNDAMENTAL")){
                cargo = "Servente";

            }
             else if( (sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("Feminino")) &&  idade < 30 && escolaridade.equals("SUPERIOR") ){
                cargo = "Auxiliar de RH";
            }

            else{
                cargo = "Nenhum cargo";
            }*/


            return cargo;

        }
}
