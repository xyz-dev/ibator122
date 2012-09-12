package org.apache.ibatis.ibator.plugins;

import java.util.List;

import org.apache.ibatis.ibator.api.IbatorPluginAdapter;
import org.apache.ibatis.ibator.api.IntrospectedColumn;
import org.apache.ibatis.ibator.api.IntrospectedTable;
import org.apache.ibatis.ibator.api.dom.java.Field;
import org.apache.ibatis.ibator.api.dom.java.FullyQualifiedJavaType;
import org.apache.ibatis.ibator.api.dom.java.Method;
import org.apache.ibatis.ibator.api.dom.java.Parameter;
import org.apache.ibatis.ibator.api.dom.java.TopLevelClass;

/**
 * 给dao增加注解增加注解
 *
 * @author QQ:34847009
 * @date 2010-10-21 下午09:33:48
 */
public class AnnotationPlugin extends IbatorPluginAdapter {
	private FullyQualifiedJavaType repository;
	private FullyQualifiedJavaType autowired;
	private FullyQualifiedJavaType sqlMapClient;
	private FullyQualifiedJavaType activeRecord;

	private FullyQualifiedJavaType t;
	private FullyQualifiedJavaType id;
	public AnnotationPlugin() {
		super();
		autowired = new FullyQualifiedJavaType(
				"org.springframework.beans.factory.annotation.Autowired"); //$NON-NLS-1$
		repository = new FullyQualifiedJavaType(
				"org.springframework.stereotype.Repository"); //$NON-NLS-1$
		sqlMapClient = new FullyQualifiedJavaType(
				"com.ibatis.sqlmap.client.SqlMapClient"); //$NON-NLS-1$
		activeRecord =  new FullyQualifiedJavaType(
				"cn.xyz.ins.domains.ActiveRecord"); //$NON-NLS-1$
		activeRecord.addTypeArgument(new FullyQualifiedJavaType("T"));
		activeRecord.addTypeArgument(new FullyQualifiedJavaType("C"));
		id = new FullyQualifiedJavaType("javax.persistence.Id");
	}

	public boolean daoImplementationGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		Method method = topLevelClass.getMethods().get(0);
		addAnnotation(topLevelClass, method);
		method.addParameter(new Parameter(sqlMapClient, "sqlMapClient"));
		method.addBodyLine("super.setSqlMapClient(sqlMapClient);");
		return true;
	}

    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    	topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.persistence.Entity"));
    	topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.persistence.Table"));
    	topLevelClass.addAnnotation("@Entity");
    	topLevelClass.addAnnotation(String.format("@Table(name=\"%s\", schema=\"%s\")", new Object[]{introspectedTable.getFullyQualifiedTable(), introspectedTable.getTableConfiguration().getSchema()}));
    	topLevelClass.setSuperClass(activeRecord);
    	topLevelClass.addImportedType(activeRecord);
    	topLevelClass.getType().addTypeArgument(new FullyQualifiedJavaType("T"));
    	topLevelClass.getType().addTypeArgument(new FullyQualifiedJavaType("C"));
        return true;
    }
    @Override
    public boolean modelFieldGenerated(Field field,
    		TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
    		IntrospectedTable introspectedTable, ModelClassType modelClassType) {
    	topLevelClass.addImportedType(id);
    	List<IntrospectedColumn> list = introspectedTable.getPrimaryKeyColumns();
		if (list.contains(introspectedColumn)) {
			field.addAnnotation("@Id");
		}
    	return super.modelFieldGenerated(field, topLevelClass, introspectedColumn,
    			introspectedTable, modelClassType);
    }
    
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
    		IntrospectedTable introspectedTable) {
    	topLevelClass.addImportedType(new FullyQualifiedJavaType("javax.persistence.Table"));
    	topLevelClass.addAnnotation(String.format("@Table(name=\"%s\", schema=\"%s\")", new Object[]{introspectedTable.getFullyQualifiedTable(), introspectedTable.getTableConfiguration().getSchema()}));
    	return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

	/**
	 * 添加注解
	 *
	 * @param topLevelClass
	 * @param method
	 */
	protected void addAnnotation(TopLevelClass topLevelClass, Method method) {
		topLevelClass.addImportedType(sqlMapClient);
		topLevelClass.addImportedType(autowired);
		topLevelClass.addImportedType(repository);
		method.addAnnotation("@Autowired");
		topLevelClass.addAnnotation("@Repository");
	}

	public boolean validate(List<String> warnings) {
		return true;
	}

}
