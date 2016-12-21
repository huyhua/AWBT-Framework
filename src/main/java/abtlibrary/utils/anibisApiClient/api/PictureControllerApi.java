package abtlibrary.utils.anibisApiClient.api;

import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.Configuration;
import abtlibrary.utils.anibisApiClient.Pair;
import abtlibrary.utils.anibisApiClient.TypeRef;

import abtlibrary.utils.anibisApiClient.model.PictureDto;
import java.util.*;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class PictureControllerApi {
  private ApiClient apiClient;

  public PictureControllerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PictureControllerApi(ApiClient apiClient) {
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
   * @param advertId 
   * @return List<PictureDto>
   */
  public List<PictureDto> pictureControllerUploadPicture (Integer advertId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'advertId' is set
     if (advertId == null) {
        throw new ApiException(400, "Missing the required parameter 'advertId' when calling pictureControllerUploadPicture");
     }
     
    // create path and map variables
    String path = "/v1/Pictures".replaceAll("\\{format\\}","json");

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

    

    
    
    TypeRef returnType = new TypeRef<List<PictureDto>>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param advertId 
   * @param pictureIds 
   * @return Object
   */
  public Object pictureControllerSetPositions (Integer advertId, List<Integer> pictureIds) throws ApiException {
    Object postBody = pictureIds;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'advertId' is set
     if (advertId == null) {
        throw new ApiException(400, "Missing the required parameter 'advertId' when calling pictureControllerSetPositions");
     }
     
     // verify the required parameter 'pictureIds' is set
     if (pictureIds == null) {
        throw new ApiException(400, "Missing the required parameter 'pictureIds' when calling pictureControllerSetPositions");
     }
     
    // create path and map variables
    String path = "/v1/Pictures/SetPositions".replaceAll("\\{format\\}","json");

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
   * @param pictureId 
   * @return Object
   */
  public Object pictureControllerDelete (Integer pictureId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'pictureId' is set
     if (pictureId == null) {
        throw new ApiException(400, "Missing the required parameter 'pictureId' when calling pictureControllerDelete");
     }
     
    // create path and map variables
    String path = "/v1/Pictures/{pictureId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "pictureId" + "\\}", apiClient.escapeString(pictureId.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<Object>() {};
    return apiClient.invokeAPI(path, "DELETE", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
