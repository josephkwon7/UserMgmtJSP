package net.slipp.support;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PrepareStatementSetter {
    public abstract void setParameters(PreparedStatement pstmt) throws SQLException;

}
