package dao;

import java.sql.SQLException;
import java.util.List;

import vo.News;

public interface NewsDao {
	List<News> selectAll() throws Exception;
	News selectByID(int id) throws Exception;
	int add(News news) throws Exception;
	int update(News news) throws SQLException, Exception;
	int delete(int id) throws Exception;
}
