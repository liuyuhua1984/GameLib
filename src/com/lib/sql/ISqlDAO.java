
package com.lib.sql;

import java.util.List;

/** 
 * ClassName:ISqlDAO <br/> 
 * Function: TODO (sql操作接口). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2017年3月16日 上午10:55:10 <br/> 
 * @author   lyh 
 * @version   
 * @see       
 */
public interface ISqlDAO<E> {

	 Long save(E transientInstance);
	
	void delete(E persistentInstance);
	
	// protected abstract void saveOrUpdate(E instance);
	
	void updateFinal(E instance);
	
	// protected abstract void updateSynEntity(Object instance);
	
	<T> T findById(Class<T> entity, long id);
	
	 <T> List<T> findAll(Class<T> c);
	
	<T> List<T> findByProperty(Class<T> c, String propertyName, Object value);
	
	<T> List<T> findByProperties(Class<T> c, List<String> propertyName, List<Object> value);
	
	<T> List<T> findByHql(String hql);
}
  