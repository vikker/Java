package temperaturesconverter;

/**
 * @author Vik Tolstoi
 */
public class TemperaturesConverter {

    public static void main(String[] args) {

        ConverterUI view = new ConverterUI();
        ConverterModel model = new ConverterModel();

        ConverterControler controler = new ConverterControler(model, view);
        view.setVisible(true);
    }

}
