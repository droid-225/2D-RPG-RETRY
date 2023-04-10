package com.base.game.gameobject.item;

import com.base.engine.Physics;
import com.base.game.gameobject.Player;

public class Cube extends Item {
	public static final float SIZE = 32;
	
	private Player player;
	
	public Cube(float x, float y, Player player) {
		init(x, y, 1.0f, 0.5f, 0, SIZE, SIZE, "The Cube");
		this.player = player;
	}
	
	public void pickup() {
		System.out.println("You Just Picked Up " + name + "!");
	}
	
	public void update() {
		if(Physics.checkCollision(this, player))
			pickup();
	}
}
