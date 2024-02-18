import javax.swing.JOptionPane;

public class CifrasSignificativas {

    public static void main(String[] args) {
        // Obtener la entrada del usuario
        String input = JOptionPane.showInputDialog("Ingrese números (sin separación):");

        // Analizar cifras significativas
        ResultadoCifrasSignificativas resultado = analizarCifrasSignificativas(input);

        // Mostrar resultados en un cuadro de diálogo
        String mensaje = "Números insertados: " + input + "\nCifras significativas: " + resultado.getCifrasSignificativasEncontradas() +
                "\nCifras significativas encontradas: " + resultado.getCifrasEncontradas();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Clase para almacenar el resultado
    static class ResultadoCifrasSignificativas {
        private int cifrasSignificativasEncontradas;
        private StringBuilder cifrasEncontradas;

        public ResultadoCifrasSignificativas(int cifrasSignificativasEncontradas, StringBuilder cifrasEncontradas) {
            this.cifrasSignificativasEncontradas = cifrasSignificativasEncontradas;
            this.cifrasEncontradas = cifrasEncontradas;
        }

        public int getCifrasSignificativasEncontradas() {
            return cifrasSignificativasEncontradas;
        }

        public String getCifrasEncontradas() {
            return cifrasEncontradas.toString();
        }
    }

    // Método para analizar cifras significativas
    private static ResultadoCifrasSignificativas analizarCifrasSignificativas(String input) {
        int cifrasSignificativas = 0;
        boolean decimalEncontrado = false;
        StringBuilder cifrasEncontradas = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isDigit(c)) {
                // Si es un dígito distinto de cero
                if (c != '0' || decimalEncontrado) {
                    cifrasSignificativas++;
                    cifrasEncontradas.append(c);
                }
                // Resetear la variable decimalEncontrado después de encontrar un dígito
                decimalEncontrado = false;
            } else if (c == '.' || c == ',') {
                // Marcamos que se ha encontrado un decimal
                decimalEncontrado = true;
            } else if (c != ' ' && c != '\t') {
                // Si es un caracter no permitido, terminamos la ejecución
                JOptionPane.showMessageDialog(null, "Error: Caracter no permitido encontrado: " + c);
                System.exit(1);
            }
        }

        return new ResultadoCifrasSignificativas(cifrasSignificativas, cifrasEncontradas);
    }
}
