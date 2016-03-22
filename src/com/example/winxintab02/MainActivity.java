package com.example.winxintab02;

import android.R.integer;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnClickListener{
	
	private LinearLayout mTabWeixin;
	private LinearLayout mTabFrd;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSettings;
	
	private ImageButton mImgWeixin;
	private ImageButton mImgFrd;
	private ImageButton mImgAddress;
	private ImageButton mImgSettings;
	
	private Fragment mTab01;
	private Fragment mTab02;
	private Fragment mTab03;
	private Fragment mTab04;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		setContentView(R.layout.activity_main);
		initview();
		initEvent();
	}

	private void initEvent()
	{
		// TODO Auto-generated method stub
		mTabWeixin.setOnClickListener(this);
		mTabFrd.setOnClickListener(this);
		mTabAddress.setOnClickListener(this);
		mTabSettings.setOnClickListener(this);
	}

	private void initview()
	{
		// TODO Auto-generated method stub
		mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
		mTabFrd= (LinearLayout) findViewById(R.id.id_tab_frd);
		mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
		mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);
		
		mImgWeixin = (ImageButton) findViewById(R.id.id_tab_weixin_image);
		mImgFrd= (ImageButton) findViewById(R.id.id_tab_frd_image);
		mImgAddress = (ImageButton) findViewById(R.id.id_tab_address_image);
		mImgSettings = (ImageButton) findViewById(R.id.id_tab_settings_image);
		
	   

	}

	private void setSelect(int i)
	{
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideFragment(transaction);
		
		
		//把图片设置成亮的并设置内容区域
		switch (i)
		{
		case 0:
			if (mTab01 == null)
			{
				mTab01 = new WeixinFragment();
				transaction.add(R.id.id_content, mTab01);
			}else
			{
				transaction.show(mTab01);
			}
			mImgWeixin.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case 1:
			if (mTab02 == null)
			{
				mTab02 = new FrdFragment();
				transaction.add(R.id.id_content, mTab02);
			}else
			{
				transaction.show(mTab02);
			}
			mImgFrd.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case 2:
			if (mTab03 == null)
			{
				mTab03 = new AddressFragment();
				transaction.add(R.id.id_content, mTab03);
			}else
			{
				transaction.show(mTab03);
			}
			mImgAddress.setImageResource(R.drawable.tab_address_pressed);	
			break;
		case 3:
			if (mTab04 == null)
			{
				mTab04 = new SettingsFragment();
				transaction.add(R.id.id_content, mTab04);
			}else
			{
				transaction.show(mTab04);
			}
			mImgSettings.setImageResource(R.drawable.tab_settings_pressed);		
			break;
		}
		
		transaction.commit();
	}
	
	private void hideFragment(FragmentTransaction transaction)
	{
		// TODO Auto-generated method stub
		if (mTab01 != null)
		{
			transaction.hide(mTab01);
		}
		if (mTab02 != null)
		{
			transaction.hide(mTab02);
		}
		if (mTab03 != null)
		{
			transaction.hide(mTab03);
		}
		if (mTab04 != null)
		{
			transaction.hide(mTab04);
		}
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub
		resetImg();
		switch (v.getId()) {
		case R.id.id_tab_weixin:
			setSelect(0);
			
			break;
		case R.id.id_tab_frd:
			setSelect(1);
			
			break;
		case R.id.id_tab_address:
			setSelect(2);
			
			break;
		case R.id.id_tab_settings:
			setSelect(3);
			
			break;
		}
	}

	private void resetImg()
	{
		// TODO Auto-generated method stub
		mImgWeixin.setImageResource(R.drawable.tab_weixin_normal);
		mImgFrd.setImageResource(R.drawable.tab_find_frd_normal);
		mImgAddress.setImageResource(R.drawable.tab_address_normal);
		mImgSettings.setImageResource(R.drawable.tab_settings_normal);
	}

}
