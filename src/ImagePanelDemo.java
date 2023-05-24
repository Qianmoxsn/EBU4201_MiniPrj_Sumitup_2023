import javax.swing.*;
import java.awt.*;

public class ImagePanelDemo extends JFrame {
    private JPanel leftPanel;
    private JPanel rightPanel;

    public ImagePanelDemo() {
        setTitle("Image Panel Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建左侧面板
        leftPanel = new JPanel(new GridBagLayout());
        addImagesToLeftPanel();

        // 创建右侧面板
        rightPanel = new JPanel(new GridBagLayout());
        addImagesToRightPanel();

        // 添加填充面板，使得左右两侧第一张图片高度对齐
        JPanel fillerPanel = new JPanel();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(fillerPanel, BorderLayout.CENTER);
        getContentPane().add(rightPanel, BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    private void addImagesToLeftPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        for (int i = 1; i <= 8; i++) {
            ImageIcon image = new ImageIcon("src\\img\\rabbit.jpg");
            JLabel label = new JLabel(image);
            gbc.gridx = (i - 1) % 3;
            gbc.gridy = (i - 1) / 3;
            leftPanel.add(label, gbc);
        }
    }

    private void addImagesToRightPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // 偏移右侧第一张图片的位置
        gbc.gridy = 1;

        for (int i = 1; i <= 10; i++) {
            ImageIcon image = new ImageIcon("src\\img\\rabbit.jpg");
            JLabel label = new JLabel(image);
            gbc.gridx = (i - 1) % 3;
            gbc.gridy = gbc.gridy + (i - 1) / 3;
            rightPanel.add(label, gbc);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImagePanelDemo::new);
    }
}
