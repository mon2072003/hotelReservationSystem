
package hotelreservationsystem;

interface CurrencyConverter {
    double convertToUSD(double amount);
}

class EuroToUSDConverter implements CurrencyConverter {
    @Override
    public double convertToUSD(double amount) {
        return amount * 1.1; // Assume 1 EUR = 1.1 USD
    }
}

class CurrencyConverterAdapter {
    private CurrencyConverter converter;

    public CurrencyConverterAdapter(CurrencyConverter converter) {
        this.converter = converter;
    }

    public double convert(double amount) {
        return converter.convertToUSD(amount);
    }
}
