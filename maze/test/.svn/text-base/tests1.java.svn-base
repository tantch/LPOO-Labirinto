package maze.test;

import static org.junit.Assert.*;
import maze.logic.*;

import org.junit.Test;

public class tests1 {
	
	Game gm;
	
	@Test
	public void NormalMove(){
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
		dr.setMove(false);
		Dragon[] drs= new Dragon[1];
		gm.setDragons(drs);
		drs[0]=dr;
		gm.place(dr, 1, 3, 1);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 6, 1);

		
		gm.getHR().move(gm, 1, 0);
		
		assertEquals(7,gm.getHR().getX());
		assertEquals(1,gm.getHR().getY());
		
		
	
		
	}

	@Test
	public void WallMove(){
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
		dr.setMove(false);
		Dragon[] drs= new Dragon[1];
		gm.setDragons(drs);
		drs[0]=dr;
		gm.place(dr, 1, 3, 1);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 6, 1);

		
		gm.getHR().move(gm, 1, 0);
		gm.getHR().move(gm, 0, 1);
		
		assertEquals(7,gm.getHR().getX());
		assertEquals(1,gm.getHR().getY());
	}

	@Test
	public void TakesUpSword(){
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
		dr.setMove(false);
		Dragon[] drs= new Dragon[1];
		gm.setDragons(drs);
		drs[0]=dr;
		gm.place(dr, 1, 3, 1);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 6, 1);
		//Heroi(6,1)
		
		gm.setSW(new Sword());
		gm.place(gm.getSW(), 3,8,1);
		//Sword(8,1)
		gm.getHR().move(gm, 1, 0);
		gm.getHR().interact(gm);
		gm.getHR().move(gm, 1, 0);
		gm.getHR().interact(gm);
		gm.getSW().interact(gm);
		assertEquals(true,gm.getHR().getArmed());
		assertEquals(true,gm.getSW().getPickedUp());
	}

	@Test
	public void HeroDies(){
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
		dr.setMove(false);
		Dragon[] drs= new Dragon[1];
		gm.setDragons(drs);
		drs[0]=dr;
		gm.place(dr, 1, 3, 1);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 6, 1);

		gm.setSW(new Sword());
		gm.place(gm.getSW(), 3,8,1);
		
		gm.getHR().move(gm, -1, 0);
		gm.getHR().move(gm, -1, 0);
		gm.getHR().interact(gm);
		drs[0].interact(gm);
	
	}

	@Test
	public void DragonDies(){
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
		dr.setMove(false);
		Dragon[] drs= new Dragon[1];
		gm.setDragons(drs);
		drs[0]=dr;;
		gm.place(dr, 1, 3, 1);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 6, 1);

		gm.setSW(new Sword());
		gm.place(gm.getSW(), 3,8,1);
		
		gm.getHR().move(gm, 1, 0);
		gm.getHR().interact(gm);
		gm.getHR().move(gm, 1, 0);
		gm.getHR().interact(gm);
		gm.getSW().interact(gm);
		
		gm.getHR().move(gm, -1, 0);
		gm.getHR().move(gm, -1, 0);
		gm.getHR().move(gm, -1, 0);
		gm.getHR().move(gm, -1, 0);
		gm.getHR().interact(gm);
		drs[0].interact(gm);
		
		assertEquals(true,drs[0].getSlayn());
		
	}
	
	@Test
	public void WinExit(){
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
		dr.setMove(false);
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
		
		gm.getHR().move(gm, 0, 0);
		gm.interact();
		
		gm.getHR().move(gm, 1, 0);
		gm.interact();

		
		//Heroi(7,1)
		
		gm.getHR().move(gm, -1, 0);
		gm.getHR().move(gm, -1, 0);
		gm.getHR().move(gm, -1, 0);
		
		gm.interact();
		
		gm.getHR().move(gm, 1, 0);
		gm.getHR().move(gm, 1, 0);
		gm.getHR().move(gm, 1, 0);
		gm.getHR().move(gm, 0, -1);
	
		

		
		assertEquals(true,gm.onExit(gm.getHR().getX(),gm.getHR().getY()));
		
		
	}

	@Test
	public void DontWinExit(){
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
		dr.setMove(false);
		Dragon[] drs= new Dragon[1];
		gm.setDragons(drs);
		drs[0]=dr;
		gm.place(drs[0], 1,9, 1);

		gm.setEX(new Exit());
		gm.place(gm.getEX(),1,6,0);
		
		gm.setHR(new Hero());
		gm.place(gm.getHR(), 1, 6, 1);
		
		gm.setSW(new Sword());
		gm.place(gm.getSW(), 3,7,1);
		
		gm.getHR().move(gm, 0, -1);
		gm.getHR().interact(gm);
		gm.getEX().interact(gm);
		Exit e= (Exit) gm.getEX();

		assertEquals(true,e.getClosed());	
	}

}
