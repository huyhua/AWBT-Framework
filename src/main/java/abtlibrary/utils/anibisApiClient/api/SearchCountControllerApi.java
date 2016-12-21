package abtlibrary.utils.anibisApiClient.api;

import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.Configuration;
import abtlibrary.utils.anibisApiClient.Pair;
import abtlibrary.utils.anibisApiClient.TypeRef;

import java.util.Map;
import abtlibrary.utils.anibisApiClient.model.SearchParameterDto;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class SearchCountControllerApi {
  private ApiClient apiClient;

  public SearchCountControllerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SearchCountControllerApi(ApiClient apiClient) {
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
   * @param parmsString 
   * @return Map<String, Integer>
   */
  public Map<String, Integer> searchCountControllerGet (String parmsString) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'parmsString' is set
     if (parmsString == null) {
        throw new ApiException(400, "Missing the required parameter 'parmsString' when calling searchCountControllerGet");
     }
     
    // create path and map variables
    String path = "/v1/SearchCounts".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "parmsString", parmsString));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<Map<String, Integer>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param parms 
   * @return Map<String, Integer>
   */
  public Map<String, Integer> searchCountControllerPost (SearchParameterDto parms) throws ApiException {
    Object postBody = parms;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'parms' is set
     if (parms == null) {
        throw new ApiException(400, "Missing the required parameter 'parms' when calling searchCountControllerPost");
     }
     
    // create path and map variables
    String path = "/v1/SearchCounts".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json", "text/json", "application/x-www-form-urlencoded"
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<Map<String, Integer>>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
