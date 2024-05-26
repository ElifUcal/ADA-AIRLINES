package Bilet;

public class YurtDısıBilet {
	private String id;
	private int fiyat;
	private String kalkış,varış,bilettipi,koltuktipi,koltukno,saat,tarih;
	private boolean sigorta;

	public YurtDısıBilet(String kalkış, String varış, String bilettipi, String koltuktipi, String koltukno, String saat,
			String tarih,String id,boolean sigorta,int fiyat) {
		this.kalkış = kalkış;
		this.varış = varış;
		this.bilettipi = bilettipi;
		this.koltuktipi = koltuktipi;
		this.koltukno = koltukno;
		this.saat = saat;
		this.tarih = tarih;
		this.id = id;
		this.sigorta = sigorta;
		this.fiyat = fiyat;
	}

	public YurtDısıBilet() {
		
	}

	public String getKalkış() {
		return kalkış;
	}

	public void setKalkış(String kalkış) {
		this.kalkış = kalkış;
	}

	public String getVarış() {
		return varış;
	}

	public void setVarış(String varış) {
		this.varış = varış;
	}

	public String getBilettipi() {
		return bilettipi;
	}

	public void setBilettipi(String bilettipi) {
		this.bilettipi = bilettipi;
	}

	public String getKoltuktipi() {
		return koltuktipi;
	}

	public void setKoltuktipi(String koltuktipi) {
		this.koltuktipi = koltuktipi;
	}

	public String getKoltukno() {
		return koltukno;
	}

	public void setKoltukno(String koltukno) {
		this.koltukno = koltukno;
	}

	public String getSaat() {
		return saat;
	}

	public void setSaat(String saat) {
		this.saat = saat;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean getSigorta () {
		return sigorta;
	}

	public void setSigorta(boolean sigorta) {
		this.sigorta = sigorta;
	}

	public int getFiyat() {return fiyat;}
	public void setFiyat(int fiyat) {this.fiyat = fiyat;}

	@Override
	public String toString() {
		return  id + "," + kalkış + "," + varış + "," + bilettipi
				+ "," + koltuktipi + "," + koltukno + "," + saat + "," + tarih;
	}
	
	
	
	
}
