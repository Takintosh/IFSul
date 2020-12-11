import java.util.Arrays;
import java.util.LinkedList;

public class lista7Ex2 {

    public static void main(String[]args) {

        String[] lingProg = {"Java", "C", "C++", "C#", "Ruby", "Javascript", "Rust", "Python", "PHP", "Perl", "R"};
        String[] lingMarc = {"HTML","XHTML", "XML", "GML", "XAML", "CSS", "R", "PHP", "Javascript", "Python", "Perl"};

        LinkedList<String> lista = new LinkedList<>(Arrays.asList(lingProg));
        LinkedList<String> lista2 = new LinkedList<>(Arrays.asList(lingMarc));
        lista.addAll(lista2);

        crescente(lista);
        decrescente(lista);

    }

    public static void crescente(LinkedList<String> lista) {
        System.out.println("\nLista crescente:\n");
        System.out.println("----------------\n");
        String linguagens[] = lista.toArray(new String[lista.size()]);
		for(String l: linguagens) 
			System.out.println(l);
    }

    public static void decrescente(LinkedList<String> lista) {
        System.out.println("\nLista decrescente:\n");
        System.out.println("------------------\n");
        String linguagens[] = lista.toArray(new String[lista.size()]);
        for (int i = linguagens.length-1; i>=0; i--) {
            System.out.println(linguagens[i]);
        }
    }
    
}