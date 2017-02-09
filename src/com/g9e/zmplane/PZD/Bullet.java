package com.g9e.zmplane.PZD;

import com.zmplay.ldzj2013hhb.Game;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 子弹的抽象类
 */
public abstract class Bullet {
	public float x, y, n;
	public float vx, vy, v;
	public boolean visible;
	public float hl;
	public int id;

	public abstract void render(Canvas g, Paint paint);

	public abstract void updata(Game game);

	public abstract void dead(Game game);
}
