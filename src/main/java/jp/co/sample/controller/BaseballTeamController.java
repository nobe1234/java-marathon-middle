package jp.co.sample.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.BaseballTeam;
import jp.co.sample.form.BaseballTeamForm;
import jp.co.sample.repository.BaseballTeamRepository;

/**
 * 野球チームの情報サイトを表示するクラス.
 * 
 * @author soheinobe
 *
 */
@Controller
@Transactional
@RequestMapping("/baseballTeam")
public class BaseballTeamController {

	/** セッションを注入 */
	@Autowired
	private HttpSession session;

	/** リポジトリを注入 */
	@Autowired
	private BaseballTeamRepository repository;

	
	/**
	 * 処理の起点となるメソッド.
	 * 
	 * リポジトリより呼び出した全検検索メソッドを利用して,チームリストを表示する.
	 * 
	 * @return セ・リーグ　チーム一覧ページ表示.
	 */
	@RequestMapping("/index")
	public String index() {
		List<BaseballTeam> teamList = repository.findAll();
		session.setAttribute("teamList", teamList);
		// チーム一覧を表示
		return "baseball/viewTeamList";
	}

	/**
	 * トップページで選択されたチームの詳細情報を表示するメソッド.
	 * 
	 * 各チームのリンクより受け取ったリクエストパラメータで主キー検索を行う.
	 * 
	 * @param フォーム
	 * @param モデル
	 * @return
	 */
	@RequestMapping("/showTeamDetail")
	public String showTeamDetail(BaseballTeamForm baseballTeamForm, Model model) {
		BaseballTeam baseballTeam = repository.load(baseballTeamForm.getId());
		model.addAttribute("baseballTeam", baseballTeam);
		// チーム詳細の表示
		return "/baseball/viewTeamDetail";
	}
}
