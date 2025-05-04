package conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConversorMoneda {

    private static final String API_KEY = "2e9a99bc576dea30767286ec";
    private static final Map<String, Double> tasasCache = new HashMap<>();

    public static void convertir(String base, String destino) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        try {
            double tasa = obtenerTasa(base, destino);
            double resultado = cantidad * tasa;
            System.out.printf("%.2f %s = %.2f %s\n", cantidad, base, resultado, destino);
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de conversión: " + e.getMessage());
        }
    }

    private static double obtenerTasa(String base, String destino) throws Exception {
        String claveDirecta = base + "_" + destino;
        String claveInversa = destino + "_" + base;

        if (tasasCache.containsKey(claveDirecta)) {
            return tasasCache.get(claveDirecta);
        } else if (tasasCache.containsKey(claveInversa)) {
            double tasaInversa = tasasCache.get(claveInversa);
            double tasa = 1.0 / tasaInversa;
            tasasCache.put(claveDirecta, tasa);
            return tasa;
        }

        double tasa = obtenerTasaDesdeAPI(base, destino);
        tasasCache.put(claveDirecta, tasa);
        return tasa;
    }

    private static double obtenerTasaDesdeAPI(String base, String destino) throws Exception {
        String urlStr = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", API_KEY, base);
        URL url = new URL(urlStr);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

        JsonObject rates = json.getAsJsonObject("conversion_rates");
        return rates.get(destino).getAsDouble();
    }

    public static void mostrarTasasCache() {
        if (tasasCache.isEmpty()) {
            System.out.println("No hay tasas almacenadas todavía.");
            return;
        }

        System.out.println("\n Tasas de cambio en caché:");
        for (Map.Entry<String, Double> entrada : tasasCache.entrySet()) {
            String[] partes = entrada.getKey().split("_");
            String origen = partes[0];
            String destino = partes[1];
            double tasa = entrada.getValue();
            System.out.printf("1 %s = %.4f %s\n", origen, tasa, destino);
        }
    }
}
