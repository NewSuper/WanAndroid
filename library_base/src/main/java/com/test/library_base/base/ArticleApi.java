package com.test.library_base.base;


import com.test.library_base.pojo.ArticleListRes;
import com.test.library_base.pojo.BannerRes;
import com.test.library_base.pojo.MyShareBean;
import com.test.library_base.pojo.PublicAuthorListRes;
import com.test.library_base.pojo.SearchBeanRes;
import com.test.library_network.ApiCall;
import com.test.library_network.ApiResponse;

import java.util.List;

import androidx.lifecycle.LiveData;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 文章api
 */
public interface ArticleApi {

    /**
     * 获取轮播图
     *
     * @return
     */
    @GET("banner/json")
    ApiCall<List<BannerRes>> getBanner();


    /**
     * 获取文章列表
     *
     * @param page 页码，拼接在连接中，从0开始。
     * @return
     */
    @GET("article/list/{page}/json")
    ApiCall<ArticleListRes> listArticle(@Path("page") int page);


    /**
     * 公众号文章列表
     *
     * @param id   公众号id
     * @param page 页码，拼接在连接中，从0开始。
     * @return
     */
    @GET("wxarticle/list/{id}/{page}/json")
    LiveData<ApiResponse<ArticleListRes>> listArticle(@Path("id") String id, @Path("page") int page);


    /**
     * 公众号作业列表
     *
     * @return
     */
    @GET("wxarticle/chapters/json")
    ApiCall<List<PublicAuthorListRes>> listPublicAuthor();


    /**
     * 知识体系下的文章
     *
     * @param page
     * @param id
     * @return
     */
    @GET("article/list/{page}/json")
    ApiCall<ArticleListRes> listArticle(@Path("page") int page, @Query("cid") String id);


    /**
     * 我的收藏列表
     *
     * @param page
     * @return
     */
    @GET("lg/collect/list/{page}/json")
    ApiCall<ArticleListRes> listMyCollect(@Path("page") int page);

    /**
     * 收藏文章
     *
     * @param id
     * @return
     */
    @POST("lg/collect/{id}/json")
    ApiCall<Object> collect(@Path("id") String id);

    /**
     * 取消收藏
     *
     * @param id
     * @return
     */
    @POST("lg/uncollect_originId/{id}/json")
    ApiCall<Object> unCollect(@Path("id") String id);

    /**
     * 热门搜索
     *
     * @return
     */
    @POST("hotkey/json")
    ApiCall<List<SearchBeanRes>> hotSearch();


    //搜索内容
    @POST("article/query/{page}/json")
    ApiCall<ArticleListRes> search(@Path("page") int pageNo, @Query("k") String k);


    /**
     * 我的分享
     *
     * @param page
     * @return
     */
    @GET("user/lg/private_articles/{page}/json")
    ApiCall<MyShareBean> listMyShare(@Path("page") int page);

    /**
     * 分享文章
     *
     * @param title
     * @param link
     * @return
     */
    @POST("lg/user_article/add/json")
    ApiCall<Object> shareArticle(@Query("title") String title, @Query("link") String link);


    /**
     * 删除文章
     *
     * @param id 文章id
     * @return
     */
    @POST("lg/user_article/delete/{id}/json")
    ApiCall<Object> deleteArticle(@Path("id") String id);
}
