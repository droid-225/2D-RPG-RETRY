package com.base.engine;

public abstract class GameObject {
	private float x;
	private float y;
	private float sx;
	private float sy;
	private Animation anim;
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getSX() {
		return sx;
	}
	
	public float getSY() {
		 return sy;
	}
}
