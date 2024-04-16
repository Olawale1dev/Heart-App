package tso.brokenheart;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class pdfViewActivity extends AppCompatActivity {

    PDFView pdfView;

    TextView moduleName;

    AdView mAdView;

    private InterstitialAd mInterstitialAd;

    private static final String TAG = "pdfViewActivity";
    private AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        getSupportActionBar().hide();


        pdfView = findViewById(R.id.pdfView);
        moduleName = findViewById(R.id.moduleNames);

        mAdView = findViewById(R.id.adView);
        if (mAdView != null) {
            adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }

        loadInterstitial();
        //new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("356D0A1542A015D4A7F240498FA05A10"));

        int position = getIntent().getIntExtra("position", 0);
        String module = getIntent().getStringExtra("name");
        if (position == 0) {
            pdfView.fromAsset("About-the-Author.pdf").load();
            moduleName.setText(module);
        } else if (position == 1) {
            pdfView.fromAsset("TABLE-OF-CONTENT.pdf").load();
            moduleName.setText(module);
        } else if (position == 2) {
            pdfView.fromAsset("Chapter-1.pdf").load();
            moduleName.setText(module);
        } else if (position == 3) {
            pdfView.fromAsset("Chapter-2.pdf").load();
            moduleName.setText(module);
        } else if (position == 4) {
            pdfView.fromAsset("Chapter-3.pdf").load();
            moduleName.setText(module);
        } else if (position == 5) {
            pdfView.fromAsset("Chapter-4.pdf").load();
            moduleName.setText(module);
        } else if (position == 6) {
            pdfView.fromAsset("Chapter-5.pdf").load();
            moduleName.setText(module);
        } else if (position == 7) {
            pdfView.fromAsset("Chapter-6.pdf").load();
            moduleName.setText(module);
        } else if (position == 8) {
            pdfView.fromAsset("Chapter-7.pdf").load();
            moduleName.setText(module);
        } else if (position == 9) {
            pdfView.fromAsset("Chapter-8.pdf").load();
            moduleName.setText(module);
        } else if (position == 10) {
            pdfView.fromAsset("Chapter-9.pdf").load();
            moduleName.setText(module);
        } else if (position == 11) {
            pdfView.fromAsset("Chapter-10.pdf").load();
            moduleName.setText(module);
        } else if (position == 12) {
            pdfView.fromAsset("Summary.pdf").load();
            moduleName.setText(module);
        } else if (position == 13) {
            pdfView.fromAsset("About-the-Author.pdf").load();
            moduleName.setText(module);


        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(pdfViewActivity.this);
                }


            }
        }, 2000);



    }

    private void loadInterstitial() {

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-9163926251753325/5449806609", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });



    }
}
