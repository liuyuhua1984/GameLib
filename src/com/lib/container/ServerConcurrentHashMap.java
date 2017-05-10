
package com.lib.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName:ServerConcurrentHashMap <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年3月13日 下午3:52:06 <br/>
 * 
 * @author lyh
 * @version
 * @param <K>
 * @param <V>
 * @see
 */
public class ServerConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
	
	/****/
	private static final long serialVersionUID = 211268481124476832L;
	//private AtomicInteger count = new AtomicInteger(0);
	private volatile int count;
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		try {
			V v = super.put(key, value);
			if (v != null){
				//count.incrementAndGet();
				++count;
			}
			return v;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		try {
			super.putAll(m);
			//count.addAndGet(m.size());
			count+=m.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public V remove(Object key) {
		// TODO Auto-generated method stub
		V rem= super.remove(key);
		if (rem != null){
			//count.decrementAndGet();
			--count;
		}
		return rem;
	}
	
	/** (non-Javadoc)
	 * @see java.util.concurrent.ConcurrentHashMap#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putIfAbsent(K key, V value) {
		// TODO Auto-generated method stub
		 if (!containsKey(key)){
			// count.incrementAndGet();
			 --count;
		 }
		return super.putIfAbsent(key, value);
	}
	
	@Override
	public boolean remove(Object key, Object value) {
		// TODO Auto-generated method stub
		boolean b = super.remove(key, value);
		if (b){
			 //count.decrementAndGet();
			--count;
		}
		return b;
	}
	
}
