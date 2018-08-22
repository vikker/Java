package temperaturesconverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Vik Tolstoi
 */
public class ConverterControler {

    private ConverterModel model;
    private ConverterUI view;

    public ConverterControler(ConverterModel model, ConverterUI view) {

        this.model = model;
        this.view = view;

        this.view.addButtonListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (view.isUsersInputValid()) {
                model.setTemperature(Integer.parseInt(view.getInput().
                        substring(0, view.getInput().length() - 1)));
                model.setSign((view.getInput().substring(view.getInput().
                        length() - 1)).toUpperCase());
                view.setOutput(model.converter());
            }

        }

    }

}
