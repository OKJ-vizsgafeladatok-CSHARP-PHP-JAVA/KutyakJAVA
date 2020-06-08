
public class KutyaFajtak {
	private int fajtaId;
	private String fajtaNev;
	private String fajtaEredetiNev;
	public KutyaFajtak(int fajtaId, String fajtaNev, String fajtaEredetiNev) {
		super();
		this.fajtaId = fajtaId;
		this.fajtaNev = fajtaNev;
		this.fajtaEredetiNev = fajtaEredetiNev;
	}
	public int getFajtaId() {
		return fajtaId;
	}
	public void setFajtaId(int fajtaId) {
		this.fajtaId = fajtaId;
	}
	public String getFajtaNev() {
		return fajtaNev;
	}
	public void setFajtaNev(String fajtaNev) {
		this.fajtaNev = fajtaNev;
	}
	public String getFajtaEredetiNev() {
		return fajtaEredetiNev;
	}
	public void setFajtaEredetiNev(String fajtaEredetiNev) {
		this.fajtaEredetiNev = fajtaEredetiNev;
	}
	@Override
	public String toString() {
		return "KutyaFajtak [fajtaId=" + fajtaId + ", fajtaNev=" + fajtaNev + ", fajtaEredetiNev=" + fajtaEredetiNev
				+ "]";
	}
	
	
}
