package com.zmplay.ldzj2013hhb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class GameExit {
	private boolean isDownExit = false;
	private boolean isDownBack = false;
	GameDraw gameDraw;
	Bitmap liangYes, anYes, zi, background, back;
	int mode, time, id;

	public GameExit(GameDraw _mc) {
		gameDraw = _mc;
	}

	public void init(Resources res) {
		liangYes = BitmapFactory.decodeResource(res, R.drawable.exit_yes1);
		anYes = BitmapFactory.decodeResource(res, R.drawable.exit_yes2);
		zi = BitmapFactory.decodeResource(res, R.drawable.exit_zi);
		background = BitmapFactory.decodeResource(res, R.drawable.sz_im);
		back = BitmapFactory.decodeResource(res, R.drawable.sz_back1);
	}

	public void free() {
		liangYes = null;
		anYes = null;
		zi = null;
		background = null;
		back = null;
	}

	public void reset() {
		mode = 0;
		time = 0;
		id = 0;
		gameDraw.canvasIndex = GameDraw.CANVAS_GAME_EXIT;
	}

	public void render(Canvas g, Paint paint) {
		switch (mode) {
		case 0:
			gameDraw.menu.render(g, paint);
			break;
		case 1:
			gameDraw.menu.render(g, paint);
			g.drawColor(0x99000000);
			g.drawBitmap(background, 48, 280, paint);
			Tools.paintMImage(g, background, 240, 280, paint);
			Tools.paintM2Image(g, background, 48, 280 + 172, paint);
			Tools.paintRotateImage(g, background, 240, 280 + 172, 180, 192,
					172, paint);
			g.drawBitmap(zi, 87, 370, paint);
			if (isDownBack)
				g.drawBitmap(back, 360, 310, paint);
			else
				g.drawBitmap(back, 360, 310, paint);
			if (isDownExit)
				g.drawBitmap(anYes, 153, 475, paint);
			else
				g.drawBitmap(liangYes, 153, 475, paint);
			if (id == 1) {
				Menu.index = Menu.NULL;
				gameDraw.canvasIndex = GameDraw.CANVAS_MENU;
			} else if (id == 2) {
				GameDraw.isRun = false;
				MainActivity.main.finish();
			}
			break;
		}
	}

	public void upData() {
		switch (mode) {
		case 0:
			mode = 1;
			break;
		}
	}

	public void touchDown(float tx, float ty) {
		switch (mode) {
		case 1:
			if (tx > 150 && tx < 325 && ty > 470 && ty < 560) {// 退出
				isDownExit = true;
				GameDraw.gameSound(1);
			} else if (tx > 350 && ty > 300 && tx < 415 && ty < 355) {// 继续
				isDownBack = true;
				GameDraw.gameSound(1);
			}
			break;
		}
	}

	public void touchUp(float tx, float ty) {
		switch (mode) {
		case 1:
			if ((tx > 150 && tx < 325 && ty > 470 && ty < 560) && isDownExit) {// 退出
				isDownExit = false;
				id = 2;
			} else if ((tx > 350 && ty > 300 && tx < 415 && ty < 355)
					&& isDownBack) {// 继续
				isDownBack = false;
				id = 1;
			}
			break;
		}
	}

	public void touchMove(float tx, float ty) {
		switch (mode) {
		case 1:
			if (!(tx > 150 && tx < 325 && ty > 470 && ty < 560) && isDownExit) {// 退出
				isDownExit = false;
			} else if (!(tx > 350 && ty > 300 && tx < 415 && ty < 355)
					&& isDownBack) {// 继续
				isDownBack = false;
			}
			break;
		}
	}
}
