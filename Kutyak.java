import java.time.LocalDate;

public class Kutyak {

	private int cId;
	private int cFajtaId;
	private int cNevID;
	private int eletkor;
	private LocalDate uEll;
	public Kutyak(int cId, int cFajtaId, int cNevID, int eletkor, LocalDate uEll) {
		super();
		this.cId = cId;
		this.cFajtaId = cFajtaId;
		this.cNevID = cNevID;
		this.eletkor = eletkor;
		this.uEll = uEll;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getcFajtaId() {
		return cFajtaId;
	}
	public void setcFajtaId(int cFajtaId) {
		this.cFajtaId = cFajtaId;
	}
	public int getcNevID() {
		return cNevID;
	}
	public void setcNevID(int cNevID) {
		this.cNevID = cNevID;
	}
	public int getEletkor() {
		return eletkor;
	}
	public void setEletkor(int eletkor) {
		this.eletkor = eletkor;
	}
	public LocalDate getuEll() {
		return uEll;
	}
	public void setuEll(LocalDate uEll) {
		this.uEll = uEll;
	}
	@Override
	public String toString() {
		return "Kutyak [cId=" + cId + ", cFajtaId=" + cFajtaId + ", cNevID=" + cNevID + ", eletkor=" + eletkor
				+ ", uEll=" + uEll + "]";
	}
	
	
}
