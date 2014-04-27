package maze.test;

import static org.junit.Assert.*;

import org.junit.Test;

import maze.logic.*;

public class testesEagle {

	Game gm;
	
	
	@Test
	public void Caminho(){
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
		Dragon dr2=new Dragon();
		dr2.setMove(false);
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
		gm.place(gm.getHR(), 1, 1, 5);
		
		Eagle eg= new Eagle();
		eg.setX(gm.getHR().getX());
		eg.setY(gm.getHR().getY());
		gm.setEA(eg);
		
		
		
		gm.setSW(new Sword());
		gm.place(gm.getSW(), 3,5,1);
		
		gm.print();
		
		//libertar aguia
		
		gm.getEA().createPath(gm.getEA().getX(),gm.getEA().getY());
		
		gm.getEA().move(gm,true);
		gm.getEA().move(gm,false);
		gm.getEA().move(gm,false);
		gm.getEA().move(gm,false);
		gm.getEA().move(gm,false);
		gm.interact();
		
		
		assertEquals(true, gm.getSW().getOnEagle());
	}
	

		
		@Test
		public void EagleDies(){
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
			Dragon dr2=new Dragon();
			dr2.setMove(false);
			Dragon[] drs= new Dragon[2];
			gm.setDragons(drs);
			drs[0]=dr;
			drs[1]=dr2;
			gm.place(drs[0], 1,1, 8);
			gm.place(drs[1],1, 6,1);
			
		
			Exit ex = new Exit();
			gm.setEX(ex);
			gm.place(gm.getEX(),1,7,0);
			
			gm.setHR(new Hero());
			gm.place(gm.getHR(), 1, 1, 5);
			
			Eagle eg= new Eagle();
			gm.setEA(eg);
			gm.getEA().setX(gm.getHR().getX());
			gm.getEA().setY(gm.getHR().getY());
			
			
			gm.setSW(new Sword());
			gm.place(gm.getSW(), 3,5,1);
			
			gm.print();
			
			//libertar aguia
			
			gm.getEA().createPath(gm.getEA().getX(),gm.getEA().getY());
			
			gm.getEA().move(gm,true);
			gm.getEA().move(gm,false);
			gm.getEA().move(gm,false);
			gm.getEA().move(gm,false);
			gm.getEA().move(gm,false);
			gm.interact();
			
			assertEquals(false,gm.getEA().getAlive());
			Unit[][] lab= gm.getMaze();
			
			assertTrue(lab[1][5].getItem() instanceof Sword);

		
	}
	
		
		
		@Test
		public void WayBack(){
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
			Dragon dr2=new Dragon();
			dr2.setMove(false);
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
			gm.place(gm.getHR(), 1, 1, 5);
			
			Eagle eg= new Eagle();
			gm.setEA(eg);
			gm.getEA().setX(gm.getHR().getX());
			gm.getEA().setY(gm.getHR().getY());
			
			
			gm.setSW(new Sword());
			gm.place(gm.getSW(), 3,5,1);
			
			gm.print();
			
			//libertar aguia
			
			gm.getEA().createPath(gm.getEA().getX(),gm.getEA().getY());
			
			gm.getEA().move(gm,true);
			gm.getEA().move(gm,false);
			gm.getEA().move(gm,false);
			gm.getEA().move(gm,false);
			gm.getEA().move(gm,false);
			gm.interact();
			
			gm.print();
			
			gm.getEA().move(gm,false);
			gm.getSW().move(gm);
			gm.getEA().move(gm,false);
			gm.getSW().move(gm);
			gm.getEA().move(gm,false);
			gm.getSW().move(gm);
			gm.getEA().move(gm,false);
			gm.getSW().move(gm);
			gm.interact();
			
			gm.print();
			
			assertEquals(true,gm.getHR().getArmed());
			
		}

		
		
	
	
}
