package Bilet;

public class YurtiçiBilet {
	private String kalkış,varış,bilettipi,koltuktipi,koltukno,saat,tarih,id;
	private int fiyat;
	private boolean sigorta;
	public YurtiçiBilet() {
		
	}

	public YurtiçiBilet(String kalkış, String varış, String bilettipi, String koltuktipi, String koltukno, String saat,
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getFiyat() {return fiyat;}
	public  void setFiyat(int fiyat) {this.fiyat = fiyat;}

	public boolean getSigorta() {
		return sigorta;
	}

	public void setSigorta(boolean sigorta) {
		this.sigorta = sigorta;
	}

}
