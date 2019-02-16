package monkeyandbanana;

public abstract class State {
	protected MonkeyController b;
public abstract void Behavior();
public abstract void AddPoint(); 
public abstract int status();
}


class InitialState extends State{
	public InitialState(MonkeyController b) {
		this.b=b;
	}
	public InitialState(State state) {
		this.b=state.b;
	}
	public void Behavior() {

		stateCheck();
	}
	public void AddPoint() {
		b.score=0;
	}
	public void stateCheck() {
		if (b.x==b.mx &&b.y==b.my) {
			b.setState(new MoveState(this));
	}
	}
	public int status() {
		return 1;
	}
	
	
}
class MoveState extends State{
	public MoveState(MonkeyController b) {
		this.b=b;
	}
	public MoveState(State state) {
		this.b=state.b;
	}
	public void Behavior() {
		AddPoint();
		b.x=(int)(Math.random()*50)*10;
		b.y=(int)(Math.random()*50)*10;
		stateCheck();

		
	}
	public void AddPoint() {
		b.score+=10;
	}
	
	public void stateCheck() {
		if(b.score==20) {
			b.setState(new OverState(this));
		}
		else {
			b.setState(new StayState(this));
		}

		
	}
	public int status() {
		return 2;
	}
}

class MoveOnlyState extends State{
	public MoveOnlyState(MonkeyController b) {
		this.b=b;
	}
	public MoveOnlyState(State state) {
		this.b=state.b;
	}
	public void Behavior() {

		b.x=(int)(Math.random()*50)*10;
		b.y=(int)(Math.random()*50)*10;
		stateCheck();	
	}
	public void AddPoint() {
	}
	
	public void stateCheck() {

			b.setState(new StayState(this));
		}
	public int status() {
		return 3;
	}
		
	}

class StayState extends State{
	public StayState(MonkeyController b) {
		this.b=b;
	}
	public StayState(State state) {
		this.b=state.b;
	}
	public void Behavior() {
		stateCheck();		
	}
	public void AddPoint() {
		
	}
	public void stateCheck() {
		if (b.x==b.mx &&b.y==b.my) {
				b.setState(new MoveState(this));				
			}
			
	}
	public int status() {
		return 4;
	}
	}



class OverState extends State{
	public OverState(MonkeyController b) {
		this.b=b;
	}
	public OverState(State state) {
		this.b=state.b;
	}
	public void Behavior() {
		Over();
		
	}
	public void AddPoint() {
		
	}
	public void Over() {
		b.x=-5;
		b.y=-5;
		b.mx=-5;
		b.my=-5;
		System.out.println("Game over");
		Result frame1 = new Result(b.score);
		frame1.setVisible(true);	
		stateCheck();
	}
	public void stateCheck() {
		b.setState(new StayState(this));
		}
	public int status() {
		return 5;
	}
	}
	

