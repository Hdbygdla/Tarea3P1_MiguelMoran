/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea3p1_miguelmoran;

import java.util.Scanner;

/**
 *
 * @author flash
 */
public class Tarea3P1_MiguelMoran {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean seguir = true;
        while (seguir) {
            System.out.println("1. Veamos si podemos formar la palabra");
            System.out.println("2. Numeros primero");
            System.out.println("3. Ordenar alfabeticamente");
            System.out.println("4. Codificar cadenas");
            System.out.println("5. Jugando con arreglos");
            System.out.println("6. Salir");
            System.out.print("Elija una opcion: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.print("Escriba la primera palabra: ");
                    sc.nextLine();
                    String word1 = sc.nextLine();
                    System.out.print("Escriba la segunda palabra: ");
                    String word2 = sc.nextLine();
                    String test = "";
                    String longword, shortword;
                    if (word1.length() > word2.length()) {
                        longword = word1.toLowerCase();
                        shortword = word2.toLowerCase();
                    } else {
                        shortword = word1.toLowerCase();
                        longword = word2.toLowerCase();
                    }
                    for (int i = 0; i < longword.length(); i++) {
                        for (int j = 0; j < shortword.length(); j++) {
                            if (longword.charAt(i) == shortword.charAt(j)) {
                                test += longword.charAt(j);
                            }
                        }
                    }
                    if (test.equals(shortword)) {
                        System.out.println("Si se puede armar " + shortword);
                    } else {
                        System.out.println("No se puede armar " + shortword);
                    }
                }
                case 2 -> {
                    System.out.print("Escriba una cadena que contenga numeros: ");
                    String string = sc.next();
                    String newstring = "";
                    for (int i = 0; i < string.length(); i++) {
                        int ascii = string.charAt(i);
                        if (ascii > 47 && ascii < 58) {
                            newstring += string.charAt(i);
                        }
                    }
                    for (int i = 0; i < string.length(); i++) {
                        int ascii = string.charAt(i);
                        if (ascii > 64 && ascii < 91) {
                            newstring += string.charAt(i);
                        } else if (ascii > 96 && ascii < 123) {
                            newstring += string.charAt(i);
                        }
                    }
                    System.out.println(newstring);
                }
                case 3 -> {
                    System.out.print("Escriba una palabra u oracion: ");
                    sc.nextLine();
                    String string = sc.nextLine();
                    System.out.println("La cadena tenia "+Orden_alfabetico(string)+" numeros");
                }
                case 4 -> {
                    System.out.print("Ingrese el mensaje secreto: ");
                    sc.nextLine();
                    String string = sc.nextLine();
                    Codificacion(string);
                }
                case 5 -> {
                    System.out.println("Ingrese los numeros del array: ");
                    int[] array = new int[10];
                    Llenado(array);
                    System.out.print("El array es: ");
                    Impresion(array);
                    System.out.println("");
                }
                case 6 -> {
                    seguir = false;
                }
                default -> {
                    System.out.println("Elija una opcion valida");
                }
            }
        }
    }
    public static int Orden_alfabetico(String string){
        string = string.toLowerCase();
        String newstring = "";
        int numeros = 0;
        for (int i = 97; i < 123; i++) {
            char charac = (char)i;
            for (int j = 0; j < string.length(); j++) {
                if(string.charAt(j) == charac){
                    newstring += string.charAt(j);
                }
            }
        }
        for (int i = 0; i < string.length(); i++) {
            int ascii = string.charAt(i);
            if(ascii > 47 && ascii < 58){
                    numeros += 1;
            }
        }
        System.out.println(newstring);
        return numeros;
    }
    public static void Codificacion(String string){
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            int ascii = string.charAt(i);
            if(i == 0){
                if(ascii > 97 && ascii < 123){
                    System.out.print(ascii-96);
                } else if(ascii > 47 && ascii < 58){
                    ascii += 17;
                    System.out.print((char)ascii);
                }
            } else {
                if(ascii > 97 && ascii < 123){
                    System.out.print("-"+(ascii-96));
                } else if(ascii > 47 && ascii < 58){
                    ascii += 17;
                    System.out.print("-"+(char)ascii);
                }
            }
        }
        System.out.println("");
    }
    public static int[] Llenado(int[] array){
        for (int i = 0; i < 10; i++) {
            System.out.println("Valor "+(i+1)+": ");
            array[i] = sc.nextInt();
        }
        return array;
    }
    public static void Impresion(int[] array){
        for (int i = 0; i < 10; i++){
            System.out.print("["+array[i]+"]");
        }
    }
}
