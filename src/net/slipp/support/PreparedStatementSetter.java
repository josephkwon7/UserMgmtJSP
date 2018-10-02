package net.slipp.support;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementSetter {
    abstract void setParameters(PreparedStatement pstmt) throws SQLException;

}
