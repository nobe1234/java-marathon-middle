package jp.co.sample.form;

/**
 * プロ野球チームの情報をリクエストパラメータとして受け取るフォーム.
 * 
 * @author soheinobe
 *
 */
public class BaseballTeam {

	/** 主キー */
	private Integer id;
	/** リーグ名 */
	private String leagueName;
	/** チーム名 */
	private String teamName;
	/** 本拠地 */
	private String headquarters;
	/** 設立日 */
	private String inauguration;
	/** 経歴 */
	private String history;

	@Override
	public String toString() {
		return "BaseballTeamForm [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName
				+ ", headquarters=" + headquarters + ", inauguration=" + inauguration + ", history=" + history + "]";

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public String getInauguration() {
		return inauguration;
	}

	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
}