package jp.co.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.sample.form.HotelForm;

/**
 *ホテル検索ページに使うリポジトリ.
 * 
 * 入力した価格以下のホテルテーブルリストを表示する.
 * 
 * @author soheinobe
 *
 */
@Repository
public class HotelRepository {

	/**
	 * JDBCのメソッド含んだテンプレートを注入.
	 */
	@Autowired
	private NamedParameterJdbcTemplate template;

	/** 結果の操作を定義 */
	private static final RowMapper<HotelForm> HOTELFORM_ROW_MAPPER = (rs, i) -> {
		HotelForm hotelForm = new HotelForm();
		hotelForm.setId(rs.getInt("id"));
		hotelForm.setAreaName(rs.getString("area_name"));
		hotelForm.setHotelName(rs.getString("hotel_name"));
		hotelForm.setAddress(rs.getString("address"));
		hotelForm.setNearestStation(rs.getString("nearest_station"));
		hotelForm.setPrice(rs.getInt("price"));
		hotelForm.setParking(rs.getString("parking"));

		return hotelForm;
	};
	
	

}
