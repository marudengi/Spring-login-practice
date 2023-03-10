package hello.loginpractice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PsqlRunner implements ApplicationRunner {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try(Connection connection = dataSource.getConnection()) {
			System.out.println(dataSource.getClass());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());
			
			Statement statement = connection.createStatement();
//			ResultSet sql = statement.executeQuery("SELECT * FROM u;");
			String sql = "SELECT * FROM user;";
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("id : " + rs.getString("userid") + ", name : " + rs.getString("name"));
//				System.out.println(rs.getString(0));
			}
			
			rs.close();
			statement.close();
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
