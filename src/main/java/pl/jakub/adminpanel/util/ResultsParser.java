package pl.jakub.adminpanel.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultsParser<U> {

    U parse(ResultSet resultSet) throws SQLException;

}
