package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HeaderComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2437837492716341216L;
	
	private JLabel header ;
	private String msg;
	
	public HeaderComponent(String msg) {
		super();
		header = new JLabel(msg);
		this.setBackground(Color.black);
//		header.setHorizontalAlignment(JLabel.CENTER);
//		header.setVerticalAlignment(JLabel.CENTER);
//		header.se
		this.add(header);
	}



	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2  = (Graphics2D) g;
        this.setBackground(Color.black);
        header.setText("welcome");
        header.repaint();
//        label.setText(this.getText());
//        label.setFont(new Font("Serif", Font.PLAIN, 7));
//        label.setVerticalAlignment(SwingConstants.CENTER);
//        label.setHorizontalAlignment(SwingConstants.CENTER);
    }



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
