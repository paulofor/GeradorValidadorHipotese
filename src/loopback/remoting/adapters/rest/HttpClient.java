package loopback.remoting.adapters.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import loopback.android.remoting.JsonUtil;
import loopback.remoting.adapters.RestAdapter;
import loopback.remoting.adapters.RestAdapter.ParameterEncoding;

import org.json.JSONException;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ProxyServer;
import com.ning.http.client.Response;

public class HttpClient extends AsyncHttpClient {

	private Map<String, String> headers = new HashMap<String, String>();
	
	private String url;
	private String param;
	private String metodo;

	private static String getVersionName() {
		String appVersion = null;
		// TODO: Find reasonable way to set this
		return (appVersion != null) ? appVersion : "";
	}

	private String baseUrl;

	public HttpClient(String baseUrl) {
		if (baseUrl == null) {
			throw new IllegalArgumentException("The baseUrl cannot be null");
		}

		this.baseUrl = baseUrl;

		// Make sure base url ends with a trailing slash.
		if (!this.baseUrl.endsWith("/")) {
			this.baseUrl += "/";
		}

		// More useful User-Agent, similar to AFNetworing.
		String appName = "StongLoopRemoting App";

		String userAgent = appName + " (" + "Placeholder" + ")";

		setUserAgent(userAgent);
		addHeader("Accept", "application/json");
	}

	private void setUserAgent(String userAgent) {
		addHeader("User-Agent", userAgent);
	}

	public void request(String method, String path, Map<String, ? extends Object> parameters,
			ParameterEncoding parameterEncoding, final AsyncCompletionHandler<Response> httpCallback) {

		// TODO: Test extensively to make sure this URI works in tandem with
		// the Android one
		if (path != null) {
			if (path.startsWith("/")) {
				path = path.substring(1);
			}
		}

		this.url = baseUrl + path;
		this.metodo = method;
		this.param = "";
		BoundRequestBuilder request = prepareRequest(method, baseUrl + path);

		String contentType = null;
		String charset = "utf-8";

		if (parameters != null) {
			// Encodes a GET, HEAD or DELETE request
			if ("GET".equalsIgnoreCase(method) || "HEAD".equalsIgnoreCase(method) || "DELETE".equalsIgnoreCase(method)) {

				Set chaves = parameters.keySet();
				for (Object chave : chaves) {
					String chaveStr = ":" + chave;
					String valor = "" + parameters.get(chave);
					// url = url.replaceAll(chaveStr, valor);
					request.addQueryParam("" + chave, valor);
					this.param += "" + chave + "=" + valor;
				}
				// for (Map.Entry<String, ? extends Object> entry :
				// flattenParameters(parameters).entrySet()) {
				// request.addQueryParam(entry.getKey(),
				// String.valueOf(entry.getValue()));
				// }
			}
			// Encodes A POST or PUT request
			else if (parameterEncoding == ParameterEncoding.FORM_URL) {

				// NOTE: Code for "x-www-form-urlencoded" is not used
				// and is untested.
				contentType = "application/x-www-form-urlencoded; charset=" + charset;

				Set chaves = parameters.keySet();
				for (Object chave : chaves) {
					String chaveStr = ":" + chave;
					String valor = "" + parameters.get(chave);
					request.addFormParam(chaveStr, valor);
				}
				// TODO: Set body param properly
				// for (Map.Entry<String, ? extends Object> entry :
				// parameters.entrySet()) {
				// request.addFormParam(entry.getKey(),
				// String.valueOf(entry.getValue()));
				// }

			} else if (parameterEncoding == RestAdapter.ParameterEncoding.FORM_MULTIPART) {

				if (!"POST".equalsIgnoreCase(method)) {
					throw new UnsupportedOperationException("RestAdapter does not support multipart PUT requests");
				}

				/*
				 * for (Map.Entry<String, ? extends Object> entry :
				 * parameters.entrySet()) { Object value = entry.getValue(); if
				 * (value != null) { if (value instanceof java.io.File) {
				 * request.addBodyPart(new FilePart(entry.getKey(), (File)
				 * value)); } else if (value instanceof StreamParam) { try {
				 * ((StreamParam) value).putTo(request, entry.getKey()); } catch
				 * (IOException e) { // TODO: Handle this in a better way.
				 * Should not continue. e.printStackTrace(); } } else if (value
				 * instanceof String) { request.addFormParam(entry.getKey(),
				 * (String) entry.getValue()); } else { throw new
				 * IllegalArgumentException( "Unknown param type for
				 * RequestParams: " + value.getClass().getName()); } } }
				 */
			} else if (parameterEncoding == ParameterEncoding.JSON) {
				contentType = "application/json; charset=" + charset;
				String s = "";
				try {
					s = String.valueOf(JsonUtil.toJson(parameters));
				} catch (JSONException e) {
					// Log.getLogger().severe("Couldn't convert parameters
					// to JSON: " + e.getMessage());
				}

				// TODO: Make sure that encoding works
				request.setBody(s);
				// body = new StringEntity(s, charset);
			}
		}

		// String url = uri.build().toString();
		// logRequest(method, url, body, requestParams);

		// Set the headers
		for (String header : headers.keySet()) {
			request.addHeader(header, getHeader(header));
		}

		ProxyServer proxy = new ProxyServer("10.21.7.10", 82, "tr626987", "Piquet07");
		//_request.setProxyServer(proxy);

		System.out.println("Url:" + this.url + "?" + this.param);

		if ("GET".equalsIgnoreCase(method)) {

			request.execute(httpCallback);
			// get(context, url, headers, null, httpCallback);
		} else if ("DELETE".equalsIgnoreCase(method)) {
			request.execute(httpCallback);
			// delete(context, url, headers, httpCallback);
		} else if ("POST".equalsIgnoreCase(method)) {
			request.addHeader("Content-Type", contentType);
			request.execute(httpCallback);
		} else if ("PUT".equalsIgnoreCase(method)) {
			request.addHeader("Content-Type", contentType);
			request.execute(httpCallback);
		} else {
			throw new IllegalArgumentException("Illegal method: " + method + ". Only GET, POST, PUT, DELETE supported.");
		}
	}

