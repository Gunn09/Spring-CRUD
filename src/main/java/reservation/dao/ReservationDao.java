package reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import reservation.model.City;
import reservation.model.Reservation;

public class ReservationDao {

	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// Delete by ID
	public int delete(Long id) {
		String sql = "DELETE FROM reservation WHERE id=" +id+"";
		return template.update(sql);
	}
	
	// Update Res 
	public int update(Reservation res) {
		//String sql = "UPDATE reservation SET name'"+res.getName()+"', gender='"+res.getGender()+"', city_id="+res.getCity_id()+" WHERE id="+res.getId()+"";
		
		String sql0 = "UPDATE reservation SET name='"+ res.getName()+"', gender= '"+res.getGender()+"', city_id="+res.getCity_id()+" WHERE id="+res.getId()+"";
		return template.update(sql0);
	}

	// Get Res by Id 
	public Reservation getResById(Long id) {
		String sql ="SELECT * FROM reservation WHERE id=?";
		
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Reservation>(Reservation.class));
		
	}
	
	// Get City List
	public List<City> getCity() {

		return template.query("SELECT * FROM city", new RowMapper<City>() {

			public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub

				City c = new City();
				c.setId(rs.getLong(1));
				c.setName(rs.getString(2));
				return c;
			}

		});

	}

	// Insert Reservation
	public int save(Reservation res) {
		String sql = "INSERT INTO reservation(name, gender, city_id) VALUES('" + res.getName() + "', '" + res.getGender()
				+ "', " + res.getCity_id() + ")";

		return template.update(sql);
	}
	
	
	// SHOW RESERVATION LIST
	public List<Reservation> getEmployees() {

		String sql = "SELECT r.*, c.id AS cityId, c.name AS cityName FROM reservation r LEFT JOIN city c ON r.city_id=c.id";
		return template.query(sql, new RowMapper<Reservation>() {

			public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub

				Reservation res = new Reservation();
				res.setId(rs.getLong(1));
				res.setName(rs.getString(2));
				res.setGender(rs.getString(3));
				res.setCity_id(rs.getLong(4));
				res.setCityID(rs.getLong(5));
				res.setCity(rs.getString(6));

				return res;
			}

		});
	}

}
