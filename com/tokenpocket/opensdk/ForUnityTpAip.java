package com.tokenpocket.opensdk;

import android.content.Context;
import android.util.Log;

import com.unity3d.player.UnityPlayer;

public class ForUnityTpAip {

      //tp登录
      public static void  _onLoginApp(Context context, String authData)
      {
          Log.i("androidunity","_onLoginApp==============");
          TPManager.getInstance().authLogin(context, authData, new TPListener() {
              @Override
              public void onSuccess(String data) {
                  Success(data);
              }

              @Override
              public void onError(String data) {
                  onError(data);
              }

              @Override
              public void onCancel(String data) {
                  OnCancel(data);
              }
          });
      }
      //tp转账
      public static void  _onTransfer(Context context,String Transferdata){
          Log.i("androidunity","_onTransfer==============");
          TPManager.getInstance().transfer(context, Transferdata, new TPListener() {
              @Override
              public void onSuccess(String data) {
                  Success(data);
              }

              @Override
              public void onError(String data) {
                  onError(data);
              }
              @Override
              public void onCancel(String data) {
                  OnCancel(data);
              }
          });
      }
      //是否安装了tp
      public static boolean  isTPInstall(Context context)
      {
            return TPManager.getInstance().isTPInstall(context);
      }

      //callback 回调
     private static void  Success(String data)
     {
         UnityPlayer.UnitySendMessage("TokenPocketManager","TpCallBakc","Success");

     }
     private static void  onError(String data)
     {
         UnityPlayer.UnitySendMessage("TokenPocketManager","TpCallBakc","Failure");
     }
     private static void  OnCancel(String data)
     {
         UnityPlayer.UnitySendMessage("TokenPocketManager","TpCallBakc","Cancel");
     }
}
