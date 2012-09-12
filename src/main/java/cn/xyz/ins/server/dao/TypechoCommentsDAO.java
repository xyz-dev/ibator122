package cn.xyz.ins.server.dao;

import cn.xyz.ins.server.model.TypechoComments;
import cn.xyz.ins.server.model.TypechoCommentsCriteria;
import java.util.List;

public interface TypechoCommentsDAO {
    int countByExample(TypechoCommentsCriteria example);

    int deleteByExample(TypechoCommentsCriteria example);

    int deleteByPrimaryKey(Integer coid);

    void insert(TypechoComments record);

    void insertSelective(TypechoComments record);

    List<TypechoComments> selectByExampleWithBLOBs(TypechoCommentsCriteria example);

    List<TypechoComments> selectByExampleWithoutBLOBs(TypechoCommentsCriteria example);

    TypechoComments selectByPrimaryKey(Integer coid);

    int updateByExampleSelective(TypechoComments record, TypechoCommentsCriteria example);

    int updateByExampleWithBLOBs(TypechoComments record, TypechoCommentsCriteria example);

    int updateByExampleWithoutBLOBs(TypechoComments record, TypechoCommentsCriteria example);

    int updateByPrimaryKeySelective(TypechoComments record);

    int updateByPrimaryKeyWithBLOBs(TypechoComments record);

    int updateByPrimaryKeyWithoutBLOBs(TypechoComments record);
}