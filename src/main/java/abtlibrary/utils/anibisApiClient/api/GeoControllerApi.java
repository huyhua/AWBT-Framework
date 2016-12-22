package abtlibrary.utils.anibisApiClient.api;

import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.Configuration;
import abtlibrary.utils.anibisApiClient.Pair;
import abtlibrary.utils.anibisApiClient.TypeRef;

import abtlibrary.utils.anibisApiClient.model.KeyValueListDto;
import abtlibrary.utils.anibisApiClient.model.GeoLocationDto;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class GeoControllerApi {
  private ApiClient apiClient;

  public GeoControllerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public GeoControllerApi(ApiClient apiClient) {
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
   * @param language 
   * @param countryCode 
   * @return KeyValueListDto
   */
  public KeyValueListDto geoControllerGetStatesDefault (String language, String countryCode) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'language' is set
     if (language == null) {
        throw new ApiException(400, "Missing the required parameter 'language' when calling geoControllerGetStatesDefault");
     }
     
     // verify the required parameter 'countryCode' is set
     if (countryCode == null) {
        throw new ApiException(400, "Missing the required parameter 'countryCode' when calling geoControllerGetStatesDefault");
     }
     
    // create path and map variables
    String path = "/v1/Geo".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "language", language));
    
    queryParams.addAll(apiClient.parameterToPairs("", "countryCode", countryCode));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<KeyValueListDto>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param language 
   * @return KeyValueListDto
   */
  public KeyValueListDto geoControllerGetCountries (String language) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'language' is set
     if (language == null) {
        throw new ApiException(400, "Missing the required parameter 'language' when calling geoControllerGetCountries");
     }
     
    // create path and map variables
    String path = "/v1/Geo/countries".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "language", language));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<KeyValueListDto>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param countryCode 
   * @param zip 
   * @param language 
   * @return List<GeoLocationDto>
   */
  public List<GeoLocationDto> geoControllerGetLocationFromZip (String countryCode, String zip, String language) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'countryCode' is set
     if (countryCode == null) {
        throw new ApiException(400, "Missing the required parameter 'countryCode' when calling geoControllerGetLocationFromZip");
     }
     
     // verify the required parameter 'zip' is set
     if (zip == null) {
        throw new ApiException(400, "Missing the required parameter 'zip' when calling geoControllerGetLocationFromZip");
     }
     
     // verify the required parameter 'language' is set
     if (language == null) {
        throw new ApiException(400, "Missing the required parameter 'language' when calling geoControllerGetLocationFromZip");
     }
     
    // create path and map variables
    String path = "/v1/Geo/locations".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "countryCode", countryCode));
    
    queryParams.addAll(apiClient.parameterToPairs("", "zip", zip));
    
    queryParams.addAll(apiClient.parameterToPairs("", "language", language));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<List<GeoLocationDto>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param language 
   * @return KeyValueListDto
   */
  public KeyValueListDto geoControllerGetStates (String language) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'language' is set
     if (language == null) {
        throw new ApiException(400, "Missing the required parameter 'language' when calling geoControllerGetStates");
     }
     
    // create path and map variables
    String path = "/v1/Geo/states".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "language", language));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<KeyValueListDto>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
