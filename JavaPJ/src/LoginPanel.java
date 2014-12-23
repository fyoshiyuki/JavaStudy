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
	private JLabel UserID_Label = new JLabel("ユーザーＩＤ");
	private JLabel UserPW_Label = new JLabel("ユーザーＰＷ");
	private JTextField UserID_Text = new JTextField();
	private JPasswordField UserPW_PText = new JPasswordField();
	private JButton Login_Button = new JButton("ログイン");

	public LoginPanel(Main mainFrame){
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 400, 400);
		this.setBackground(Color.orange);
		this.setLayout(null);

		//ユーザーIDラベル設定
		this.add(UserID_Label);
		UserID_Label.setBounds(30, 80, 100, 20);

		//ユーザーPWラベル設定
		this.add(UserPW_Label);
		UserPW_Label.setBounds(30, 160, 100, 20);

		//ユーザーIDテキスト設定
		this.add(UserID_Text);
		UserID_Text.setBounds(130,80,150,30);

		//ユーザーPWテキスト設定
		this.add(UserPW_PText);
		UserPW_PText.setEchoChar('*');
		UserPW_PText.setBounds(130,160,150,30);

		//ログインボタンの設定
		this.add(Login_Button);
		Login_Button.setSize(new Dimension(100,30));
		Login_Button.setLocation(30, 230);

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

			this.userID = QuerryList.LoginQuerry(UserID_Text.getText(), password);
			System.out.println("取得ユーザー: " + this.userID);
			//ユーザーが取得できないときの処理
			if(this.userID != null){
				clearAll();
				mainFrame.panelChange(this, mainFrame.panelName[1]);
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
