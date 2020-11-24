import java.util.Scanner;

public class lista4Ex3 {

    public static void main(String[] args) {

        String fecha = "";
        StringBuilder fechaConstruida = new StringBuilder(fecha);

        String fechaInput;
        Scanner input = new Scanner(System.in);
        System.out.print("\nIngrese la fecha: \n");
        fechaInput = input.nextLine();
        input.close();

        String meses[][] = { { "", "" }, { "01", "enero" }, { "02", "febrero" }, { "03", "marzo" }, { "04", "abril" },
                { "05", "mayo" }, { "06", "junio" }, { "07", "julio" }, { "08", "agosto" }, { "09", "setiembre" },
                { "10", "octubre" }, { "11", "noviembre" }, { "12", "diciembre" } };

        if (fechaInput.length() <= 10) {
            String arrayFecha[] = fechaInput.split("/");
            int mes = Integer.parseInt(arrayFecha[1]);
            fechaConstruida.append(arrayFecha[0]).append(" de ").append(meses[mes][1]).append(" de ")
                    .append(arrayFecha[2]);
            fecha = fechaConstruida.toString();
            if (fecha.substring(0, 1).equals("0")) {
                fecha = fecha.substring(1);
            }
        } else {
            fechaInput = fechaInput.toLowerCase();
            String arrayFecha[] = fechaInput.split(" de ");
            for (int i = 1; i < meses.length; i++) {
                if (arrayFecha[1].equals(meses[i][1])) {
                    arrayFecha[1] = meses[i][0];
                }
            }
            if (Integer.parseInt(arrayFecha[0]) <= 10) {
                StringBuilder diaConstruido = new StringBuilder();
                diaConstruido = diaConstruido.append("0").append(arrayFecha[0]);
                arrayFecha[0] = diaConstruido.toString();
            }
            fechaConstruida.append(arrayFecha[0]).append("/").append(arrayFecha[1]).append("/").append(arrayFecha[2]);
            fecha = fechaConstruida.toString();
        }

        System.out.print("\nFecha convertida: \n" + fecha + ".");

    }

}