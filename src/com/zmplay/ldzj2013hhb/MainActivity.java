package com.zmplay.ldzj2013hhb;

import java.util.ArrayList;
import java.util.List;

import com.joymeng.PaymentSdkV2.PaymentCb;
import com.joymeng.PaymentSdkV2.PaymentJoy;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity implements PaymentCb {
	public static boolean sysDebug = true;
	public static boolean gcDebug = true;
	public static boolean isFirstPlay = true;// �����ж��Ƿ��ǵ�һ����
	public static boolean isEndPlay = false;// �����ж��Ƿ�ͨ��
	public static final boolean isShowBuyMessage = true;

	public static int SCREEN_WIDTH, SCREEN_HEIGHT;
	public static MainActivity main;
	GameDraw gameDraw;

	public MainActivity() {
		main = this;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// ȥ������
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// ȥ��״̬��
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// ��������
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		SCREEN_WIDTH = dm.widthPixels;
		SCREEN_HEIGHT = dm.heightPixels;

		gameDraw = new GameDraw(this);
		gameDraw.setKeepScreenOn(true);
		setContentView(gameDraw);

		PaymentJoy.onCreate(this);
	}

	public boolean onKeyDown(int key, KeyEvent keyEvent) {
		if (gameDraw.keyDown(key) == true) {
			return true;
		} else {
			return super.onKeyDown(key, keyEvent);
		}
	}

	public void onPause() {
		super.onPause();
		if (GameDraw.isSound) {
			if (GameDraw.gameMediaPlayer.isPlaying()) {
				GameDraw.gameMediaPlayer.pause();
			}
			if (GameDraw.bossMediaPlayer.isPlaying()) {
				GameDraw.bossMediaPlayer.pause();
			}
			if (GameDraw.menuMediaPlayer.isPlaying()) {
				GameDraw.menuMediaPlayer.pause();
			}
		}
		switch (gameDraw.canvasIndex) {
		case GameDraw.CANVAS_GAME:
			// if(!isAppForeground){//�Ӻ�̨�е�ǰ̨����91SDK��ͣҳ
			// // TODO Auto-generated method stub
			// //����pause����
			// mc.gm.reset() ;
			// isAppForeground = true;
			// }
			gameDraw.pause.reset();
			gameDraw.pause.mode = 1;
			gameDraw.pause.t = 0;
			break;
		}

		// if(mc.canvasIndex != 20 && mc.canvasIndex != 25)
		// {
		// if(!isAppForeground){//�Ӻ�̨�е�ǰ̨����91SDK��ͣҳ
		// // TODO Auto-generated method stub
		// //����pause����
		// PaymentJoy.pause(this) ;
		// isAppForeground = true;
		// }
		// }
	}

	public void onResume() {
		super.onResume();
		if (GameDraw.isSound) {
			if (gameDraw.canvasIndex == GameDraw.CANVAS_GAME
					|| gameDraw.canvasIndex == GameDraw.CANVAS_GAME_PAUSE) {
				if (Game.bosst > 0) {
					GameDraw.isPlayMusic(GameDraw.menuMediaPlayer,
							GameDraw.gameMediaPlayer, GameDraw.bossMediaPlayer);
				} else {
					GameDraw.isPlayMusic(GameDraw.menuMediaPlayer,
							GameDraw.bossMediaPlayer, GameDraw.gameMediaPlayer);
				}
			} else if (gameDraw.canvasIndex != GameDraw.CANVAS_PROGRESS
					&& gameDraw.canvasIndex != GameDraw.CANVAS_FIRST_STORY_LINE) {
				GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
						GameDraw.bossMediaPlayer, GameDraw.menuMediaPlayer);
			}
		}

		if (!isAppForeground) {// �Ӻ�̨�е�ǰ̨����91SDK��ͣҳ
			// TODO Auto-generated method stub
			// ����pause����
			PaymentJoy.pause(this);
			isAppForeground = true;
		}
	}

	protected void onStart() {
		super.onStart();
		PaymentJoy.onStart();
	}

	protected void onStop() {
		super.onStop();
		if (!isAppOnForeground()) {// app�����̨
			isAppForeground = false;
		}
		PaymentJoy.onStop();
	}

	public void onDestroy() {
		super.onDestroy();
		// PaymentJoy.onDestroy();
		System.exit(0);
	}

	public void PaymentResult(int resultCode, String[] cbParam) {

	}

	// �ж��Ƿ����ƶ��Ŀ�
	public static boolean isYD = true;

	public boolean isCM() {
		return true;
		// TelephonyManager manager = (TelephonyManager)
		// (getSystemService(Context.TELEPHONY_SERVICE));
		// String operator = manager.getSimOperator();
		// String opName = manager.getSimOperatorName();
		// String imsi = manager.getSubscriberId();
		// if (imsi.startsWith("46000") || imsi.startsWith("46002") ||
		// opName.equals("�й��ƶ�")||imsi.startsWith("46007"))
		// {
		// return true;
		// }else{
		// return false;
		// }
	}

	private static boolean isAppForeground = true;

	public static boolean isAppOnForeground() {
		ActivityManager activityManager = (ActivityManager) main
				.getApplicationContext().getSystemService(
						Context.ACTIVITY_SERVICE);
		String packageName = main.getApplicationContext().getPackageName();
		List<RunningAppProcessInfo> appProcesses = activityManager
				.getRunningAppProcesses();
		if (appProcesses == null)
			return false;
		for (RunningAppProcessInfo appProcess : appProcesses) {
			if (appProcess.processName.equals(packageName)
					&& appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
				return true;
			}
		}
		return false;
	}

}