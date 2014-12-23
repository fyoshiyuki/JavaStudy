/**
 * LoginUserクラスは現在ログインしている人の情報を保持用
 * @author admin
 */
public class LoginUser {
	private static String UserID = null;
	private static String UserName = null;

	//セッターとゲッター
	public void setUserID(String userID){
		this.UserID = userID;
	}
	public String getUserID(){
		return this.UserID;
	}
	public void setUserName(String userName){
		this.UserName = userName;
	}
	public String getUserName(){
		return this.UserName;
	}
}
