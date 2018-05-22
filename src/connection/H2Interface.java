package connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;


public interface H2Interface {

	Reiziger save(Reiziger rs) throws SQLException;

	boolean update(Reiziger rs) throws SQLException;

	boolean delete(Reiziger rs) throws SQLException;

}
