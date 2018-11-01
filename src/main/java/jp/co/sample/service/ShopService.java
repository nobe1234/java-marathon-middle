package jp.co.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.domain.Shop;
import jp.co.sample.repository.ShopRepository;

/**
 * リポジトリからメソッドを受け取り、コントローラへ返すサービスクラス.
 * 
 * @author soheinobe
 *
 */
@Service
public class ShopService {

	/**
	 * リポジトリを注入.
	 */
	@Autowired
	private ShopRepository repository;

	/**
	 * 服の色と性別で検索するメソッド.
	 * 
	 * リポジトリから受け取り、コントローラへ返す.
	 *  
	 * @param gender
	 * @param color
	 * @return
	 */
	public List<Shop> findBySelect(Integer gender, String color) {
		return repository.findBySelect(gender, color);
	}

}
