package com.example.botik.repository;


import com.example.botik.model.CartCount;
import com.example.botik.model.ModelAddCart;
import com.example.botik.model.ModelDetails;
import com.example.botik.model.ModelGetCart;
import com.example.botik.model.ModelIndex;
import com.example.botik.model.ModelListOrder;
import com.example.botik.model.ModelOrder;
import com.example.botik.model.ModelPay;
import com.example.botik.model.ModelSelectAddress;
import com.example.botik.model.ModelShowData;
import com.example.botik.model.ModelUserInfo;
import com.example.botik.model.Price;
import com.example.botik.model.Status;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    Api.Companion Compation = Companion.$$Instance;

    @GET("index.php")
    Single<List<ModelIndex>> SinglePost();

    @FormUrlEncoded
    @POST("postdetails.php")
    Single<ModelDetails> ApiDetails(@Field("id") String id);

    @FormUrlEncoded
    @POST("register.php")
    Single<Status> Register(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("userinfo.php")
    Single<List<ModelUserInfo>> UserInfo(@Field("token") String token);

    @FormUrlEncoded
    @POST("login.php")
    Single<Status> Login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("addaddress.php")
    Single<Status> Edit(@Field("token") String token, @Field("address") String address, @Field("codeposti") String codeposti, @Field("phone") String phone, @Field("phonesabet") String phonesabet);


    @FormUrlEncoded
    @POST("order.php")
    Single<List<ModelListOrder>> order(@Field("token") String token);


    @FormUrlEncoded
    @POST("fcart.php")
    Single<CartCount> Single_Count_Cart(@Field("token") String token);


    @FormUrlEncoded
    @POST("Addcart.php")
    Single<ModelAddCart> Single_Addcart(@Field("product")String product, @Field("token")String token, @Field("count")String count, @Field("check")String check);


    @FormUrlEncoded
    @POST("Get_record_cart.php")
    Single<List<ModelGetCart>> Single_Listcart(@Field("token")String token);


    @FormUrlEncoded
    @POST("Get_pricecart.php")
    Single<List<Price>> Single_sumprice(@Field("token")String user);


    @FormUrlEncoded
    @POST("del_cart.php")
    Single<Status> Single_Delete_items(@Field("idcart")String idcart);


    @FormUrlEncoded
    @POST("Get_address.php")
    Single<List<ModelSelectAddress>> SelectAddress(@Field("token")String token);


    @FormUrlEncoded
    @POST("Add_order.php")
    Single<ModelOrder> AddOrder(@Field("token")String token, @Field("address")String address);

    @GET("pay.php")
    Single<List<ModelPay>> Pay();

    @FormUrlEncoded
    @POST("ShowData.php")
    Single<List<ModelShowData>> ShowData(@Field("token") String token);

    final class Companion {
        static final Api.Companion $$Instance;

        public final Api invoke() {

            return (new Retrofit.Builder())
                    .baseUrl("https://alisamadzadeh.ir/botik/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api.class);
        }

        static {
            $$Instance = new Companion();
        }

    }
}
