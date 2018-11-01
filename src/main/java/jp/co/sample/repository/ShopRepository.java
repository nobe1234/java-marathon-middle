package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Shop;

/**
 * 洋服ショップ検索サイトの検索メソッドを定義するリポジトリ.
 * 
 * 受け取るリクエストパラメータは性別,色。
 * 
 * @author soheinobe
 *
 */
@Repository
public class ShopRepository {

	/** JDBCテンプレートを注入 */
	@Autowired
	private NamedParameterJdbcTemplate template;

	/** 結果の操作を定義 */
	private static final RowMapper<Shop> SHOP_ROW_MAPPER = (rs, i) -> {
		Shop shop = new Shop();
		shop.setId(rs.getInt("id"));
		shop.setCategory(rs.getString("category"));
		shop.setGenre(rs.getString("genre"));
		shop.setGender(rs.getInt("gender"));
		shop.setColor(rs.getString("color"));
		shop.setPrice(rs.getInt("price"));
		shop.setSize(rs.getString("size"));

		return shop;
	};

	//不要　レビューが終わったらDBから選択肢を取り出す方法も考えてみる。
//	public List<Shop> findAll() {
//		String sql = "select from shops order by ";
//		
//		List<Shop> selectList;
//		return selectList;
//	}

	/**
	 * 服の色と性別で検索するメソッド.
	 * 
	 * @param 性別
	 * @param 色
	 * @return　検索結果のリスト
	 */
	public List<Shop> findByGenderAndColor(Integer gender, String color) {
		String sql = "select id,category,genre,gender,color,price,size from shops"
				+ " where gender = :gender AND color = :color";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		List<Shop> shopList = template.query(sql, param, SHOP_ROW_MAPPER);

		return shopList;
	}

}
