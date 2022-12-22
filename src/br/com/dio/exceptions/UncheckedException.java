package br.com.dio.exceptions;

import javax.swing.*;

//Fazer a divisão de 2 valores inteiros
public class UncheckedException {
    public static void main(String[] args) {

        boolean continueLooping = true;
        do {
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador: ");

            //O try consegue recuperar erros que possam ocorrer no código fornecido em seu bloco
            try{ //try é o bloco onde coloca a lógica e pode ocorrer a exception
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
                //O catch por sua vez faz o tratamento dos erros que aconteceram.
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Entrada inválida, informe um número inteiro! " + e.getMessage());
            } catch (ArithmeticException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Impossível dividir um número por 0.");
            }
            finally {
                System.out.println("Chegou no finally!");
            }
        } while(continueLooping);


        System.out.println("O código continua..."); //tudo que ocorre após a try, catch e finally, vai continuar independente de ter ocorrido exception ou não.

    }

    public static int dividir(int a, int b) {
        return a / b;
    }
}
