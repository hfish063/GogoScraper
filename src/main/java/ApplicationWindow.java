import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationWindow extends JFrame {
    private JLabel animeUrlLabel;
    private JTextField animeTitleTextField;
    private JButton submit;
    private JPanel panel;

    /**
     * Create JFrame to take the title/episode, and
     * display video url to user
     */
    public void setUPApplicationWindow() {
        Parser p = new Parser();

        setTitle("GoGo Scraper");

        JLabel animeUrlLabel = new JLabel();
        JButton submit = new JButton("Submit");
        JTextField animeTitleTextField = new JTextField(16);
        JPanel panel = new JPanel();

        // take title/episode and display url
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchString = animeTitleTextField.getText();

                int endTitleIndex = searchString.indexOf(" ");

                String title = searchString.substring(0, endTitleIndex);
                String episode = searchString.substring(endTitleIndex + 1);

                animeUrlLabel.setText(p.getEpisode(title, episode));
            }
        });
        panel.add(animeUrlLabel);
        panel.add(submit);
        panel.add(animeTitleTextField);
        add(panel);

        setSize(800, 600);
        setVisible(true);
    }
}
