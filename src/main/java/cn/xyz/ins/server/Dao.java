package cn.xyz.ins.server;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T, C> {
	int countByExample(C example) throws SQLException;

	int deleteByExample(C example) throws SQLException;

	int deleteByPrimaryKey(T key) throws SQLException;

	void insert(T record) throws SQLException;

	void insertSelective(T record) throws SQLException;

	List<T> selectByExampleWithBLOBs(C example) throws SQLException;

	List<T> selectByExampleWithoutBLOBs(C example) throws SQLException;

	T selectByPrimaryKey(T record) throws SQLException;

	int updateByExampleSelective(T record, C example) throws SQLException;

	int updateByExampleWithBLOBs(T record, C example) throws SQLException;

	int updateByExampleWithoutBLOBs(T record, C example) throws SQLException;

	int updateByPrimaryKeySelective(T record) throws SQLException;

	int updateByPrimaryKeyWithBLOBs(T record) throws SQLException;

	int updateByPrimaryKeyWithoutBLOBs(T record) throws SQLException;
}