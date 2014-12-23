import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * testNextPanelクラスはテスト用パネルです。
 * LoginPanelとの画面遷移の為に作成しています。
 * @author onuki
 * @version 1.0
 */
public class testNextPanel extends JPanel implements java.awt.event.ActionListener{
	private Main mainFrame = null;
	private String panelName = "testNextPanel";
	private JLabel testLabel = new JLabel("画面遷移テスト");
	private JButton returnBtn = new JButton("戻る");

	public testNextPanel(Main mainFrame){
		this.mainFrame = mainFrame;
		this.setName(panelName);
		this.setBounds(0, 0, 400, 400);
		this.setBackground(Color.BLUE);
		this.setLayout(null);

		this.add(testLabel);
		testLabel.setForeground(Color.WHITE);
		testLabel.setBounds(20, 50, 100, 30);

		this.add(returnBtn);
		returnBtn.setSize(new Dimension(70, 20));
		returnBtn.setLocation(300,50);
		returnBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getSource() == returnBtn){
			System.out.println("* 戻るボタン処理 *");
			mainFrame.panelChange(this, mainFrame.panelName[0]);
		}
	}
}
