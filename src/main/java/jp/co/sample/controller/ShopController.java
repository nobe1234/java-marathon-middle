package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Shop;
import jp.co.sample.service.ShopService;

/**
 * 色と性別で検索可能な洋服ショップのサイト表示クラス.
 * 
 * 受け取るリクエストパラメータはラジオボタンで選択された性別とプルダウン色.
 * 
 * @author soheinobe
 *
 */
@Controller
@Transactional
@RequestMapping("/shop")
public class ShopController {

	/** サービスを注入 */
	@Autowired
	private ShopService service;

	/**
	 * 処理の起点となるメソッド.
	 * 
	 * shopsテーブル内の色や性別を選択させる検索画面を表示.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("/index")
	public String index() {
		return "/shop/searchClothes";
	}

	/**
	 * 検索結果を表示するメソッド.
	 * 
	 * 選択された条件に合う服の情報をデータベースから取り出す.
	 * 
	 * @return 検索結果
	 */
	@RequestMapping("/searchClothes")
	public String showSelectClothes(Integer gender, String color, Model model) {
		List<Shop> shopList = service.findBySelect(gender, color);
		model.addAttribute("shopList", shopList);

		return "/shop/searchClothes";
	}

}
