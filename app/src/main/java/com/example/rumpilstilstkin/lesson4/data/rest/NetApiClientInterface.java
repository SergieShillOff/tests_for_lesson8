package com.example.rumpilstilstkin.lesson4.data.rest;


import com.example.rumpilstilstkin.lesson4.data.models.GithubUser;
import io.reactivex.Observable;


public interface NetApiClientInterface {
    Observable<GithubUser> getUser(String user);
}
