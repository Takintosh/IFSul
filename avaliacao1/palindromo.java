package avaliacao1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class palindromo {

    public static void main(String[] args) {

        String regex = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
        Pattern pattern = Pattern.compile(regex);
        String data;
        Scanner input = new Scanner(System.in);
        Boolean done = false;

        System.out.print("\nPalindromo de Data");
        System.out.print("\n------------------");

        while(!done) {
            System.out.print("\nInforme a data (dd/mm/aaaa): ");
            data = input.nextLine();
            Matcher matcher = pattern.matcher(data);
            if (matcher.matches()) {
                done = true;
                data = data.replace("/", "");
                check(data);
            } else {
                System.out.print("\nFormato incorreto, tente novamente.\n");
            }
        }

    }

    public static void check(String data) {

        String data2;
        StringBuilder inverso = new StringBuilder(data);
        data2 = inverso.reverse().toString();
        if (data.equals(data2)) {
            System.out.print("A data é um palindromo.");
        } else {
            System.out.print("A data nao é um palindromo.");
        }

    }
    
}