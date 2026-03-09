import java.util.Scanner;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EJ3_MoneyExchange_API {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Currency Converter ===");
        
        // Get input parameters
        System.out.print("Enter the currency 1 (e.g., USD): ");
        String haveCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the currency 2 (e.g., EUR): ");
        String wantCurrency = scanner.nextLine().toUpperCase();
        
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        
        System.out.println("\nConverting " + amount + " " + haveCurrency + " to " + wantCurrency + "...\n");

        try {
            // Create HTTP client
            HttpClient client = HttpClient.newHttpClient();
            
            // Build the API URL for exchange rate
            // NEW URL: https://api.api-ninjas.com/v1/exchangerate
            // EXAMPLE string: https://api.api-ninjas.com/v1/exchangerate?pair=GBP_AUD
            // form: currency1_currency2
            String apiUrl = String.format("https://api.api-ninjas.com/v1/exchangerate?pair=%s_%s", 
                                        haveCurrency, wantCurrency);
            
            // Build the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Accept", "application/json")
                    .header("X-Api-Key", "O0mFt7x+s9iD9AECdcwijA==iLPNgRrlxfHbVn3O")
                    .GET()
                    .build();
            
            // Send the request and get response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            if (response.statusCode() == 200) {
                // Parse the JSON response
                String jsonResponse = response.body();
                parseAndPrintExchangeRate(jsonResponse, amount, haveCurrency, wantCurrency);
            } else {
                System.out.println("Error: HTTP " + response.statusCode());
                System.out.println("Response: " + response.body());
            }
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching conversion: " + e.getMessage());
        }

        scanner.close();
    }
    
    private static void parseAndPrintExchangeRate(String json, double originalAmount, String haveCurrency, String wantCurrency) {
        try {
            System.out.println("Raw JSON: " + json);
            System.out.println();
            
            // Extract the exchange rate from JSON
            // Expected format: {"currency_pair":"USD_EUR","exchange_rate":0.9171}
            String currencyPair = extractStringValue(json, "currency_pair");
            double exchangeRate = extractDoubleValue(json, "exchange_rate");
            
            // Calculate the converted amount
            double newAmount = originalAmount * exchangeRate;

            // Display results in requested format
            System.out.println("=== CONVERSION RESULT ===");
            System.out.println("┌─────────────────────────────────────────┐");
            System.out.println("│            💱 CURRENCY EXCHANGE         │");
            System.out.println("├─────────────────────────────────────────┤");
            System.out.printf("│ New Amount:    %.2f %s%n", newAmount, wantCurrency);
            System.out.printf("│ New Currency:  %s%n", wantCurrency);
            System.out.printf("│ Old Amount:    %.2f %s%n", originalAmount, haveCurrency);
            System.out.printf("│ Old Currency:  %s%n", haveCurrency);
            System.out.println("└─────────────────────────────────────────┘");
            
            // Show exchange rate details
            System.out.printf("\nExchange Rate: 1 %s = %.4f %s%n", haveCurrency, exchangeRate, wantCurrency);
            System.out.printf("Currency Pair: %s%n", currencyPair);
            
        } catch (Exception e) {
            System.out.println("Error parsing exchange rate: " + e.getMessage());
            System.out.println("Raw response: " + json);
        }
    }
    
    private static double extractDoubleValue(String json, String key) {
        try {
            String value = extractStringFromJson(json, key);
            return Double.parseDouble(value);
        } catch (Exception e) {
            System.out.println("Error extracting double " + key + ": " + e.getMessage());
            return 0.0;
        }
    }
    
    private static String extractStringValue(String json, String key) {
        try {
            return extractStringFromJson(json, key);
        } catch (Exception e) {
            System.out.println("Error extracting string " + key + ": " + e.getMessage());
            return "";
        }
    }
    
    private static String extractStringFromJson(String json, String key) {
        // Look for "key": value pattern (handles both strings and numbers)
        String searchKey = "\"" + key + "\"";
        int keyIndex = json.indexOf(searchKey);
        if (keyIndex == -1) return "";
        
        // Find the colon after the key
        int colonIndex = json.indexOf(":", keyIndex);
        if (colonIndex == -1) return "";
        
        // Skip whitespace after colon
        int valueStart = colonIndex + 1;
        while (valueStart < json.length() && Character.isWhitespace(json.charAt(valueStart))) {
            valueStart++;
        }
        
        // Check if value is a string (starts with quote) or number
        if (json.charAt(valueStart) == '"') {
            // String value
            int endQuote = json.indexOf('"', valueStart + 1);
            if (endQuote == -1) return "";
            return json.substring(valueStart + 1, endQuote);
        } else {
            // Number value - find end (comma or closing brace)
            int valueEnd = valueStart;
            while (valueEnd < json.length() && 
                   json.charAt(valueEnd) != ',' && 
                   json.charAt(valueEnd) != '}' && 
                   json.charAt(valueEnd) != ']') {
                valueEnd++;
            }
            return json.substring(valueStart, valueEnd).trim();
        }
    }
}
