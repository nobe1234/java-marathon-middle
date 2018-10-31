package jp.co.sample.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Shop;

@Repository
public class ShopRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

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

	public List<Shop> findBySelect(){
		
		
	 return new ArrayList();
	}
	
	
}
