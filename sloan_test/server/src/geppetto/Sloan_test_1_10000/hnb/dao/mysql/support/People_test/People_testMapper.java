package geppetto.Sloan_test_1_10000.hnb.dao.mysql.support.People_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import geppetto.Sloan_test_1_10000.hnb.domain.core.People_test;


/**
 * 
 * @author Geppetto Generated Code</br>
 * Date Created: </br>
 * @since  </br>
 * build:   </p> 
 *
 * code was generated by the Geppetto System </br>
 * Gepppetto system Copyright - Geppetto LLC </br>
 * The generated code is free to use by anyone</p>
 *
 *
 *
*/
public class People_testMapper implements RowMapper <People_test> {


	@Override
	public  People_test mapRow(ResultSet rs, int rowNum) throws SQLException {

		People_test the_People_test = new People_test();
		the_People_test.set_First_name(rs.getString("First_name"));
		the_People_test.set_Last_name(rs.getString("Last_name"));
		the_People_test.set_Organization_id(rs.getLong("Organization_id"));
		the_People_test.set_Id(rs.getLong("Id"));

		return the_People_test;


	}


}