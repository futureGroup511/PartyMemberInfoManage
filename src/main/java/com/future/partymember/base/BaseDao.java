package com.future.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	public BaseDao(){
		Type type=this.getClass().getGenericSuperclass();
		if(!(type instanceof ParameterizedType)){
			type=type.getClass().getSuperclass().getGenericSuperclass();
		}
		clazz=(Class<T>)((ParameterizedType) type).getActualTypeArguments()[0];
	}
	
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	protected T getEntity(int id){
		return (T)this.getSession().get(clazz, id);
	}
	protected boolean saveEntity(T t){
		this.getSession().save(t);
		return true;
	}
	protected boolean updateEntity(T t){
		this.getSession().update(t);
		return true;
	}
	protected boolean deleteEntity(T t){
		this.getSession().delete(t);
		return true;
	}
	protected List<T> getEntityList(String hql,Object ...objects){
		Query query=this.getSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		List<T> list=query.list();
		return list;
	}
	
	protected Object uniqueResult(String hql, Object... objects) {
		Query query = getSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		return query.uniqueResult();
	}
	//执行返回列表的sql查询语句
	protected List executeSQLQuery(Class clazz,String sql, Object ...objects){
		SQLQuery sQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if(clazz!=null){//这样可以直接的将投影查询之后可以将数组包装成实体类型的数据格式
			sQuery.addEntity(clazz);
		}
		for(int i=0;i<objects.length;i++){
			sQuery.setParameter(i, objects[i]);
		}
		return sQuery.list();
	}
	/*执行无返回值的sql语句*/
	protected void executeSQL(String sql, Object ...objects){
		SQLQuery sQuery = getSession().createSQLQuery(sql);
		for(int i=0;i<objects.length;i++){
			sQuery.setParameter(i, objects[i]);
		}
		sQuery.executeUpdate();
	}
	/*执行限制数量的hql*/
	protected List<T> getEntityLimitList(String hql,int first,int max,Object ...objects){
		Query query=this.getSession().createQuery(hql);
		for(int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);
		}
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}
}
