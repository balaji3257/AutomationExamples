import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import com.akiban.sql.parser.JoinNode;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPath;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpExamples {
	static OkHttpClient client = new OkHttpClient();
	static String strAccessToken ="ZdbqlODLBWjLGccBpkRPibKf1G1pl0cGIGVY_4vDp5rhFFVMxWGAyzAl9Fsf7ApHR47KmYRq4uXIOEubcDQndQ0QD8woXJOGdwRZdxxeJl8eJBw3qRboZ-OUqpwy9OXImpYPinVlCzxsO29sEJiQryEpUFEetse_X7-eo_FhGkKVXdcFSRObkxC7sSt2OsP7YjWWqIFY15xSu9WcA9ilOp3kH7T_QIjEG7AucslZWRc0z4hn4drTrS5w2GgHCp9T0ZkGQzVQ_raNdKniYFW4T93Du55Hwcwglmombr0-nli3qcWsDtvmKXBFbz2WE-CwTfSIb59QH8LE7RwtLXwDBYtpEuoJLegtlwvsMEx6SihAw0LbpMDQCtfpX1x-_TX6_1LpIvl0tc9ChIL5UopuSxDizQqJGkwQ4ElDH3rLoKjZw6PCKbssoN5FsXja9vqMu_fJkwe5-cms2Wab6egf4VJLV5CMNnhTcgS1ycZW30D5HoxGRVfyFU3Fns8MB-om0TwazT5KDLfY91BHMD3Yeg";
	/*
	 * String authenticate(String url) throws IOException { Request req = new
	 * Request.Builder().url("").build();
	 * 
	 * try (Response response = client.newCall(req).execute()) { return
	 * response.body().string(); } }
	 */

	private static String getRequest(String url) throws IOException {
		Request request = new Request.Builder().url(url).header("User-Agent", "OkHttp Headers.java")
				.addHeader("content-type", "application/json").addHeader("Authorization", "Bearer "+strAccessToken)
				.build();

		try (Response response = client.newCall(request).execute()) {
			long tx = response.sentRequestAtMillis();
		    long rx = response.receivedResponseAtMillis();
		    System.out.println("response time : "+(rx - tx)+" ms");
			return response.body().string();
		}
	}

	private static String  post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
		Request request = new Request.Builder().url(url).header("User-Agent", "OkHttp Headers.java")
				.addHeader("content-type", "application/json").post(body).build();
		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}
	}

	private static String getNodeValue(String strResponse, String strJsonPath) {
		String strActual = null;
		try {
			strActual = JsonPath.read(strResponse, strJsonPath);
		} catch (ClassCastException e) {
			Assert.fail("Error Converting Json Node Value " + strJsonPath);
			e.printStackTrace();
		} catch (InvalidPathException | NullPointerException e) {
			Assert.fail("Cannot find the Json Node : " + strJsonPath);
			e.printStackTrace();
		}
		return strActual;
	}

	public static void main(String[] args) throws IOException {
		OkhttpExamples example = new OkhttpExamples();

		String url = "https://staging.uipath.com/api/Account/Authenticate";
		String Reqbody = "{\r\n" + "    \"tenancyName\" : \"RPA_RAPI\",\r\n"
				+ "    \"usernameOrEmailAddress\" : \"balaji.3257@gmail.com\",\r\n"
				+ "    \"password\" : \"Uipath@3257\"\r\n" + "}";
		// Post Request

		 String response = post(url, Reqbody);
		 System.out.println(response);
		System.out.println(getNodeValue(response, "$['result']"));

//		System.out.println( "Settings Resources :"+getRequest("https://staging.uipath.com/odata/Settings") );

	}

}