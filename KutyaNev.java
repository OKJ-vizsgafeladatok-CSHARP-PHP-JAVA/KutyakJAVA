
public class KutyaNev {
private int NevId;
private String KutyaNev;
public KutyaNev(int nevId, String kutyaNev) {
	super();
	NevId = nevId;
	KutyaNev = kutyaNev;
}
public int getNevId() {
	return NevId;
}
public void setNevId(int nevId) {
	NevId = nevId;
}
public String getKutyaNev() {
	return KutyaNev;
}
public void setKutyaNev(String kutyaNev) {
	KutyaNev = kutyaNev;
}
@Override
public String toString() {
	return "KutyaNev [NevId=" + NevId + ", KutyaNev=" + KutyaNev + "]";
}

}
