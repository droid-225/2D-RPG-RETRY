package com.base.game.gameobject;

import com.base.engine.GameObject;
import com.base.engine.Sprite;

public class Player extends GameObject {
	public static final float SIZE = 32;
	
	public Player(float x, float y) {
		this.x = x;
		this.y = y;
		Sprite temp = new Sprite(0.1f,1f,0.25f,SIZE,SIZE);
	}
}
