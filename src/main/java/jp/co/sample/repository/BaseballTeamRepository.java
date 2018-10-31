package jp.co.sample.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.form.BaseballTeamForm;

@Repository
public class BaseballTeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<BaseballTeamForm> BASEBALLTEAMFORM_ROW_MAPPER = (rs, i) -> {

		BaseballTeamForm baseballTeamForm = new BaseballTeamForm();
		baseballTeamForm.setId(rs.getInt("id"));
		baseballTeamForm.setLeagueName(rs.getString("league_name"));
		baseballTeamForm.setTeamName(rs.getString("team_name"));
		baseballTeamForm.setHeadquarters(rs.getString("headquarters"));
		baseballTeamForm.setInauguration(rs.getString("inauguration"));
		baseballTeamForm.setHistory(rs.getString("history"));

		return baseballTeamForm;
	};

	//クリックされたチームのリンク先にチームの情報を表示させるため。
	public BaseballTeamForm load(Integer id) {
	String sql = "select id,league_name,team_name,headquarters,inauguration,history from baseball_teams where id = :id";
	SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
	BaseballTeamForm baseballTeamForm = template.queryForObject(sql, param, BASEBALLTEAMFORM_ROW_MAPPER);	
		return baseballTeamForm;
	}

	//チーム一覧を表示
	
	public List<BaseballTeamForm> findAll() {
		String sql = "select id,league_name,team_name,headquarters,inauguration,history from baseball_teams order by id";
		List<BaseballTeamForm> teamList = template.query(sql, BASEBALLTEAMFORM_ROW_MAPPER);		
		return teamList;
	}
}
