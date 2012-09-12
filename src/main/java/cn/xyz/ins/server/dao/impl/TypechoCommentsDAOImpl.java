package cn.xyz.ins.server.dao.impl;

import cn.xyz.ins.server.dao.TypechoCommentsDAO;
import cn.xyz.ins.server.model.TypechoComments;
import cn.xyz.ins.server.model.TypechoCommentsCriteria;
import com.ibatis.sqlmap.client.SqlMapClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class TypechoCommentsDAOImpl extends SqlMapClientDaoSupport implements TypechoCommentsDAO {

    @Autowired
    public TypechoCommentsDAOImpl(SqlMapClient sqlMapClient) {
        super();
        super.setSqlMapClient(sqlMapClient);
    }

    public int countByExample(TypechoCommentsCriteria example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("typecho_comments.countByCriteria", example);
        return count;
    }

    public int deleteByExample(TypechoCommentsCriteria example) {
        int rows = getSqlMapClientTemplate().delete("typecho_comments.deleteByCriteria", example);
        return rows;
    }

    public int deleteByPrimaryKey(Integer coid) {
        TypechoComments _key = new TypechoComments();
        _key.setCoid(coid);
        int rows = getSqlMapClientTemplate().delete("typecho_comments.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(TypechoComments record) {
        getSqlMapClientTemplate().insert("typecho_comments.insert", record);
    }

    public void insertSelective(TypechoComments record) {
        getSqlMapClientTemplate().insert("typecho_comments.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<TypechoComments> selectByExampleWithBLOBs(TypechoCommentsCriteria example) {
        List<TypechoComments> list = getSqlMapClientTemplate().queryForList("typecho_comments.selectByCriteriaWithBLOBs", example);
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<TypechoComments> selectByExampleWithoutBLOBs(TypechoCommentsCriteria example) {
        List<TypechoComments> list = getSqlMapClientTemplate().queryForList("typecho_comments.selectByCriteria", example);
        return list;
    }

    public TypechoComments selectByPrimaryKey(Integer coid) {
        TypechoComments _key = new TypechoComments();
        _key.setCoid(coid);
        TypechoComments record = (TypechoComments) getSqlMapClientTemplate().queryForObject("typecho_comments.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(TypechoComments record, TypechoCommentsCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("typecho_comments.updateByCriteriaSelective", parms);
        return rows;
    }

    public int updateByExampleWithBLOBs(TypechoComments record, TypechoCommentsCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("typecho_comments.updateByCriteriaWithBLOBs", parms);
        return rows;
    }

    public int updateByExampleWithoutBLOBs(TypechoComments record, TypechoCommentsCriteria example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("typecho_comments.updateByCriteria", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(TypechoComments record) {
        int rows = getSqlMapClientTemplate().update("typecho_comments.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKeyWithBLOBs(TypechoComments record) {
        int rows = getSqlMapClientTemplate().update("typecho_comments.updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    public int updateByPrimaryKeyWithoutBLOBs(TypechoComments record) {
        int rows = getSqlMapClientTemplate().update("typecho_comments.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends TypechoCommentsCriteria {
        private Object record;

        public UpdateByExampleParms(Object record, TypechoCommentsCriteria example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}