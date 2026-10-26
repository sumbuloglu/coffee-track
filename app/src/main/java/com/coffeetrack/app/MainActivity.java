package com.coffeetrack.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.JsResult;
import android.app.AlertDialog;
import android.net.Uri;
import android.content.DialogInterface;
public class MainActivity extends Activity {
 private WebView web;
 @Override public void onCreate(Bundle b){super.onCreate(b);getWindow().setStatusBarColor(0xff173e35);getWindow().setNavigationBarColor(0xff173e35);web=new WebView(this);web.setBackgroundColor(0xfff7f5ed);web.getSettings().setJavaScriptEnabled(true);web.getSettings().setDomStorageEnabled(true);web.getSettings().setAllowFileAccess(false);web.getSettings().setAllowContentAccess(false);web.setWebViewClient(new WebViewClient(){
 @Override public android.webkit.WebResourceResponse shouldInterceptRequest(WebView view, android.webkit.WebResourceRequest req){Uri u=req.getUrl();if("https".equals(u.getScheme())&&"app.coffeetrack.local".equals(u.getHost())){String p=u.getPath();String f="/".equals(p)?"index.html":p.substring(1);if(!f.matches("[a-zA-Z0-9._-]+"))return new android.webkit.WebResourceResponse("text/plain","UTF-8",null);try {String mime=f.endsWith(".css")?"text/css":f.endsWith(".js")?"application/javascript":"text/html";return new android.webkit.WebResourceResponse(mime,"UTF-8",getAssets().open(f));}catch(Exception e){return new android.webkit.WebResourceResponse("text/plain","UTF-8",null);}}return new android.webkit.WebResourceResponse("text/plain","UTF-8",null);}
 @Override public boolean shouldOverrideUrlLoading(WebView view,android.webkit.WebResourceRequest req){return !"app.coffeetrack.local".equals(req.getUrl().getHost());}
 });web.setWebChromeClient(new WebChromeClient(){@Override public boolean onJsConfirm(WebView view,String url,String message,final JsResult result){new AlertDialog.Builder(MainActivity.this).setTitle("Coffee Track").setMessage(message).setPositiveButton("Start over",new DialogInterface.OnClickListener(){public void onClick(DialogInterface d,int w){result.confirm();}}).setNegativeButton("Cancel",new DialogInterface.OnClickListener(){public void onClick(DialogInterface d,int w){result.cancel();}}).setOnCancelListener(new DialogInterface.OnCancelListener(){public void onCancel(DialogInterface d){result.cancel();}}).show();return true;}});setContentView(web);web.loadUrl("https://app.coffeetrack.local/");}
 @Override public void onBackPressed(){new AlertDialog.Builder(this).setTitle("Leave Coffee Track?").setMessage("Your earned rewards are saved. An unfinished shift restarts when you return.").setPositiveButton("Leave",new DialogInterface.OnClickListener(){public void onClick(DialogInterface d,int w){finish();}}).setNegativeButton("Keep playing",null).show();}
 @Override protected void onPause(){super.onPause();if(web!=null)web.onPause();}
 @Override protected void onResume(){super.onResume();if(web!=null)web.onResume();}
}
