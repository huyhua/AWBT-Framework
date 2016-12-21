package abtlibrary.utils.anibisApiClient.api;

import abtlibrary.utils.anibisApiClient.ApiException;
import abtlibrary.utils.anibisApiClient.ApiClient;
import abtlibrary.utils.anibisApiClient.Configuration;
import abtlibrary.utils.anibisApiClient.Pair;
import abtlibrary.utils.anibisApiClient.TypeRef;

import abtlibrary.utils.anibisApiClient.model.ChangesDto;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-12-21T13:19:31.219+07:00")
public class MetaDataControllerApi {
  private ApiClient apiClient;

  public MetaDataControllerApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MetaDataControllerApi(ApiClient apiClient) {
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
   * @param whitelabelId 
   * @param section 
   * @return ChangesDto
   */
  public ChangesDto metaDataControllerPost (String language, Integer whitelabelId, String section) throws ApiException {
    Object postBody = null;
    byte[] postBinaryBody = null;
    
     // verify the required parameter 'language' is set
     if (language == null) {
        throw new ApiException(400, "Missing the required parameter 'language' when calling metaDataControllerPost");
     }
     
     // verify the required parameter 'whitelabelId' is set
     if (whitelabelId == null) {
        throw new ApiException(400, "Missing the required parameter 'whitelabelId' when calling metaDataControllerPost");
     }
     
     // verify the required parameter 'section' is set
     if (section == null) {
        throw new ApiException(400, "Missing the required parameter 'section' when calling metaDataControllerPost");
     }
     
    // create path and map variables
    String path = "/v1/MetaData".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "language", language));
    
    queryParams.addAll(apiClient.parameterToPairs("", "whitelabelId", whitelabelId));
    
    queryParams.addAll(apiClient.parameterToPairs("", "section", section));
    

    

    

    final String[] accepts = {
      "application/json", "text/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    

    
    
    TypeRef returnType = new TypeRef<ChangesDto>() {};
    return apiClient.invokeAPI(path, "POST", queryParams, postBody, postBinaryBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
    


  }
  
}
