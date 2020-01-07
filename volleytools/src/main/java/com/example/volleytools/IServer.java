package com.example.volleytools;

import android.content.Context;

import java.util.List;

//import ir.programmershouse.digikala.Activity.Main_home.Pack_sand_count.Datamodel_sandcount;

public interface IServer {
    void Connect(Context context, String Url, int method);



    interface IAfterConnect {
        void GetResult(Object result);

    }
}
