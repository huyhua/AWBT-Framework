package abtlibrary.utils.anibisApiClient.api;

import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.Configuration;
import abtlibrary.utils.anibisApiClient.Pair;
import abtlibrary.utils.anibisApiClient.TypeRef;
import abtlibrary.utils.anibisApiClient.XTokenGenerator;
import abtlibrary.utils.anibisApiClient.model.UserDto;

import java.util.Map;

import abtlibrary.utils.anibisApiClient.model.RegisterModel;
import abtlibrary.utils.anibisApiClient.model.AdvertDto;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class MemberControllerApi {
	private ApiClient apiClient;

	public MemberControllerApi() {
		this(Configuration.getDefaultApiClient());
	}

	public MemberControllerApi(String username, String password) {
		this(Configuration.getDefaultApiClient(), username, password);
	}

	public MemberControllerApi(ApiClient apiClient, String username,
			String password) {
		this.apiClient = apiClient;
		apiClient.addDefaultHeader(
				"Authorization",
				String.format("Basic %s",
						XTokenGenerator.getBaseAuthValue(username, password)));
	}

	public MemberControllerApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * 
	 * 
	 * @return UserDto
	 */
	public UserDto memberControllerGet() throws ApiException {
		Object postBody = null;
		byte[] postBinaryBody = null;

		// create path and map variables
		String path = "/v1/Members".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> queryParams = new ArrayList<Pair>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, Object> formParams = new HashMap<String, Object>();

		final String[] accepts = { "application/json", "text/json" };
		final String accept = apiClient.selectHeaderAccept(accepts);

		final String[] contentTypes = {

		};
		final String contentType = apiClient
				.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		TypeRef returnType = new TypeRef<UserDto>() {
		};
		return apiClient.invokeAPI(path, "GET", queryParams, postBody,
				postBinaryBody, headerParams, formParams, accept, contentType,
				authNames, returnType);

	}

	/**
	 * 
	 * 
	 * @return Map<String, String>
	 */
	public Map<String, String> memberControllerPost() throws ApiException {
		Object postBody = null;
		byte[] postBinaryBody = null;

		// create path and map variables
		String path = "/v1/Members".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> queryParams = new ArrayList<Pair>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, Object> formParams = new HashMap<String, Object>();

		final String[] accepts = { "application/json", "text/json" };
		final String accept = apiClient.selectHeaderAccept(accepts);

		final String[] contentTypes = {

		};
		final String contentType = apiClient
				.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		TypeRef returnType = new TypeRef<Map<String, String>>() {
		};
		return apiClient.invokeAPI(path, "POST", queryParams, postBody,
				postBinaryBody, headerParams, formParams, accept, contentType,
				authNames, returnType);

	}

	/**
	 * 
	 * 
	 * @param email
	 * @return String
	 */
	public String memberControllerPasswordRecovery(String email)
			throws ApiException {
		Object postBody = null;
		byte[] postBinaryBody = null;

		// verify the required parameter 'email' is set
		if (email == null) {
			throw new ApiException(
					400,
					"Missing the required parameter 'email' when calling memberControllerPasswordRecovery");
		}

		// create path and map variables
		String path = "/v1/Members/PasswordRecovery".replaceAll("\\{format\\}",
				"json");

		// query params
		List<Pair> queryParams = new ArrayList<Pair>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, Object> formParams = new HashMap<String, Object>();

		queryParams.addAll(apiClient.parameterToPairs("", "email", email));

		final String[] accepts = { "application/json", "text/json" };
		final String accept = apiClient.selectHeaderAccept(accepts);

		final String[] contentTypes = {

		};
		final String contentType = apiClient
				.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		TypeRef returnType = new TypeRef<String>() {
		};
		return apiClient.invokeAPI(path, "GET", queryParams, postBody,
				postBinaryBody, headerParams, formParams, accept, contentType,
				authNames, returnType);

	}

	/**
	 * 
	 * 
	 * @param model
	 * @return UserDto
	 */
	public UserDto memberControllerRegister(RegisterModel model)
			throws ApiException {
		Object postBody = model;
		byte[] postBinaryBody = null;

		// verify the required parameter 'model' is set
		if (model == null) {
			throw new ApiException(400,
					"Missing the required parameter 'model' when calling memberControllerRegister");
		}

		// create path and map variables
		String path = "/v1/Members/register".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> queryParams = new ArrayList<Pair>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, Object> formParams = new HashMap<String, Object>();

		final String[] accepts = { "application/json", "text/json" };
		final String accept = apiClient.selectHeaderAccept(accepts);

		final String[] contentTypes = { "application/json", "text/json",
				"application/x-www-form-urlencoded" };
		final String contentType = apiClient
				.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		TypeRef returnType = new TypeRef<UserDto>() {
		};
		return apiClient.invokeAPI(path, "POST", queryParams, postBody,
				postBinaryBody, headerParams, formParams, accept, contentType,
				authNames, returnType);

	}

	/**
	 * 
	 * 
	 * @param memberId
	 * @return List<AdvertDto>
	 */
	public List<AdvertDto> memberControllerGetUserAdverts(Integer memberId)
			throws ApiException {
		Object postBody = null;
		byte[] postBinaryBody = null;

		// verify the required parameter 'memberId' is set
		if (memberId == null) {
			throw new ApiException(
					400,
					"Missing the required parameter 'memberId' when calling memberControllerGetUserAdverts");
		}

		// create path and map variables
		String path = "/v1/Members/{memberId}/Adverts".replaceAll(
				"\\{format\\}", "json").replaceAll("\\{" + "memberId" + "\\}",
				apiClient.escapeString(memberId.toString()));

		// query params
		List<Pair> queryParams = new ArrayList<Pair>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, Object> formParams = new HashMap<String, Object>();

		final String[] accepts = { "application/json", "text/json" };
		final String accept = apiClient.selectHeaderAccept(accepts);

		final String[] contentTypes = {

		};
		final String contentType = apiClient
				.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		TypeRef returnType = new TypeRef<List<AdvertDto>>() {
		};
		return apiClient.invokeAPI(path, "GET", queryParams, postBody,
				postBinaryBody, headerParams, formParams, accept, contentType,
				authNames, returnType);

	}

	/**
	 * 
	 * 
	 * @param memberId
	 * @param email
	 * @return String
	 */
	public String memberControllerChangeEmail(Integer memberId, String email)
			throws ApiException {
		Object postBody = null;
		byte[] postBinaryBody = null;

		// verify the required parameter 'memberId' is set
		if (memberId == null) {
			throw new ApiException(
					400,
					"Missing the required parameter 'memberId' when calling memberControllerChangeEmail");
		}

		// verify the required parameter 'email' is set
		if (email == null) {
			throw new ApiException(
					400,
					"Missing the required parameter 'email' when calling memberControllerChangeEmail");
		}

		// create path and map variables
		String path = "/v1/Members/{memberId}/ChangeEmail".replaceAll(
				"\\{format\\}", "json").replaceAll("\\{" + "memberId" + "\\}",
				apiClient.escapeString(memberId.toString()));

		// query params
		List<Pair> queryParams = new ArrayList<Pair>();
		Map<String, String> headerParams = new HashMap<String, String>();
		Map<String, Object> formParams = new HashMap<String, Object>();

		queryParams.addAll(apiClient.parameterToPairs("", "email", email));

		final String[] accepts = { "application/json", "text/json" };
		final String accept = apiClient.selectHeaderAccept(accepts);

		final String[] contentTypes = {

		};
		final String contentType = apiClient
				.selectHeaderContentType(contentTypes);

		String[] authNames = new String[] {};

		TypeRef returnType = new TypeRef<String>() {
		};
		return apiClient.invokeAPI(path, "POST", queryParams, postBody,
				postBinaryBody, headerParams, formParams, accept, contentType,
				authNames, returnType);

	}

}
