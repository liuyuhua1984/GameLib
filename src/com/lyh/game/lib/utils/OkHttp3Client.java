
package com.lyh.game.lib.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * ClassName:OkHttp3Client <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月12日 上午10:45:10 <br/>
 * RequestBody的数据格式都要指定Content-Type，常见的有三种：
 * 
 * application/x-www-form-urlencoded 数据是个普通表单 multipart/form-data 数据里有文件 application/json 数据是个json
 * 
 * @author lyh
 * @version
 * @see
 */
public class OkHttp3Client {
	private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
	private static final MediaType CONTENT_TYPE_DATA = MediaType.parse("multipart/form-data");
	private static final MediaType CONTENT_TYPE_JSON = MediaType.parse("application/json");
	
	// MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	// RequestBody body = RequestBody.create(JSON, "你的json");
	//
	// RequestBody requestBody = new MultipartBody.Builder()
	// .setType(MultipartBody.FORM)
	// .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/png"), file))
	// .build();
	
	public static void httpGet(String url, boolean asyn) {
		OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
			.connectTimeout(15, TimeUnit.SECONDS)
	                .writeTimeout(20, TimeUnit.SECONDS)
	                .readTimeout(20, TimeUnit.SECONDS);
			OkHttpClient okHttpClient=builder.build(); 
			
		Request request = new Request.Builder().url(url).build();
		Call call = okHttpClient.newCall(request);
		if (asyn) {
			call.enqueue(new Callback() {
				@Override
				public void onFailure(Call call, IOException e) {
					e.printStackTrace();
				}
				
				@Override
				public void onResponse(Call call, Response response) throws IOException {
					System.out.println("我是异步线程,线程Id为:" + Thread.currentThread().getId());
				}
			});
			for (int i = 0; i < 10; i++) {
				System.out.println("我是主线程,线程Id为:" + Thread.currentThread().getId());
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				Response response = call.execute();
				System.out.println(response.body().string());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void httpPost(String url, boolean asyn) {
		OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
		.connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);
		OkHttpClient okHttpClient=builder.build(); 
		
		RequestBody body = new FormBody.Builder().add("键", "值").add("键", "值")
		        
		        .build();
		
		Request request = new Request.Builder().url(url).post(body).build();
		
		Call call = okHttpClient.newCall(request);
		if (asyn) {
			call.enqueue(new Callback() {
				@Override
				public void onFailure(Call call, IOException e) {
					e.printStackTrace();
				}
				
				@Override
				public void onResponse(Call call, Response response) throws IOException {
					System.out.println("我是异步线程,线程Id为:" + Thread.currentThread().getId());
				}
			});
			for (int i = 0; i < 10; i++) {
				System.out.println("我是主线程,线程Id为:" + Thread.currentThread().getId());
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				Response response = call.execute();
				System.out.println(response.body().string());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
