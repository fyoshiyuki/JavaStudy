import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MySQL_DBクラスはMySQLのDBに通信を行い、
 * DBのデータの取得を行います。
 * @author onuki
 * @version 1.0
 */
public class MySQL_DB {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	//ドライバーの有効化(１度きり)
	static{
		System.out.println("ドライバの有効化処理");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("ドライバの有効化処理-Error");
			e.printStackTrace();
		}
	}

	//インスタンス生成時の初期化処理
	public MySQL_DB(){
		System.out.println("コンストラクタ");
		dbConnect();
	}

	//データベース接続メソッド
	public void dbConnect(){
		String url = "jdbc:mysql://localhost/javastudy";
		String user = "root";
		String password = "admin";

		System.out.println("コンストラクタ-データベース接続処理");
		try {
			//接続情報
			this.conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			System.out.println("コンストラクタ-データベース接続処理-接続エラー" + e.getMessage());
			try {
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//SQL取得処理
//	public void executeSQL(String sql){
	public String executeSQL(String sql){
		String connectLoginUser = null;

		System.out.println("SQL取得処理");
		//データベース接続状態の場合に処理をする
		if(this.conn != null){
			System.out.println("SQL取得処理-DB接続状態");
			System.out.println("SQL：" + sql);
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				System.out.println("データ取得後のパラメータセット処理");

				while(this.rs.next()){
					connectLoginUser = rs.getString("user_id");
				}
				this.rs.close();
				this.pstmt.close();

			} catch (SQLException e) {
				System.out.println("SQL取得処理-エラー処理");
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return connectLoginUser;
			} finally {
				if(this.conn != null){
					System.out.println("Connectionクローズ処理");
					try {
						this.conn.close();
					} catch (SQLException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			}
		}
		return connectLoginUser;
	}
}
