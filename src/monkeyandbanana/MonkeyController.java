package monkeyandbanana;
import java.util.Timer;
import java.util.TimerTask;


public class MonkeyController {
	private State state;
	public int x,y;
	public int mx,my;
	public int score=0;
	public int time=30;
	public int over=0;
	public int reset=0;
	Timer timer1=new Timer();
	Timer timer2=new Timer();
	public int Totaltime=120;

	
public MonkeyController() {
	timer2.schedule(new TimerTask2(), 0,1000);
	timer1.schedule(new TimerTask1(), 0,1000);
	x=(int)(Math.random()*50)*10;
	y=(int)(Math.random()*50)*10;
	this.state=new InitialState(this);
	state.Behavior();
	System.out.println("Initial Banana");
}

public int GetxPos() {
	return this.x;
	
}
public int GetyPos() {
	return this.y;
	
}
public void getMon(int mx,int my) {
	this.mx=mx;
	this.my=my;
	
}
public void Behavior() {
	if(over==1) {
		this.state=new OverState(this);
	}
	if(reset==1) {
		this.state=new MoveOnlyState(this);
		reset=0;
	}
	if(state.status()==2) {
		time=30;		
	}
	state.Behavior();
}
public void setState(State state) {
	this.state=state;
}
public int getStatus() {
	return state.status();
}

class TimerTask2 extends TimerTask{
	public void run() {
		
		if (time==0) {
			time=30;
			reset=1;
		}	
		time--;
		
		
	}
}
class TimerTask1 extends TimerTask{
	public void run() {
		
		if(Totaltime==0) {
			over=1;
			System.out.println("Times out");
		}
		Totaltime--;
		
	}
}
}


