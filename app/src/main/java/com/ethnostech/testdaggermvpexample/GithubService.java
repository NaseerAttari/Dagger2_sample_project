package com.ethnostech.testdaggermvpexample;




import com.ethnostech.testdaggermvpexample.models.GithubRepo;
import com.ethnostech.testdaggermvpexample.models.GithubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

  @GET("users/{username}/repos")
  Call<List<GithubRepo>> getReposForUser(@Path("username") String username);

  @GET("repositories")
  Call<List<GithubRepo>> getAllRepos();

  @GET("users/{username}")
  Call<GithubUser> getUser(@Path("username") String username);
}
