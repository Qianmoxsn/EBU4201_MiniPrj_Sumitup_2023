import javax.swing.*;
import java.awt.*;

public class SumItUp extends JFrame {
    private static final String title = "Welcome to Sum It Up!";
    private static final String img_rabbit = "img/rabbit.jpg";
    private static final String img_plus = "img/plus.png";
    private static final ImageIcon img_rabbit_icon = new ImageIcon(img_rabbit);
    private static final ImageIcon img_plus_icon = new ImageIcon(img_plus);
    private JPanel panel_left;
    private JPanel panel_right;
    private JPanel panel_bottom;
    private JLabel info;
    private JTextField input_1;
    private JTextField input_2;
    private JTextField input_3;
    private static SumItUp frame;
    private int num_1;
    private int num_2;
    public Font font = new Font("Consolas", Font.BOLD, 16);

    public SumItUp() {
        setTitle(title);
        setLayout(new BorderLayout());
        setLocation(700, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_left = new JPanel(new GridLayout(4, 3));
        panel_right = new JPanel(new GridLayout(4, 3));
        panel_bottom = new JPanel();

        add(panel_left, BorderLayout.WEST);
        add(panel_right, BorderLayout.EAST);
        add(panel_bottom, BorderLayout.SOUTH);

        /*** Test: ***/
//        panel_left.setBackground(Color.pink);
//        panel_right.setBackground(Color.orange);
        /*************/
    }


    public void addImageToPanel(int img_num, JPanel panel) {
        panel.removeAll();

        for (int i = 0; i < img_num; i++) {
            JLabel label = new JLabel(img_rabbit_icon);
            panel.add(label);
        }
        for (int i = 0; i < (12 - img_num); i++) {
            JLabel label = new JLabel("");
            panel.add(label);
        }
        panel.updateUI();
    }

    public void addInfoLabel(String primary_info_text) {
        info = new JLabel(primary_info_text);
        info.setHorizontalAlignment(JLabel.CENTER);
        frame.add(info, BorderLayout.NORTH);
    }

    public void modifyInfoLabel(String info_text) {
        info.setText(info_text);
    }

    public void addCenterImage() {
        JLabel label_plus = new JLabel(img_plus_icon);
        frame.add(label_plus, BorderLayout.CENTER);
    }

    public void addBottomPanel() {
        input_1 = new JTextField();
        input_2 = new JTextField();
        input_3 = new JTextField();
        JButton button = new JButton("Check!");
        input_1.setPreferredSize(new Dimension(30, 25));
        input_2.setPreferredSize(new Dimension(30, 25));
        input_3.setPreferredSize(new Dimension(30, 25));
        input_1.setFont(font);
        input_2.setFont(font);
        input_3.setFont(font);
        button.setFont(font);
        panel_bottom.add(input_1);
        panel_bottom.add(new JLabel("+"));
        panel_bottom.add(input_2);
        panel_bottom.add(new JLabel("="));
        panel_bottom.add(input_3);
        panel_bottom.add(button);

        button.addActionListener(e -> {
            frame.judgeResult(num_1, num_2);
        });
    }

    private void newGame() {
        num_1 = frame.randomInt(1, 10);
        num_2 = frame.randomInt(1, 10);
        frame.addImageToPanel(num_1, frame.panel_left);
        frame.addImageToPanel(num_2, frame.panel_right);
    }

    public int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    private void judgeResult(int num_1, int num_2) {
        int valid_result = num_1 + num_2;
        String input1Text = input_1.getText();
        String input2Text = input_2.getText();
        String input3Text = input_3.getText();
        if (input1Text.equals("") || input2Text.equals("") || input3Text.equals("")) {}
        else {
            if (input1Text.equals(String.valueOf(num_1)) && input2Text.equals(String.valueOf(num_2)) && input3Text.equals(String.valueOf(valid_result))) {
                modifyInfoLabel("Correct! Have another go?");
                input_1.setText("");
                input_2.setText("");
                input_3.setText("");
                frame.newGame();
            } else {
                modifyInfoLabel("Wrong! Try again!");
            }
        }
    }

    public static void main(String[] args) {
        frame = new SumItUp();
        frame.addInfoLabel("Enter two operands, result and click on 'Check!'");
        frame.addCenterImage();
        frame.addBottomPanel();

        frame.newGame();

        frame.pack();
        frame.setVisible(true);
    }


}
