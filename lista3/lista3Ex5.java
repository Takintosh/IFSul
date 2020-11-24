package lista3;

public class lista3Ex5 {
    public static void main (String[] args) {

        System.out.print("Testando metodo contar():\n");
        Contagem.contar();

        System.out.print("\nTestando metodo contar(int fim):\n");
        Contagem.contar(8);

        System.out.print("\nTestando metodo contar(int inicio, int fim):\n");
        Contagem.contar(4, 15);

        System.out.print("\nTestando metodo contar(int inicio, int fim, int pausa):\n");
        Contagem.contar(0, 10, 1);

    }  

}
