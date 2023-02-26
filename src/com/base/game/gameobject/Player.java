package com.base.game.gameobject;

import org.lwjgl.input.Keyboard;

import com.base.engine.GameObject;
import com.base.engine.Sprite;

public class Player extends GameObject {
	public static final float SIZE = 32;

	private int health;
	private float xp;
	
	public Player(float x, float y) {
		init(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE);
		health = 10;
		xp = 0;
	}
	
	public void getInput() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) 
			move(0,1); // (x, y)
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) 
			move(0,-1);
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) 
			move(-1,0);
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) 
			move(1,0);		
	}
	
	public void update() {
		System.out.println("Stats: Speed: " + getSpeed() + " Level: " + getLevel() + " Max HP: " 
							+ getMaxHealth( ) + " Health: " + getCurrentHealth() + " Magic: " + getMagic() + " Strength: " + getStrength());
	}
	
	private void move(float magX, float magY) { // mag is short for magnitude
		x += getSpeed() * magX;
		y += getSpeed() * magY;
	}
	
	public float getSpeed() {
		return 4f;
	}
	
	public int getLevel() {
		return (int)(xp / 50) + 1;
	}
	
	public int getMaxHealth() {
		return getLevel() * 10;
	}
	
	public int getCurrentHealth() {
		int max = getMaxHealth();
		if(health > max) {
			health = max;
		}
		return health;
	}
	
	public float getStrength() {
		return getLevel() * 4f; 
	}
	
	public float getMagic() {
		return getLevel() * 4f;
	}
	
	public void addXP(float amt) { // amt : amount
		xp += amt;
	}
}
