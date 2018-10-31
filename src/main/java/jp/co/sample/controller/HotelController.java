package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.HotelForm;
import jp.co.sample.service.HotelService;

/**
 * 入力フォームに任意の料金を入れるとそこ料金以下のホテルの情報を表示してくれるクラス.
 * 
 * ホテル名,最寄り駅,価格を同ページ内に表示.
 * 
 * @author sohei.nobe
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

//	/** セッションスコープを注入 */
//	@Autowired
//	private HttpSession session;
	
	/** サービスクラスを注入 */
	@Autowired
	private HotelService service;

	/**
	 *　任意の料金以下のホテルの情報を検索するフォームを表示するメソッド.
	 * 
	 * @return ホテル検索画面
	 */
	@RequestMapping("/index")
	public String index() {
//		List<HotelForm> hotelList = (List<HotelForm>) session.getAttribute("hotelList");
//		
//		if(hotelList == null) {
////			List<HotelForm> hotelList = new ArrayList<>(); 
//		}
		
		return "/hotel/searchByPrice";
	}

	/**
	 * 検索結果を検索項目の下に表示するメソッド.
	 * 
	 * 結果は表として表示する.
	 * 
	 * @return 参照画面を表示　２重対策のリダイレクトは不要.
	 */
	@RequestMapping("/searchHotel")
	public String showLowerPriceHotel(HotelForm form,Model model) {
		List<HotelForm> hotelList = service.findByLowPrice(form.getPrice());
		model.addAttribute("hotelList", hotelList);		
		return "/hotel/searchByPrice";
	}
}
