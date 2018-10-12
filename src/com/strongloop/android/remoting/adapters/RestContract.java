// Copyright (c) 2013 StrongLoop. All rights reserved.

package com.strongloop.android.remoting.adapters;

import java.util.HashMap;
import java.util.Map;

/**
 * A contract specifies how remote method names map to HTTP routes.
 * 
 * For example, if a remote method on the server has been remapped like so:
 * 
 * <pre>
 * &#064;code
 * project.getObject = function (id, callback) {
 *     callback(null, { ... });
 * };
 * helper.method(project.getObject, {
 *     http: { verb: 'GET', path: '/:id'},
 *     accepts: { name: 'id', type: 'string' }
 *     returns: { name: 'object', type: 'object' }
 * })
 * 
 * </pre>
 * 
 * The new route is GET /:id, instead of POST /project/getObject, so we need to
 * update our contract on the client:
 * 
 * <pre>
 * &#064;code
 * contract.addItem(new RestContractItem(&quot;/:id&quot;, &quot;GET&quot;), &quot;project.getObject&quot;);
 * 
 * </pre>
 */
public class RestContract {

	private Map<String, RestContractItem> items = new HashMap<String, RestContractItem>();

	/**
	 * Adds a single item to this contract. The item can be shared among
	 * different contracts, managed by the sum of all contracts that contain it.
	 * Similarly, each item can be used for more than one method, like so:
	 * 
	 * <pre>
	 * {
	 * 	&#064;code
	 * 	RestContractItem upsert = new RestContractItem(&quot;/widgets/:id&quot;, &quot;PUT&quot;);
	 * 	contract.addItem(upsert, &quot;widgets.create&quot;);
	 * 	contract.addItem(upsert, &quot;widgets.update&quot;);
	 * }
	 * </pre>
	 * 
	 * @param item
	 *            The item to add to this contract.
	 * @param method
	 *            The method the item should represent.
	 */
	public void addItem(RestContractItem item, String method) {
		if (item == null || method == null) {
			throw new IllegalArgumentException(
					"Neither item nor method can be null");
		}
		items.put(method, item);
	}

	/**
	 * Adds all items from contract.
	 * 
	 * @see #addItem(RestContractItem, String)
	 * @param contract
	 *            The contract to copy from.
	 */
	public void addItemsFromContract(RestContract contract) {
		if (contract == null) {
			throw new IllegalArgumentException("Contract cannot be null");
		}
		items.putAll(contract.items);
	}

	/**
	 * Returns the custom pattern representing the given method string, or
	 * <code>null</code> if no custom pattern exists.
	 * 
	 * @param method
	 *            The method to resolve.
	 * @return The custom pattern if one exists, <code>null</code> otherwise.
	 */
	public String getPatternForMethod(String method) {
		if (method == null) {
			throw new IllegalArgumentException("Method cannot be null");
		}

		RestContractItem item = items.get(method);

		return item != null ? item.getPattern() : null;
	}

	/**
	 * Gets the HTTP verb for the given method string.
	 * 
	 * @param method
	 *            The method to resolve.
	 * @return The resolved verb, or "POST" if it isn't defined.
	 */
	public String getVerbForMethod(String method) {
		if (method == null) {
			throw new IllegalArgumentException("Method cannot be null");
		}

		RestContractItem item = items.get(method);

		return item != null ? item.getVerb() : "POST";
	}

	/**
	 * Gets the ParameterEncoding for the given method.
	 * 
	 * @param method
	 *            The method to resolve.
	 * @return The parameter encoding.
	 */
	public RestAdapter.ParameterEncoding getParameterEncodingForMethod(
			String method) {
		if (method == null) {
			throw new IllegalArgumentException("Method cannot be null");
		}

		RestContractItem item = items.get(method);

		return item != null ? item.getParameterEncoding()
				: RestAdapter.ParameterEncoding.JSON;
	}

	/**
	 * Resolves a specific method, replacing pattern fragments with the optional
	 * parameters as appropriate.
	 * 
	 * @param method
	 *            The method to resolve.
	 * @param parameters
	 *            Pattern parameters. Can be <code>null</code>.
	 * @return The complete, resolved URL.
	 */
	public String getUrlForMethod(String method,
			Map<String, ? extends Object> parameters) {
		if (method == null) {
			throw new IllegalArgumentException("Method cannot be null");
		}

		String pattern = getPatternForMethod(method);

		if (pattern != null) {
			return getUrl(pattern, parameters);
		} else {
			return getUrlForMethodWithoutItem(method);
		}
	}

	/**
	 * Generates a fallback URL for a method whose contract has not been
	 * customized.
	 * 
	 * @param method
	 *            The method to generate from.
	 * @return The resolved URL.
	 */
	public String getUrlForMethodWithoutItem(String method) {
		if (method == null) {
			throw new IllegalArgumentException("Method cannot be null");
		}

		return method.replace('.', '/');
	}

	/**
	 * Returns a rendered URL pattern using the parameters provided. For
	 * example, the pattern <code>"/widgets/:id"</code> with the parameters
	 * that contain the value <code>"57"</code> for key <code>"id"</code>,
	 * begets <code>"/widgets/57"</code>.
	 * 
	 * @param pattern
	 *            The pattern to render.
	 * @param parameters
	 *            The values to render with.
	 * @return The rendered URL.
	 */
	public String getUrl(String pattern,
			Map<String, ? extends Object> parameters) {
		if (pattern == null) {
			throw new IllegalArgumentException("Pattern cannot be null");
		}

		String url = pattern;
		if (parameters == null) {
			return url;
		}
		
		parameters.getKeys();
		for (String chave : parameters.)
		
		for (Map.Entry<String, ? extends Object> entry : parameters.entrySet()) {
			String key = ":" + entry.getKey();
			String value = String.valueOf(entry.getValue());
			url = url.replace(key, value);
		}

		return url;
	}
}
