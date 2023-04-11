package fp.word;

import java.util.Objects;

public class Votes {

	private Integer up,down;
	
	
	public Float getPositiveProportion()
	{return (float)up/(up+down);}
	
	public PosNeg getCalification()
	{	Float a = ((float)up-down)/(up+down);
		PosNeg b = PosNeg.VERY_POSITIVE;
		if (a>=-1 && a < -0.5) {
			 b = PosNeg.VERY_NEGATIVE;
		}
		else if (a>=-0.5 && a < -0.1) {
			 b = PosNeg.NEGATIVE;
		}
		else if (a>-0.1 && a < 0.1 )  {
			 b = PosNeg.NEUTRAL;
		}
		else if (a>=0.1 && a < 0.5 ) {
			 b = PosNeg.POSITIVE;
		}
		else if (a>=0.5 && a < 1) {
			 b = PosNeg.VERY_POSITIVE;
		}
		return b;
	}
	public Boolean getPositiveOverNegative()
	{return up >= down;}

	public Integer getUp() {
		return up;
	}

	public void setUp(Integer up) {
		this.up = up;
	}

	public Integer getDown() {
		return down;
	}

	public void setDown(Integer down) {
		this.down = down;
	}

	public Votes(Integer up, Integer down) {
		super();
		this.up = up;
		this.down = down;
	}

	@Override
	public int hashCode() {
		return Objects.hash(down, up);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Votes other = (Votes) obj;
		return Objects.equals(down, other.down) && Objects.equals(up, other.up);
	}
	public int upMinusDown()
	{return up - down;}
	
}
