
package com.lyh.game.lib.errorcode;

/** ClassName:ErrorCode <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年4月1日 下午5:30:00 <br/>
 * 
 * @author lyh
 * @version
 * @see */
public class GameErrorCode {
	
	/**账号不能为空***/  
	public final static String ERROE_CODE_0 = "账号不能为空";
	
	/** 玩家不是空闲状态 **/
	public final static String ERROE_CODE_1 = "玩家不是空闲状态";
	
	/** 座位已满 **/
	public final static String ERROE_CODE_2 = "座位已满";
	
	/** 战局已经开启不能退出房间 **/
	public final static String ERROE_CODE_3 = "战局已经开启不能退出房间";
	
	/**房间不存在**/  
	public final static String ERROE_CODE_4 = "房间不存在";
	/**创建房间出错**/
	public final static String ERROR_CODE_5 = "创建房间数已达上限";
	
	public final static String ERROR_CODE_6 = "游戏异常,请重新登录";
	/**非法聊天**/
	public final static String ERROR_CODE_7 = "聊天非法";
	/**聊天内容过长**/
	public final static String ERROR_CODE_8 = "聊天内容过长";
	/**IP相同**/
	public final static String ERROR_CODE_9 = "同一IP禁止进入房间";
	/**玩家不存在**/
	public final static String ERROR_CODE_10 = "玩家不存在";
	/**数据不合法**/
	public final static String ERROR_CODE_11 = "数据不合法";
	/**不是自己的数据**/
	public final static String ERROR_CODE_12 = "不是自己的数据";
	/**玩家已加入房间**/
	public final static String ERROR_CODE_13 = "玩家已加入房间";
	/**玩家不在房间内**/
	public final static String ERROR_CODE_14 = "玩家不在房间内";
	/**不应该你出牌**/
	public final static String ERROR_CODE_15 = "不应该你出牌";
	
	/**局数已满**/
	public final static String ERROR_CODE_16 = "局数已满";
	/**战局已开不能加入房间**/
	public final static String ERROR_CODE_17 = "战局已开不能加入房间";
	
	/**听牌才能托管**/
	public final static String ERROR_CODE_18 = "听牌才能托管";
	/**自动托管不能取消**/
	public final static String ERROR_CODE_19 = "自动托管不能取消";
	
	/**出牌玩家不能托管**/
	public final static String ERROR_CODE_20 = "出牌玩家不能托管";
	
	public final static String ERROR_CODE_21 = "游戏已经开始！";
	
	public final static String ERROR_CODE_22 ="不同意解散房间！";
}
