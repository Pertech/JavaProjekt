package Collision.Testing;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Collision.CollisionDetection;
import Entity.Player;
import WorldObject.Wall;
import WorldObject.WorldObjectSingleton;

public class CollisionTests {
	
	@Before
	public void init(){
		try {
			WorldObjectSingleton.getInstance().addWorldObject(new Wall(50, 50));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
	@Test
	public void testTop() {
		try {
			Player testPlayer = new Player(50,-1,50,50);
			CollisionDetection.getInstance().checkCollision(testPlayer, 0, 1);
			assertTrue(testPlayer.canMove());
			CollisionDetection.getInstance().checkCollision(testPlayer, 0, 2);
			assertFalse(testPlayer.canMove());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLeft() {
		try {
			Player testPlayer = new Player(-1,50,50,50);
			CollisionDetection.getInstance().checkCollision(testPlayer, 1, 0);
			assertTrue(testPlayer.canMove());
			CollisionDetection.getInstance().checkCollision(testPlayer, 2, 0);
			assertFalse(testPlayer.canMove());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBottom() {
		try {
			Player testPlayer = new Player(50,101,50,50);
			CollisionDetection.getInstance().checkCollision(testPlayer, 0, -1);
			assertTrue(testPlayer.canMove());
			CollisionDetection.getInstance().checkCollision(testPlayer, 0, -2);
			assertFalse(testPlayer.canMove());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRight() {
		try {
			Player testPlayer = new Player(101,50,50,50);
			CollisionDetection.getInstance().checkCollision(testPlayer, -1, 0);
			assertTrue(testPlayer.canMove());
			CollisionDetection.getInstance().checkCollision(testPlayer, -2, 0);
			assertFalse(testPlayer.canMove());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
