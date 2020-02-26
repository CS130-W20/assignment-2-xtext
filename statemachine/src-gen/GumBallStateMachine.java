interface State {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispenseGumball();
}


class NoQuarterState implements State {
	
	GumBallStateMachine gumBall;
	
	public NoQuarterState(GumBallStateMachine gumBall) {
		this.gumBall = gumBall;
	}

	public void ejectQuarter() {}

	public void turnCrank() {}

	public void dispenseGumball() {}
	
	public void insertQuarter() {
		this.gumBall.setState(this.gumBall.getHasQuarterState());
	}
}


class HasQuarterState implements State {
	
	GumBallStateMachine gumBall;
	
	public HasQuarterState(GumBallStateMachine gumBall) {
		this.gumBall = gumBall;
	}

	public void insertQuarter() {}

	public void dispenseGumball() {}
	
	public void ejectQuarter() {
		this.gumBall.setState(this.gumBall.getNoQuarterState());
	}
	public void turnCrank() {
		this.gumBall.setState(this.gumBall.getGumballSoldState());
	}
}


class GumballSoldState implements State {
	
	GumBallStateMachine gumBall;
	
	public GumballSoldState(GumBallStateMachine gumBall) {
		this.gumBall = gumBall;
	}

	public void ejectQuarter() {}

	public void turnCrank() {}
	
	public void dispenseGumball() {
		if (this.gumBall.count > 0) {
			this.gumBall.setState(this.gumBall.getOutOfGumballsState());
		}
	}
	public void insertQuarter() {
		this.gumBall.setState(this.gumBall.getHasQuarterState());
	}
}


class OutOfGumballsState implements State {
	
	GumBallStateMachine gumBall;
	
	public OutOfGumballsState(GumBallStateMachine gumBall) {
		this.gumBall = gumBall;
	}

	public void insertQuarter() {}

	public void ejectQuarter() {}

	public void turnCrank() {}

	public void dispenseGumball() {}
	
}


public class GumBallStateMachine {
	int count = 0;
	
	State state;
	NoQuarterState noQuarterState;
	HasQuarterState hasQuarterState;
	GumballSoldState gumballSoldState;
	OutOfGumballsState outOfGumballsState;
	
	public GumBallStateMachine() {
		this.noQuarterState = new NoQuarterState(this);
		this.hasQuarterState = new HasQuarterState(this);
		this.gumballSoldState = new GumballSoldState(this);
		this.outOfGumballsState = new OutOfGumballsState(this);
		this.state = noQuarterState;
	}
	
	public State getState() {
		return this.state;
	}
	
	void setState(State state) {
		this.state = state;
	}

	public void setCount(int val) {
		this.count = val;
	}
	public int getCount() {
		return this.count;
	}

	
	public State getNoQuarterState() {
		return this.noQuarterState;
	}
	public State getHasQuarterState() {
		return this.hasQuarterState;
	}
	public State getGumballSoldState() {
		return this.gumballSoldState;
	}
	public State getOutOfGumballsState() {
		return this.outOfGumballsState;
	}
	
	public void insertQuarter() {
		this.state.insertQuarter();
	}
	public void ejectQuarter() {
		this.state.ejectQuarter();
	}
	public void turnCrank() {
		this.state.turnCrank();
	}
	public void dispenseGumball() {
		this.state.dispenseGumball();
	}
	
}
