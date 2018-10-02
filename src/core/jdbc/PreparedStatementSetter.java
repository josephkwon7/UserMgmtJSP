package core.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
    abstract void setParameters(PreparedStatement pstmt) throws SQLException;
}
