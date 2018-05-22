package connection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class Statements extends Test implements H2Interface{
	public Statements() throws SQLException {
		getConnection();
	}
	
	public List<Reiziger> findbygbd(Date gb){
		ArrayList<Reiziger> lijst = new ArrayList<Reiziger>();
		Reiziger reis = null;
		
		try {
			Statement stmt = conn.createStatement();
		     PreparedStatement ps = conn.prepareStatement("select * from REIZIGER where GEBORTEDATUM = ?");
		     ps.setDate(1, gb);
		     ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reis = new Reiziger(rs.getInt("REIZIGERID"), rs.getString("VOORLETTERS"), rs.getString("TUSSENVOEGSEL"), rs.getString("ACHTERNAAM"), rs.getDate("GEBORTEDATUM"));
				lijst.add(reis);
			}
			rs.close();
			stmt.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return lijst;
	}
	
	@Override
	public Reiziger save(Reiziger rs) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into Reiziger values (?, ?, ?, ?, ?)");
        ps.setInt(1, rs.getReizigerID());
        ps.setString(2, rs.getVoorletters());
        ps.setString(3, rs.getTussenVoegsel());
        ps.setString(4, rs.getAchternaam());
        ps.setDate(5, rs.getgbd());
        int res = ps.executeUpdate();

        if (res == 0)
            return null;
        return rs;
    }
	
	@Override
	public boolean update(Reiziger rs) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update REIZIGER set values (?, ?, ?, ?) where REIZIGERID = ?");
        ps.setString(1, rs.getVoorletters());
        ps.setString(2, rs.getTussenVoegsel());
        ps.setString(3, rs.getAchternaam());
        ps.setDate(4, rs.getgbd());
        ps.setInt(5, rs.getReizigerID());
        int res = ps.executeUpdate();

        boolean ending = true;
        if (res == 0)
            ending = false;
        return ending;
    }
	
	@Override
	public boolean delete(Reiziger rs) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from REIZIGER where REIZIGERID = ?");
        ps.setInt(1, rs.getReizigerID());
        int res = ps.executeUpdate();

        boolean ending = true;
        if (res == 0)
            ending = false;
        return ending;
    }

}

