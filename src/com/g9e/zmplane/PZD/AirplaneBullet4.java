package com.g9e.zmplane.PZD;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.zmplay.ldzj2013hhb.Game;
import com.zmplay.ldzj2013hhb.GameDraw;
import com.zmplay.ldzj2013hhb.Airplane;

//public class AirplaneBullet4 extends Bullet {
//	Bitmap[] im;
//	float x, y, hl;
//	int w, h, id;
//
//	public AirplaneBullet4(Bitmap[] _im, float _x, float _y, float _hl) {
//		im = _im;
//		x = _x;
//		y = _y;
//		hl = _hl;
//		w = im[0].getWidth() / 2;
//		h = im[0].getHeight() / 2;
//		visible = true;
//
//		id = 1;
//	}
//
//	public void dead(Game game) {
//		game.bombManager.create(10, x + GameDraw.random.nextInt() % 20, y
//				+ GameDraw.random.nextInt() % 20, 0, 6);
//		visible = false;
//	}
//
//	public void render(Canvas g, Paint paint) {
//		g.drawBitmap(im[Math.abs(GameDraw.random.nextInt(4))], x - 54, y - 800,
//				paint);
//	}
//
//	public void updata(Game game) {
//		x = Airplane.x;
//		y = Airplane.y;
//		if (game != null) {
//			for (int i = 0; i < game.npcManager.l; i++) {
//				if (game.npcManager.npcs[i].visible != false) {
//					if (y > game.npcManager.npcs[i].y
//							&& Math.abs(x + Game.cx - game.npcManager.npcs[i].x) < w) {
//						game.npcManager.npcs[i].isHit(
//								game.npcManager.npcs[i].x,
//								game.npcManager.npcs[i].y, hl, game);
//					}
//				}
//			}
//		}
//	}
//
//}
