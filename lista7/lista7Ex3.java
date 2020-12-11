import java.util.ArrayList;
import java.util.List;

public class lista7Ex3 {

    public static void main(String[]args) {

        String[] lingProg = {"Java", "C", "C++", "C#", "Ruby", "Javascript", "Rust", "Python", "PHP", "Perl", "R"};
        String[] lingMarc = {"HTML","XHTML", "XML", "GML", "XAML", "CSS", "R", "PHP", "Javascript", "Python", "Perl"};

        List<String> lista = new ArrayList<String>();
        for(String l:lingProg) {
			lista.add(l);
        }

        List<String> lista2 = new ArrayList<String>();
        for(String l:lingMarc) {
			lista2.add(l);
        }
        
        System.out.println("\n\n------------------------------\n");
        listaProg(lista);
        System.out.println("\n\n------------------------------\n");
        listaMarc(lista2);
        System.out.println("\n\n------------------------------\n");
        check(lista, lista2);
        System.out.println("\n\n------------------------------\n");

    }

    public static void listaProg(List<String> lista) {
        System.out.println("Linguagens de Programaçao:");
        for (int i = lista.size()-1; i>=0; i--) {
            System.out.print(lista.get(i) + " ");
        }
    }

    public static void listaMarc(List<String> lista) {
        System.out.println("Linguagens de Marcaçao/Script:");
        for (String l:lista) {
            System.out.print(l + " ");
        }
    }

    public static void check(List<String> lista, List<String> lista2) {
        System.out.println("Linguagens nas duas listas:");
        List<String> aux = new ArrayList<String>();
        for (String l:lista) {
            for (String l2:lista2) {
                if (l.equals(l2)) {
                    aux.add(l);
                }
            }
        }
        for (String l:aux) {
            System.out.print(l + " ");
        }
    }
    
}