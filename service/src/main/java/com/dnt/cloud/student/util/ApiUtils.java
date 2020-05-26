/**
 * 
 */
package com.dnt.cloud.student.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

/**
 * HTTPS请求：Tiens api平台
 * @author julio
 * 2018年11月24日
 */
public class ApiUtils {
	
	private static Logger logger = LoggerFactory.getLogger(ApiUtils.class);
	
	public static final String ACCEPT_JSON = "application/json";
	
	/**
	 * 直接访问后端地址
	 * @param url 接口地址
	 * @param parameter 参数
	 * @param parameterFlg 参数方式[0：path方式，1：model方式]
	 * @param contentType：application/json
	 * @return
	 * @throws Exception
	 */
    public static String sendRequestByPath(String url)throws Exception{
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            logger.info("请求地址：" + realUrl.toString());

            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setDoInput(true);// 创建输入流，必须有
            conn.setDoOutput(true);// 创建输出流，必须有
            conn.setUseCaches(false);// 不缓存
            conn.setConnectTimeout(60000);// 连接超时
            conn.setReadTimeout(60000);// 响应超时
            conn.setRequestMethod("GET");

            conn.addRequestProperty("Charset", "UTF-8");
            conn.addRequestProperty("content-type",ACCEPT_JSON);
            conn.addRequestProperty("Connection", "Keep-Alive");
            conn.addRequestProperty("Accept", MediaType.APPLICATION_JSON.toString());
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());

            // flush输出流的缓冲
            out.flush();

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return buffer.toString();
    }
    
	/**
	 * 直接访问后端地址
	 * @param url 接口地址
	 * @param parameter 参数
	 * @param parameterFlg 参数方式[0：path方式，1：model方式]
	 * @param contentType：application/json
	 * @return
	 * @throws Exception
	 */
    public static String sendRequestByPath(String url,String parameter)throws Exception{
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            logger.info("请求地址：" + realUrl.toString());

            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection)realUrl.openConnection();
            // 设置通用的请求属性
            conn.setDoInput(true);// 创建输入流，必须有
            conn.setDoOutput(true);// 创建输出流，必须有
            conn.setUseCaches(false);// 不缓存
            conn.setConnectTimeout(60000);// 连接超时
            conn.setReadTimeout(60000);// 响应超时
            conn.setRequestMethod("POST");

            conn.addRequestProperty("Charset", "UTF-8");
            conn.addRequestProperty("content-type",ACCEPT_JSON);
            conn.addRequestProperty("Connection", "Keep-Alive");
            conn.addRequestProperty("Accept", MediaType.APPLICATION_JSON.toString());
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());

            // 发送请求参数
            out.print(parameter);

            // flush输出流的缓冲
            out.flush();

            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭输出流、输入流
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return buffer.toString();
    }

	
	public static void main(String[] args) throws Exception {
	}
}
