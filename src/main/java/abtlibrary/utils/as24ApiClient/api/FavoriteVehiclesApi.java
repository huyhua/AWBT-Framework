/**
 * AS24 API v4.1
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v4.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package abtlibrary.utils.as24ApiClient.api;

import abtlibrary.utils.as24ApiClient.ApiCallback;
import abtlibrary.utils.as24ApiClient.ApiClient;
import abtlibrary.utils.as24ApiClient.ApiException;
import abtlibrary.utils.as24ApiClient.ApiResponse;
import abtlibrary.utils.as24ApiClient.Configuration;
import abtlibrary.utils.as24ApiClient.Pair;
import abtlibrary.utils.as24ApiClient.ProgressRequestBody;
import abtlibrary.utils.as24ApiClient.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import abtlibrary.utils.as24ApiClient.model.ResponseMessageCollectionListFavoriteVehicle;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoriteVehiclesApi {
    private ApiClient apiClient;

    public FavoriteVehiclesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public FavoriteVehiclesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for dELETEpublicV41UsersUseridFavoritevehicles */
    private com.squareup.okhttp.Call dELETEpublicV41UsersUseridFavoritevehiclesCall(Integer userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling dELETEpublicV41UsersUseridFavoritevehicles(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/public/v4.1/users/{userId}/favoritevehicles".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void dELETEpublicV41UsersUseridFavoritevehicles(Integer userId) throws ApiException {
        dELETEpublicV41UsersUseridFavoritevehiclesWithHttpInfo(userId);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> dELETEpublicV41UsersUseridFavoritevehiclesWithHttpInfo(Integer userId) throws ApiException {
        com.squareup.okhttp.Call call = dELETEpublicV41UsersUseridFavoritevehiclesCall(userId, null, null);
        return apiClient.execute(call);
    }

    /**
     *  (asynchronously)
     * 
     * @param userId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call dELETEpublicV41UsersUseridFavoritevehiclesAsync(Integer userId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = dELETEpublicV41UsersUseridFavoritevehiclesCall(userId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for dELETEpublicV41UsersUseridFavoritevehiclesVehicleid */
    private com.squareup.okhttp.Call dELETEpublicV41UsersUseridFavoritevehiclesVehicleidCall(Integer userId, Integer vehicleId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling dELETEpublicV41UsersUseridFavoritevehiclesVehicleid(Async)");
        }
        
        // verify the required parameter 'vehicleId' is set
        if (vehicleId == null) {
            throw new ApiException("Missing the required parameter 'vehicleId' when calling dELETEpublicV41UsersUseridFavoritevehiclesVehicleid(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/public/v4.1/users/{userId}/favoritevehicles/{vehicleId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()))
        .replaceAll("\\{" + "vehicleId" + "\\}", apiClient.escapeString(vehicleId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @param vehicleId  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void dELETEpublicV41UsersUseridFavoritevehiclesVehicleid(Integer userId, Integer vehicleId) throws ApiException {
        dELETEpublicV41UsersUseridFavoritevehiclesVehicleidWithHttpInfo(userId, vehicleId);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @param vehicleId  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> dELETEpublicV41UsersUseridFavoritevehiclesVehicleidWithHttpInfo(Integer userId, Integer vehicleId) throws ApiException {
        com.squareup.okhttp.Call call = dELETEpublicV41UsersUseridFavoritevehiclesVehicleidCall(userId, vehicleId, null, null);
        return apiClient.execute(call);
    }

    /**
     *  (asynchronously)
     * 
     * @param userId  (required)
     * @param vehicleId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call dELETEpublicV41UsersUseridFavoritevehiclesVehicleidAsync(Integer userId, Integer vehicleId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = dELETEpublicV41UsersUseridFavoritevehiclesVehicleidCall(userId, vehicleId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for gETpublicV41UsersUseridFavoritevehicles */
    private com.squareup.okhttp.Call gETpublicV41UsersUseridFavoritevehiclesCall(Integer userId, Integer skip, Integer take, String filter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling gETpublicV41UsersUseridFavoritevehicles(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/public/v4.1/users/{userId}/favoritevehicles".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));
        if (take != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "take", take));
        if (filter != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter", filter));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @param skip  (optional)
     * @param take  (optional)
     * @param filter  (optional)
     * @return ResponseMessageCollectionListFavoriteVehicle
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseMessageCollectionListFavoriteVehicle gETpublicV41UsersUseridFavoritevehicles(Integer userId, Integer skip, Integer take, String filter) throws ApiException {
        ApiResponse<ResponseMessageCollectionListFavoriteVehicle> resp = gETpublicV41UsersUseridFavoritevehiclesWithHttpInfo(userId, skip, take, filter);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @param skip  (optional)
     * @param take  (optional)
     * @param filter  (optional)
     * @return ApiResponse&lt;ResponseMessageCollectionListFavoriteVehicle&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseMessageCollectionListFavoriteVehicle> gETpublicV41UsersUseridFavoritevehiclesWithHttpInfo(Integer userId, Integer skip, Integer take, String filter) throws ApiException {
        com.squareup.okhttp.Call call = gETpublicV41UsersUseridFavoritevehiclesCall(userId, skip, take, filter, null, null);
        Type localVarReturnType = new TypeToken<ResponseMessageCollectionListFavoriteVehicle>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param userId  (required)
     * @param skip  (optional)
     * @param take  (optional)
     * @param filter  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETpublicV41UsersUseridFavoritevehiclesAsync(Integer userId, Integer skip, Integer take, String filter, final ApiCallback<ResponseMessageCollectionListFavoriteVehicle> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = gETpublicV41UsersUseridFavoritevehiclesCall(userId, skip, take, filter, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseMessageCollectionListFavoriteVehicle>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for gETpublicV41UsersUseridFavoritevehiclesCount */
    private com.squareup.okhttp.Call gETpublicV41UsersUseridFavoritevehiclesCountCall(Integer userId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling gETpublicV41UsersUseridFavoritevehiclesCount(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/public/v4.1/users/{userId}/favoritevehicles/count".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @return ResponseMessageCollectionListFavoriteVehicle
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ResponseMessageCollectionListFavoriteVehicle gETpublicV41UsersUseridFavoritevehiclesCount(Integer userId) throws ApiException {
        ApiResponse<ResponseMessageCollectionListFavoriteVehicle> resp = gETpublicV41UsersUseridFavoritevehiclesCountWithHttpInfo(userId);
        return resp.getData();
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @return ApiResponse&lt;ResponseMessageCollectionListFavoriteVehicle&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ResponseMessageCollectionListFavoriteVehicle> gETpublicV41UsersUseridFavoritevehiclesCountWithHttpInfo(Integer userId) throws ApiException {
        com.squareup.okhttp.Call call = gETpublicV41UsersUseridFavoritevehiclesCountCall(userId, null, null);
        Type localVarReturnType = new TypeToken<ResponseMessageCollectionListFavoriteVehicle>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * 
     * @param userId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call gETpublicV41UsersUseridFavoritevehiclesCountAsync(Integer userId, final ApiCallback<ResponseMessageCollectionListFavoriteVehicle> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = gETpublicV41UsersUseridFavoritevehiclesCountCall(userId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseMessageCollectionListFavoriteVehicle>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for pUTpublicV41UsersUseridFavoritevehicles */
    private com.squareup.okhttp.Call pUTpublicV41UsersUseridFavoritevehiclesCall(Integer userId, List<Integer> vehicleIds, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = vehicleIds;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling pUTpublicV41UsersUseridFavoritevehicles(Async)");
        }
        
        // verify the required parameter 'vehicleIds' is set
        if (vehicleIds == null) {
            throw new ApiException("Missing the required parameter 'vehicleIds' when calling pUTpublicV41UsersUseridFavoritevehicles(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/public/v4.1/users/{userId}/favoritevehicles".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "text/json", "application/x-www-form-urlencoded"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @param vehicleIds  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void pUTpublicV41UsersUseridFavoritevehicles(Integer userId, List<Integer> vehicleIds) throws ApiException {
        pUTpublicV41UsersUseridFavoritevehiclesWithHttpInfo(userId, vehicleIds);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @param vehicleIds  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> pUTpublicV41UsersUseridFavoritevehiclesWithHttpInfo(Integer userId, List<Integer> vehicleIds) throws ApiException {
        com.squareup.okhttp.Call call = pUTpublicV41UsersUseridFavoritevehiclesCall(userId, vehicleIds, null, null);
        return apiClient.execute(call);
    }

    /**
     *  (asynchronously)
     * 
     * @param userId  (required)
     * @param vehicleIds  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTpublicV41UsersUseridFavoritevehiclesAsync(Integer userId, List<Integer> vehicleIds, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pUTpublicV41UsersUseridFavoritevehiclesCall(userId, vehicleIds, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for pUTpublicV41UsersUseridFavoritevehiclesVehicleid */
    private com.squareup.okhttp.Call pUTpublicV41UsersUseridFavoritevehiclesVehicleidCall(Integer userId, Integer vehicleId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'userId' is set
        if (userId == null) {
            throw new ApiException("Missing the required parameter 'userId' when calling pUTpublicV41UsersUseridFavoritevehiclesVehicleid(Async)");
        }
        
        // verify the required parameter 'vehicleId' is set
        if (vehicleId == null) {
            throw new ApiException("Missing the required parameter 'vehicleId' when calling pUTpublicV41UsersUseridFavoritevehiclesVehicleid(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/public/v4.1/users/{userId}/favoritevehicles/{vehicleId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "userId" + "\\}", apiClient.escapeString(userId.toString()))
        .replaceAll("\\{" + "vehicleId" + "\\}", apiClient.escapeString(vehicleId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "text/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @param vehicleId  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void pUTpublicV41UsersUseridFavoritevehiclesVehicleid(Integer userId, Integer vehicleId) throws ApiException {
        pUTpublicV41UsersUseridFavoritevehiclesVehicleidWithHttpInfo(userId, vehicleId);
    }

    /**
     * 
     * 
     * @param userId  (required)
     * @param vehicleId  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> pUTpublicV41UsersUseridFavoritevehiclesVehicleidWithHttpInfo(Integer userId, Integer vehicleId) throws ApiException {
        com.squareup.okhttp.Call call = pUTpublicV41UsersUseridFavoritevehiclesVehicleidCall(userId, vehicleId, null, null);
        return apiClient.execute(call);
    }

    /**
     *  (asynchronously)
     * 
     * @param userId  (required)
     * @param vehicleId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call pUTpublicV41UsersUseridFavoritevehiclesVehicleidAsync(Integer userId, Integer vehicleId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = pUTpublicV41UsersUseridFavoritevehiclesVehicleidCall(userId, vehicleId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
}
