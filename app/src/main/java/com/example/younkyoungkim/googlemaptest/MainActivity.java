package com.example.younkyoungkim.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap googleMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.4663282,126.9307193),17)); //위도, 경도, 줌 레벨
        googleMap.getUiSettings().setZoomControlsEnabled(true); //확대.축소 버튼
    }

    public static final int ITEM_SATELLITE=1;
    public static final int ITEM_NORMAL=2;
    public static final int ITEM_BUCHUN=3;
    public static final int ITEM_LOTTEWORLD=4;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, ITEM_SATELLITE, 0, "위성 지도"); //2번째 자리는 메뉴 아이디 값
        menu.add(0, ITEM_NORMAL, 0, "일반 지도");
        SubMenu hotMenu=menu.addSubMenu("핫 플레이스");
        hotMenu.add(0, ITEM_BUCHUN, 0, "부천만화박물관");
        hotMenu.add(0, ITEM_LOTTEWORLD, 0, "롯데월드");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case ITEM_SATELLITE : googleMap.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                return true;
            case ITEM_NORMAL : googleMap.setMapType((GoogleMap.MAP_TYPE_NORMAL));
                return true;
            case ITEM_BUCHUN : googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.5087709,126.740076),17));
                return true;
            case ITEM_LOTTEWORLD : googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.51112,127.0959783),17));
                return true;
        }
        return false;
    }
}
