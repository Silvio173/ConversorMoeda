package scr;

import jdk.jfr.Frequency;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RequestCurrency requestCurrency = new RequestCurrency();

        Map<Integer,String> coinMap = new HashMap<>();
        coinMap.put(1,"USD");
        coinMap.put(2,"EUR");
        coinMap.put(3,"COP");
        coinMap.put(4,"ARS");
        coinMap.put(5,"MXN");
        coinMap.put(6,"AUD");
        coinMap.put(7,"JPY");
        coinMap.put(8,"ILS");

        System.out.println(coinMap);


        int choice = 0;
        String exit = "S";
        double cash_value = 0;

        Scanner scs = new Scanner(System.in);

         while (choice !=9) {
            System.out.println("***********************************************");
            System.out.println("Seja bem vindo ao conversor de moedas do Silvio");
            System.out.println("Entre com o valor em Real e saiba quanto tera na moeda ");
            System.out.println();
            System.out.println();
            System.out.println(" 1) Real Brasileiro BRL ==>> Dolar Americano USD");
            System.out.println(" 2) Real Brasileiro BRL ==>> Euro EUR");
            System.out.println(" 3) Real Brasileiro BRL ==>> Peso Colombiano COP");
            System.out.println(" 4) Real Brasileiro BRL ==>> Peso Argentino ARS");
            System.out.println(" 5) Real Brasileiro BRL ==>> Peso Mexicano MXN");
            System.out.println(" 6) Real Brasileiro BRL ==>> Dolar Australiano AUD");
            System.out.println(" 7) Real Brasileiro BRL ==>> Iene Japones JPY");
            System.out.println(" 8) Real Brasileiro BRL ==>> Shekel Israelense IlS");

            System.out.println("9) Sair");
            System.out.println("***********************************************");
            System.out.print("Escolha uma opção valida =  ");
            choice = scs.nextInt();
            String coin = coinMap.get(choice);

            Currency newCurrency = requestCurrency.searchCurrency("BRL");

             if(choice != 9) {
                double  valueCoin = (double) newCurrency.conversion_rates().get(coin);
                System.out.print("Entre com o valor em reais a ser convertido = ");
                cash_value = scs.nextDouble();

                double valueConvert = cash_value * valueCoin;
                String numberFormated = String.format(coin + " %.2f",valueConvert);
                System.out.println("Valor convertido de BRL para "+ coin + " = " + numberFormated);
                System.out.println();
                System.out.println();
                System.out.print("Deseja converter BRL para outras moedas ? (S/N) =");
                exit = scs.next();
                if(exit.equalsIgnoreCase("N")) break;

            }else {
                System.out.println("Fim do programa");
            }
        }

    }
}
