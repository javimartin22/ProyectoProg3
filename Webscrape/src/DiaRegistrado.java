
public class DiaRegistrado {

	private int diaSem;
	private int tempHigh;
	private int tempAvg;
	private int tempLow;
	private int rocioHigh;
	private int rocioAvg;
	private int rocioLow;
	private int humedadHigh;
	private int humedadAvg;
	private int humedadLow;
	private double precip;
	public DiaRegistrado(int diaSem, int tempHigh, int tempAvg, int tempLow, int rocioHigh, int rocioAvg, int rocioLow,
			int humedadHigh, int humedadAvg, int humedadLow, double precip) {
		super();
		this.diaSem = diaSem;
		this.tempHigh = tempHigh;
		this.tempAvg = tempAvg;
		this.tempLow = tempLow;
		this.rocioHigh = rocioHigh;
		this.rocioAvg = rocioAvg;
		this.rocioLow = rocioLow;
		this.humedadHigh = humedadHigh;
		this.humedadAvg = humedadAvg;
		this.humedadLow = humedadLow;
		this.precip = precip;
	}
	public int getDiaSem() {
		return diaSem;
	}
	public void setDiaSem(int diaSem) {
		this.diaSem = diaSem;
	}
	public int getTempHigh() {
		return tempHigh;
	}
	public void setTempHigh(int tempHigh) {
		this.tempHigh = tempHigh;
	}
	public int getTempAvg() {
		return tempAvg;
	}
	public void setTempAvg(int tempAvg) {
		this.tempAvg = tempAvg;
	}
	public int getTempLow() {
		return tempLow;
	}
	public void setTempLow(int tempLow) {
		this.tempLow = tempLow;
	}
	public int getRocioHigh() {
		return rocioHigh;
	}
	public void setRocioHigh(int rocioHigh) {
		this.rocioHigh = rocioHigh;
	}
	public int getRocioAvg() {
		return rocioAvg;
	}
	public void setRocioAvg(int rocioAvg) {
		this.rocioAvg = rocioAvg;
	}
	public int getRocioLow() {
		return rocioLow;
	}
	public void setRocioLow(int rocioLow) {
		this.rocioLow = rocioLow;
	}
	public int getHumedadHigh() {
		return humedadHigh;
	}
	public void setHumedadHigh(int humedadHigh) {
		this.humedadHigh = humedadHigh;
	}
	public int getHumedadAvg() {
		return humedadAvg;
	}
	public void setHumedadAvg(int humedadAvg) {
		this.humedadAvg = humedadAvg;
	}
	public int getHumedadLow() {
		return humedadLow;
	}
	public void setHumedadLow(int humedadLow) {
		this.humedadLow = humedadLow;
	}
	public double getPrecip() {
		return precip;
	}
	public void setPrecip(double precip) {
		this.precip = precip;
	}
	@Override
	public String toString() {
		return "DiaRegistrado [diaSem=" + diaSem + ", tempHigh=" + tempHigh + ", tempAvg=" + tempAvg + ", tempLow="
				+ tempLow + ", rocioHigh=" + rocioHigh + ", rocioAvg=" + rocioAvg + ", rocioLow=" + rocioLow
				+ ", humedadHigh=" + humedadHigh + ", humedadAvg=" + humedadAvg + ", humedadLow=" + humedadLow
				+ ", precip=" + precip + "]";
	}
	
}
