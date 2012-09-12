package cn.xyz.ins.server;
//
//import java.lang.reflect.Field;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.persistence.Table;
//
//import com.ibatis.sqlmap.client.SqlMapClient;
//
//public class IbatisDAOImpl {
//    private SqlMapClient sqlMapClient;
////
////    public IbatisDAOImpl(SqlMapClient sqlMapClient) {
////        super();
////        this.sqlMapClient = sqlMapClient;
////    }
//
//    public <Criteria> int countByCriteria(Criteria criteria) throws SQLException {
//        Integer count = (Integer)  sqlMapClient.queryForObject(getSqlMapNamespace(criteria) + ".countByCriteria", criteria);
//        return count;
//    }
//
//    public <T, Criteria> int deleteByCriteria(Criteria criteria) throws SQLException {
//        int rows = sqlMapClient.delete(getSqlMapNamespace(criteria) + ".deleteByCriteria", criteria);
//        return rows;
//    }
//
//    public <T> int deleteByPrimaryKey(T record) throws SQLException {
//        int rows = sqlMapClient.delete(getSqlMapNamespace(record) + ".deleteByPrimaryKey", record);
//        return rows;
//    }
//
//    public <T> void insert(T record) throws SQLException {
//        sqlMapClient.insert(getSqlMapNamespace(record) + ".insert", record);
//    }
//
//    public <T> void insertSelective(T record) throws SQLException {
//        sqlMapClient.insert(getSqlMapNamespace(record) + ".insertSelective", record);
//    }
//
//    @SuppressWarnings("unchecked")
//    public <T, Criteria> List<T> selectByCriteriaWithBLOBs(T record, Criteria criteria) throws SQLException {
//        List<T> list = sqlMapClient.queryForList(getSqlMapNamespace(record) + ".selectByCriteriaWithBLOBs", criteria);
//        return list;
//    }
//
//    @SuppressWarnings("unchecked")
//    public <T, Criteria> List<T> selectByCriteriaWithoutBLOBs(T record, Criteria criteria) throws SQLException {
//        List<T> list = sqlMapClient.queryForList(getSqlMapNamespace(record) + ".selectByCriteria", criteria);
//        return list;
//    }
//
//    @SuppressWarnings("unchecked")
//    public <T> T selectByPrimaryKey(T _key) throws SQLException {
//        T record = (T) sqlMapClient.queryForObject(getSqlMapNamespace(_key) + ".selectByPrimaryKey", _key);
//        return record;
//    }
//
//    public <T, Criteria> int updateByCriteriaSelective(T record, Criteria criteria) throws SQLException {
//        UpdateByCriteriaParms<T, Criteria> parms = new UpdateByCriteriaParms<T, Criteria>(record, criteria);
//        int rows = sqlMapClient.update(getSqlMapNamespace(record) + ".updateByCriteriaSelective", parms);
//        return rows;
//    }
//
//    public <T, Criteria> int updateByCriteriaWithBLOBs(T record, Criteria criteria) throws SQLException {
//        UpdateByCriteriaParms<T, Criteria> parms = new UpdateByCriteriaParms<T, Criteria>(record, criteria);
//        int rows = sqlMapClient.update(getSqlMapNamespace(record) + ".updateByCriteriaWithBLOBs", parms);
//        return rows;
//    }
//
//    public <T, Criteria> int updateByCriteriaWithoutBLOBs(T record, Criteria criteria) throws SQLException {
//        UpdateByCriteriaParms<T, Criteria> parms = new UpdateByCriteriaParms<T, Criteria>(record, criteria);
//        int rows = sqlMapClient.update(getSqlMapNamespace(record) + ".updateByCriteria", parms);
//        return rows;
//    }
//
//    public <T> int updateByPrimaryKeySelective(T record) throws SQLException {
//        int rows = sqlMapClient.update(getSqlMapNamespace(record) + ".updateByPrimaryKeySelective", record);
//        return rows;
//    }
//
//    public <T> int updateByPrimaryKeyWithBLOBs(T record) throws SQLException {
//        int rows = sqlMapClient.update(getSqlMapNamespace(record) + ".updateByPrimaryKeyWithBLOBs", record);
//        return rows;
//    }
//
//    public <T> int updateByPrimaryKeyWithoutBLOBs(T record) throws SQLException {
//        int rows = sqlMapClient.update(getSqlMapNamespace(record) + ".updateByPrimaryKey", record);
//        return rows;
//    }
//
//    
//    private <T> String getSqlMapNamespace(T record) {
//    	if (record == null) {
//    		return null;
//    	}
//    	Table table = record.getClass().getAnnotation(Table.class);
//    	if (table == null) {
//    		table = record.getClass().getSuperclass().getAnnotation(Table.class);
//    	}
//    	return table.name();
//    }
//
//    private static class UpdateByCriteriaParms<T, C> {
//        private T record;
//        private C criteria;
//
//        public UpdateByCriteriaParms(T record, C criteria) {
//            this.record = record;
//            this.criteria = criteria;
//        }
//
//        @SuppressWarnings("unused")
//		public T getRecord() {
//            return record;
//        }
//
//        @SuppressWarnings("unused")
//        public String getOrderByClause() {
//        	return (String) getValue(this, "orderByClause");
//        }
//
//        @SuppressWarnings("unused")
//        public boolean isDistinct() {
//        	return (Boolean)getValue(this, "distinct");
//        }
//        
//        @SuppressWarnings("unused")
//		public List<?> getOredCriteria() {
//        	try {
//				Field oredCriteria = criteria.getClass().getField("oredCriteria");
//				oredCriteria.setAccessible(true);
//				return (List<?>) oredCriteria.get(criteria);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//        	ArrayList<Criteria> list = new ArrayList<Criteria>();
//        	Criteria criteria = new Criteria();
//        	criteria.addCriterion(" 1 = 2 ");
//        	list.add(criteria);
//        	return list;
//        }
//        
//		private final static Object getValue(Object object, String fieldname) {
//			try {
//				Field field = object.getClass().getField(fieldname);
//				field.setAccessible(true);
//				return field.get(object);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return null;
//		}
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
//}