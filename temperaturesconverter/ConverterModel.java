package temperaturesconverter;

/**
 *
 * @author Vik Tolstoi
 */
public class ConverterModel {

    private int temperature;
    private String sign;

    public int getTemperature() {
        return temperature;
    }

    public String getSign() {
        return sign;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    String converter() {

        String res = "";

        switch (this.getSign()) {
            case "C":
                res = "{\"F\": " + "\"" + this.convertCtoF()
                        + "\", " + "\"K\": " + "\"" + this.convertCtoK() + "\"}";
                break;
            case "F":
                res = "{\"C\": " + "\"" + this.convertFtoC()
                        + "\", " + "\"K\": " + "\"" + this.convertFtoK() + "\"}";
                break;
            case "K":
                res = "{\"C\": " + "\"" + this.convertKtoC()
                        + "\", " + "\"F\": " + "\"" + this.convertKtoF() + "\"}";
                break;
        }
        return res;
    }

    String convertCtoF() {
        return Integer.toString(9 * temperature / 5 + 32);
    }

    String convertCtoK() {
        return Integer.toString(temperature + 273);
    }

    String convertFtoC() {
        return Integer.toString((temperature - 32) * 5 / 9);
    }

    String convertFtoK() {
        return Integer.toString((temperature - 32) * 5 / 9 + 273);
    }

    String convertKtoC() {
        return Integer.toString(temperature - 273);
    }

    String convertKtoF() {
        return Integer.toString((temperature - 273) * 9 / 5 + 32);
    }

}
