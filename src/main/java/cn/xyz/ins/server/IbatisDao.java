package cn.xyz.ins.server;
//
//import java.lang.reflect.Field;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.ibatis.sqlmap.client.SqlMapClient;
//
//public class IbatisDao<T, C> implements Dao<T, C>{
//
//	@Autowired
//    private SqlMapClient sqlMapClient;
//
//	@Autowired
//    public IbatisDao(SqlMapClient sqlMapClient) {
//        this.sqlMapClient = sqlMapClient;
//    }
//
//    public int countByExample(C example) throws SQLException {
//        Integer count = (Integer)  sqlMapClient.queryForObject(getActurlClass() + ".ibatorgenerated_countByExample", example);
//        return count;
//    }
//
//    public int deleteByExample(C example) throws SQLException {
//        int rows = sqlMapClient.delete(getActurlClass() + ".ibatorgenerated_deleteByExample", example);
//        return rows;
//    }
//
//    public int deleteByPrimaryKey(T key) throws SQLException {
//        int rows = sqlMapClient.delete(getActurlClass() + ".ibatorgenerated_deleteByPrimaryKey", key);
//        return rows;
//    }
//
//    public void insert(T record) throws SQLException {
//        sqlMapClient.insert(getActurlClass() + ".ibatorgenerated_insert", record);
//    }
//
//    public void insertSelective(T record) throws SQLException {
//        sqlMapClient.insert(getActurlClass() + ".ibatorgenerated_insertSelective", record);
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<T> selectByExampleWithBLOBs(C example) throws SQLException {
//        List<T> list = sqlMapClient.queryForList(getActurlClass() + ".ibatorgenerated_selectByExampleWithBLOBs", example);
//        return list;
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<T> selectByExampleWithoutBLOBs(C example) throws SQLException {
//        List<T> list = sqlMapClient.queryForList(getActurlClass() + ".ibatorgenerated_selectByExample", example);
//        return list;
//    }
//
//    @SuppressWarnings("unchecked")
//	public T selectByPrimaryKey(T key) throws SQLException {
//        T record = (T) sqlMapClient.queryForObject(getActurlClass() + ".ibatorgenerated_selectByPrimaryKey", key);
//        return record;
//    }
//
//    public int updateByExampleSelective(T record, C example) throws SQLException {
//        UpdateByExampleParms<T, C> parms = new UpdateByExampleParms<T, C>(record, example);
//        int rows = sqlMapClient.update(getActurlClass() + ".ibatorgenerated_updateByExampleSelective", parms);
//        return rows;
//    }
//
//    public int updateByExampleWithBLOBs(T record, C example) throws SQLException {
//        UpdateByExampleParms<T, C> parms = new UpdateByExampleParms<T, C>(record, example);
//        int rows = sqlMapClient.update(getActurlClass() + ".ibatorgenerated_updateByExampleWithBLOBs", parms);
//        return rows;
//    }
//
//    public int updateByExampleWithoutBLOBs(T record, C example) throws SQLException {
//        UpdateByExampleParms<T, C> parms = new UpdateByExampleParms<T, C>(record, example);
//        int rows = sqlMapClient.update(getActurlClass() + ".ibatorgenerated_updateByExample", parms);
//        return rows;
//    }
//
//    public int updateByPrimaryKeySelective(T record) throws SQLException {
//        int rows = sqlMapClient.update(getActurlClass() + ".ibatorgenerated_updateByPrimaryKeySelective", record);
//        return rows;
//    }
//
//    public int updateByPrimaryKeyWithBLOBs(T record) throws SQLException {
//        int rows = sqlMapClient.update(getActurlClass() + ".ibatorgenerated_updateByPrimaryKeyWithBLOBs", record);
//        return rows;
//    }
//
//    public int updateByPrimaryKeyWithoutBLOBs(T record) throws SQLException {
//        int rows = sqlMapClient.update(getActurlClass() + ".ibatorgenerated_updateByPrimaryKey", record);
//        return rows;
//    }
//
//	private String getActurlClass() {
////		Class<?> entityClass = Utils.getEntityClass(this.getClass());
////		return Utils.addUnderscores(entityClass.getSimpleName());
//		return null;
//	}
//
//    private static class UpdateByExampleParms<T, C> {
//        private T record;
//        private C example;
//
//        public UpdateByExampleParms(T record, C example) {
//            this.example = example;
//            this.record = record;
//        }
//
//        @SuppressWarnings("unused")
//		public T getRecord() {
//            return record;
//        }
//
//        @SuppressWarnings("unused")
//		public List<?> getOredCriteria() {
//        	try {
//				Field oredCriteria = example.getClass().getField("oredCriteria");
//				oredCriteria.setAccessible(true);
//				return (List<?>) oredCriteria.get(example);
//			} catch (SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalArgumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchFieldException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        	ArrayList<Criteria> list = new ArrayList<Criteria>();
//        	Criteria criteria = new Criteria();
//        	criteria.addCriterion(" 1 = 2 ");
//        	list.add(criteria);
//        	return list;
//        }
//        
//        @SuppressWarnings("unused")
//        public static class Criteria {
//            protected List<String> criteriaWithoutValue;
//
//            protected List<Map<String, Object>> criteriaWithSingleValue;
//
//            protected List<Map<String, Object>> criteriaWithListValue;
//
//            protected List<Map<String, Object>> criteriaWithBetweenValue;
//
//            protected Criteria() {
//                super();
//                criteriaWithoutValue = new ArrayList<String>();
//                criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
//                criteriaWithListValue = new ArrayList<Map<String, Object>>();
//                criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
//            }
//
//			public boolean isValid() {
//                return criteriaWithoutValue.size() > 0
//                    || criteriaWithSingleValue.size() > 0
//                    || criteriaWithListValue.size() > 0
//                    || criteriaWithBetweenValue.size() > 0;
//            }
//
//            public List<String> getCriteriaWithoutValue() {
//                return criteriaWithoutValue;
//            }
//
//            public List<Map<String, Object>> getCriteriaWithSingleValue() {
//                return criteriaWithSingleValue;
//            }
//
//            public List<Map<String, Object>> getCriteriaWithListValue() {
//                return criteriaWithListValue;
//            }
//
//            public List<Map<String, Object>> getCriteriaWithBetweenValue() {
//                return criteriaWithBetweenValue;
//            }
//            
//            public void addCriterion(String condition) {
//                if (condition == null) {
//                    throw new RuntimeException("Value for condition cannot be null");
//                }
//                criteriaWithoutValue.add(condition);
//            }
//        }
//
//    }
//
//
//}