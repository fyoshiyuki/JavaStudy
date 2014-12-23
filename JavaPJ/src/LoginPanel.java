import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

/**
 * LoginPanelクラスはログイン画面に表示するパネルを作成します。
 * @author onuki
 * @version 1.0
 */
public class LoginPanel extends JPanel implements ActionListener {
	private Main mainFrame = null;
	private String userID = null;
	private JLabel messageLabel_1 = new JLabel("ユーザーIDとユーザーPWを入力して下さい。入力後、「ログイン」ボタンを押してください。");
	private JLabel messageLabel_2 = new JLabel("※ユーザーIDまたはユーザーPWがわからない場合、管理者へお問い合わせください。");
	private JLabel UserID_Label = new JLabel("ユーザーＩＤ");
	private JLabel UserPW_Label = new JLabel("ユーザーＰＷ");
	private JTextField UserID_Text = new JTextField();
	private JPasswordField UserPW_PText = new JPasswordField();
	private JButton Login_Button = new JButton("ログイン");

	public LoginPanel(Main mainFrame){
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 700, 400);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);

		//メッセージラベル1設定
		this.add(messageLabel_1);
		messageLabel_1.setBounds(30, 50, 800, 20);

		//メッセージラベル2設定
		this.add(messageLabel_2);
		messageLabel_2.setBounds(30, 80, 800, 20);

		//ユーザーIDラベル設定
		this.add(UserID_Label);
		UserID_Label.setBounds(30, 150, 100, 20);

		//ユーザーPWラベル設定
		this.add(UserPW_Label);
		UserPW_Label.setBounds(30, 200, 100, 20);

		//ユーザーIDテキスト設定
		this.add(UserID_Text);
		UserID_Text.setBounds(130,150,200,30);

		//ユーザーPWテキスト設定
		this.add(UserPW_PText);
		UserPW_PText.setEchoChar('*');
		UserPW_PText.setBounds(130,200,200,30);

		//ログインボタンの設定
		this.add(Login_Button);
		Login_Button.setSize(new Dimension(100,30));
		Login_Button.setLocation(230, 280);

		//対象コンポーネントのイベント設定
		Login_Button.addActionListener(this);
		Login_Button.setActionCommand("pushLoginBtn");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//ログインボタン押下時の処理
		if(e.getActionCommand().equals("pushLoginBtn")){
			StringBuilder sb_UserPW = new StringBuilder();
			for(char data : UserPW_PText.getPassword()){
				sb_UserPW.append(data);
			}
			String password = sb_UserPW.toString();

			System.out.println("UserID : " + UserID_Text.getText());
			System.out.println("UserPW : " + password);

//			this.userID = QuerryList.LoginQuerry(UserID_Text.getText(), password);
//			System.out.println("取得ユーザー: " + this.userID);

			LoginUser loginUser = QuerryList.LoginQuerry2(UserID_Text.getText(), password, "pushLoginBtn");
//			if(this.userID != null){
			System.out.println("loginUser : " + loginUser);
			if(loginUser != null){
				System.out.println("loginUser-ID : " + loginUser.getUserID());
				System.out.println("loginUser-Name : " + loginUser.getUserName());
				//ログインユーザーをセット
				clearAll();
				mainFrame.panelChange(this, mainFrame.panelName[1], loginUser);
			}
			else{
				JOptionPane.showMessageDialog(null, "ログインできませんでした。再度入力してください", "ログイン不可", JOptionPane.YES_OPTION);
				this.clearPW();
			}
		}
	}
	public void clearPW(){
		UserPW_PText.setText(null);
	}
	public void clearAll(){
		UserID_Text.setText(null);
		clearPW();
	}
}