	private BoundRequestBuilder prepareRequest(String method, String url) {
		//
		if ("GET".equalsIgnoreCase(method)) {
			return prepareGet(url);
		} else if ("HEAD".equalsIgnoreCase(method)) {
			return prepareHead(url);
		} else if ("DELETE".equalsIgnoreCase(method)) {
			return prepareDelete(url);
		} else if ("POST".equalsIgnoreCase(method)) {
			return preparePost(url);
		} else if ("PUT".equalsIgnoreCase(method)) {
			return preparePut(url);
		} else if ("OPTIONS".equalsIgnoreCase(method)) {
			return prepareOptions(url);
		} else {
			return null;
		}
	}

	/*
	 * private void logRequest(String method, String url, HttpEntity body,
	 * RequestParams requestParams) { Log.getLogger().info(method + " " + url);
	 * if (requestParams != null)
	 * Log.getLogger().info(requestParams.toString()); else if (body != null &&
	 * body.isRepeatable()) { try { // Convert body stream to string // Based on
	 * http://stackoverflow.com/a/5445161/69868 Scanner s = new
	 * Scanner(body.getContent()).useDelimiter("\\A"); if (s.hasNext())
	 * Log.getLogger().info(s.next()); } catch (IOException e) { } } }
	 */

	private Map<String, Object> flattenParameters(final Map<String, ? extends Object> parameters) {
		return flattenParameters(null, parameters);
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> flattenParameters(final String keyPrefix, final Map<String, ? extends Object> parameters) {

		// This method converts nested maps into a flat list
		// Input: { "here": { "lat": 10, "lng": 20 }
		// Output: { "here[lat]": 10, "here[lng]": 20 }

		Map<String, Object> result = new HashMap<String, Object>();

		/*
		 * for (Map.Entry<String, ? extends Object> entry :
		 * parameters.entrySet()) {
		 * 
		 * String key = keyPrefix != null ? keyPrefix + "[" + entry.getKey() +
		 * "]" : entry.getKey();
		 * 
		 * Object value = entry.getValue();
		 * 
		 * if (value instanceof Map) { result.putAll(flattenParameters(key,
		 * (Map) value)); } else { result.put(key, value); } }
		 */

		return result;
	}

	public void addHeader(String key, String value) {
		headers.put(key, value);
	}

	public String getHeader(String key) {
		return headers.get(key);
	}

	public void removeHeader(String key) {
		headers.remove(key);
	}
	
	
	private String debugRequest(BoundRequestBuilder request) {
		return request.toString();
	}
}
