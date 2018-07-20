package cn.sharehe.weixin.utils;
import cn.sharehe.weixin.constant.VxFileEnum;
import cn.sharehe.weixin.vxinterface.GetToken;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
/**
 * 调用微信接口工具类
 * @Author: wugui
 * @Date 2018-7-17 10:17
 */
public class HttpInterface {
    /**
     * 使用get访问
     * @param url 请求http url
     * @return 返回接口返回字符串出现异常则返回空
     */
    public static String doGet(String url) {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = null;
        HttpEntity httpEntity = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String rel = null;
        try {
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            rel = EntityUtils.toString(httpEntity, "utf8");
            httpResponse.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return rel;
    }
    /**
     * 使用post访问
     * @param url  请求url
     * @param boby 请求参数 实体类对象
     * @return 返回接口返回字符串出现异常则返回空
     */
    public static String doPost(String url, Object boby) {
        return doPost(url, JSON.toJSONString(boby));
    }
    /**
     * 使用post访问
     * @param url  请求url
     * @param boby 请求参数 实体类对象
     * @return 返回接口返回字符串出现异常则返回空
     */
    public static String doPost(String url, String boby) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(boby, "utf8"));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse res = null;
        HttpEntity entity = null;
        String rel = null;
        try {
            res = httpClient.execute(httpPost);
            entity = res.getEntity();
            rel = EntityUtils.toString(entity, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return rel;
    }

    /**
     * 上传文件
     *
     * @param url
     * @param path
     * @return
     */
    public static String doFlie(String url, String path) {
        URL urlObj = null;
        String result = null;
        try {
            urlObj = new URL(url);
            File file = new File(path);
            //连接
            HttpURLConnection con = null;
            con = (HttpURLConnection) urlObj.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false); // post方式不能使用缓存
            // 设置请求头信息
            con.setRequestProperty("Connection", "Keep-Alive");
            con.setRequestProperty("Charset", "UTF-8");
            // 设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            con.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary="
                            + BOUNDARY);
            // 请求正文信息
            // 第一部分：
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length() + "\";filename=\""
                    + file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream out = new DataOutputStream(con.getOutputStream());
            // 输出表头
            out.write(head);
            // 文件正文部分
            // 把文件已流文件的方式 推入到url中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            in.close();
            // 结尾部分
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            out.write(foot);
            out.flush();
            out.close();
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = null;
            // 定义BufferedReader输入流来读取URL的响应
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            if (result == null) {
                result = buffer.toString();
            }
        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        } finally {

        }
        return result;
    }

    /**
     * 下载文件 get请求
     * @param  path 文件保存路径
     * @param url
     * @return 返回 InputStream
     */
    public static boolean doDown(String url,String path) {
        try {
            URL url1 = new URL(url);
            URLConnection urlConnection = url1.openConnection();
            return write(path,urlConnection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * post请求
     * @param url
     * @param path
     * @param param 请求参数 post字符串
     * @return
     */
    public static boolean doDown(String url,String path,String param){
        try {
            URL url1 = new URL(url);
            URLConnection urlConnection = url1.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            return write(path,urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean write(String path,InputStream in){
        OutputStream out = null;
        try {
            out = new FileOutputStream(path);
            byte byt[] = new byte[512];
            int len;
            while ((len = in.read(byt)) != -1){
                out.write(byt,0,len);
            }
            out.flush();
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=" + GetToken.getToken() + "&type=" + VxFileEnum.IMAGE.val;
        System.out.println(HttpInterface.doFlie(url, "F:\\桌面\\class.jpg"));
    }
}
