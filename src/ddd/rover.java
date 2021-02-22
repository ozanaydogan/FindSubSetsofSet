package ddd;

import java.util.ArrayList;

public class rover {
	
	int coordinate_x = 0;
	int coordinate_y = 0;
	char direction = ' ';
	
	public void move_on_mars(int coordinate_x ,int coordinate_y, char direction, ArrayList<Character> destination, int[][] mars) {
		
		int go = 0;
		
		while(go < destination.size()) {
			
			if(destination.get(go)=='L' || destination.get(go)=='R') {
				
			this.turn_direction(this.direction, destination.get(go) );	
			
			}
			
			else if(destination.get(go) == 'M') {
				
				this.move_on_mars(this.coordinate_x, this.coordinate_y);
				
			}
			go++;
			
		}
		
	}
	
	
	public void turn_direction(char direction, char turn){
		
		if(this.direction == 'N') {
			if(turn == 'L') {
			this.direction = 'W';
			}
			if(turn == 'R') {
			this.direction = 'E';
			}
		}
		//
		else if(this.direction == 'W') {
			if(turn == 'L') {
			this.direction = 'S';
			}
			if(turn == 'R') {
			this.direction = 'N';
			}
		}
		//
		else if(this.direction == 'S') {
			if(turn == 'L') {
			this.direction = 'E';
			}
			if(turn == 'R') {
			this.direction = 'W';
			}
		}
		//
		else if(this.direction == 'E') {
			if(turn == 'L') {
			this.direction = 'N';
			}
			if(turn == 'R') {
			this.direction = 'S';
			}
		}
		
	}
	
	public void move_on_mars(int coordinate_x, int coordinate_y) {
		
		if(this.direction == 'E') {
			this.coordinate_x += coordinate_x;
			this.coordinate_y = coordinate_y;
		}
		//
		else if(this.direction == 'W') {
			this.coordinate_x -= coordinate_x;
			this.coordinate_y = coordinate_y;
		}
		//
		else if(this.direction == 'N') {
			this.coordinate_x = coordinate_x;
			this.coordinate_y += coordinate_y;
		}
		//
		else if(this.direction == 'S') {
			this.coordinate_x = coordinate_x;
			this.coordinate_y -= coordinate_y;
		}
		
	}
	
	public static void main(String args[]) {
		
		rover gezici = new rover();
		gezici.coordinate_x = 2;
		gezici.coordinate_y = 3;
		gezici.direction = 'N';
		
		System.out.println(gezici.coordinate_x +" "+ gezici.coordinate_y +" "+ gezici.direction);
		
		ArrayList<Character> destination = new ArrayList<Character>();
		destination.add('R');
		destination.add('M');
		destination.add('M');
		destination.add('L');
		destination.add('M');
		destination.add('L');
		destination.add('L');
		destination.add('M');
		destination.add('M');

		
		int[][] mars = new int[8][8];

		
		
		gezici.move_on_mars(gezici.coordinate_x, gezici.coordinate_y, gezici.direction,destination, mars);
		
		System.out.println(gezici.coordinate_x +" "+ gezici.coordinate_y +" "+ gezici.direction);
		
	}
}
