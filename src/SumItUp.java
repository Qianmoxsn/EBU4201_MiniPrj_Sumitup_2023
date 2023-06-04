import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * A class to build the GUI interface of sum it up.
 *
 * @author QIANMO
 * @version 1.0
 */
public class SumItUp extends JFrame {

    /**
     * The title of the frame.
     */
    private static final String title = "Welcome to Sum It Up!";
    /**
     * The path of the image(rabbit).
     */
    private static final String img_rabbit = "img/rabbit.jpg";
    /**
     * The path of the image(plus).
     */
    private static final String img_plus = "img/plus.png";
    /**
     * The imageicon of rabbit.
     */
    private static final ImageIcon img_rabbit_icon = new ImageIcon(img_rabbit);
    /**
     * The imageicon of plus.
     */
    private static final ImageIcon img_plus_icon = new ImageIcon(img_plus);
    /**
     * The panel on the left of the frame(WEST)
     */
    private final JPanel panel_left;
    /**
     * The panel on the right of the frame(EAST)
     */
    private final JPanel panel_right;
    /**
     * The panel on the bottom of the frame(SOUTH)
     */
    private final JPanel panel_bottom;
    /**
     * The label to display the info(NORTH)
     */
    private JLabel info;
    /**
     * The combo box of operand 1
     */
    private JComboBox<String> input_1;
    /**
     * The combo box of operand 2
     */
    private JComboBox<String> input_2;
    /**
     * The combo box of result
     */
    private JComboBox<String> input_3;
    /**
     * The frame of the game
     */
    private static SumItUp frame;
    /**
     * The number of images(rabbit) on the left(random)
     */
    private int num_1;
    /**
     * The number of images(rabbit) on the right(random)
     */
    private int num_2;
    /**
     * The font of the text.
     */
    private final Font font = new Font("Consolas", Font.BOLD, 16);

    /**
     * Constructor of SumItUp class.
     */
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
    }

    /**
     * Add image to panel.
     *
     * @param img_num the number of images(rabbit) to be added
     * @param panel   which panel to add images
     */
    private void addImageToPanel(int img_num, JPanel panel) {
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

    /**
     * Add info label to frame.
     *
     * @param primary_info_text the text to be displayed on the top of the frame
     */
    public void addInfoLabel(String primary_info_text) {
        info = new JLabel(primary_info_text);
        info.setHorizontalAlignment(JLabel.CENTER);
        frame.add(info, BorderLayout.NORTH);
    }

    /**
     * Modify the text of info label.
     *
     * @param info_text the text to be modified
     */
    private void modifyInfoLabel(String info_text) {
        info.setText(info_text);
    }

    /**
     * Add plus image to the center of the frame.
     */
    public void addCenterImage() {
        JLabel label_plus = new JLabel(img_plus_icon);
        frame.add(label_plus, BorderLayout.CENTER);
    }

    /**
     * Add bottom panel to the frame, which contains three text fields and a button.
     */
    public void addBottomPanel() {
        input_1 = new JComboBox<>();
        input_2 = new JComboBox<>();
        input_3 = new JComboBox<>();
        input_1.addItem("");
        input_2.addItem("");
        input_3.addItem("");
        for (int i = 1; i <= 10; i++) {
            input_1.addItem(String.valueOf(i));
            input_2.addItem(String.valueOf(i));
            input_3.addItem(String.valueOf(i));
        }
        for (int i = 11; i <=20 ; i++) {
            input_3.addItem(String.valueOf(i));
        }
        JButton button = new JButton("Check!");
        input_1.setMaximumSize(new Dimension(50, 30));
        input_2.setMaximumSize(new Dimension(50, 30));
        input_3.setMaximumSize(new Dimension(50, 30));
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

    /**
     * The method to start a new game.
     */
    public void newGame() {
        num_1 = frame.randomInt(1, 10);
        num_2 = frame.randomInt(1, 10);
        frame.addImageToPanel(num_1, frame.panel_left);
        frame.addImageToPanel(num_2, frame.panel_right);
    }

    /**
     * Generate a random integer between min and max.
     *
     * @param min the minimum of the random integer
     * @param max the maximum of the random integer
     * @return a random integer between min and max
     */
    private int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Judge the accuracy of the result.
     *
     * @param num_1 the number of images(rabbit) on the left(random)
     * @param num_2 the number of images(rabbit) on the right(random)
     */
    private void judgeResult(int num_1, int num_2) {
        int valid_result = num_1 + num_2;
        String input1Text = Objects.requireNonNull(input_1.getSelectedItem()).toString();
        String input2Text = Objects.requireNonNull(input_2.getSelectedItem()).toString();
        String input3Text = Objects.requireNonNull(input_3.getSelectedItem()).toString();

        if (input1Text.equals("") || input2Text.equals("") || input3Text.equals("")) {
        } else {
            if (input1Text.equals(String.valueOf(num_1)) && input2Text.equals(String.valueOf(num_2)) && input3Text.equals(String.valueOf(valid_result))) {
                modifyInfoLabel("Correct! Have another go?");
                // clear the choice of the three combo boxes
                input_1.setSelectedIndex(0);
                input_2.setSelectedIndex(0);
                input_3.setSelectedIndex(0);

                frame.newGame();
            } else {
                modifyInfoLabel("Wrong! Try again!");
            }
        }
    }

    /**
     * The main method to start the game.
     *
     * @param args the arguments, which is not used
     */
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
