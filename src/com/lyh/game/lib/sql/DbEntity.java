package com.lyh.game.lib.sql;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import com.lyh.game.lib.utils.ServerUUID;

/** 
 * ClassName:DbEntity <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2014-6-3 下午3:31:26 <br/> 
 * @author   lyh 
 * @version   
 * @see       
 */
/**
 * ClassName: DbEntity <br/>
 * Function: TODO (所有数据库数的的基类). <br/>
 * Reason: TODO (). <br/>
 * date: 2014-6-3 下午3:31:26 <br/>
 * 
 * @author lyh
 * @version
 */
//@MappedSuperclass
public class DbEntity implements Serializable, Cloneable {
	
	/****/
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	/**记录创建时间**/  
	private Date createTime;
	
	public DbEntity(){
		createIdAndTime();
	}
	
	
	// @GeneratedValue
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		DbEntity db = null;
		try {
			db = (DbEntity) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return db;
	}

	public Date getCreateTime() {
        	return createTime;
        }

	public void setCreateTime(Date createTime) {
        	this.createTime = createTime;
        }
	
	/**
	 * 創建id和記錄時間
	 */
	private void createIdAndTime(){
		setCreateTime(new Date(System.currentTimeMillis()));
		this.setId(ServerUUID.getUUID());
	}
}
