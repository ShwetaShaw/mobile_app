package api;

import model.api.BaseResponse;
import model.api.UserAuthenticate;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import util.Constant;

/**
 * Created by megha on 11/06/17.
 */

public interface LoginApiEndPoint {

    @POST("users/authenticate")
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    Call<BaseResponse> userLogin(@Body UserAuthenticate userAuthenticate);
}
