package maze.logic;

import java.util.Stack;

public class Eagle extends Entity {

	boolean flying, alive, onShoulder;
	int retX, rety;
	Stack<Par> caminho, caminhoVolta;

	void refresh() {

		if (alive)
			token = 'B';
		else
			token = '$';
		if (flying)
			token = 'b';

	}

	void createPath(int ex, int ey) {

		int tx=ex,ty=ey;
		int dx = Math.abs(x - ex);
		int dy = Math.abs(y - ey);
		int up,right,spare;
		boolean hor;
		int extra,normal,bigger;
		
		//if dx!=0 e dy!=0
		if(x < ex)
			right=1;
		else right=-1;
		if(y > ey)
			up=-1;
		else up=1;
		
		if(dx >= dy){
			normal=dy;
			spare=dx % dy;
			extra=dx/dy;
			bigger=dx;
			hor=true;
		}
		else{ 
			normal=dx;
			spare=dy % dx;
			extra=dy/dx;
			bigger=dy;
			
			hor=false;
		}
		
		
		for(int i=0;i<normal;i++){
			
			tx=tx+right;
			ty=ty+ up;
			caminho.push(new Par(tx,ty));
			for(int j=0;j<extra;j++){
				if(hor)
					tx=tx+right;
				else
					ty=ty+up;
				
				caminho.push(new Par(tx,ty));
			}
			
			if(bigger % ((bigger/spare)+1) == i){
				
				if(hor)
					tx=tx+right;
				else
					ty=ty+up;
				
				caminho.push(new Par(tx,ty));
				
			}
				
			
			
			
			
		}
		
		//endif
		
		Stack<Par> temp=caminho;
		
		temp.pop();
		while(!temp.empty())
			caminhoVolta.push(temp.pop());
		
		caminhoVolta.push(new Par(ex,ey));
			
		

	}

}
