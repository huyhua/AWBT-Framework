package abtlibrary.utils.anibisApiClient.api;

import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.Configuration;
import abtlibrary.utils.anibisApiClient.Pair;
import abtlibrary.utils.anibisApiClient.TypeRef;
import abtlibrary.utils.anibisApiClient.XTokenGenerator;
import abtlibrary.utils.anibisApiClient.model.AdvertDetailDto;
import abtlibrary.utils.anibisApiClient.model.IdListDto;
import abtlibrary.utils.anibisApiClient.model.AdvertInsertion;
import abtlibrary.utils.anibisApiClient.model.InsertionUpdateResult;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AdvertDetailControllerApi {
  private ApiClient apiClient;

  public AdvertDetailControllerApi() {
    this(Configuration.getDefaultApiClient());
  }
  
  public AdvertDetailControllerApi(String username, String password) {
	    this(Configuration.getDefaultApiClient(), username, password);
	  }
  
  public AdvertDetailControllerApi(ApiClient apiClient, String username, String password) {
	    this.apiClient = apiClient;
	    apiClient.addDefaultHeader("Authorization", String.format("Basic %s",
								XTokenGenerator.getBaseAuthValue(username, password)));
	  }

  public AdvertDetailControllerApi(ApiClient apiClient) {
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
   * @param ids 
   * @return List<AdvertDetailDto>
   */
  public List<AdvertDetailDto> advertDetailControllerPost (IdListDto ids) throws ApiException {
    Object postBody = ids;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'ids' is set
     if (ids == null) {
        throw new ApiException(400, "Missing the required parameter 'ids' when calling advertDetailControllerPost");
     }
     
    // create path and map variables
    String path = "/v1/AdvertDetails".replaceAll("\\{format\\}","json");

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

    

    
    
    TypeRef returnType = new TypeRef<List<AdvertDetailDto>>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param advertId 
   * @return Object
   */
  public Object advertDetailControllerRemoveAdvert (Integer advertId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'advertId' is set
     if (advertId == null) {
        throw new ApiException(400, "Missing the required parameter 'advertId' when calling advertDetailControllerRemoveAdvert");
     }
     
    // create path and map variables
    String path = "/v1/AdvertDetails".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "advertId", advertId));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<Object>() {};
    return apiClient.invokeAPI(path, "DELETE", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param model 
   * @return Object
   */
  public Object advertDetailControllerInsertAdvert (AdvertInsertion model) throws ApiException {
    Object postBody = model;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'model' is set
     if (model == null) {
        throw new ApiException(400, "Missing the required parameter 'model' when calling advertDetailControllerInsertAdvert");
     }
     
    // create path and map variables
    String path = "/v1/AdvertDetails/Insert".replaceAll("\\{format\\}","json");

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

    

    
    
    TypeRef returnType = new TypeRef<Object>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param model 
   * @return AdvertDetailDto
   */
  public AdvertDetailDto advertDetailControllerUpdateAdvert (AdvertInsertion model) throws ApiException {
    Object postBody = model;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'model' is set
     if (model == null) {
        throw new ApiException(400, "Missing the required parameter 'model' when calling advertDetailControllerUpdateAdvert");
     }
     
    // create path and map variables
    String path = "/v1/AdvertDetails/Update".replaceAll("\\{format\\}","json");

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

    

    
    
    TypeRef returnType = new TypeRef<AdvertDetailDto>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param advertId 
   * @return AdvertDetailDto
   */
  public AdvertDetailDto advertDetailControllerPublishAdvert (Integer advertId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'advertId' is set
     if (advertId == null) {
        throw new ApiException(400, "Missing the required parameter 'advertId' when calling advertDetailControllerPublishAdvert");
     }
     
    // create path and map variables
    String path = "/v1/AdvertDetails/activate".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "advertId", advertId));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<AdvertDetailDto>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param advertId 
   * @return AdvertDetailDto
   */
  public AdvertDetailDto advertDetailControllerDeactivateAdvert (Integer advertId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'advertId' is set
     if (advertId == null) {
        throw new ApiException(400, "Missing the required parameter 'advertId' when calling advertDetailControllerDeactivateAdvert");
     }
     
    // create path and map variables
    String path = "/v1/AdvertDetails/deactivate".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "advertId", advertId));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<AdvertDetailDto>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param id 
   * @return AdvertDetailDto
   */
  public AdvertDetailDto advertDetailControllerGet (Integer id) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'id' is set
     if (id == null) {
        throw new ApiException(400, "Missing the required parameter 'id' when calling advertDetailControllerGet");
     }
     
    // create path and map variables
    String path = "/v1/AdvertDetails/{id}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<AdvertDetailDto>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
