package PruebaEvaluable;
public class ClaveCasaPapel {
	public static void main(String[] args) {
        // Generar clave aleatoria de 4 letras minúsculas
        int clave1 = (int)(Math.floor(Math.random() * 26)) + 97;
        int clave2 = (int)(Math.floor(Math.random() * 26)) + 97;
        int clave3 = (int)(Math.floor(Math.random() * 26)) + 97;
        int clave4 = (int)(Math.floor(Math.random() * 26)) + 97;

        // Ejecutar los métodos y mostrar resultados
        Resultado resAleatoria = fuerzaAleatoria(clave1, clave2, clave3, clave4);
        System.out.printf("fuerzaAleatoria encontró: %c%c%c%c%n", clave1, clave2, clave3, clave4);
        System.out.printf("fuerzaAleatoria -> tiempo (s): %.6f | intentos: %d%n", resAleatoria.tiempoSegundos, resAleatoria.intentos);

        Resultado resBruta = fuerzaBruta(clave1, clave2, clave3, clave4);
        System.out.printf("fuerzaBruta encontró: %c%c%c%c%n", clave1, clave2, clave3, clave4);
        System.out.printf("fuerzaBruta    -> tiempo (s): %.6f | intentos: %d%n", resBruta.tiempoSegundos, resBruta.intentos);

        Resultado resJusta = fuerzaJusta(clave1, clave2, clave3, clave4);
        System.out.printf("fuerzaJusta encontró: %c%c%c%c%n", clave1, clave2, clave3, clave4);
        System.out.printf("fuerzaJusta    -> tiempo (s): %.6f | intentos: %d%n", resJusta.tiempoSegundos, resJusta.intentos);
    }

    // Clase mínima para tiempo e intentos
    static class Resultado {
        double tiempoSegundos;
        long intentos;
        Resultado(double t, long i) {
            tiempoSegundos = t;
            intentos = i;
        }
    }

    // 1) Fuerza aleatoria
    public static Resultado fuerzaAleatoria(int target1, int target2, int target3, int target4) {
        long inicio = System.nanoTime();
        long intentos = 0;
        int a, b, c, d;
        while (true) {
            a = (int)(Math.floor(Math.random() * 26)) + 97;
            b = (int)(Math.floor(Math.random() * 26)) + 97;
            c = (int)(Math.floor(Math.random() * 26)) + 97;
            d = (int)(Math.floor(Math.random() * 26)) + 97;
            intentos++;
            if (a == target1 && b == target2 && c == target3 && d == target4) {
                double segundos = (System.nanoTime() - inicio) / 1_000_000_000.0;
                return new Resultado(segundos, intentos);
            }
        }
    }

    // 2) Fuerza bruta secuencial sin usar outer
    public static Resultado fuerzaBruta(int target1, int target2, int target3, int target4) {
        long inicio = System.nanoTime();
        long intentos = 0;
        int a=97, b=97, c=97, d=97;
        boolean encontrado = false;

        for (a = 97; a <= 122 && !encontrado; a++) {
            for (b = 97; b <= 122 && !encontrado; b++) {
                for (c = 97; c <= 122 && !encontrado; c++) {
                    for (d = 97; d <= 122 && !encontrado; d++) {
                        intentos++;
                        if (a == target1 && b == target2 && c == target3 && d == target4) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (encontrado) break;
                }
                if (encontrado) break;
            }
            if (encontrado) break;
        }

        if (encontrado) { a--; b--; c--; d--; }

        double segundos = (System.nanoTime() - inicio) / 1_000_000_000.0;
        return new Resultado(segundos, intentos);
    }

    // 3) Fuerza justa (letra a letra)
    public static Resultado fuerzaJusta(int target1, int target2, int target3, int target4) {
        long inicio = System.nanoTime();
        long intentos = 0;

        int a = 97; while (a <= 122) { intentos++; if (a == target1) break; a++; }
        int b = 97; while (b <= 122) { intentos++; if (b == target2) break; b++; }
        int c = 97; while (c <= 122) { intentos++; if (c == target3) break; c++; }
        int d = 97; while (d <= 122) { intentos++; if (d == target4) break; d++; }

        double segundos = (System.nanoTime() - inicio) / 1_000_000_000.0;
        return new Resultado(segundos, intentos);
    }
}