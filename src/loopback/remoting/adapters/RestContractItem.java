package loopback.remoting.adapters;

/**
 * A single item within a larger SLRESTContract, encapsulation a single route's
 * verb and pattern, e.g. GET /widgets/:id.
 */
public class RestContractItem {

	private final String pattern;
	private final String verb;
	private final RestAdapter.ParameterEncoding parameterEncoding;

	/**
	 * Creates a new item encapsulating the given pattern and the default verb,
	 * <code>"POST"</code>.
	 * 
	 * @param pattern
	 *            The pattern corresponding to this route, e.g.
	 *            <code>"/widgets/:id"</code>.
	 */
	public RestContractItem(String pattern) {
		this(pattern, "POST");
	}

	public RestContractItem(String pattern, String verb) {
		this(pattern, verb, RestAdapter.ParameterEncoding.JSON);
	}

	private RestContractItem(String pattern, String verb,
			RestAdapter.ParameterEncoding parameterEncoding) {
		this.pattern = pattern;
		this.verb = verb;
		this.parameterEncoding = parameterEncoding;
	}

	/**
	 * Gets the pattern corresponding to this route, e.g.
	 * <code>"/widgets/:id"</code>.
	 * 
	 * @return the pattern.
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * Gets the verb corresponding to this route, e.g. <code>"GET"</code>.
	 * 
	 * @return the verb.
	 */
	public String getVerb() {
		return verb;
	}

	public RestAdapter.ParameterEncoding getParameterEncoding() {
		return parameterEncoding;
	}
}
