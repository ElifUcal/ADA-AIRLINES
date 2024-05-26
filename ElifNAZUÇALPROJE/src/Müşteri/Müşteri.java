package Müşteri;

public class Müşteri {
	private String ad,soyad,dogumgünü,cinsiyet,uyruk,telefonno,tc,email,sifre;
	
	private int id;

	public Müşteri(String ad, String soyad, String dogumgünü, String cinsiyet, String uyruk, String telefonno,
			String tc, String email, String sifre,int id) {
		
		this.ad = ad;
		this.soyad = soyad;
		this.dogumgünü = dogumgünü;
		this.cinsiyet = cinsiyet;
		this.uyruk = uyruk;
		this.telefonno = telefonno;
		this.tc = tc;
		this.email = email;
		this.sifre = sifre;
		this.id = id;
	}
	public Müşteri() {
		
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getDogumgünü() {
		return dogumgünü;
	}
	public void setDogumgünü(String dogumgünü) {
		this.dogumgünü = dogumgünü;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(Object object) {
		this.cinsiyet = (String) object;
	}
	public String getUyruk() {
		return uyruk;
	}
	public void setUyruk(String uyruk) {
		this.uyruk = uyruk;
	}
	public String getTelefonno() {
		return telefonno;
	}
	public void setTelefonno(String telefonno) {
		this.telefonno = telefonno;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String şifre) {
		this.sifre = şifre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
