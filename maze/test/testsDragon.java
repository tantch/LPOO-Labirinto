package maze.test;

import static org.junit.Assert.*;
import maze.logic.*;

import org.junit.Test;

public class testsDragon {

	Game gm;
	
	@Test
	public void Movement(){
		gm= new Game(10,10,1);
		char[][] temp={
			{'X','X','X','X','X','X','X','X','X','X'},          
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ',' ',' ',' ',' ',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ',' ',' ',' ',' ','X'}, 
			{'X','X','X','X','X','X','X','X','X','X'}};
		
		gm.setMaze(temp, 10,10);
		
		Dragon dr=new Dragon();
		Dragon[] drs= new Dragon[1];
		gm.setDragons(drs);
		drs[0]=dr;
		gm.place(drs[0], 1,3, 1);
	
		Exit ex = new Exit();
		gm.setEX(ex);
		gm.place(gm.getEX(),1,7,0);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 6, 1);
		
		gm.setSW(new Sword());
		gm.place(gm.getSW(), 3,7,1);
		
		
		
		//Dragao (3,1)
		//Saida(7,0)
		//Heroi (6,1)
		//Sword(7,1)
		
		drs[0].moveTo(4, 1, gm);
		
		assertEquals(4,drs[0].getX());
		assertEquals(1,drs[0].getY());
		
	}
	
	@Test
	public void Sleep(){
		
		gm= new Game(10,10,1);
		char[][] temp={
			{'X','X','X','X','X','X','X','X','X','X'},          
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ',' ',' ',' ',' ',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ',' ',' ',' ',' ','X'}, 
			{'X','X','X','X','X','X','X','X','X','X'}};
		
		gm.setMaze(temp, 10,10);
		
		Dragon dr=new Dragon();
		Dragon[] drs= new Dragon[1];
		gm.setDragons(drs);
		drs[0]=dr;
		gm.place(drs[0], 1,3, 1);
	
		Exit ex = new Exit();
		gm.setEX(ex);
		gm.place(gm.getEX(),1,7,0);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 6, 1);
		
		gm.setSW(new Sword());
		gm.place(gm.getSW(), 3,7,1);
		
		
		
		//Dragao (3,1)
		//Saida(7,0)
		//Heroi (6,1)
		//Sword(7,1)
		
		drs[0].setSleeping(true);
		
		gm.getHR().move(gm, -1, 0);
		gm.getHR().move(gm, -1, 0);
		
		assertEquals(true,gm.getHR().getAlive());
		
	}


	@Test
	public void Multiple(){

		gm= new Game(10,10,1);
		char[][] temp={
			{'X','X','X','X','X','X','X','X','X','X'},          
			{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X','X','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ',' ',' ',' ',' ',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ','X',' ','X',' ','X'}, 
			{'X',' ','X','X',' ',' ',' ',' ',' ','X'}, 
			{'X','X','X','X','X','X','X','X','X','X'}};
		
		gm.setMaze(temp, 10,10);
		
		Dragon dr=new Dragon();
		Dragon dr2=new Dragon();
		Dragon[] drs= new Dragon[2];
		gm.setDragons(drs);
		drs[0]=dr;
		drs[1]=dr2;
		gm.place(drs[0], 1,1, 8);
		gm.place(drs[1],1, 8,1);
	
		Exit ex = new Exit();
		gm.setEX(ex);
		gm.place(gm.getEX(),1,7,0);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 4, 1);
		
		gm.setSW(new Sword());
		gm.place(gm.getSW(), 3,5,1);
		
		drs[0].move(gm);
		drs[1].move(gm);

		assertEquals(7,drs[0].getY());
		assertEquals(7,drs[1].getX());
		
		
		
		
		//Dragao (3,1)
		//Saida(7,0)
		//Heroi (6,1)
		//Sword(7,1)
	}
}
