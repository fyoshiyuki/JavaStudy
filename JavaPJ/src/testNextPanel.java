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
	private JLabel titleLabel = new JLabel("画面遷移テスト");
	private JButton returnBtn = new JButton("戻る");
	private JLabel loginUserIDLabel = new JLabel();
	private JLabel loginUserNameLabel = new JLabel();

	public testNextPanel(Main mainFrame){
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 700, 400);
		this.setBackground(Color.BLUE);
		this.setLayout(null);

		this.add(titleLabel);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(20, 50, 100, 30);

		this.add(loginUserIDLabel);
		loginUserIDLabel.setForeground(Color.WHITE);
		loginUserIDLabel.setBounds(400, 60, 200, 30);

		this.add(loginUserNameLabel);
		loginUserNameLabel.setForeground(Color.WHITE);
		loginUserNameLabel.setBounds(400, 100, 200, 30);

		this.add(returnBtn);
		returnBtn.setSize(new Dimension(70, 20));
		returnBtn.setLocation(500,20);
		returnBtn.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getSource() == returnBtn){
			System.out.println("* 戻るボタン処理 *");
			mainFrame.panelChange(this, mainFrame.panelName[0], null);
		}
	}

	//ログインユーザー名をラベルに設定します。
	public void setUserLabel(LoginUser loginUser){
		loginUserIDLabel.setText("ログインユーザーID：" + loginUser.getUserID());
		loginUserNameLabel.setText("ログインユーザー名：" + loginUser.getUserName());
	}
}
