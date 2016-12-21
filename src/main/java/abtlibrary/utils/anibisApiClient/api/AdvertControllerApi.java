package abtlibrary.utils.anibisApiClient.api;

import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.Configuration;
import abtlibrary.utils.anibisApiClient.Pair;
import abtlibrary.utils.anibisApiClient.TypeRef;
import abtlibrary.utils.anibisApiClient.model.AdvertDto;
import abtlibrary.utils.anibisApiClient.model.IdListDto;
import abtlibrary.utils.anibisApiClient.model.PictureDto;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class AdvertControllerApi {
  private ApiClient apiClient;

  public AdvertControllerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public AdvertControllerApi(ApiClient apiClient) {
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
   * @return List<AdvertDto>
   */
  public List<AdvertDto> advertControllerPost (IdListDto ids) throws ApiException {
    Object postBody = ids;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'ids' is set
     if (ids == null) {
        throw new ApiException(400, "Missing the required parameter 'ids' when calling advertControllerPost");
     }
     
    // create path and map variables
    String path = "/v1/Adverts".replaceAll("\\{format\\}","json");

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

    

    
    
    TypeRef returnType = new TypeRef<List<AdvertDto>>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param advertId 
   * @return List<List<PictureDto>>
   */
  public List<List<PictureDto>> advertControllerGetAdvertPictures (Integer advertId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'advertId' is set
     if (advertId == null) {
        throw new ApiException(400, "Missing the required parameter 'advertId' when calling advertControllerGetAdvertPictures");
     }
     
    // create path and map variables
    String path = "/v1/Adverts/{advertId}/Pictures".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "advertId" + "\\}", apiClient.escapeString(advertId.toString()));

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

    

    
    
    TypeRef returnType = new TypeRef<List<List<PictureDto>>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param advertId 
   * @param productId 
   * @param amount 
   * @return AdvertDto
   */
  public AdvertDto advertControllerUpgradeAdvert (Integer advertId, Integer productId, Integer amount) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'advertId' is set
     if (advertId == null) {
        throw new ApiException(400, "Missing the required parameter 'advertId' when calling advertControllerUpgradeAdvert");
     }
     
     // verify the required parameter 'productId' is set
     if (productId == null) {
        throw new ApiException(400, "Missing the required parameter 'productId' when calling advertControllerUpgradeAdvert");
     }
     
    // create path and map variables
    String path = "/v1/Adverts/{advertId}/upgrade".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "advertId" + "\\}", apiClient.escapeString(advertId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "productId", productId));
    
    queryParams.addAll(apiClient.parameterToPairs("", "amount", amount));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<AdvertDto>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
  /**
   * 
   * 
   * @param id 
   * @return AdvertDto
   */
  public AdvertDto advertControllerGet (Integer id) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'id' is set
     if (id == null) {
        throw new ApiException(400, "Missing the required parameter 'id' when calling advertControllerGet");
     }
     
    // create path and map variables
    String path = "/v1/Adverts/{id}".replaceAll("\\{format\\}","json")
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

    

    
    
    TypeRef returnType = new TypeRef<AdvertDto>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
