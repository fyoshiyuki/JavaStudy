import java.awt.*;
import javax.swing.*;

/**
 * Mainクラスはウィンドウを作成します。
 * ウィンドウに載せるパネルの切替を行っています。
 * @author onuki
 * @version 1.0
 */
public class Main extends JFrame {
	/**
	 * 画面遷移対象のパネル生成
	 */
	static String[] panelName = {"LoginPanel", "textNextPanel"};
	private static String[] frameTitleName = {	"家計簿アプリケーション(ログイン画面)",
												"家計簿アプリケーション(テスト画面)"
							  				 };
	LoginPanel lp = new LoginPanel(this);
	LoginUser loginUser = null;
	testNextPanel tp = new testNextPanel(this);
	private final static String FRAME_TITLE_NAME = "家計簿アプリケーション";

	//フレームと初期パネルの設定
	public static void main(String[] args) {
		//ウィンドウの生成
		Main mainFrame = new Main();
		mainFrame.setLayout(null);
		mainFrame.setBounds(10, 10, 700, 400);
		mainFrame.setTitle(frameTitleName[0]);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}

	//初期パネル表示設定
	public Main(){
		this.add(lp); lp.setVisible(true);
		this.add(tp); tp.setVisible(false);
	}

	//パネルの切り替え
	public void panelChange(JPanel panel, String nextPanel, LoginUser loginUser){
		System.out.println("パネル切り替え処理");
		//現在のパネルを非表示にする。
		panel.setVisible(false);
		this.loginUser = loginUser;
		//遷移先のパネルを表示にする。
		if(nextPanel.equals(panelName[0])){
			this.setTitle(frameTitleName[0]);
			lp.setVisible(true);
		}
		if(nextPanel.equals(panelName[1])){
			this.setTitle(frameTitleName[1]);
			tp.setUserLabel(loginUser);
			tp.setVisible(true);
		}
	}
}
