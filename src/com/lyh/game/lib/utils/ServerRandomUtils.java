/** 
 * Project Name:DragonBallWorldServerHappy 
 * File Name:ServerRandom.java 
 * Package Name:com.sj.world.utils 
 * Date:2013-9-14上午10:50:15 
 * Copyright (c) 2013, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package com.lyh.game.lib.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName:ServerRandom <br/>
 * Function: TODO (随机数实体类全是静态方法). <br/>
 * Reason: TODO (). <br/>
 * Date: 2013-9-14 上午10:50:15 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
public class ServerRandomUtils {
	private static Random random = new Random();
	
	public static int nextInt(int val) {
	
		return nextInt(val,true);
	}
	
	public static int nextInt(int val,boolean isAbs) {
		int r = (int)(ThreadLocalRandom.current().nextDouble() * val);
		if (isAbs){
			return Math.abs(r);
		}
		return r;
	}
	
	
	public static float randomFloat(float val) {
		// random.setSeed(System.currentTimeMillis());
		float r = ((random.nextFloat()) * val);
		return r;
	}
	
	public static int randomNum(int min, int max) {
		if (min < 0) {
			int i = nextInt(max + 1 + Math.abs(min));
			return min + i;
		} else {
			int i = nextInt(max + 1 - min);
			return min + i;
		}
	}
	
	// public static float randomFloatNum(int min, int max) {
	// float i = new Random().nextFloat() % max;
	// return i % max;
	//
	// }
	
	/**
	 * randomNums:(). <br/>
	 * TODO(得到区间内n个不重复随机数).<br/>
	 * 
	 * @author yst
	 * @param min 最小值（包含）
	 * @param max 最大值（包含）
	 * @param count 数量
	 * @return
	 */
	public static List<Integer> randomNums(int min, int max, int count) {
		if (max - min + 1 > count) {
			count = max - min + 1;
		}
		Set<Integer> nums = new LinkedHashSet<Integer>();
		while (nums.size() < count) {
			nums.add(randomNum(min, max));
		}
		List<Integer> list = new ArrayList<Integer>(nums);
		return list;
	}
	

	/** 
	 * 权重随机， 
	 * weightList：权重列表
	 * return：随机的位数
	 * randomByWeight:(). <br/> 
	 */  
	public static int randomByWeight(List<Integer> weightList)
	{
		int count = weightList.size();
		if(count <=0)
			return -1;
		if(count == 1)
			return 0;
		//拼接和数组
		int[] sumOrder = new int[count];
		for(int i=0;i < weightList.size(); i++)
		{
			if(i == 0)
			{
				sumOrder[i] = weightList.get(i);
			}
			else
			{
				sumOrder[i] = sumOrder[i-1] + weightList.get(i);
			}
		}
		int sum = sumOrder[count - 1];
		if(sum == 0)
			return -1;
		
		int rand = randomNum(1,sum);
		for(int i=0; i < count; ++i)
		{
			if(rand <= sumOrder[i])
				return i;
		}
		return -1;
	}
}
