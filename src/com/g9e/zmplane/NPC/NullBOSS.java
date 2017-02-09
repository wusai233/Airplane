package com.g9e.zmplane.NPC;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.zmplay.ldzj2013hhb.Game;
import com.zmplay.ldzj2013hhb.NPCBulletManager;

public class NullBOSS extends NPC {
	Bitmap im;

	public NullBOSS(Bitmap _im, float _x, float _y, int _level) {
		im = _im;
		x = _x;
		y = _y;
	}

	@Override
	public void render(Canvas g, Paint paint) {
		g.drawBitmap(im, x, y, paint);
	}

	@Override
	public void upData(NPCBulletManager zm) {

	}

	@Override
	public boolean isHit(float _x, float _y, float h, Game game) {
		return false;
	}

}
