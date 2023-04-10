package com.base.game.gameobject;

import org.lwjgl.input.Keyboard;

import com.base.engine.GameObject;
import com.base.engine.Sprite;

public class Player extends GameObject {
	public static final float SIZE = 32;
	public static final double LEVEL_CONST = 25 * Math.pow(3, (3.0/2.0)); // Bennny came up with this constant, don't know how

	private int health;
	private float xp;
	
	public Player(float x, float y) {
		init(x, y, 0.1f, 1f, 0.25f, SIZE, SIZE, 0);
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
		//System.out.println("Stats: Speed: " + getSpeed() + " Level: " + getLevel() + " Max HP: " + getMaxHealth( ) + " Health: " + getCurrentHealth() + " Magic: " + getMagic() + " Strength: " + getStrength());
	}
	
	private void move(float magX, float magY) { // mag is short for magnitude
		x += getSpeed() * magX;
		y += getSpeed() * magY;
	}
	
	public float getSpeed() {
		return 4f;
	}
	
	public int getLevel() {
		double x = xp + 105; //xp being calculated
		
		double a = Math.sqrt(243 * (x * x) + 4050 * x + 17500); // Benny has gone insane // Exponential function for xp
		double c = (3 * x + 25) / 25; // Linear function for xp
		double d = Math.cbrt(a / LEVEL_CONST + c); // Combine a and c, final xp algorithm
		
		return (int)(d - 1.0/d * 3) - 1;
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
