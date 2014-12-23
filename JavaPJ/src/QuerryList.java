import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * QuerryListクラスは当アプリケーションで使用するSQL文の一覧を表示し、
 * MySQL_DBクラスにSQLを送信しています。
 * 送信した結果を戻り値とする。
 * @author onuki
 * @version 1.0
 */
public class QuerryList {
	public static String LoginQuerry(String UserID, String UserPW){
		//ログインIDと取得件数を取得するSQL文
		String sql = "select * from user_masta where user_id = '"+ UserID +"' and user_pw = '"+ UserPW +"'";
		MySQL_DB db = new MySQL_DB();
		return db.executeSQL(sql);
	}
	public static LoginUser LoginQuerry2(String UserID, String UserPW, String command){
		//ログインIDと取得件数を取得するSQL文
		String sql = "select * from user_masta where user_id = '"+ UserID +"' and user_pw = '"+ UserPW +"'";
		MySQL_DB db = new MySQL_DB();
		return db.executeSQL(sql, command);
	}
}
