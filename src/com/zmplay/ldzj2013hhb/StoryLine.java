package com.zmplay.ldzj2013hhb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * 剧情
 */
//public class StoryLine {
//	GameDraw gameDraw;
//	Bitmap im1, im2;
//	Bitmap[] zi = new Bitmap[9];
//	Bitmap gb, an;
//
//	int alp, y, at;
//
//	int m, t;
//
//	int id, zl;
//
//	public StoryLine(GameDraw _mc) {
//		gameDraw = _mc;
//	}
//
//	public void init(Resources res) {
//		im1 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_im1);
//		im2 = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_im2);
//		gb = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_gb);
//		an = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_tiao);
//
//		zi[0] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi1);
//		zi[1] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi2);
//		zi[2] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi3);
//		zi[3] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi4);
//		zi[4] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi5);
//		zi[5] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi6);
//		zi[6] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi7);
//		zi[7] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi8);
//		zi[8] = BitmapFactory.decodeResource(gameDraw.res, R.drawable.jq_zi9);
//	}
//
//	public void free() {
//		im1 = null;
//		im2 = null;
//		gb = null;
//		an = null;
//		for (int i = 0; i < zi.length; i++) {
//			zi[i] = null;
//		}
//	}
//
//	public void reset() {
//		m = 0;
//		t = 0;
//		gameDraw.canvasIndex = GameDraw.CANVAS_FIRST_STORY_LINE;
//		Game.isFrist = false;
//
//		Data.save();
//
//		if (GameDraw.isSound) {
//			GameDraw.menuMediaPlayer.pause();
//		}
//	}
//
//	public void render(Canvas g, Paint paint) {
//		switch (m) {
//		case 0:
//			g.drawBitmap(Menu.bg, 0, 0, paint);
//			g.drawColor((t * 50 + 5) << 24);
//			break;
//		case 1:
//			g.drawColor(0xff000000);
//			break;
//		case 2:
//			paint.setAlpha(alp);
//			g.drawBitmap(im1, 0, -y, paint);
//			paint.setAlpha(255);
//			for (int i = 0; i < id; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			renderWZ(g, id, paint);
//			break;
//		case 3:
//			g.drawBitmap(im1, 0, -480, paint);
//			for (int i = 0; i < 2; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			break;
//		case 4:
//			g.drawBitmap(im1, 0, -480, paint);
//			for (int i = 0; i < 2; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			paint.setAlpha(t * 25 + 5);
//			g.drawBitmap(im2, 0, -480, paint);
//			paint.setAlpha(255);
//			break;
//		case 5:
//			g.drawBitmap(im2, 0, -480, paint);
//			for (int i = 2; i < id; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			renderWZ(g, id, paint);
//			break;
//		case 6:
//			g.drawBitmap(im2, 0, -480, paint);
//			for (int i = 2; i < 4; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			break;
//		case 7:
//			g.drawBitmap(im2, 0, -y, paint);
//			for (int i = 2; i < 4; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			break;
//		case 8:
//			g.drawBitmap(im2, 0, 0, paint);
//			for (int i = 2; i < 4; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			break;
//		case 9:
//			g.drawBitmap(im2, 0, 0, paint);
//			for (int i = 2; i < 4; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			g.drawColor((t * 25 + 5) << 24);
//			break;
//		case 10:
//			g.drawColor(0xff000000);
//			for (int i = 4; i < id; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			renderWZ(g, id, paint);
//			break;
//		case 11:
//			g.drawColor(0xff000000);
//			for (int i = 4; i < 9; i++) {
//				g.drawBitmap(zi[i], zix[i], ziy[i], paint);
//			}
//			break;
//		case 20:
//			paint.setAlpha(t * 25 + 5);
//			g.drawBitmap(Menu.bg, 0, 0, paint);
//			paint.setAlpha(255);
//			break;
//		}
//
//		if (m < 20) {
//			g.drawBitmap(an, 370, 750, paint);
//		}
//	}
//
//	int gbt = 0;
//
//	public void renderGB(Canvas g, float x, float y, Paint paint) {
//		gbt++;
//		if (gbt < 10) {
//			g.drawBitmap(gb, x + 3, y + 21, paint);
//		} else if (gbt == 20) {
//			gbt = 0;
//		}
//	}
//
//	public void renderWZ(Canvas g, int id, Paint paint) {
//		if (zl > 0) {
//			Tools.paintImage(g, zi[id], zix[id], ziy[id], ziw[id][zl - 1],
//					paint);
//			renderGB(g, zix[id] + ziw[id][zl - 1], ziy[id], paint);
//		} else {
//			renderGB(g, zix[id], ziy[id], paint);
//		}
//	}
//
//	public void upData() {
//		switch (m) {
//		case 0:
//			t++;
//			if (t >= 5) {
//				t = 0;
//				m = 1;
//				gameDraw.menu.free();
//			}
//			break;
//		case 1:
//			t++;
//			if (t >= 10) {
//				t = 0;
//				m = 2;
//				id = 0;
//				zl = 0;
//				alp = 0;
//				y = 0;
//				at = 0;
//				if(MainActivity.gcDebug){
//					System.gc();
//				}
//			}
//			break;
//		case 2:
//			if (alp < 255) {
//				alp += 15;
//			} else {
//				alp = 255;
//				if (at < 30) {
//					at++;
//				} else {
//					y += 4;
//					if (y >= 480) {
//						y = 480;
//						t = 0;
//						m = 3;
//					}
//				}
//			}
//			if (id < 2) {
//				t--;
//				if (t <= 0) {
//					zl++;
//					resetT();
//					if (zl > ziw[id].length) {
//						id++;
//						zl = 0;
//					}
//				}
//			}
//			break;
//		case 3:
//			t++;
//			if (t >= 20) {
//				t = 0;
//				m = 4;
//			}
//			break;
//		case 4:
//			t++;
//			if (t >= 10) {
//				t = 0;
//				m = 5;
//				id = 2;
//				zl = 0;
//			}
//			break;
//		case 5:
//			t--;
//			if (t <= 0) {
//				zl++;
//				resetT();
//				if (zl > ziw[id].length) {
//					id++;
//					if (id >= 4) {
//						t = 0;
//						m = 6;
//					} else {
//						zl = 0;
//					}
//				}
//			}
//			break;
//		case 6:
//			t++;
//			if (t >= 10) {
//				t = 0;
//				m = 7;
//			}
//			break;
//		case 7:
//			y -= 50;
//			if (y <= 0) {
//				y = 0;
//				t = 0;
//				m = 8;
//			}
//			break;
//		case 8:
//			t++;
//			if (t >= 10) {
//				t = 0;
//				m = 9;
//			}
//			break;
//		case 9:
//			t++;
//			if (t >= 10) {
//				t = 0;
//				m = 10;
//				id = 4;
//				zl = 0;
//			}
//			break;
//		case 10:
//			t--;
//			if (t <= 0) {
//				zl++;
//				resetT();
//				if (zl > ziw[id].length) {
//					id++;
//					if (id >= 9) {
//						t = 0;
//						m = 11;
//					} else {
//						zl = 0;
//					}
//				}
//			}
//			break;
//		case 11:
//			t++;
//			if (t >= 20) {
//				t = 0;
//				m = 20;
//			}
//			break;
//		case 20:
//			t++;
//			if (t >= 10) {
//				gameDraw.chooseAirplane.init(gameDraw.res);
//				gameDraw.chooseAirplane.reset();
//				if (GameDraw.isSound) {
//					GameDraw.isPlayMusic(GameDraw.gameMediaPlayer,
//							GameDraw.bossMediaPlayer,
//							GameDraw.menuMediaPlayer);
//				}
//			} else if (t == 5) {
//				free();
//				if(MainActivity.gcDebug){
//					System.gc();
//				}
//			}
//			break;
//		}
//	}
//
//	public void resetT() {
//		t = (int) (GameDraw.random.nextFloat() * 5 + 2);
//	}
//
//	public void touchDown(float tx, float ty) {
//		if (tx > 350 && ty > 730 && m < 20) {
//			m = 20;
//			t = 0;
//			GameDraw.gameSound(1);
//		}
//	}
//
//	int[][] ziw = new int[][] {
//			{ 16, 30, 42, 56, 82, 96, 119, 130, 144, 170, 181 }, // 2060年5月18日
//			{ 26, 51, 76, 101, 127, 152, 177, 201, 227, 252, 263 }, // 人类成功移民道外星球
//			{ 26, 51, 76, 103 },// 庆贺时刻
//			{ 26, 51, 77, 101, 126, 152, 177, 202, 227, 252, 277, 302, 327,
//					352, 377, 403 }, // 突然大量的…………
//			{ 28, 54, 79, 106, 133, 159, 185, 213 }, // 难道人类移民太空
//			{ 27, 54, 80, 106, 133, 159, 186, 221, 240, 257 }, // 遭到了外星人的补满
//			{ 27, 54, 65, 79, 107, 132, 159, 185, 212, 229, 250 }, // 好吧，没什么好怕的
//			{ 27, 53, 80, 106, 133, 159, 185, 212, 224 }, // 宇宙骑士即将完成
//			{ 27, 53, 79, 106, 133, 159, 186, 212, 225, 238, 252, 263 }, // 拿起武器准备战斗
//	};
//
//	float[] zix = new float[] { 30, 30, 20, 20, 20, 20, 160, 160, 160 };
//	float[] ziy = new float[] { 130, 190, 580, 640, 160, 220, 410, 470, 530 };
//
//}
