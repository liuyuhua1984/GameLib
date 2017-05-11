
package com.lyh.game.lib.container;

import java.util.Vector;

/** 
 * ClassName:PollingVector <br/> 
 * Function: TODO (自定义vector). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2017年3月22日 下午4:38:53 <br/> 
 * @author   lyh 
 * @version   
 * @see       
 */
public class PollingVector<E> extends Vector<E> {

	/****/  
	private static final long serialVersionUID = -1328080851701621484L;
	
	private Integer pos = 0;
	
	/** 
	 * polling:(). <br/> 
	 * TODO().<br/> 
	 * 轮询
	 * @author lyh 
	 * @return 
	 */  
	public E polling(){
		E e = null;
		synchronized (pos) {
			if (pos >= size()){
				pos = 0;
			}
			 e = this.get(pos);
			pos++;
		}
		return e;
	}
}
  