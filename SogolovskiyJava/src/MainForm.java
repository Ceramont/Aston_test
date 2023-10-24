import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainForm extends JDialog {
    private JPanel contentPane;
    private JTextField insertSevenField;
    private JButton sevenButton;
    private JLabel sevenLabel;
    private JLabel sevenAnswerLabel;
    private JLabel nameLabel;
    private JTextField insertNameField;
    private JButton nameButton;
    private JLabel answerNameLabel;
    private JLabel arrayLabel;
    private JTextField insertNewArrField;
    private JTextField arrayNowLabel;
    private JLabel newArrayLabel;
    private JButton updateArrayButton;
    private JLabel updateArrayLabel;
    private JButton modThreeButton;
    private JTextField arrayModField;
    private JLabel arrNowLabel;

    public MainForm() {

        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrayNowLabel.setText(Arrays.toString(intArray));
        arrayNowLabel.setVisible(true);
        sevenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onSevenButton();
            }
        });

        nameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNameButton();
            }
        });

        updateArrayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onUpdateArrayButton();
            }
        });

        modThreeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onModThreeButton();
            }
        });
    }

    // Обработчик нажатия кнопки Проверить число
    private void onSevenButton() {

        String text = insertSevenField.getText();
        try {

            int value = Integer.parseInt(text);
            if (value <= 7) {

                sevenAnswerLabel.setText("тевирП");
                sevenAnswerLabel.setForeground(Color.red);
                sevenAnswerLabel.setVisible(true);

            } else {

                sevenAnswerLabel.setText("Привет");
                sevenAnswerLabel.setForeground(Color.green);
                sevenAnswerLabel.setVisible(true);

            }

        } catch (NumberFormatException e) {

            sevenAnswerLabel.setText("Некорректное значение");
            sevenAnswerLabel.setForeground(Color.red);
            sevenAnswerLabel.setVisible(true);

        }

    }

    // Обработчик нажатия кнопки Проверить имя
    private void onNameButton() {
        //Получаем текст из текстового поля
        String text = insertNameField.getText();
        try {
            //Проверяем текст на совпадение
            if (text.equals("Вячеслав")) {
                // Выводим результат
                answerNameLabel.setText(String.format("Привет, %s", text));
                answerNameLabel.setForeground(Color.green);
                answerNameLabel.setVisible(true);

            } else {

                answerNameLabel.setText("Нет такого имени");
                answerNameLabel.setForeground(Color.red);
                answerNameLabel.setVisible(true);

            }

        } catch (Exception e) {

            answerNameLabel.setText("Некорректное значение");
            answerNameLabel.setForeground(Color.red);
            answerNameLabel.setVisible(true);

        }

    }

    //Обработчик нажатия кнопки обновить массив
    private void onUpdateArrayButton() {
        //Достаем текст из тестового поля
        String arrayText = insertNewArrField.getText();
        String[] parsedArrayText = null;
        boolean isUpdate = true;
        try {
            // Создаем из строки массив строк
            parsedArrayText = arrayText.split(",");
        } catch (Exception e) {
            updateArrayLabel.setText("Некорректное значение в массиве");
            updateArrayLabel.setForeground(Color.red);
            updateArrayLabel.setVisible(true);
            isUpdate = false;
        }

        int[] arrayInt = new int[parsedArrayText.length];

        for (int i = 0; i < parsedArrayText.length; i++) {

            try {
                // Добавляем в массив чисел преобразованные числа из строк
                arrayInt[i] = Integer.parseInt(parsedArrayText[i]);

            } catch (NumberFormatException e) {

                updateArrayLabel.setText("Некорректное значение в массиве");
                updateArrayLabel.setForeground(Color.red);
                updateArrayLabel.setVisible(true);
                isUpdate = false;
            }

        }
        if (isUpdate) {

            arrayNowLabel.setText(Arrays.toString(arrayInt));

        }

    }

    //Обработчик нажатия кнопки Вывести числа кратные 3
    private void onModThreeButton() {

        String arrayText = arrayNowLabel.getText();
        // Удаляем символы [,], пробел из текста
        String arrayModText = arrayText.replaceAll("\\[|\\]|\\s", "");
        // Создаем массив строк из строки
        String[] parsedArrayText = arrayModText.split(",");
        List<Integer> listModInt = new ArrayList<Integer>();
        // Проходим массив строк, преобразуем строки в числа, проверяем кратно ли 3 и записываем в итоговый лист
        for (int i = 0; i < parsedArrayText.length; i++) {

            if (Integer.parseInt(parsedArrayText[i]) % 3 == 0) {

                listModInt.add(Integer.parseInt(parsedArrayText[i]));

            }

        }
        //Вставляем итоговый лист в Текстовое поле ответа
        arrayModField.setVisible(true);
        arrayModField.setText(listModInt.toString());
        arrayModField.setForeground(Color.green);


    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("SogolovskiyJava");
        frame.setContentPane(new MainForm().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

    }


}
