package jp.co.sample.domain;

import java.util.List;

/**
 * ショップのデータを表すドメイン.
 * 
 * @author soheinobe
 *
 */
public class Shop {

	/** 主キー */
	private Integer id;
	/** カテゴリー */
	private String category;
	/** ジャンル */
	private String genre;
	/** 性別 */
	private Integer gender;
	/** 色 */
	private String color;
	/** 価格 */
	private Integer price;
	/** サイズ */
	private String size;
	/** 性別リスト */
	private List<Integer> genderList;
	/** 色リスト */
	private List<Integer> colorList;

	public List<Integer> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<Integer> genderList) {
		this.genderList = genderList;
	}

	public List<Integer> getColorList() {
		return colorList;
	}

	public void setColorList(List<Integer> colorList) {
		this.colorList = colorList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", category=" + category + ", genre=" + genre + ", gender=" + gender + ", color="
				+ color + ", price=" + price + ", size=" + size + ", genderList=" + genderList + ", colorList="
				+ colorList + "]";
	}

}
