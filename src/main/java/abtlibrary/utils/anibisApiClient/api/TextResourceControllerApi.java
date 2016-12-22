package abtlibrary.utils.anibisApiClient.api;

import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.Configuration;
import abtlibrary.utils.anibisApiClient.Pair;
import abtlibrary.utils.anibisApiClient.TypeRef;

import abtlibrary.utils.anibisApiClient.model.TextResourceDto;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class TextResourceControllerApi {
  private ApiClient apiClient;

  public TextResourceControllerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TextResourceControllerApi(ApiClient apiClient) {
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
   * @param whitelabelId 
   * @param language 
   * @param sectionOrId 
   * @return List<TextResourceDto>
   */
  public List<TextResourceDto> textResourceControllerGetByWhitelabelAndSectionOrId (Integer whitelabelId, String language, String sectionOrId) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'whitelabelId' is set
     if (whitelabelId == null) {
        throw new ApiException(400, "Missing the required parameter 'whitelabelId' when calling textResourceControllerGetByWhitelabelAndSectionOrId");
     }
     
     // verify the required parameter 'language' is set
     if (language == null) {
        throw new ApiException(400, "Missing the required parameter 'language' when calling textResourceControllerGetByWhitelabelAndSectionOrId");
     }
     
    // create path and map variables
    String path = "/v1/TextResources".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "whitelabelId", whitelabelId));
    
    queryParams.addAll(apiClient.parameterToPairs("", "language", language));
    
    queryParams.addAll(apiClient.parameterToPairs("", "sectionOrId", sectionOrId));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<List<TextResourceDto>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
