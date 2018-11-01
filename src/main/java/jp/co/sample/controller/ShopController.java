package jp.co.sample.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Shop;
import jp.co.sample.form.ShopForm;
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

	@ModelAttribute
	public ShopForm setUpForm() {
		return new ShopForm();
	}

	/**
	 * 処理の起点となるメソッド.
	 * 
	 * shopsテーブル内の色や性別を選択させる検索画面を表示.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");
		model.addAttribute("genderMap", genderMap);

		// リストにすると順番をそのまま、かつjspでLIstから取り出すだけでOK
		// 選択肢名はタグの外にかく。
		Map<String, String> colorMap = new LinkedHashMap<>();
		colorMap.put("赤", "赤");
		colorMap.put("青", "青");
		colorMap.put("黄", "黄");
		colorMap.put("白", "白");
		model.addAttribute("colorMap", colorMap);

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
	public String showSelectClothes(ShopForm shopForm, Model model) {
//		Shop shop = new Shop();
//		BeanUtils.copyProperties(form, shop);
//
//		List<Integer> genderList = new ArrayList<>();
//		for (Integer gender : form.getGenderList()) {
//			switch (gender) {
//			case 0:
//				genderList.add(0);
//				break;
//
//			case 1:
//				genderList.add(1);
//				break;
//			}
//
//		}

		List<Shop> shopList = service.findByGenderAndColor(shopForm.getGender(), shopForm.getColor());
		model.addAttribute("shopList", shopList);
		//すでにインスタンス化されているので、インスタンス化不要。
//		ShopController controller = new ShopController();

		return index(model);
	}

//	@RequestMapping("/searchClothes")
//	public String showSelectClothes(Integer gender, String color, Model model) {
//		List<Shop> shopList = service.findBySelect(gender, color);
//		model.addAttribute("shopList", shopList);
//		
//		return "/shop/searchClothes";
//	}

}
