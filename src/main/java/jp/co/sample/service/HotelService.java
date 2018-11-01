package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.form.HotelForm;
import jp.co.sample.repository.HotelRepository;

/**
 * ホテルの検索メソッドを呼び出して返すクラス.
 * 
 * トランザクション処理も行う.
 * 
 * @author sohei.nobe
 *
 */
@Service
@Transactional
public class HotelService {

	/** リポジトリを注入. */
	@Autowired
	private HotelRepository repository;
	
	/**
	 * リポジトリに価格検索メソッドを返すメソッド.
	 * 
	 * @return　価格検索メソッド.
	 */
	public List<HotelForm> findByLowPrice(Integer price){
		return repository.findByLowPrice(price);
	}

}
